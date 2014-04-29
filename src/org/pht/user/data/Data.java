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
		return al;
	}
	
	public double getWeeklyAverage(int fieldName) {
		Double avg = 0.0;
		Calendar today = Calendar.getInstance();
		int c = 0;
		for (int i = 1; i <= 7; i++) {
			today.set(Calendar.DAY_OF_WEEK, i);
			DataEntry tmp = getEntry(today);
			if (tmp != null) {
				c++;
				if (fieldName == DataEntry.BLOOD_SUGAR)
					avg += (Double) tmp.get(fieldName);
				else
					avg += 0.0 + (Integer)tmp.get(fieldName);
			}
		}
		if (c==0)
			return avg;
		return avg/(c*1.0);
	}
	
	public ArrayList<Double> getMonthlySummary(int fieldName) {
		ArrayList<Double> al = new ArrayList<Double>();
		Calendar today = Calendar.getInstance();
		int max = today.getActualMaximum(Calendar.DAY_OF_MONTH);
		for (int i = 1; i <= max; i++) {
			today.set(Calendar.DAY_OF_MONTH, i);
			int week = today.get(Calendar.WEEK_OF_MONTH)-1;
			DataEntry tmp = getEntry(today);
			if (al.size() <= week)
				al.add(0.0);
			if (tmp == null)
				al.set(week, al.get(week));
			else {
				al.set(week, al.get(week)+(Double) ((Integer)tmp.get(fieldName)/60.0));
			}
		}
		while (al.size() < 6)
			al.add(0.0);
		return al;
	}
	
	public double getMonthlyAverage(int fieldName) {
		Double avg = 0.0;
		Calendar today = Calendar.getInstance();
		int max = today.getActualMaximum(Calendar.DAY_OF_MONTH);
		int c = 0;
		for (int i = 1; i <= max; i++) {
			today.set(Calendar.DAY_OF_MONTH, i);
			DataEntry tmp = getEntry(today);
			if (tmp != null) {
				c++;
				if (fieldName == DataEntry.BLOOD_SUGAR)
					avg += (Double) tmp.get(fieldName);
				else
					avg += 0.0 + (Integer)tmp.get(fieldName);
			}
		}
		if (c==0)
			return avg;
		return avg/(c*1.0);
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Data [data=" + data + "]";
	}
}
