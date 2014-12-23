package com;

import java.util.Random;

public class TestStr {
	
	public static void main(String[] args) {
		/*
		String str = "20140910";
		System.out.println( str.substring(0,4));
		System.out.println( str.substring(4,6));
		System.out.println( str.substring(6,8));
		*/
        Random random = new Random();

        int s = random.nextInt(4);
        System.out.println(s);
	}
}
