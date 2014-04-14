/*
 * Personal Health Tracker
 *
 * Author: 	Derek Bixler
 * Date:   	March 25, 2014
 * Summary: 	Serves as a container for Personal Health Tracker medical
 * 		data when loaded from text files.
 * 
 */

package org.pht.datalib;

public class PHTDataElement {

	// Constants and Class Variables
	protected int day, month, year, restingHeartRate, systolic, diastolic;
	protected double bloodSugar;
	protected String fileForm;

	// Constructors
	public PHTDataElement() {
	}

	public PHTDataElement(int month, int day, int year, int restingHeartRate,
			int systolic, int diastolic, double bloodSugar) {
		this.month = month;
		this.day = day;
		this.year = year;
		this.restingHeartRate = restingHeartRate;
		this.systolic = systolic;
		this.diastolic = diastolic;
		this.bloodSugar = bloodSugar;
		this.fileForm = this.toString();
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public int getSystolic() {
		return systolic;
	}

	public int getDiastolic() {
		return diastolic;
	}

	public double getBloodSugar() {
		return bloodSugar;
	}

	public int getRestingHeartRate() {
		return restingHeartRate;
	}

	public String getFileForm() {
		return fileForm;
	}

	public void setDate(int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setSystolic(int systolic) {
		this.systolic = systolic;
	}

	public void setDiastolic(int diastolic) {
		this.diastolic = diastolic;
	}

	public void setBloodSugar(double bloodSugar) {
		this.bloodSugar = bloodSugar;
	}

	public void setrestingHeartRate(int restingHeartRate) {
		this.restingHeartRate = restingHeartRate;
	}

	public void setFileForm(String fileForm) {
		this.fileForm = fileForm;
	}

	public void print(Object obj) {
		System.err.println(obj);
	}

	public String toString() {
		return (month + "\n" + day + "\n" + year + "\n" + restingHeartRate
				+ "\n" + systolic + "\n" + diastolic + "\n" + bloodSugar + "\n");
	}

}
