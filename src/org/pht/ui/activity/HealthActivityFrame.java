package org.pht.ui.activity;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;

import com.toedter.calendar.JDateChooser;

public class HealthActivityFrame extends ActivityFrame {
    private static final long serialVersionUID = -7544441861748313095L;

    //Properties
	private static String[] healthInformation = { "Blood Pressure", "Blood Sugar", "Heart Rate"};
	private int systolic, diastolic, bloodSugar, heartRate;
	private	static JPanel healthComponent;
	private static JTextField value;
	private static JTextArea memo;
	private static JScrollPane memoSPane;
	private static JDateChooser dateChooser;
	private static JLabel dateLbl;
	private static JLabel notice;

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
	            	if(((String) activities.getSelectedItem()).equals(healthInformation[0])) {
	            		ArrayList<String> bp = new ArrayList<String>(Arrays.asList(value.getText().split("/")));
	            		if (bp.size() < 2) {
	            			notice.setText("Error: Invalid Blood Pressure Sys/Dia");
	            		} else {		 
	            			int s, d;
		            		try {
		            			s = Integer.parseInt(bp.get(0));
		            			d = Integer.parseInt(bp.get(1));
		            		} catch(Exception exc) {
		            			notice.setText("Error: Invalid Blood Pressure Sys/Dia");
		            			return;
		            		}
		            		
		            		if(s < 240 && s > 0 && d < 240 && d > 0) {
		            			systolic = Integer.parseInt(bp.get(0));
		            			diastolic = Integer.parseInt(bp.get(1));
		            			memoStored = memo.getText();
		            			typeStored = (String)activities.getSelectedItem();
		            			if (dateChooser.getCalendar() != null) {
				            		dateAdded = dateChooser.getCalendar();
				            	}
		            			dispose();
		            		} else {
		            			notice.setText("Error: Invalid Blood Pressure Sys/Dia");
		            			return;		            			
		            		}
	            		}
	            	}
     	
	            	//If the user is entering Blood Sugar
	            	if(((String) activities.getSelectedItem()).equals(healthInformation[1])) {
	            		
	            		int bs;
	            		try {
	            			bs = Integer.parseInt(value.getText());
	            		} catch (Exception exc) {
	            			notice.setText("Error: Invalid Blood Sugar Value");
	            			return;
	            		}
	            		
	            		//If the entered values are within a valid range, parse the strings for the integer values and close the window
	            		if(Integer.parseInt(value.getText()) > 0 && Integer.parseInt(value.getText()) < 400) {
	            			bloodSugar = Integer.parseInt(value.getText());
	            			memoStored = memo.getText();
	    	            	typeStored = (String) activities.getSelectedItem();
	            			if (dateChooser.getCalendar() != null) {
			            		dateAdded = dateChooser.getCalendar();
			            	}
	    	            	dispose();
	            		} else {
	            			notice.setText("Error: Invalid Blood Sugar Value");
	            			return;
	            		}
	            	}
	            	
	            	//If the user is entering Heart Rate
	            	if(((String) activities.getSelectedItem()).equals(healthInformation[2])) {
	            		
	            		int hr;
	            		try {
	            			hr = Integer.parseInt(value.getText());
	            		} catch (Exception exc) {
	            			notice.setText("Error: Invalid Heart Rate Value");
	            			return;
	            		}
	            		
	            		//If the entered values are within a valid range, parse the strings for the integer values and close the window
	            		if(Integer.parseInt(value.getText()) > 0 && Integer.parseInt(value.getText()) < 300) {
	            			heartRate = Integer.parseInt(value.getText());
	            			memoStored = memo.getText();
	    	            	typeStored = (String) activities.getSelectedItem();
	    	            	dispose();	    	            	
	            		} else {
	            			notice.setText("Error: Invalid Blood Sugar Value");
	            			return;
	            		}
	            	}
	            }
	        }
	    });
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
		setTitle("Add Health Activity");	
        setVisible(true);
	}

    private static JPanel createHealthComponents() {
		healthComponent = new JPanel();
		
		//Instantiate new text fields to hold user information
		value = new JTextField("Value");
		memo = new JTextArea("Memos");
		memoSPane = new JScrollPane(memo);
		dateChooser = new JDateChooser();
		dateLbl = new JLabel("Date:");
		notice = new JLabel(" ");

		dateChooser.setPreferredSize(new Dimension(160, 30));
		memo.setLineWrap(true);
		memoSPane.setPreferredSize(new Dimension(200, 120));
		value.setPreferredSize(new Dimension(200, 20));
		notice.setForeground(Color.RED);

		
		//Add each field to the JPanel to be returned by the function
		healthComponent.add(value);
		healthComponent.add(memoSPane);
		healthComponent.add(setTwoComponents(dateLbl, dateChooser));
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
