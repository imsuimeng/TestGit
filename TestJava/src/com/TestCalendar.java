package com;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestCalendar {
	public static void main(String[] args) {
		getBeginToEnd();
	}

	public static void getBeginToEnd() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String beginDate = sdf.format(new Date());
		String endDate = sdf.format(new Date());
	
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		c1.set(Calendar.DAY_OF_MONTH, 1);
		c2.set(Calendar.DAY_OF_MONTH, c2.getActualMaximum(Calendar.DAY_OF_MONTH));

		beginDate = sdf.format(c1.getTime());
		endDate = sdf.format(c2.getTime());

		System.out.println(beginDate);
		System.out.println(endDate);
	}

	public static void test() {
		Calendar calendar = Calendar.getInstance();

		Date date = calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		System.out.println(sdf.format(date));
	}

}
