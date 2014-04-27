package org.pht.user.data;

import java.util.Calendar;
import java.util.TimeZone;

// Data needs this to store values without needing the month, day, and year.
public final class CALENDAR {
	private static final Long MILLIS_SEC = new Long(1000), SECS_DAY = new Long(86400);

	// Returns the number of days since January 1, 1970
	public static long calToDays(Calendar cal) {
		Long millis = new Long(cal.getTimeInMillis());
		return millis / MILLIS_SEC / SECS_DAY;
	}
	public static Calendar daysToCal(long days) {
		Long millis = new Long(days) * MILLIS_SEC * SECS_DAY + (SECS_DAY * MILLIS_SEC); // I don't know why but the calculations were always a day behind
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(millis);
		cal.setTimeZone(TimeZone.getDefault());
		return cal;
		
	}
}
