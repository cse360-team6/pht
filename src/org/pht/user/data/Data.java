package org.pht.user.data;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;

public class Data extends HashMap<Long, DataEntry> implements Serializable {
	private static final long MILLIS_DAY = 86400000;
	private static final long serialVersionUID = -3059143241386106119L;
	private String userName;

	public Data() {
	}
	
	public Data(String userName) {
		this.userName = userName;
	}

	public DataEntry getEntryByDate(Calendar date) {
		long day = date.getTimeInMillis() / MILLIS_DAY;
		return this.get(day);
	}

	public void addEntry(DataEntry e) {

	}

	public void deleteEntry(Calendar cal) { // TODO Auto-generated method stub
	}

	public void replaceEntryByDate(Calendar cal, DataEntry e) { // TODO
																// Auto-generated
																// method stub
	}
	
	
	
	// Setters and Getters
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
