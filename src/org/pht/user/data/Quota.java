package org.pht.user.data;

import java.io.Serializable;


public class Quota implements Serializable
{
	private static final long serialVersionUID = 3504938562290978942L;
	private int strengthGoal, cardioGoal, workGoal, sleepGoal, systolicGoal, 
		diastolicGoal, heartRateGoal;
	private double bloodSugarGoal;
	
	public Quota() { }

	public int getStrengthGoal() {
		return strengthGoal;
	}

	public void setStrengthGoal(int strengthGoal) {
		this.strengthGoal = strengthGoal;
	}

	public int getCardioGoal() {
		return cardioGoal;
	}

	public void setCardioGoal(int cardioGoal) {
		this.cardioGoal = cardioGoal;
	}

	public int getWorkGoal() {
		return workGoal;
	}

	public void setWorkGoal(int workGoal) {
		this.workGoal = workGoal;
	}

	public int getSleepGoal() {
		return sleepGoal;
	}

	public void setSleepGoal(int sleepGoal) {
		this.sleepGoal = sleepGoal;
	}

	public int getSystolicGoal() {
		return systolicGoal;
	}

	public void setSystolicGoal(int systolicGoal) {
		this.systolicGoal = systolicGoal;
	}

	public int getDiastolicGoal() {
		return diastolicGoal;
	}

	public void setDiastolicGoal(int diastolicGoal) {
		this.diastolicGoal = diastolicGoal;
	}

	public int getHeartRateGoal() {
		return heartRateGoal;
	}

	public void setHeartRateGoal(int heartRateGoal) {
		this.heartRateGoal = heartRateGoal;
	}

	public double getBloodSugarGoal() {
		return bloodSugarGoal;
	}

	public void setBloodSugarGoal(double bloodSugarGoal) {
		this.bloodSugarGoal = bloodSugarGoal;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
