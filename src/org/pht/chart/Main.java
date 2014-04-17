package org.pht.chart;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import javafx.scene.Scene;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import java.util.Calendar;
import java.util.GregorianCalendar;

import Project.Pie;
public class Main {
	
	private static void initAndShowGUI()
	{
		
		JFrame frame = new JFrame("Swing and JavaFX");
		final JFXPanel p = new JFXPanel();		
		final PhysicalActivity[] activity = new PhysicalActivity[] {
				new PhysicalActivity(), 
				new PhysicalActivity(), 
				new PhysicalActivity(), 
				new PhysicalActivity(), 
				new PhysicalActivity(), 
				new PhysicalActivity(), 
				new PhysicalActivity()};
		
		
		activity[0].setType(0);
		activity[0].setHours(200);
		activity[1].setType(0);
		activity[1].setHours(600);
		activity[2].setType(0);
		activity[2].setHours(222);
		activity[3].setType(0);
		activity[3].setHours(600);
		activity[4].setType(1);
		activity[4].setHours(111);
		activity[5].setType(1);
		activity[5].setHours(222);
	    activity[6].setType(2);
		activity[6].setHours(333);
	    		
		frame.add(p);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
				
		Platform.runLater(new Runnable() {
			@Override 
			public void run() {
				initFX(p, activity);
			}
		});

		frame.setVisible(true);
		
	}
	
	private static void initFX(JFXPanel p, PhysicalActivity[] activity)
	{
		Bar bar = new Bar();
		Calendar date = new GregorianCalendar();
		
		Scene scene = bar.dayPhysicalBar(activity, date);
		p.setScene(scene);		
	}
	
	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				initAndShowGUI();
			}
		});		
	}
	
}
