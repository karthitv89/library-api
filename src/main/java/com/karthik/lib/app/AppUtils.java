package com.karthik.lib.app;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AppUtils {
	public static Date getTodayFrom12AM() {
		Calendar c = new GregorianCalendar();
		c.set(Calendar.HOUR_OF_DAY, 0); // anything 0 - 23
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		Date today = c.getTime();
		return today;
	}
	
	public static Date afterGivenDays(int days) {
		Calendar c = new GregorianCalendar();
		c.add(Calendar.DAY_OF_MONTH, days);
		c.set(Calendar.HOUR_OF_DAY, 23); // anything 0 - 23
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 59);
		Date neededDay = c.getTime();
		return neededDay;
	}
	
}
