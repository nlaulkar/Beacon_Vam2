package com.vam.util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public static Object[][] readData(String SheetName) throws IOException
	{
		//Creating bridge to excel file
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\vam\\data\\TestData.xlsx");
		XSSFWorkbook wb =new XSSFWorkbook(ip);
		XSSFSheet sh = wb.getSheet(SheetName);
		
		//Total no of rows
		int totalrows = sh.getPhysicalNumberOfRows();
		
		//Total number of columns
		int totalcol= sh.getRow(0).getPhysicalNumberOfCells();
		
		//Read Data from excel and store in 2D object array.
		Object arr[][]=new Object[totalrows-1][totalcol];
		for(int i=0;i<totalrows;i++)//rows
		{
			for(int j=0; j<totalcol; j++)//columns
			{
				arr[i-1][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return arr;
	}
}
