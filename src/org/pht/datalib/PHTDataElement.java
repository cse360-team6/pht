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

public class PHTDataElement
{

    // Constants and Class Variables
    protected int day, month, year, strengthHours, cardioHours, workHours,
            sleepHours, restingHeartRate, systolic, diastolic;
    protected double bloodSugar;
    protected String str; // Each data member is on a new line for
                          // saving the data to file.

    // Constructors
    public PHTDataElement()
    {
        this.month = 0;
        this.day = 0;
        this.year = 0;
        this.strengthHours = 0;
        this.cardioHours = 0;
        this.workHours = 0;
        this.sleepHours = 0;
        this.restingHeartRate = 0;
        this.systolic = 0;
        this.diastolic = 0;
        this.bloodSugar = 0.0;
        this.str = this.cacheToString();
    }

    /*
     * It is faster to use this constructor, it sets all variables for the class
     * and only uses cacheToString() once compared to caching each use of a
     * setter method. cacheToString will save computation time when saving
     * files.
     */
    public PHTDataElement(int month, int day, int year, int strengthHours,
            int cardioHours, int workHours, int sleepHours,
            int restingHeartRate, int systolic, int diastolic, double bloodSugar)
    {
        this.month = month;
        this.day = day;
        this.year = year;
        this.strengthHours = strengthHours;
        this.cardioHours = cardioHours;
        this.workHours = workHours;
        this.sleepHours = sleepHours;
        this.restingHeartRate = restingHeartRate;
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.bloodSugar = bloodSugar;
        this.str = this.cacheToString();
    }

    public void setDate(int month, int day, int year)
    {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public int getDay()
    {
        return day;
    }

    public void setDay(int day)
    {
        this.day = day;
        this.cacheToString();
    }

    public int getMonth()
    {
        return month;
    }

    public void setMonth(int month)
    {
        this.month = month;
        this.cacheToString();
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
        this.cacheToString();
    }

    public int getStrengthHours()
    {
        return strengthHours;
    }

    public void setStrengthHours(int strengthHours)
    {
        this.strengthHours = strengthHours;
        this.cacheToString();
    }

    public int getCardioHours()
    {
        return cardioHours;
    }

    public void setCardioHours(int cardioHours)
    {
        this.cardioHours = cardioHours;
        this.cacheToString();
    }

    public int getWorkHours()
    {
        return workHours;
    }

    public void setWorkHours(int workHours)
    {
        this.workHours = workHours;
        this.cacheToString();
    }

    public int getSleepHours()
    {
        return sleepHours;
    }

    public void setSleepHours(int sleepHours)
    {
        this.sleepHours = sleepHours;
        this.cacheToString();
    }

    public int getRestingHeartRate()
    {
        return restingHeartRate;
    }

    public void setRestingHeartRate(int restingHeartRate)
    {
        this.restingHeartRate = restingHeartRate;
        this.cacheToString();
    }

    public int getSystolic()
    {
        return systolic;
    }

    public void setSystolic(int systolic)
    {
        this.systolic = systolic;
        this.cacheToString();
    }

    public int getDiastolic()
    {
        return diastolic;
    }

    public void setDiastolic(int diastolic)
    {
        this.diastolic = diastolic;
        this.cacheToString();
    }

    public double getBloodSugar()
    {
        return bloodSugar;
    }

    public void setBloodSugar(double bloodSugar)
    {
        this.bloodSugar = bloodSugar;
        this.cacheToString();
    }

    public String toString()
    {
        return this.str;
    }

    private String cacheToString()
    {
        return (month + "\n" + day + "\n" + year + "\n" + strengthHours + "\n"
                + cardioHours + "\n" + workHours + "\n" + sleepHours + "\n"
                + restingHeartRate + "\n" + systolic + "\n" + diastolic + "\n"
                + bloodSugar + "\n");
    }

}
