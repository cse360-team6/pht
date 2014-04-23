package org.pht.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.pht.quota.PHTQuotaPanel;
import org.pht.ui.activity.HealthActivityFrame;
import org.pht.ui.activity.PhysicalActivityFrame;

public class MainFrame extends JFrame {
	private JPanel framePanel, personPanel, statusPanel, buttonPanel, /*quotaPanel,*/ centerPanel;
	private PHTQuotaPanel quotaPanel;
	private JButton addHealthBtn, addPhysBtn, viewRepBtn, addPersBtn;
	
	//components for personPanel
	private JComboBox<String> nameCombo, genderCombo;
	private JComboBox<Integer> ageCombo;
	private JLabel ageLbl, genderLbl;
	private String[] genderStr = {"Male", "Female"};
	
	//components for statusPanel
	private JLabel statusLbl;
	private JCheckBox sleepBox, workBox, cardioBox, strengthBox;
	
	//components for quotaPanel
	private JLabel quotaLbl;
	
	private PhysicalActivityFrame paFrame;
	private HealthActivityFrame haFrame;
	
	public MainFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Personal Health Tracker");
		setSize(800, 500);
		framePanel = new JPanel(new BorderLayout());
		
		personPanel = new JPanel(new GridLayout(3,0));
		personPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		((GridLayout)personPanel.getLayout()).setHgap(10);
		((GridLayout)personPanel.getLayout()).setVgap(10);
		nameCombo = new JComboBox<String>(new String[] {"Name"});
		nameCombo.setPreferredSize(new Dimension(300, 26));
		genderCombo = new JComboBox<String>(genderStr);
		ageCombo = new JComboBox<Integer>();
		for (int i = 0; i < 120; i++)
			ageCombo.addItem(i);
		ageLbl = new JLabel("Age:");
		genderLbl = new JLabel("Gender:");
		addPersBtn = new JButton("Add");
		personPanel.add(setTwoComponents(nameCombo, addPersBtn));
		personPanel.add(setTwoComponents(ageLbl, ageCombo));
		personPanel.add(setTwoComponents(genderLbl, genderCombo));
		
		statusPanel = new JPanel();
		statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.Y_AXIS));
		statusPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		statusLbl = new JLabel("Status:");
		sleepBox = new JCheckBox("Sleep");
		workBox = new JCheckBox("Work");
		cardioBox = new JCheckBox("Cardio");
		strengthBox = new JCheckBox("Strength");
		statusPanel.add(statusLbl);
		statusPanel.add(sleepBox);
		statusPanel.add(workBox);
		statusPanel.add(cardioBox);
		statusPanel.add(strengthBox);
		
		centerPanel = new  JPanel(new GridLayout(0,1));
		centerPanel.setPreferredSize(new Dimension(500, 400));
		centerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		centerPanel.add(personPanel);
		centerPanel.add(statusPanel);	
		
		buttonPanel = new JPanel(new FlowLayout());
		buttonPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		addHealthBtn = new JButton("Add Health Activity");
		addPhysBtn = new JButton("Add Physical Activity");
		viewRepBtn = new JButton("View Detail Report");
		
		addHealthBtn.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if (e.getSource() instanceof JButton) {
	            	if (haFrame == null || !haFrame.isVisible())	{            		
	            		haFrame = new HealthActivityFrame();
	            		haFrame.setLocationRelativeTo(centerPanel);
	            	} else {
	            		haFrame.toFront();
		            }
	            }
	        }
		});
		addPhysBtn.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if (e.getSource() instanceof JButton) {
	            	if (paFrame == null || !paFrame.isVisible())	{
	            		paFrame = new PhysicalActivityFrame();
	            		paFrame.setLocationRelativeTo(centerPanel);
	            	} else {
	            		paFrame.toFront();
	            	}
	            }
	        }
		});
		viewRepBtn.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if (e.getSource() instanceof JButton) {
	            	
	            }
	        }
		});
		
		buttonPanel.add(addHealthBtn);
		buttonPanel.add(addPhysBtn);
		buttonPanel.add(viewRepBtn);
		
		quotaPanel = new PHTQuotaPanel();
		quotaPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		quotaPanel.setPreferredSize(new Dimension(300, 400));
		//quotaLbl = new JLabel("Quota");
		//quotaLbl.setPreferredSize(new Dimension(250, 30));
		//quotaLbl.setHorizontalAlignment(SwingConstants.CENTER);
		//quotaLbl.setBorder(BorderFactory.createLineBorder(Color.black));
		//quotaPanel.add(quotaLbl);
		
		framePanel.add(BorderLayout.SOUTH, buttonPanel);
		framePanel.add(BorderLayout.CENTER, centerPanel);
		framePanel.add(BorderLayout.EAST, quotaPanel);
		add(framePanel);
		setVisible(true);
	}
	
	private JPanel setTwoComponents(JComponent a, JComponent b) {
		JPanel res = new JPanel(new FlowLayout(FlowLayout.LEADING));
		res.add(a);
		res.add(b);
		return res;
	}
	
}
