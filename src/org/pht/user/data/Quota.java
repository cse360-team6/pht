package org.pht.user.data;

import java.io.Serializable;

public class Quota implements Serializable {
	private static final long serialVersionUID = 3504938562290978942L;
	private int strengthGoal, cardioGoal, workGoal, sleepGoal, systolicGoal,
			diastolicGoal, heartRateGoal, strengthProgress, cardioProgress,
			workProgress, sleepProgress, systolicProgress, diastolicProgress,
			heartRateProgress;
	private double bloodSugarGoal, bloodSugarProgress;

	public Quota() { 
		this.calculateProgress();
	}
	
	public void calculateProgress() {
		
	}
	
	public double getBloodSugarProgress() {
		return bloodSugarProgress;
	}

	public void setBloodSugarProgress(double bloodSugarProgress) {
		this.bloodSugarProgress = bloodSugarProgress;
	}
	
	public int getStrengthProgress() {
		return strengthProgress;
	}

	public void setStrengthProgress(int strengthProgress) {
		this.strengthProgress = strengthProgress;
	}

	public int getCardioProgress() {
		return cardioProgress;
	}

	public void setCardioProgress(int cardioProgress) {
		this.cardioProgress = cardioProgress;
	}

	public int getWorkProgress() {
		return workProgress;
	}

	public void setWorkProgress(int workProgress) {
		this.workProgress = workProgress;
	}

	public int getSleepProgress() {
		return sleepProgress;
	}

	public void setSleepProgress(int sleepProgress) {
		this.sleepProgress = sleepProgress;
	}

	public int getSystolicProgress() {
		return systolicProgress;
	}

	public void setSystolicProgress(int systolicProgress) {
		this.systolicProgress = systolicProgress;
	}

	public int getDiastolicProgress() {
		return diastolicProgress;
	}

	public void setDiastolicProgress(int diastolicProgress) {
		this.diastolicProgress = diastolicProgress;
	}

	public int getHeartRateProgress() {
		return heartRateProgress;
	}

	public void setHeartRateProgress(int heartRateProgress) {
		this.heartRateProgress = heartRateProgress;
	}

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
