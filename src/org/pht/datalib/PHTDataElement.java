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
    protected int day, month, year, heartBPM;
    protected double bloodPressure, bloodSugar;
    protected String fileForm;

    // Constructor
    public PHTDataElement(int month, int day, int year, int heartBPM,
	    double bloodPressure, double bloodSugar) {
	this.month = month;
	this.day = day;
	this.year = year;
	this.heartBPM = heartBPM;
	this.bloodPressure = bloodPressure;
	this.bloodSugar = bloodSugar;
	this.fileForm = this.toString();
    }

    public void setDate(int month, int day, int year) {
	this.month = month;
	this.day = day;
	this.year = year;
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

    public double getBloodPressure() {
	return bloodPressure;
    }

    public double getBloodSugar() {
	return bloodSugar;
    }

    public int getHeartBPM() {
	return heartBPM;
    }

    public String getFileForm() {
	return fileForm;
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

    public void setBloodPressure(double bloodPressure) {
	this.bloodPressure = bloodPressure;
    }

    public void setBloodSugar(double bloodSugar) {
	this.bloodSugar = bloodSugar;
    }

    public void setHeartBPM(int heartBPM) {
	this.heartBPM = heartBPM;
    }

    public void setFileForm(String fileForm) {
	this.fileForm = fileForm;
    }

    public void print(Object obj) {
	System.err.println(obj);
    }

    public String toString() {
	return (month + "\n" + day + "\n" + year + "\n" + heartBPM + "\n"
		+ bloodPressure + "\n" + bloodSugar + "\n");
    }

}
