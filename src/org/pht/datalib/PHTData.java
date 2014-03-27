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

    private static final long serialVersionUID = 2340570229023294917L;

    private final Path DEFAULT_PATH = Paths.get(
	    System.getProperty("user.home"), "/Personal Health Tracker",
	    "phtdata.txt");
    private Path FILE_PATH;

    /*
     * Default constructor that uses the default file path. 
     * "~/Personal Health Tracker/phtdata.txt"
     */
    public PHTData() {
	super();
	FILE_PATH = DEFAULT_PATH;
    }

    /**
     * New PHT data file with fileName located in parentDir.
     * <p>
     * The parent directory must be the full path and the file name must include
     * the extension. For example, PHTData("C:\my secret
     * folder", "things-i-love-about-cats.txt"
     * <p>
     * To create a file using ~/Personal Health Tracker/phtdata.txt use the
     * default constructor instead.
     * 
     * @param parentDir the parent directory's full path
     * @param fileName the name and extension
     */
    public PHTData(String parentDir, String fileName) {
	super();
	FILE_PATH = Paths.get(System.getProperty("user.home"), parentDir,
		fileName);
    }

    /**
     * Saves values of self to file.
     * <p>
     * If default constructor was used,
     */
    public void save() {
	PHTDataFile io = new PHTDataFile(FILE_PATH);
	this.trimToSize();
	io.saveDataFrom(this);
    }

    /**
     * Loads contents of file PATH to PHTData
     * 
     * 
     */
    public void load() {
	PHTDataFile io = new PHTDataFile(FILE_PATH);
	io.loadDataTo(this);
    }

    /*
     * Adds PHTDataElement created from user-supplied data values
     */
    public boolean add(int month, int day, int year, int heartBPM,
	    double bloodPressure, double bloodSugar) {
	return super.add(new PHTDataElement(month, day, year, heartBPM,
		bloodPressure, bloodSugar));
    }

    /**
     * Adds a user-supplied PHTDataElement to self.
     * <p>
     * Overrides ArrayList.add().
     * 
     * @param 	a data element with values initialized
     * @return 	true if element was added, false otherwise.
     * @see 	java.util.ArrayList#add(java.lang.Object)
     */
    @Override
    public boolean add(PHTDataElement e) {
	if (e != null)
	    return super.add(e);
	else
	    return false;
    }

    /**
     * @return an array containing months 1-12
     */
    public int[] getMonths() {
	int[] months = new int[this.size()];
	for (int i = 0; i < this.size(); i++) {
	    months[i] = this.get(i).getMonth();
	}
	return months;
    }

    /**
     * @return an array containing days 1-31
     */
    public int[] getdays() {
	int[] days = new int[this.size()];
	for (int i = 0; i < this.size(); i++) {
	    days[i] = this.get(i).getDay();
	}
	return days;
    }

    /**
     * @return an array containing years XXXX-XXXX
     */
    public int[] getYears() {
	int[] months = new int[this.size()];
	for (int i = 0; i < this.size(); i++) {
	    months[i] = this.get(i).getYear();
	}
	return months;
    }

    /**
     * @return an array containing heart rate measurements
     */
    public int[] getHeartBPMs() {
	int[] heartBPMs = new int[this.size()];
	for (int i = 0; i < this.size(); i++) {
	    heartBPMs[i] = this.get(i).getHeartBPM();
	}
	return heartBPMs;
    }

    /**
     * @return an array containing blood sugar measurements
     */
    public double[] getBloodSugars() {
	double[] bloodSugars = new double[this.size()];
	for (int i = 0; i < this.size(); i++) {
	    bloodSugars[i] = this.get(i).getBloodSugar();
	}
	return bloodSugars;
    }

    /**
     * @return an array containing blood pressure measurements
     */
    public double[] getbloodPressures() {
	double[] bloodPressures = new double[this.size()];
	for (int i = 0; i < this.size(); i++) {
	    bloodPressures[i] = this.get(i).getBloodPressure();
	}
	return bloodPressures;
    }

}
