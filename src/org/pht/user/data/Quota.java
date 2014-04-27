package org.pht.user.data;

import java.io.Serializable;


public class Quota implements Serializable
{
	private static final long serialVersionUID = 3504938562290978942L;
	private int strengthGoal, cardioGoal, workGoal, sleepGoal, systolicGoal, 
		diastolicGoal, heartRateGoal;
	private double bloodSugarGoal;
	
	public Quota() { }
	
}
