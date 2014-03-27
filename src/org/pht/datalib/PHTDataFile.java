package org.pht.datalib;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class PHTDataFile {

    /*
     * Other Charset options that would work: "UTF-16" and "US-ASCII"
     */
    private final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
    private Path PATH;

    
    /*
     * Creates a PHTDataFile using a custom path object
     */
    public PHTDataFile(Path p) {
	PATH = p;
    }
    
    /*
     * Creates a PHTDataFile at location /.../.../parentDir/<fileName>.<ext>
     */
    public PHTDataFile(String parentDir, String fileName) {
	PATH = Paths.get(System.getProperty("user.home"), parentDir, fileName);
    }

    /* 
     * Loads values from PHTDataFile to input PHTData instance 
     */
    public boolean loadDataTo(PHTData phtData) {
	try (BufferedReader br = Files.newBufferedReader(PATH, DEFAULT_CHARSET)) {
	    String line = null;
	    int month, day, year, heartBPM;
	    double bloodPressure, bloodSugar;
	    while ((line = br.readLine()) != null) {
		month = new Integer(line);
		day = new Integer(br.readLine());
		year = new Integer(br.readLine());
		heartBPM = new Integer(br.readLine());
		bloodPressure = new Double(br.readLine());
		bloodSugar = new Double(br.readLine());
		phtData.add(month, day, year, heartBPM, bloodPressure,
			bloodSugar);
	    }
	    return true;
	} catch (NumberFormatException | IOException e) {
	    System.err.println("Either the specified file does "
		    + "not exist use newDataFile) or "
		    + "the data is corrupted");
	    return false;
	}
    }
    
    /*
     * Saves values from PHTDataFile to output file
     */
    public boolean saveDataFrom(PHTData phtData) {
	boolean writeWasSuccessful = false;
	String tmp;
	try (BufferedWriter bw = Files.newBufferedWriter(PATH, DEFAULT_CHARSET,
		StandardOpenOption.CREATE)) {
	    for (int i = 0; i < phtData.size(); i++) {
		tmp = phtData.get(i).toString();
		bw.write(tmp, 0, tmp.length());
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return writeWasSuccessful;
    }

}
