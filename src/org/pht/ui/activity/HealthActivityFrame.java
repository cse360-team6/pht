package org.pht.ui.activity;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HealthActivityFrame extends ActivityFrame {
    private static final long serialVersionUID = -7544441861748313095L;

    //Properties
	private static String[] healthInformation = { "Blood Pressure", "Blood Sugar", "Heart Rate"};
	private int systolic, diastolic, bloodSugar, heartRate;
	private	static JPanel healthComponent;
	private static JTextField value, memo;
	private static JLabel notice = new JLabel("");

    // Constructors
	public HealthActivityFrame() {
		//Create an Activity frame with Health Information components
		super(healthInformation, new String("Add Health Information"), createHealthComponents());
	
		//Add action listener to ok button to save the information entered by the user
		ok.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if (e.getSource() instanceof JButton) {
	            	
	            	//If the user is entering Blood Pressure
	            	if(((String) activities.getSelectedItem()).compareTo(healthInformation[0]) == 0) {
	            		ArrayList<String> bp = new ArrayList<String>(Arrays.asList(value.getText().split("/")));
	            		
	            		if(Integer.parseInt(bp.get(0)) < 240 && Integer.parseInt(bp.get(1)) > 0) {
	            			systolic = Integer.parseInt(bp.get(0));
	            			diastolic = Integer.parseInt(bp.get(1));
	            			memoStored = memo.getText();
	            			typeStored = (String)activities.getSelectedItem();
	            			dispose();
	            		}
	            	}
	            	else {
	            		notice.setText(new String("Error: Invalid Blood Pressure Levels"));
	            	}
	            	
	            	//If the user is entering Blood Sugar
	            	if(((String) activities.getSelectedItem()).compareTo(healthInformation[1]) == 0) {
	            		
	            		//If the entered values are within a valid range, parse the strings for the integer values and close the window
	            		if(Integer.parseInt(value.getText()) > 0 && Integer.parseInt(value.getText()) < 400) {
	            			bloodSugar = Integer.parseInt(value.getText());
	            			memoStored = memo.getText();
	    	            	typeStored = (String) activities.getSelectedItem();
	    	            	dispose();
	            		}
	            		
	            		//Otherwise, display an error inside the window
	            		else {
	            			notice.setText(new String("Error: Invalid Blood Sugar Levels"));	            			
	            		}
	            	}
	            	
	            	//If the user is entering Heart Rate
	            	if(((String) activities.getSelectedItem()).compareTo(healthInformation[2]) == 0) {
	            		
	            		//If the entered values are within a valid range, parse the strings for the integer values and close the window
	            		if(Integer.parseInt(value.getText()) > 0 && Integer.parseInt(value.getText()) < 300) {
	            			heartRate = Integer.parseInt(value.getText());
	            			memoStored = memo.getText();
	    	            	typeStored = (String) activities.getSelectedItem();
	    	            	dispose();
	    	            	
	            		}
	            		
	            		//Otherwise, display an error inside the window
	            		else {
	            			notice.setText("Error: Invalid Heart Rate Levels");
	            		}
	            	}
	            }
	        }
	    });
	}

    private static JPanel createHealthComponents() {
		healthComponent = new JPanel();
		
		//Instantiate new text fields to hold user information
		value = new JTextField("Value");
		memo = new JTextField("Memos");
		
		value.setPreferredSize(new Dimension(200, 20));
		memo.setPreferredSize(new Dimension(200, 100));
		
		//Add each field to the JPanel to be returned by the function
		healthComponent.add(value);
		healthComponent.add(memo);
		healthComponent.add(notice);
		
		return healthComponent;
    }

    //Accessors
	public int getSystolic() {
		//Return Blood Pressure entered
		return systolic;
	}
	public int getDiastolic() {
		return diastolic;
	}
	public int getBloodSugar() {
		//Return Blood Sugar entered
		return bloodSugar;
	}
	public int getHeartRate() {
		//Return Heart Rate entered
		return heartRate;
	}
}
