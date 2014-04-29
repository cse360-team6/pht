package org.pht.user.data;

import java.io.Serializable;
import java.util.Calendar;

public class Quota implements Serializable {
	private static final long serialVersionUID = 3504938562290978942L;
	private int strengthGoal, cardioGoal, workGoal, sleepGoal,
			strengthWeeklyProgress, cardioWeeklyProgress, workWeeklyProgress,
			sleepWeeklyProgress;

	/*
	 * Only if we can get that far private int systolicGoal, diastolicGoal,
	 * heartRateGoal, systolicWeeklyProgress, diastolicWeeklyProgress,
	 * heartRateWeeklyProgress; private double bloodSugarGoal,
	 * bloodSugarWeeklyProgress;
	 */

	public final static int STRENGTH = 0, CARDIO = 1, WORK = 2, SLEEP = 3;
	Data data;

////	public void main(String args[]) {
//		Calendar cal = Calendar.getInstance();
//		Data data = new Data();
//		int[] actual = { 0, 0, 0, 0 };
//		int[] expected = { 0, 0, 0, 0 };
//		for (int i = 0; i < 20; i++) {
//			cal.set(Calendar.DAY_OF_YEAR, i);
//			data.addEntry(new DataEntry(Calendar.getInstance(), i * 1, i * 2,
//					i * 3, i * 4, i * 5, i * 6, i * 7, i * 1.1));
//		}
//		
//		for (int i = 19; i <= 20; i++) {
//			expected[0] += i*1;
//			expected[1] += i*2;
//			expected[2] += i*3;
//			expected[3] += i*4;
//		}
//		
//		for(int i = 0; i < 4; i++) {
//			System.out.println(expected[i]);
//		}
//	}
	
	public Quota() {

	}
	
	public Quota(Data data) {
		this.data = data;
	}

	public void setWeeklyProgress(Data d) {
		strengthWeeklyProgress = 0;
		cardioWeeklyProgress = 0;
		workWeeklyProgress = 0;
		sleepWeeklyProgress = 0;
		Calendar today = Calendar.getInstance();
		for (int i = Calendar.getInstance().get(Calendar.DAY_OF_WEEK); i > -1; i--, today
				.set(Calendar.DAY_OF_WEEK, i)) {
			DataEntry tmp = d.getEntry(today);
			if (tmp == null) continue;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// public int getSystolicWeeklyProgress() {
	// return systolicWeeklyProgress;
	// }
	//
	// public void setSystolicWeeklyProgress(int systolicWeeklyProgress) {
	// this.systolicWeeklyProgress = systolicWeeklyProgress;
	// }
	//
	// public int getDiastolicWeeklyProgress() {
	// return diastolicWeeklyProgress;
	// }
	//
	// public void setDiastolicWeeklyProgress(int diastolicWeeklyProgress) {
	// this.diastolicWeeklyProgress = diastolicWeeklyProgress;
	// }
	//
	// public int getHeartRateWeeklyProgress() {
	// return heartRateWeeklyProgress;
	// }
	//
	// public void setHeartRateWeeklyProgress(int heartRateWeeklyProgress) {
	// this.heartRateWeeklyProgress = heartRateWeeklyProgress;
	// }
	//
	// public int getSystolicGoal() {
	// return systolicGoal;
	// }
	//
	// public void setSystolicGoal(int systolicGoal) {
	// this.systolicGoal = systolicGoal;
	// }
	//
	// public int getDiastolicGoal() {
	// return diastolicGoal;
	// }
	//
	// public void setDiastolicGoal(int diastolicGoal) {
	// this.diastolicGoal = diastolicGoal;
	// }
	//
	// public int getHeartRateGoal() {
	// return heartRateGoal;
	// }
	//
	// public void setHeartRateGoal(int heartRateGoal) {
	// this.heartRateGoal = heartRateGoal;
	// }
	//
	// public double getBloodSugarGoal() {
	// return bloodSugarGoal;
	// }
	//
	// public void setBloodSugarGoal(double bloodSugarGoal) {
	// this.bloodSugarGoal = bloodSugarGoal;
	// }
	//
	//
	// public double getBloodSugarWeeklyProgress() {
	// return bloodSugarWeeklyProgress;
	// }
	//
	// public void setBloodSugarWeeklyProgress(double bloodSugarWeeklyProgress)
	// {
	// this.bloodSugarWeeklyProgress = bloodSugarWeeklyProgress;
	// }
}
