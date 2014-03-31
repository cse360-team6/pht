package org.pht.ui.activity;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HealthActivityFrame extends ActivityFrame {
    private static final long serialVersionUID = -7544441861748313095L;

    // Properties
    private static String[] healthInformation = { "Blood Pressure",
	    "Blood Sugar", "Heart Rate" };
    private int bloodPressure, bloodSugar, heartRate;
    private static JPanel healthComponent;
    private static JTextField value, memo;
    private static JLabel notice = new JLabel("");

    // Constructors
	public HealthActivityFrame() {
		super(healthInformation, new String("Add Health Information"),
			createHealthComponents());
		
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() instanceof JButton) {
				
					// If the user is entering Blood Pressure
					if (((String) activities.getSelectedItem()).compareTo(healthInformation[0]) == 0) {
						// need to find out how to extract data from entered
						// value of "140/80"
					}
					
					// If the user is entering Blood Sugar
					if (((String) activities.getSelectedItem()).compareTo(healthInformation[1]) == 0) {
						if (Integer.parseInt(value.getText()) > 0
							&& Integer.parseInt(value.getText()) < 400) {
						    bloodSugar = Integer.parseInt(value.getText());
						    memoStored = memo.getText();
						    typeStored = (String) activities.getSelectedItem();
						    dispose();
						} else {
						    notice.setText(new String("Error: Invalid Blood Sugar Levels"));
						}
					}
					
					// If the user is entering Heart Rate
					if (((String) activities.getSelectedItem()).compareTo(healthInformation[2]) == 0) {
						if (Integer.parseInt(value.getText()) > 0
							&& Integer.parseInt(value.getText()) < 300) {
						    heartRate = Integer.parseInt(value.getText());
						    memoStored = memo.getText();
						    typeStored = (String) activities.getSelectedItem();
						    dispose();
						
						} else {
							notice.setText("Error: Invalid Heart Rate Levels");
						}
					}
				}
		    }
		});
	}

    private static JPanel createHealthComponents() {
		healthComponent = new JPanel();
	
		value = new JTextField("Value");
		memo = new JTextField("Memos");
	
		value.setPreferredSize(new Dimension(200, 20));
		memo.setPreferredSize(new Dimension(200, 100));
	
		healthComponent.add(value);
		healthComponent.add(memo);
		healthComponent.add(notice);
	
		return healthComponent;
    }

    // Accessors
    public int getBloodPressure() {
    	return bloodPressure;
    }

    public int getBloodSugar() {
    	return bloodSugar;
    }

    public int getHeartRate() {
    	return heartRate;
    }
}
