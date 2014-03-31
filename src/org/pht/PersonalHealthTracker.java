package org.pht;

import org.pht.ui.MainFrame;
import org.pht.ui.activity.HealthActivityFrame;
import org.pht.ui.activity.PhysicalActivityFrame;

import javax.swing.JFrame;

public class PersonalHealthTracker {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		PhysicalActivityFrame physical = new PhysicalActivityFrame();
		physical.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		physical.setVisible(true);
		
		HealthActivityFrame health = new HealthActivityFrame();	
		health.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		health.setVisible(true);
		
		MainFrame mainFrame = new MainFrame();
		
		
	}

}
