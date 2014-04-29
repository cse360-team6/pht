package org.pht.ui;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;

import org.pht.PersonalHealthTracker;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;

public class EditQuotaFrame extends JFrame {
	private static final long serialVersionUID = 6804571264316993425L;
	protected static JTextField txtStrengthGoal;
	private static JTextField txtCardioGoal;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private static JTextField txtWorkGoal;
	private static JTextField txtSleepGoal;
	
	public EditQuotaFrame() {
		setBounds(new Rectangle(350, 200, 175, 200));
		getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 6, 175, 143);
		getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		txtCardioGoal = new JTextField();
		panel_1.add(txtCardioGoal);
		txtCardioGoal.setText("cardio goal");
		txtCardioGoal.setToolTipText("Enter your weekly cardio goal.");
		txtCardioGoal.setColumns(10);
		
		txtStrengthGoal = new JTextField();
		panel_1.add(txtStrengthGoal);
		txtStrengthGoal.setText("strength goal");
		txtStrengthGoal.setToolTipText("Enter your weekly strength goal.");
		txtStrengthGoal.setColumns(10);
		
		txtWorkGoal = new JTextField();
		panel_1.add(txtWorkGoal);
		txtWorkGoal.setText("work goal");
		txtWorkGoal.setColumns(10);
		
		txtSleepGoal = new JTextField();
		panel_1.add(txtSleepGoal);
		txtSleepGoal.setText("sleep goal");
		txtSleepGoal.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 149, 175, 29);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int strength, cardio, work, sleep;
				try {
					strength = new Integer(EditQuotaFrame.txtStrengthGoal.getText());
					cardio = new Integer (EditQuotaFrame.txtCardioGoal.getText());
					work = new Integer (EditQuotaFrame.txtWorkGoal.getText());
					sleep = new Integer (EditQuotaFrame.txtSleepGoal.getText());
					PersonalHealthTracker.getMainFrame().getQuotaPanel().updateProgressBars(strength,cardio,work,sleep);
					dispose();
				} catch (NumberFormatException e1) {
				}
			}
		});
		panel.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel.add(btnCancel);
	}
}
