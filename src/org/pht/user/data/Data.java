package org.pht.user.data;

import java.io.Serializable;
import java.util.ArrayList;
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
			int restingHeartRate, double bloodSugar, String memo) {
		DataEntry e = new DataEntry(calendar, cardioHours, strengthHours,
				workHours, sleepHours, systolic, diastolic, restingHeartRate,
				bloodSugar, memo);
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
	
	public ArrayList<Double> getWeeklySummary(int fieldName) {
		ArrayList<Double> al = new ArrayList<Double>();
		Calendar today = Calendar.getInstance();
		for (int i = 1; i <= 7; i++) {
			today.set(Calendar.DAY_OF_WEEK, i);
			DataEntry tmp = getEntry(today);
			if (tmp == null)
				al.add(0.0);
			else {
				al.add((Double) ((Integer)tmp.get(fieldName)/60.0));
			}
		}
		System.out.println(al.toString());
		return al;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Data [data=" + data + "]";
	}
}
