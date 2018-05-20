package com.infra.mgmt.manager;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.infra.mgmt.pojo.AssetInventory;
import com.infra.mgmt.pojo.OrderTracking;
import com.infra.mgmt.utility.DateUtility;
import com.infra.mgmt.utility.ExcelUtility;
import com.infra.mgmt.utility.OrderStatus;

@Service
public class AssetInventoryService {

	public static final String fileName = "AssetInventory.xlsx";

	@Autowired
	OrderTrackingService orderTrackingService;

	@Autowired
	ExcelUtility excelUtility;

	//@Scheduled(fixedRate = 3*60*1000)
	public void checkInventory() throws InvalidFormatException, IOException {
		Workbook workBook = excelUtility.readExcel(fileName);
		Sheet sheet = workBook.getSheetAt(0);

		DataFormatter dataFormatter = new DataFormatter();
		List<AssetInventory> list = new ArrayList<>();
		sheet.forEach(row -> {
			AssetInventory aInv = new AssetInventory();
			if (row.getRowNum() != 0) {
				Double d = Double.parseDouble(row.getCell(0).toString());
				aInv.setItemNumber(d.longValue());
				aInv.setName(dataFormatter.formatCellValue(row.getCell(1)));
				aInv.setDescription(dataFormatter.formatCellValue(row.getCell(2)));
				aInv.setType(dataFormatter.formatCellValue(row.getCell(3)));
				// aInv.setDateOfLastOrder((row.getCell(4).toString()));
				aInv.setVendor(dataFormatter.formatCellValue(row.getCell(5)));
				aInv.setPricePerItem(Double.parseDouble(row.getCell(6).toString()));
				Double d1 = Double.parseDouble(dataFormatter.formatCellValue(row.getCell(8)));
				aInv.setQuantity(d1.intValue());
				list.add(aInv);
			}
		});

		placeInventoryOrder(list);
	}

	private void placeInventoryOrder(List<AssetInventory> list) throws InvalidFormatException, IOException {
		list.stream().filter(i -> i.getQuantity() < 3).forEach(a -> {
			OrderTracking ot = new OrderTracking();
			ot.setDateOfOrder(new Date());
			Double d = Math.random();
			System.out.println(d);
			ot.setOrderNumber(d.longValue());
			ot.setItemNumber(a.getItemNumber());
			ot.setCurrentStatus("A");
			ot.setProcessor("Alex");
			ot.setQuantity(5);
			ot.setOrderStatus(OrderStatus.NEW.toString());
			ot.setVendor("CHROMA");
			ot.setExpectedDateOfDelivery(DateUtility.asDate(LocalDate.now().plusDays(10)));
			try {
				orderTrackingService.createOrder(ot);
			} catch (Exception e) {
				System.out.println("Exception Occurred !!" + e.getMessage());
			}

		});
	}

	public void placeEmployeeOrder(AssetInventory assetInventory) throws InvalidFormatException, IOException {
		Workbook workbook = excelUtility.readExcel(fileName);
		Sheet sheet = workbook.getSheetAt(0);
		sheet.forEach(row -> {
			if (row.getRowNum() != 0) {
				Double d = Double.parseDouble(row.getCell(0).toString());
				if (d.longValue() == assetInventory.getItemNumber()) {
					Double quantity = Double.parseDouble(row.getCell(8).toString()) - 1;
					row.getCell(8).setCellValue(quantity);
				}
			}
		});
		excelUtility.writeExcel(fileName, workbook);
	}

	public void getAllAssets() throws InvalidFormatException, IOException {

		Workbook workbook = excelUtility.readExcel(fileName);
		Sheet sheet = workbook.getSheetAt(0);

		DataFormatter dataFormatter = new DataFormatter();
		sheet.forEach(row -> {
			row.forEach(cell -> {
				String cellValue = dataFormatter.formatCellValue(cell);
				System.out.print(cellValue + "\t");
			});
			System.out.println();
		});
	}
}
