package com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestPOI {

	public static void main(String[] args) {
		TestPOI t = new TestPOI();
//		t.read2007("c:/test.xlsx");
		t.readExcel();
	}
	

	/**
	 * test 给过来的文件 test1， test2.xlsx 2010 test3.xls 2003 test4.xls 2010
	 * 
	 */
	public void readExcel() {
		InputStream is;
		Workbook book = null;
		String path = "c:/test3.xls";
		try {
			is = new FileInputStream(path);
			book = create(is);
			if(book instanceof XSSFWorkbook){
				System.out.println("is 2007");
				read2007(path);
			}else{
				System.out.println("is 2003");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void read2003(String path) {
		Workbook book = null;
		InputStream input1;
		try {
			input1 = new FileInputStream(path);
			book = new HSSFWorkbook(input1);
			HSSFSheet hssfSheet = (HSSFSheet) book.getSheetAt(0);
			for (int i = 0; i < hssfSheet.getLastRowNum(); i++) {
				HSSFRow row = hssfSheet.getRow(i);
				System.out.println(row.getCell(0));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void read2007( String path) {
		Workbook book = null;
		InputStream input1;
		try {
			input1 = new FileInputStream(path);
			book = new XSSFWorkbook(input1);
			XSSFSheet sheet = (XSSFSheet) book.getSheetAt(0);
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				XSSFRow row = sheet.getRow(i);
				System.out.println(row.getCell(0));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Workbook create(InputStream is ) throws IOException ,InvalidFormatException{
		if(!is.markSupported()){
			is = new PushbackInputStream(is , 8);
		}
		if(POIFSFileSystem.hasPOIFSHeader(is)){
			return new HSSFWorkbook(is);
		}
		if(POIXMLDocument.hasOOXMLHeader(is)){
			return new XSSFWorkbook(OPCPackage.open(is));
		}
		throw new IllegalArgumentException("您的Excel版本目前解析不了");
	}

}
