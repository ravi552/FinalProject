package com.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLibrary {
	
	public static String getCellData(String path, String sheet,int row, int cell) throws Throwable {
		
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		String excelValue =wb.getSheet(sheet).getRow(row).getCell(cell).toString();
		return excelValue;
	}
	
	public static int getRowCount(String path,String sheet) throws Throwable {
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(sheet).getLastRowNum();
		return rowCount;
	}
	
	public String getPropKeyValue(String propPath,String key) throws Throwable {
		FileInputStream fis = new FileInputStream(propPath);
		Properties prop = new Properties();
		prop.load(fis);
		String propValue =prop.getProperty(key,"Not a valid key");
		return propValue;
	}
	
	public void writeDataintoExcel(String path,String sheet,int row,int cell,String givenInput) throws Throwable{
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheet).getRow(row).createCell(cell).setCellValue(givenInput);
		FileOutputStream fos = new FileOutputStream(path);
		wb.write(fos);
		wb.close();
		System.out.println("Writing done..........");
	}
}
