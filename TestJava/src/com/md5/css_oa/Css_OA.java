package com.md5.css_oa;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.TestMD5;

public class Css_OA {
	
	public static void main(String[] args) {
		String userName = "wanggj";
		String key = "dj#78djj6f%fs";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String dateStr = sdf.format(date);
		
		String md5Str = userName + dateStr + key;

		String result = TestMD5.MD5(md5Str);
		
		System.out.println(result);
	}

}
