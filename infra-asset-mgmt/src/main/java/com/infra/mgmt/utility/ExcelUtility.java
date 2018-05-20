package com.infra.mgmt.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Component;

@Component
public class ExcelUtility {

	public static final String SAMPLE_XLSX_FILE_PATH = "data/";

	public Workbook readExcel(String fileName) throws InvalidFormatException, IOException{
		ClassLoader classLoader = this.getClass().getClassLoader();
		File file = new File(classLoader.getResource(SAMPLE_XLSX_FILE_PATH + fileName).getFile());
		Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
		return workbook;
	}
	
	public void writeExcel(String fileName,Workbook workBook) throws IOException{
		ClassLoader classLoader = this.getClass().getClassLoader();
		File file = new File(classLoader.getResource(SAMPLE_XLSX_FILE_PATH + fileName).getFile());
		FileOutputStream outputFile =new FileOutputStream(file);
		workBook.write(outputFile);
		outputFile.close();
	}
	
}
