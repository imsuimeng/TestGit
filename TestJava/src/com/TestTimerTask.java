package com;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * ¶¨Ê±Æ÷
 * @author WGJ
 *
 */
public class TestTimerTask extends TimerTask {

	@Override
	public void run() {
		System.out.println(sdf.format(new Date()));
	}
	
	SimpleDateFormat sdf = new SimpleDateFormat("HH");
	
	
	public static void main(String[] args) {
		TestTimerTask t = new TestTimerTask();
		
		Timer timer = new Timer();
		timer.schedule(t, 1000 , 2000);
		
	}
}

