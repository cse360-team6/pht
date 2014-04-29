package org.pht.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.pht.user.Users;

import com.toedter.calendar.JDateChooser;

public class NewUserFrame extends JFrame{
	// Properties
	private static final long serialVersionUID = -9134935483343341332L;
	protected Calendar birthday = new GregorianCalendar();
	protected static JButton add, cancel;
	private JPanel buttons = new JPanel();
	private JLabel genderLbl, nameLbl, heightLbl, weightLbl, bdayLbl;
	private static JLabel notice;
	private JDateChooser dateChooser;
	private JTextField nameField;
	private JComboBox<String> genderCombo;
	private JComboBox<String> heightCombo;
	private JComboBox<Integer> weightCombo;
	private String[] genderStr = {"Male", "Female"};
	private String[] heightStr = {"4'0\"","4'1\"","4'2\"","4'3\"","4'4\"","4'5\"","4'6\"","4'7\"","4'8\"","4'9\"","4'10\"","4'11\"",
									"5'0\"","5'1\"","5'2\"","5'3\"","5'4\"","5'5\"","5'6\"","5'7\"","5'8\"","5'9\"","5'10\"","5'11\"",
									"6'0\"","6'1\"","6'2\"","6'3\"","6'4\"","6'5\"","6'6\"","6'7\"","6'8\"","6'9\"","6'10\"","6'11\"",
									"7'0\"","7'1\"","7'2\"","7'3\"","7'4\"","7'5\"","7'6\"","7'7\"","7'8\"","7'9\"","7'10\"","7'11\""};
	
    // Constructors
    public NewUserFrame() {
    	// Set title to New User
    	setTitle("New User");
    	this.setLayout(new GridLayout(7,0));
    	
		//Create universal 'ok' and 'cancel' buttons available for any extended class
		add = new JButton("Add User");
		cancel = new JButton("Cancel");	
		
		//Add buttons to respective JPanel objects
		buttons.add(add);
		buttons.add(cancel);
		
		//Add labels for the text fields
		genderLbl = new JLabel("Gender:");
		nameLbl = new JLabel("Name:");
		heightLbl = new JLabel("Height:");
		weightLbl = new JLabel("Weight:");
		bdayLbl = new JLabel("Birth Date:");
		notice = new JLabel(" ");
		notice.setForeground(Color.RED);
		
		//Add values for ComboBoxes
		genderCombo = new JComboBox<String>(genderStr);
		genderCombo.setPreferredSize(new Dimension(100, 25));
		heightCombo = new JComboBox<String>(heightStr);
		heightCombo.setPreferredSize(new Dimension(100, 25));
		heightCombo.setSelectedIndex(15);
		weightCombo = new JComboBox<Integer>();
		weightCombo.setPreferredSize(new Dimension(100, 25));
		for (int i = 60; i < 500; i++)
			weightCombo.addItem(i);
		weightCombo.setSelectedIndex(40);
		
		//Add date chooser
		dateChooser = new JDateChooser();
		
		//Add text fields for entering data
		nameField = new JTextField();
		nameField.setPreferredSize(new Dimension(180, 20));
		
		//Add an action listener for the Add User button to create the user
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() instanceof JButton) {
					ArrayList<String> h = new ArrayList<String>(Arrays.asList(heightCombo.getSelectedItem().toString().split("'")));
					int feet = Integer.parseInt(h.get(0));
					int inch = Integer.parseInt(h.get(1).split("\"")[0]);
					int heightInch = (feet * 12) + inch;
					int weight = (int)weightCombo.getSelectedItem();
					String height = (String)heightCombo.getSelectedItem().toString();
					String name = "";
					if (!nameField.getText().equals("")){
						name = nameField.getText();}
					else
					{
						notice.setText("Error: Please Enter a Name");
						return;
					}
					String gender = genderCombo.getSelectedItem().toString();
					String birthDay = dateChooser.getDateFormatString();
					if (dateChooser.getCalendar() == null){
						notice.setText("Error: Please Select Birth Date");
						return;
					}
					//Use a simple algorithm to calculate age... is approximate and not exact
					int age = Calendar.getInstance().get(Calendar.YEAR) - dateChooser.getCalendar().get(Calendar.YEAR);
					dispose();
            		}
				}
			}
		);
		
		//Add an action listener for the cancel button to close the window
		cancel.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if (e.getSource() instanceof JButton) {
	            	dispose();
	            }
	        }
		});
		
		//Add the respective data to be entered and buttons to the Grid Layout JFrame
		add(setTwoComponents(nameLbl, nameField));
		add(setTwoComponents(bdayLbl, dateChooser));
		add(setTwoComponents(genderLbl, genderCombo));
		add(setTwoComponents(heightLbl, heightCombo));
		add(setTwoComponents(weightLbl, weightCombo));
		add(notice);
		add(buttons);
		
		setSize(250, 300);	
		setResizable(false);
		setVisible(true);
	}
    
    private JPanel setTwoComponents(JComponent a, JComponent b) {
		JPanel res = new JPanel(new FlowLayout(FlowLayout.LEADING));
		res.add(a);
		res.add(b);
		return res;
	}

}
