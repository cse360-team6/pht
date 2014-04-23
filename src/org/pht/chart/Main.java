//package org.pht.chart;
//
//import javax.swing.JFrame;
//import javax.swing.SwingUtilities;
//
//import javafx.scene.Scene;
//import javafx.application.Platform;
//import javafx.embed.swing.JFXPanel;
//
//import java.util.Calendar;
//import java.util.GregorianCalendar;
//
//import org.pht.ui.activity.*;
//public class Main {
//	
//	private static void initAndShowGUI()
//	{
//		
//		JFrame frame = new JFrame("Swing and JavaFX");
//		final JFXPanel p = new JFXPanel();		
//		final PhysicalActivityFrame[] activity = new PhysicalActivityFrame[] {
//				new PhysicalActivityFrame(), 
//				new PhysicalActivityFrame(), 
//				new PhysicalActivityFrame(), 
//				new PhysicalActivityFrame(), 
//				new PhysicalActivityFrame(), 
//				new PhysicalActivityFrame(), 
//				new PhysicalActivityFrame()};
//		
//		
//		
//	    		
//		frame.add(p);
//		frame.setSize(500, 500);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//				
//		Platform.runLater(new Runnable() {
//			@Override 
//			public void run() {
//				initFX(p, activity);
//			}
//		});
//
//		frame.setVisible(true);
//		
//	}
//	
//	private static void initFX(JFXPanel p, PhysicalActivityFrame[] activity)
//	{
//		Bar bar = new Bar();
//		Calendar date = new GregorianCalendar();
//		
//		Scene scene = bar.dayPhysicalBar(activity, date);
//		p.setScene(scene);		
//	}
//	
//	public static void main(String[] args) 
//	{
//		SwingUtilities.invokeLater(new Runnable() {
//			@Override
//			public void run() {
//				initAndShowGUI();
//			}
//		});		
//	}
//	
//}
