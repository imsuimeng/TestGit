package com;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TestExcelReader {

	public static void main(String[] args) {
		try {
			Workbook workBook = Workbook.getWorkbook(new File("c:test.xls"));
			Sheet sheet = workBook.getSheet(0);
			
			Cell cell = null;
			String result = null;
			
			for (int i = 0; i < sheet.getRows(); i++) {
				cell = sheet.getCell(0,i);
				result = cell.getContents();
				System.out.println(result);
			}
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
