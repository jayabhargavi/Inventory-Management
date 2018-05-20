package com.infra.mgmt.manager;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.infra.mgmt.pojo.AssetInventory;
import com.infra.mgmt.utility.DateUtility;
import com.infra.mgmt.utility.ExcelUtility;

@Service
public class EmployeeRequestService {
	
	public static final String fileName = "EmployeeRequestList.xlsx";
	
	@Autowired
	ExcelUtility excelUtility;
	
	@Autowired
	AssetInventoryService assetInventoryService;
	
	public void placeOrder(){
		
	}
	
	public void searchCatalogue(){
		
	}
	
	@Scheduled(fixedRate = 5*60*1000)
	public void readEmployeeRequestFile() throws InvalidFormatException, IOException{
		
		Workbook workbook = excelUtility.readExcel(fileName);
		Sheet sheet = workbook.getSheetAt(0);
		AssetInventory assetInventory = new AssetInventory();
		sheet.forEach(row ->{
			if(row.getCell(4).toString().equals("NEW")){
				row.getCell(4).setCellValue("INPROCESS");
				row.getCell(3).setCellValue(new Date());
				row.createCell(5).setCellValue(DateUtility.asDate(LocalDate.now().plusDays(7)));
				Double d = Double.parseDouble(row.getCell(2).toString());
				assetInventory.setItemNumber(d.longValue());
			}
		});
		
		assetInventoryService.placeEmployeeOrder(assetInventory);
		excelUtility.writeExcel(fileName, workbook);
	}
	
	
	public void getAllEmployeeRequests() throws InvalidFormatException, IOException {
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
