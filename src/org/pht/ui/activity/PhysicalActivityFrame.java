package org.pht.ui.activity;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.pht.PersonalHealthTracker;
import org.pht.user.User;

import com.toedter.calendar.JDateChooser;

public class PhysicalActivityFrame extends ActivityFrame {

	//Properties
	private int minutesStored, hoursStored;
	private static String[] physicalActivities = { "Cardio Workout", "Strength Workout", "Work Hours", "Time Slept"};
	private static JButton timer;
	private static JTextField hours, minutes;
	private static JTextArea memo;
	private static JPanel physicalComponent;
	private static JLabel notice;
	private static JScrollPane memoSPane;
	private static JDateChooser dateChooser;
	private static JLabel dateLbl;	

    // Constructors
    public PhysicalActivityFrame() {
		//Create an Activity frame with Physical Activity components
		super(physicalActivities, new String("Add Physical Activity"), createPhysicalComponents());
		
		//Add action listener to ok button to save the information entered by the user
		ok.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if (e.getSource() instanceof JButton) {
	            	int h, m;
	            	try {
	            		h = Integer.parseInt(hours.getText());
	            		m = Integer.parseInt(minutes.getText());
	            	} catch (Exception exc) {
	            		notice.setText("Error: Invalid Time Entered");
	            		h = m = 100;
	            	}
	            	
	            	//If they are valid entries, parse the integer values from the strings and close the window
	            	if (m < 60 && h < 24) {
	            		minutesStored = m;
	            		hoursStored = h;
	            		int totalMin = (h*60) + m;
		            	memoStored = memo.getText();
		            	typeStored = (String) activities.getSelectedItem();
		            	
		            	if (dateChooser.getCalendar() != null) {
		            		dateAdded = dateChooser.getCalendar();
		            	}
		            	User user = PersonalHealthTracker.getMainFrame().getUsers().getUsers().get(PersonalHealthTracker.getMainFrame().getCurrentUser());
		            	switch((String)activities.getSelectedItem()) {
		            		case "Cardio Workout":
            					user.getData().addEntry(dateAdded, totalMin, 0, 0, 0, 0, 0, 0, 0, memoStored);
            					break;
            				case "Strength Workout":
            					user.getData().addEntry(dateAdded, 0, totalMin, 0, 0, 0, 0, 0, 0, memoStored);
            					break;
            				case "Work Hours":
            					user.getData().addEntry(dateAdded, 0, 0, totalMin, 0, 0, 0, 0, 0, memoStored);
	        					break;
	        				case "Time Slept":
            					user.getData().addEntry(dateAdded, 0, 0, 0, totalMin, 0, 0, 0, 0, memoStored);
	        					break;
            			}
		            	dispose();
		            	
	            	}
	            	
	            	//Otherwise, display an error inside the window
	            	else {
	            		notice.setText("Error: Invalid Time Entered");
	            	}    
	            }
	        }
	    });
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setTitle("Add Physical Activity");
        setVisible(true);
	}

    private static JPanel createPhysicalComponents() {
		physicalComponent = new JPanel();
		
		//Instantiate new text fields to hold user information
		hours = new JTextField("Hours");		
		minutes = new JTextField("Minutes");
		timer = new JButton("Timer");
		memo = new JTextArea("Memos");
		memoSPane = new JScrollPane(memo);
		dateChooser = new JDateChooser();
		dateLbl = new JLabel("Date:");
		notice = new JLabel(" ");	
				
		dateChooser.setPreferredSize(new Dimension(160, 30));
		hours.setPreferredSize(new Dimension(60, 20));
		minutes.setPreferredSize(new Dimension(60, 20));
		timer.setPreferredSize(new Dimension(80, 20));
		memo.setLineWrap(true);
		memoSPane.setPreferredSize(new Dimension(200, 120));
		notice.setForeground(Color.RED);
		
		//Add each field to the JPanel to be returned by the function
		physicalComponent.add(hours);
		physicalComponent.add(minutes);
		physicalComponent.add(timer);
		physicalComponent.add(memoSPane);
		physicalComponent.add(setTwoComponents(dateLbl, dateChooser));
		physicalComponent.add(notice);
		
		return physicalComponent;
    }

    //Accessors
	public int getHours() {
		//Return hours entered
		return hoursStored;
	}
	public int getMinutes() {
		//Return minutes entered
		return minutesStored;
	}
}