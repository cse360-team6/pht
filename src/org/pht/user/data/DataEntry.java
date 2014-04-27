package org.pht.user.data;

import java.io.Serializable;
import java.util.Calendar;

// Represents an entry in the user's daily logs
public class DataEntry implements Serializable
{
	private static final long serialVersionUID = 5638248638171687539L;
	private static final long MILLIS_DAY = 86400000;
	private int cardioHours, strengthHours, workHours, sleepHours, 
		systolic, diastolic, restingHeartRate;
	private double bloodSugar;
	private long day;
	private Calendar cal;
	
	public DataEntry() { }
	public DataEntry(Calendar cal, int cardioHours, int strengthHours, int workHours, 
			int sleepHours, int systolic, int diastolic, int restingHeartRate, 
			double bloodSugar) {
		this.cardioHours = cardioHours;
		this.strengthHours = strengthHours;
		this.workHours = workHours;
		this.sleepHours = sleepHours;
		this.systolic = systolic;
		this.diastolic = diastolic;
		this.restingHeartRate = restingHeartRate;
		this.bloodSugar = bloodSugar;
		this.cal = cal;
		this.day = this.getDays(cal);
	}
	
	public long getDays(Calendar cal) {
		long millis = cal.getTimeInMillis();
		long days = (millis / MILLIS_DAY);
		return days;
	}
	
	public int getSystolic() { return systolic; }
	public int getDiastolic() { return diastolic; }
	public int getRestingHeartRate() { return restingHeartRate; }
	public double getBloodSugar() { return bloodSugar; }
	public int getSleepHours() { return sleepHours; }
	public int getStrengthHours() { return strengthHours; }
	public int getCardioHours() { return cardioHours; }
	public int getWorkHours() { return workHours; }
	public Calendar getCal() { return cal; }
	public long getDay() { return day; }
		
	public void setSystolic(int systolic) { this.systolic = systolic; }
	public void setDiastolic(int diastolic) { this.diastolic = diastolic; }
	public void setRestingHeartRate(int restingHeartRate) { this.restingHeartRate = restingHeartRate; }
	public void setBloodSugar(double bloodSugar) { this.bloodSugar = bloodSugar; }
	public void setCardioHours(int cardioHours) { this.cardioHours = cardioHours; }
	public void setStrengthHours(int strengthHours) { this.strengthHours = strengthHours; }
	public void setSleepHours(int sleepHours) { this.sleepHours = sleepHours; }
	public void setWorkHours(int workHours) { this.workHours = workHours; }
	public void setCal(Calendar cal) { this.cal = cal; }
	public void setDay(long day) { this.day = day; }
	public int compareTo(DataEntry e) { return this.cal.compareTo(e.getCal()); }
	
	@Override
	public String toString() {
		return "DataEntry [cardioHours=" + cardioHours + ", strengthHours="
				+ strengthHours + ", workHours=" + workHours + ", sleepHours="
				+ sleepHours + ", systolic=" + systolic + ", diastolic="
				+ diastolic + ", restingHeartRate=" + restingHeartRate
				+ ", bloodSugar=" + bloodSugar + ", cal=" + cal + "]";
	}
}
