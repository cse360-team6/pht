package org.pht.ui;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import java.awt.Component;
import javax.swing.Box;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextPane;
import org.pht.user.User;
import org.pht.user.data.Data;
import org.pht.user.data.Quota;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class QuotaPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1446567741568668883L;
	JProgressBar strengthBar, cardioBar, workBar, sleepBar;

	private User user;
	private JButton editButton;
	private final Action action = new SwingAction();
	private EditQuotaFrame edit;

	public QuotaPanel() {
		
		this.user = null;
		
		setLayout(null);

		JPanel labelPanel = new JPanel();
		labelPanel.setBounds(0, 0, 300, 45);
		add(labelPanel);
		labelPanel.setLayout(null);

		Component horizontalStrut = Box.createHorizontalStrut(80);
		horizontalStrut.setBounds(0, 14, 112, 12);
		labelPanel.add(horizontalStrut);

		JLabel lblQuota = new JLabel("Quota");
		lblQuota.setBounds(112, 9, 74, 22);
		labelPanel.add(lblQuota);
		lblQuota.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuota.setToolTipText("Edit personal goals and view their progress.");
		lblQuota.setFont(new Font("Lucida Grande", Font.PLAIN, 18));

		Component horizontalStrut_1 = Box.createHorizontalStrut(80);
		horizontalStrut_1.setBounds(186, 14, 112, 12);
		labelPanel.add(horizontalStrut_1);

		JPanel progressPanel = new JPanel();
		progressPanel.setBounds(10, 50, 280, 222);
		add(progressPanel);
		progressPanel.setLayout(new GridLayout(0, 1, 0, 0));

		this.strengthBar = new JProgressBar();
		progressPanel.add(strengthBar);
		strengthBar.setString("Strength");
		strengthBar.setStringPainted(true);

		this.cardioBar = new JProgressBar();
		progressPanel.add(cardioBar);
		cardioBar.setStringPainted(true);
		cardioBar.setString("Cardio");

		this.workBar = new JProgressBar();
		progressPanel.add(workBar);
		workBar.setStringPainted(true);
		workBar.setString("Work");

		this.sleepBar = new JProgressBar();
		progressPanel.add(sleepBar);
		sleepBar.setString("Sleep");
		sleepBar.setStringPainted(true);

		JPanel textAlertPanel = new JPanel();
		textAlertPanel.setBounds(10, 277, 280, 83);
		add(textAlertPanel);
		textAlertPanel.setLayout(new BorderLayout(0, 0));

		JTextPane textAlertPane = new JTextPane();
		textAlertPane.setLocation(10, 0);
		textAlertPane.setPreferredSize(new Dimension(280, 83));
		textAlertPane
				.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		textAlertPanel.add(textAlertPane);
		
		JButton btnEditQuota = new JButton("Edit Quota");
		btnEditQuota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edit = new EditQuotaFrame();
				edit.setVisible(true);
			}
		});
		btnEditQuota.setBounds(6, 372, 284, 29);
		add(btnEditQuota);

	}

	public void updateProgressBars(User user) {
		this.user = user;
		this.cardioBar.setValue(user.getQuota().getCardioWeeklyProgress());
		this.strengthBar.setValue(user.getQuota().getStrengthWeeklyProgress());
		this.workBar.setValue(user.getQuota().getWorkWeeklyProgress());
		this.sleepBar.setValue(user.getQuota().getSleepWeeklyProgress());

		this.cardioBar.setMaximum(user.getQuota().getCardioGoal());
		this.strengthBar.setMaximum(user.getQuota().getStrengthGoal());
		this.workBar.setMaximum(user.getQuota().getWorkGoal());
		this.sleepBar.setMaximum(user.getQuota().getSleepGoal());
	}
	
	public void updateProgressBars(int cgoal, int sgoal, int wgoal, int sleepgoal) {
		this.cardioBar.setMaximum(cgoal);
		this.strengthBar.setMaximum(sgoal);
		this.workBar.setMaximum(wgoal);
		this.sleepBar.setMaximum(sleepgoal);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		updateProgressBars(this.user);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
