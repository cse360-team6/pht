package org.pht.user.data;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;

public class Data implements Serializable {
	private static final long serialVersionUID = -3059143241386106119L;
	private HashMap<Long, DataEntry> data;

	public Data() {
		data = new HashMap<Long, DataEntry>();
	}

	public DataEntry getEntry(Calendar cal) {
		Long days = new Long(CALENDAR.calToDays(cal));
		return data.get(days);
	}

	public void addEntry(DataEntry e) {
		Long days = new Long(CALENDAR.calToDays(e.getCalendar()));
		data.put(days, e);
	}

	public void addEntry(Calendar calendar, int cardioHours, int strengthHours,
			int workHours, int sleepHours, int systolic, int diastolic,
			int restingHeartRate, double bloodSugar) {
		DataEntry e = new DataEntry(calendar, cardioHours, strengthHours,
				workHours, sleepHours, systolic, diastolic, restingHeartRate,
				bloodSugar);
		Long days = new Long(CALENDAR.calToDays(e.getCalendar()));
		data.put(days, e);
	}

	public void deleteEntry(Calendar calendar) {
		Long days = new Long(CALENDAR.calToDays(calendar));
		data.remove(days);
	}

	public void replaceEntry(Calendar date, DataEntry newEntry) {
		Long days = new Long(CALENDAR.calToDays(date));
		data.put(days, newEntry);
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Data [data=" + data + "]";
	}
}
