package org.pht.ui.activity;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ActivityFrame extends JFrame {
    // Properties
    private static final long serialVersionUID = -8671910450938286915L;
	protected String memoStored = "", typeStored = "";
	protected Calendar dateAdded = new GregorianCalendar();
	protected static JButton ok, cancel;
	protected JComboBox<String> activities = new JComboBox<String>();	
	private JPanel dropDown = new JPanel (new FlowLayout());	
	private JPanel buttons = new JPanel();;

    // Constructors
    public ActivityFrame(String[] options, String frameTitle, JPanel activity) {
		//Create universal 'ok' and 'cancel' buttons available for any extended class
		ok = new JButton("OK");
		cancel = new JButton("Cancel");
		
		//Create a drop down menu from a string array passed in through the super constructor
		activities = new JComboBox<String>(options);
		activities.setSelectedIndex(0);
		activities.setPreferredSize(new Dimension(220, 25));		
		
		//Add buttons and drop down menu to respective JPanel objects
		dropDown.add(activities);
		buttons.add(ok);
		buttons.add(cancel);
		
		//Add an action listener for the cancel button to close the window
		cancel.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if (e.getSource() instanceof JButton) {
	            	dispose();
	            }
	        }
		});
		
		//Add the drop down menu and buttons to the main JFrame, and add the components other classes pass through
		add(dropDown, BorderLayout.NORTH);
		add(activity);
		add(buttons, BorderLayout.SOUTH);		
		
		setSize(250, 300);		
	}

    //Accessors
	public String getMemo()	{
		//Return text entered in memo text box
		return memoStored;
	}
	public String getActivityType()	{
		//Return text selected in activity drop down menu
		return typeStored;
	}
	public Calendar getDate()	{
		//Return date (for use in charts)
		return dateAdded;
	}
}