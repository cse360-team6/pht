package org.pht.ui.activity;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;

import org.pht.PersonalHealthTracker;
import org.pht.user.User;
import org.pht.user.data.DataEntry;

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
	            		addBloodPressure();
	            	} else
     	
	            	//If the user is entering Blood Sugar
	            	if(((String) activities.getSelectedItem()).equals(healthInformation[1])) {
	            		addBloodSugar();
	            	} else
	            	
	            	//If the user is entering Heart Rate
	            	if(((String) activities.getSelectedItem()).equals(healthInformation[2])) {
	            		addHeartRate();
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

    private boolean addHeartRate() {
    	int hr;
		try {
			hr = Integer.parseInt(value.getText());
		} catch (Exception exc) {
			notice.setText("Error: Invalid Heart Rate Value");
			return false;
		}
		if (dateChooser.getCalendar() == null){
			notice.setText("  Error: Please Select Date");
			return false;
		} else if (dateChooser.getCalendar().compareTo(Calendar.getInstance()) > 0) {
			notice.setText("  Error: Please Select Valid Date");
			return false;
		}
    	dateAdded = dateChooser.getCalendar();
		
		//If the entered values are within a valid range, parse the strings for the integer values and close the window
		if(hr > 0 && hr < 300) {
			heartRate = hr;
			memoStored = memo.getText();
        	typeStored = (String) activities.getSelectedItem();
        	User user = PersonalHealthTracker.getMainFrame().getUsers().getUsers().get(PersonalHealthTracker.getMainFrame().getCurrentUser());
        	DataEntry de = user.getData().getEntry(dateAdded);
			if (de == null)
				user.getData().addEntry(dateAdded, 0, 0, 0, 0, 0, 0, heartRate, 0, memoStored);
			else
				de.setRestingHeartRate(heartRate);
        	dispose();	    	            	
		} else {
			notice.setText("Error: Invalid Blood Sugar Value");
			return false;
		}
		return true;
    	
    }

    private boolean addBloodPressure() {
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
    			return false;
    		}
    		
    		if(s < 240 && s > 0 && d < 240 && d > 0) {
    			systolic = s;
    			diastolic = d;
    			memoStored = memo.getText();
    			typeStored = (String)activities.getSelectedItem();
    			if (dateChooser.getCalendar() == null){
					notice.setText("  Error: Please Select Date");
					return false;
				} else if (dateChooser.getCalendar().compareTo(Calendar.getInstance()) > 0) {
					notice.setText("  Error: Please Select Valid Date");
					return false;
				}
            	dateAdded = dateChooser.getCalendar();
    			User user = PersonalHealthTracker.getMainFrame().getUsers().getUsers().get(PersonalHealthTracker.getMainFrame().getCurrentUser());
    			DataEntry de = user.getData().getEntry(dateAdded);
    			if (de == null)
    				user.getData().addEntry(dateAdded, 0, 0, 0, 0, s, d, 0, 0, memoStored);
    			else {
    				de.setSystolic(s);
    				de.setDiastolic(d);
    			}
    			dispose();
    		} else {
    			notice.setText("Error: Invalid Blood Pressure Sys/Dia");
    			return false;		            			
    		}
		}
		return true;
    }

    private boolean addBloodSugar() {
    	int bs;
		try {
			bs = Integer.parseInt(value.getText());
		} catch (Exception exc) {
			notice.setText("Error: Invalid Blood Sugar Value");
			return false;
		}
		
		//If the entered values are within a valid range, parse the strings for the integer values and close the window
		if(bs > 0 && bs < 400) {
			bloodSugar = bs;
			memoStored = memo.getText();
        	typeStored = (String) activities.getSelectedItem();
        	if (dateChooser.getCalendar() == null){
				notice.setText("  Error: Please Select Date");
				return false;
			} else if (dateChooser.getCalendar().compareTo(Calendar.getInstance()) > 0) {
				notice.setText("  Error: Please Select Valid Date");
				return false;
			}
        	dateAdded = dateChooser.getCalendar();
			User user = PersonalHealthTracker.getMainFrame().getUsers().getUsers().get(PersonalHealthTracker.getMainFrame().getCurrentUser());
			DataEntry de = user.getData().getEntry(dateAdded);
			if (de == null)
				user.getData().addEntry(dateAdded, 0, 0, 0, 0, 0, 0, 0, bloodSugar, memoStored);
			else
				de.setBloodSugar(bloodSugar);
			dispose();
		} else {
			notice.setText("Error: Invalid Blood Sugar Value");
			return false;
		}
		return true;
    }
}
