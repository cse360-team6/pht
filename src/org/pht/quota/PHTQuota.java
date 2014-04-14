/*
 * Description:
 * The user can add a desired amount of hours for each activity as well as the
 * desired health status in the quota management section. The software will 
 * use this data against the data input by the user for their activities 
 * completed.
 */

package org.pht.quota;

public class PHTQuota {

	// Health goals
	private int restingHeartRate, systolic, diastolic;
	double bloodSugar;

	// Activity goals
	private int exerciseHours, sleepHours, workHours;

	public PHTQuota() {
		return;
	}

	public PHTQuota(int restingHeartRate, int systolic, int diastolic,
			double bloodSugar, int exerciseHours, int sleepHours, int workHours) {
		this.restingHeartRate = restingHeartRate;
		this.systolic = systolic;
		this.diastolic = diastolic;
		this.bloodSugar = bloodSugar;
		this.exerciseHours = exerciseHours;
		this.sleepHours = sleepHours;
		this.workHours = workHours;
	}

	public int getRestingHeartRate() {
		return restingHeartRate;
	}

	public void setRestingHeartRate(int restingHeartRate) {
		this.restingHeartRate = restingHeartRate;
	}

	public int getSystolic() {
		return systolic;
	}

	public void setSystolic(int systolic) {
		this.systolic = systolic;
	}

	public int getDiastolic() {
		return diastolic;
	}

	public void setDiastolic(int diastolic) {
		this.diastolic = diastolic;
	}

	public double getBloodSugar() {
		return bloodSugar;
	}

	public void setBloodSugar(double bloodSugar) {
		this.bloodSugar = bloodSugar;
	}

	public int getExerciseHours() {
		return exerciseHours;
	}

	public void setExerciseHours(int exerciseHours) {
		this.exerciseHours = exerciseHours;
	}

	public int getSleepHours() {
		return sleepHours;
	}

	public void setSleepHours(int sleepHours) {
		this.sleepHours = sleepHours;
	}

	public int getWorkHours() {
		return workHours;
	}

	public void setWorkHours(int workHours) {
		this.workHours = workHours;
	}

}
