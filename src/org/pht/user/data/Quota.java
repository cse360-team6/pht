package org.pht.user.data;

import java.io.Serializable;
import java.util.Calendar;

public class Quota implements Serializable {
	private static final long serialVersionUID = 3504938562290978942L;
	private int strengthGoal, cardioGoal, workGoal, sleepGoal, systolicGoal,
			diastolicGoal, heartRateGoal, strengthWeeklyProgress,
			cardioWeeklyProgress, workWeeklyProgress, sleepWeeklyProgress,
			systolicWeeklyProgress, diastolicWeeklyProgress,
			heartRateWeeklyProgress;
	private double bloodSugarGoal, bloodSugarWeeklyProgress;
	public final static int STRENGTH = 0, CARDIO = 1, WORK = 2, SLEEP = 3;
	
	public Quota() {

	}

	public void setWeeklyProgress(Data d) {
		Calendar today = Calendar.getInstance();
		strengthWeeklyProgress = 0;
		cardioWeeklyProgress = 0;
		workWeeklyProgress = 0;
		sleepWeeklyProgress = 0;
		for (int i = Calendar.getInstance().get(Calendar.DAY_OF_WEEK); i > -1; i--, today
				.set(Calendar.DAY_OF_WEEK, i)) {
			DataEntry tmp = d.getEntry(today);
			this.strengthWeeklyProgress += tmp.getStrengthHours();
			this.cardioWeeklyProgress += tmp.getCardioHours();
			this.workWeeklyProgress += tmp.getWorkHours();
			this.sleepWeeklyProgress += tmp.getSleepHours();
		}
	}

	public int[] getWeeklyProgress() {
		int prog[] = new int[4];
		prog[STRENGTH] = this.strengthWeeklyProgress;
		prog[CARDIO] = this.cardioWeeklyProgress;
		prog[WORK] = this.workWeeklyProgress;
		prog[SLEEP] = this.sleepWeeklyProgress;

		return prog;
	}

	public double getBloodSugarWeeklyProgress() {
		return bloodSugarWeeklyProgress;
	}

	public void setBloodSugarWeeklyProgress(double bloodSugarWeeklyProgress) {
		this.bloodSugarWeeklyProgress = bloodSugarWeeklyProgress;
	}

	public int getStrengthWeeklyProgress() {
		return strengthWeeklyProgress;
	}

	public void setStrengthWeeklyProgress(int strengthWeeklyProgress) {
		this.strengthWeeklyProgress = strengthWeeklyProgress;
	}

	public int getCardioWeeklyProgress() {
		return cardioWeeklyProgress;
	}

	public void setCardioWeeklyProgress(int cardioWeeklyProgress) {
		this.cardioWeeklyProgress = cardioWeeklyProgress;
	}

	public int getWorkWeeklyProgress() {
		return workWeeklyProgress;
	}

	public void setWorkWeeklyProgress(int workWeeklyProgress) {
		this.workWeeklyProgress = workWeeklyProgress;
	}

	public int getSleepWeeklyProgress() {
		return sleepWeeklyProgress;
	}

	public void setSleepWeeklyProgress(int sleepWeeklyProgress) {
		this.sleepWeeklyProgress = sleepWeeklyProgress;
	}

	public int getSystolicWeeklyProgress() {
		return systolicWeeklyProgress;
	}

	public void setSystolicWeeklyProgress(int systolicWeeklyProgress) {
		this.systolicWeeklyProgress = systolicWeeklyProgress;
	}

	public int getDiastolicWeeklyProgress() {
		return diastolicWeeklyProgress;
	}

	public void setDiastolicWeeklyProgress(int diastolicWeeklyProgress) {
		this.diastolicWeeklyProgress = diastolicWeeklyProgress;
	}

	public int getHeartRateWeeklyProgress() {
		return heartRateWeeklyProgress;
	}

	public void setHeartRateWeeklyProgress(int heartRateWeeklyProgress) {
		this.heartRateWeeklyProgress = heartRateWeeklyProgress;
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
