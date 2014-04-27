/**
 * @author Derek Bixler
 * 
 * 
 */

package org.pht.datalib;

import java.util.ArrayList;

public class PHTData extends ArrayList<PHTDataElement> {
	private static final long serialVersionUID = 2340570229023294917L;
	PHTDataFile phtdatafile;
	double avgRestingHeartRate, avgSystolic, avgDiastolic, avgBloodSugar;

	public PHTData() {
		super();
	}

	public void save() {
		phtdatafile = new PHTDataFile();
		this.trimToSize();
		phtdatafile.saveDataFrom(this);
	}

	public void load() {
		phtdatafile = new PHTDataFile();
		phtdatafile.loadDataTo(this);
	}

	public boolean add(int month, int day, int year, int strengthHours,
			int cardioHours, int workHours, int sleepHours,
			int restingHeartRate, int systolic, int diastolic, double bloodSugar) {
		return super.add(new PHTDataElement(month, day, year, strengthHours,
				cardioHours, workHours, sleepHours, restingHeartRate, systolic,
				diastolic, bloodSugar));
	}

	@Override
	public boolean add(PHTDataElement e) {
		if (e != null)
			return super.add(e);
		else
			return false;
	}

	public double[] getMonths() {
		double[] months = new double[this.size()];
		for (int i = 0; i < this.size(); i++)
			months[i] = this.get(i).getMonth() + (this.get(i).getDay() / 30);
		return months;
	}

	public double[] getdays() {
		double[] days = new double[this.size()];
		for (int i = 0; i < this.size(); i++)
			days[i] = this.get(i).getDay();
		return days;
	}

	public double[] getYears() {
		double[] months = new double[this.size()];
		for (int i = 0; i < this.size(); i++)
			months[i] = this.get(i).getYear();
		return months;
	}

	public double[] getRestingHeartRates() {
		double[] restingHeartRates = new double[this.size()];
		for (int i = 0; i < this.size(); i++)
			restingHeartRates[i] = this.get(i).getRestingHeartRate();
		return restingHeartRates;
	}

	public double[] getBloodSugars() {
		double[] bloodSugars = new double[this.size()];
		for (int i = 0; i < this.size(); i++)
			bloodSugars[i] = this.get(i).getBloodSugar();
		return bloodSugars;
	}

	public double[] getSystolics() {
		double[] systolic = new double[this.size()];
		for (int i = 0; i < this.size(); i++)
			systolic[i] = this.get(i).getSystolic();
		return systolic;
	}

	public double[] getDiastolics() {
		double[] diastolic = new double[this.size()];
		for (int i = 0; i < this.size(); i++)
			diastolic[i] = this.get(i).getDiastolic();
		return diastolic;
	}

	public double[] getCardioHours() {
		double[] cardio = new double[this.size()];
		for (int i = 0; i < this.size(); i++)
			cardio[i] = this.get(i).getCardioHours();
		return cardio;
	}

	public double[] getStrengthHours() {
		double[] strength = new double[this.size()];
		for (int i = 0; i < this.size(); i++)
			strength[i] = this.get(i).getStrengthHours();
		return strength;
	}

	public double[] getWorkHours() {
		double[] work = new double[this.size()];
		for (int i = 0; i < this.size(); i++)
			work[i] = this.get(i).getWorkHours();
		return work;
	}

	public double[] getSleepHours() {
		double[] sleep = new double[this.size()];
		for (int i = 0; i < this.size(); i++)
			sleep[i] = this.get(i).getSleepHours();
		return sleep;
	}

	// All-time averages
	public double getAvgRestingHeartRate() {
		return this.average(this.getRestingHeartRates());
	}

	public double getAvgSystolic() {
		return this.average(this.getSystolics());
	}

	public double getAvgDiastolic() {
		return this.average(this.getDiastolics());
	}

	public double getAvgBloodSugar() {
		return this.average(this.getBloodSugars());
	}

	// End all-time averages

	private double weeklyAverage(double A[]) {
		double sum = 0.0;
		for (int i = 0; i < 7; i++) {
			sum += A[A.length - i];
		}

		return sum / 7.0;
	}

	private double average(double A[]) {
		double sum = 0;
		int n = this.size();
		for (int i = 0; i < n; i++) {
			sum += A[i];
		}
		return sum / n;
	}
}
