package com.shaffan.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	public static Object[][] getExcelData(String fileName, String sheetName) {
		Object[][] data = null;
		Workbook book = null;
		
		try {
			
			// 1. Open the file
			FileInputStream fis = new FileInputStream("src/test/resources/testdata/" + fileName);
			book = new XSSFWorkbook(fis);
			
			// 2. Get the sheet
			XSSFSheet sheet = (XSSFSheet) book.getSheet(sheetName);
			
			System.out.println("Sheet object is: " + sheet);
			
			// 3. Get row and column counts
			int rowCount = sheet.getLastRowNum();
			int colCount = sheet.getRow(0).getLastCellNum();
			
			System.out.println("Total rows found: " + rowCount);
			System.out.println("Total columns found: " + colCount);
			
			// 4. Initialize array (rowCount is index, so simple loop covers data, skipping header)
			data = new Object[rowCount][colCount];
			DataFormatter formatter = new DataFormatter(); //Handles converting numbers/dates to String
			
			// 5. Loop through rows (Start at 1 to skip Header)
			for(int i=1;i <= rowCount;i++) {
				XSSFRow row = sheet.getRow(i);
				System.out.println("✅ DEBUG: Processing Row " + i);
				for(int j=0; j<colCount; j++) {
					XSSFCell cell = row.getCell(j);
					data[i-1][j] = formatter.formatCellValue(cell);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(book != null) {
					book.close();
				}
			} catch (IOException e) {
				// TODO: handle exception
			}
		}
		return data;
	}
}
