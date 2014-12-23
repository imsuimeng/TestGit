package com;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class TestExcelWrite {
	public static void main(String[] args) {
		
		int startMonth = 6;	//1949 - 01 是周六 
		int[] month  = { 31 , 28 , 31 ,30 , 31 , 30 , 31 , 31 , 30 , 31 , 30 , 31};

		 try {
			WritableWorkbook book = Workbook.createWorkbook(new File("c:/test.xls"));
			WritableSheet sheet = book.createSheet("MySheet", 0);

			 jxl.write.Number number = null;
			for(int i = 1949; i<3949 ; i++){				//年
				number = new jxl.write.Number( 0 , i-1949 , i);
				sheet.addCell(number);
				
				if(i%4 ==0){
					month[1] = 29;
				}
				else{
					month[1] = 28;
				}
				for (int j = 1; j <= month.length; j++) {			//月
					number = new jxl.write.Number( j , i-1949 , startMonth);
					startMonth = (startMonth+month[j-1])%7;
					sheet.addCell(number);
				}
			}
			book.write();
			book.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}
}
