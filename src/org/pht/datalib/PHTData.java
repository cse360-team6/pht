/**
 * @author Derek Bixler
 * 
 * 
 */

package org.pht.datalib;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class PHTData extends ArrayList<PHTDataElement> {

	private Path FILE_PATH;
	private static final long serialVersionUID = 2340570229023294917L;
	private final Path DEFAULT_PATH = Paths.get(
			System.getProperty("user.home"), "/Personal Health Tracker",
			"phtdata.txt");

	public PHTData() {
		super();
		FILE_PATH = DEFAULT_PATH;
	}

	public PHTData(String parentDir, String fileName) {
		super();
		FILE_PATH = Paths.get(System.getProperty("user.home"), parentDir,
				fileName);
	}

	public void save() {
		PHTDataFile io = new PHTDataFile(FILE_PATH);
		this.trimToSize();
		io.saveDataFrom(this);
	}

	public void load() {
		PHTDataFile io = new PHTDataFile(FILE_PATH);
		io.loadDataTo(this);
	}

	public boolean add(int month, int day, int year, int restingHeartRate,
			int systolic, int diastolic, double bloodSugar) {
		return super.add(new PHTDataElement(month, day, year, restingHeartRate,
				systolic, diastolic, bloodSugar));
	}

	public boolean add(PHTDataElement e) {
		if (e != null)
			return super.add(e);
		else
			return false;
	}

	public int[] getMonths() {
		int[] months = new int[this.size()];
		for (int i = 0; i < this.size(); i++) {
			months[i] = this.get(i).getMonth();
		}
		return months;
	}

	public int[] getdays() {
		int[] days = new int[this.size()];
		for (int i = 0; i < this.size(); i++) {
			days[i] = this.get(i).getDay();
		}
		return days;
	}

	public int[] getYears() {
		int[] months = new int[this.size()];
		for (int i = 0; i < this.size(); i++) {
			months[i] = this.get(i).getYear();
		}
		return months;
	}

	public int[] getRestingHeartRates() {
		int[] restingHeartRates = new int[this.size()];
		for (int i = 0; i < this.size(); i++) {
			restingHeartRates[i] = this.get(i).getRestingHeartRate();
		}
		return restingHeartRates;
	}

	public double[] getBloodSugars() {
		double[] bloodSugars = new double[this.size()];
		for (int i = 0; i < this.size(); i++) {
			bloodSugars[i] = this.get(i).getBloodSugar();
		}
		return bloodSugars;
	}

	public double[][] getbloodPressures() {
		double[][] bloodPressures = new double[this.size()][2];
		for (int i = 0; i < this.size(); i++) {
			bloodPressures[i][0] = this.get(i).getSystolic();
			bloodPressures[i][1] = this.get(i).getDiastolic();
		}
		return bloodPressures;
	}

}
