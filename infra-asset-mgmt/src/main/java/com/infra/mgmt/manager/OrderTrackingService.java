package com.infra.mgmt.manager;

import java.io.File;
import java.io.IOException;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infra.mgmt.pojo.OrderTracking;
import com.infra.mgmt.utility.ExcelUtility;

@Service
public class OrderTrackingService {

	public static final String fileName = "OrderTracking.xlsx";
	
	private static final String SAMPLE_XLSX_FILE_PATH = "data/OrderTracking.xlsx";
	
	@Autowired
	ExcelUtility excelUtility;

	public void createOrder(OrderTracking ot) throws InvalidFormatException, IOException {

		Workbook workbook = excelUtility.readExcel(fileName);
		Sheet sheet = workbook.getSheetAt(0);
		CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setColor(HSSFColor.BLACK.index);
        style.setFont(font);
		Row row = sheet.createRow(sheet.getLastRowNum()+1);
		
		row.createCell(0).setCellValue(ot.getOrderNumber());
		row.getCell(0).setCellStyle(style);
		row.createCell(1).setCellValue(ot.getItemNumber());
		row.createCell(2).setCellValue(ot.getQuantity());
		row.createCell(3).setCellValue(ot.getVendor());
		row.createCell(4).setCellValue(ot.getProcessor());
		row.createCell(5).setCellValue(ot.getDateOfOrder());
		row.createCell(6).setCellValue(ot.getOrderStatus());
		row.createCell(7).setCellValue(ot.getExpectedDateOfDelivery());
		row.createCell(8).setCellValue("");
		row.createCell(9).setCellValue(ot.getCurrentStatus());

		excelUtility.writeExcel(fileName, workbook);

	}

	public void checkOrderStatus() {

	}

	public void getAllActiveOrders() throws InvalidFormatException, IOException {

		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(SAMPLE_XLSX_FILE_PATH).getFile());

		Workbook workbook = WorkbookFactory.create(file);

		Sheet sheet = workbook.getSheetAt(0);

		// Create a DataFormatter to format and get each cell's value as String
		DataFormatter dataFormatter = new DataFormatter();

		sheet.forEach(row -> {
			row.forEach(cell -> {
				String cellValue = dataFormatter.formatCellValue(cell);
				System.out.print(cellValue + "\t");
			});
			System.out.println();
		});

		// Closing the workbook
		//workbook.close();

	}
}
