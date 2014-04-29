package org.pht.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.EOFException;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import org.pht.ui.QuotaPanel;
import org.pht.ui.activity.HealthActivityFrame;
import org.pht.ui.activity.PhysicalActivityFrame;
import org.pht.user.User;
import org.pht.user.Users;
import org.pht.user.data.Quota;

public class MainFrame extends JFrame {
	private JPanel framePanel, personPanel, statusPanel, buttonPanel, /*quotaPanel,*/ centerPanel;
	private QuotaPanel quotaPanel;
	private JButton addHealthBtn, addPhysBtn, viewRepBtn, addPersBtn;
	
	//components for personPanel
	private JComboBox<String> nameCombo;
	private JComboBox<String> statusCombo;
	
	//components for statusPanel
	private JLabel statusLbl;
	
	//components for quotaPanel
	private JLabel quotaLbl;
	
	private PhysicalActivityFrame paFrame;
	private HealthActivityFrame haFrame;
	private NewUserFrame nuFrame;
	
	private static Users USERS;
	
	Quota quota;
	
	public MainFrame() {
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(
			            (JFrame)e.getSource(),
			            "Are you sure you want to exit the application?",
			            "Exit Application",
			            JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					try {
						USERS.saveUsers();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					((JFrame)e.getSource()).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
			}
		});
		setTitle("Personal Health Tracker");
		setSize(800, 500);
		framePanel = new JPanel(new BorderLayout());
		
		personPanel = new JPanel(new GridLayout(1,0));
		personPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		((GridLayout)personPanel.getLayout()).setHgap(10);
		((GridLayout)personPanel.getLayout()).setVgap(10);
		nameCombo = new JComboBox<String>(new String[] {});
		nameCombo.setPreferredSize(new Dimension(200, 26));
		addPersBtn = new JButton("Add");
		personPanel.add(setTwoComponents(nameCombo, addPersBtn));
		
		statusPanel = new JPanel();
		//statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.Y_AXIS));
		statusPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		String[] status = {"All","Sleep","Work","Cardio","Strength"};
		statusCombo = new JComboBox<String>(status);
		statusCombo.setPreferredSize(new Dimension(100,25));
		statusLbl = new JLabel("Status For:");
		statusPanel.add(statusLbl);
		statusPanel.add(statusCombo);
		
		centerPanel = new  JPanel();
		centerPanel.setPreferredSize(new Dimension(500, 400));
		centerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		centerPanel.add(setTwoComponents(personPanel,statusPanel));
		centerPanel.add(new JSeparator(SwingConstants.HORIZONTAL));
		
		buttonPanel = new JPanel(new FlowLayout());
		buttonPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		addHealthBtn = new JButton("Add Health Activity");
		addPhysBtn = new JButton("Add Physical Activity");
		viewRepBtn = new JButton("View Detail Report");
		
		addPersBtn.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if (e.getSource() instanceof JButton) {
	            	if (nuFrame == null || !nuFrame.isVisible())	{            		
	            		nuFrame = new NewUserFrame();
	            		nuFrame.setLocationRelativeTo(centerPanel);
	            	} else {
	            		nuFrame.toFront();
		            }
	            }
	        }
		});
		
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
		
		quotaPanel = new QuotaPanel(this.quota);
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
		setResizable(false);
		setVisible(true);
		try {
			USERS = new Users();
			USERS.loadUsers();
			for (String key: USERS.getUsers().keySet()) {
				nameCombo.addItem(key);				
			}
		} catch (Exception e1) {
			if (e1 instanceof EOFException) {
				if (nuFrame == null || !nuFrame.isVisible())	{            		
            		nuFrame = new NewUserFrame();
            		nuFrame.setLocationRelativeTo(centerPanel);
            	} else {
            		nuFrame.toFront();
	            }
			} else
			e1.printStackTrace();
		}
	}
	
	private JPanel setTwoComponents(JComponent a, JComponent b) {
		JPanel res = new JPanel(new FlowLayout(FlowLayout.LEADING));
		res.add(a);
		res.add(b);
		return res;
	}
	
	public static Users getUsers() {
		return USERS;
	}
	
	public String getCurrentUser() {
		return (String)nameCombo.getSelectedItem();
	}
	
	public void setCurrentUser(String name) {
		if (USERS.getUsers().containsKey(name)) {
			boolean res = false;
			for (int i = 0; i < nameCombo.getItemCount(); i++) {
				if (nameCombo.getItemAt(i).equals(name)) {
					res = true;
					break;
				}
			}
			if (!res)
				nameCombo.addItem(name);
			nameCombo.setSelectedItem(name);
			
		}
	}
	
}
