package org.pht.user.data;

import java.math.BigInteger;
import java.util.Calendar;

public class CALENDAR {
	public static final BigInteger MILLIS_DAY = BigInteger.valueOf(Long.valueOf(86400000));
	// Returns the number of days since Jan 1, 1970
	public static long getDays(Calendar cal) { 
		BigInteger millisSinceEpoch = BigInteger.valueOf(cal.getTimeInMillis());
		BigInteger daysSinceEpoch = millisSinceEpoch.divide(MILLIS_DAY);
		long days = daysSinceEpoch.longValue();
		return days;
	}
}
	
	