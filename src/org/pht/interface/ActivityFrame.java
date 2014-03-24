import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class ActivityFrame extends JFrame 
{
	//Properties
	protected String memoStored, typeStored;
	protected Date dateAdded = new Date();
	protected static JButton ok, cancel;
	protected JComboBox activities;	
	private JPanel dropDown = new JPanel (new FlowLayout());	
	private JPanel buttons = new JPanel();;	
	
	//Constructors
	public Activity(String[] options, String frameTitle, JPanel activity)
	{
		ok = new JButton("OK");
		cancel = new JButton("Cancel");
		
		activities = new JComboBox(options);
		activities.setSelectedIndex(0);
		activities.setPreferredSize(new Dimension(220, 25));		
		
		dropDown.add(activities);
		buttons.add(ok);
		buttons.add(cancel);
		
		cancel.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if (e.getSource() instanceof JButton) {
	            	dispose();
	            }
	        }
		});
		
		add(dropDown, BorderLayout.NORTH);
		add(activity);
		add(buttons, BorderLayout.SOUTH);		
		
		setSize(250, 300);
	}
	
	//Accessors
	public String getMemo()
	{
		return memoStored;
	}
	public String getActivityType()
	{
		return typeStored;
	}
	public Date getDate()
	{
		//For potential use in charts
		return dateAdded;
	}
}