import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Activity extends JFrame 
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


class PhysicalActivity extends Activity
{	
	//Properties
	private int minutesStored, hoursStored;
	private static String[] physicalActivities = { "Cardio Workout", "Strength Workout", "Work Hours", "Time Slept"};
	private static JTextField hours, minutes, memo;
	private static JPanel physicalComponent;
	private static JLabel physicalNotice = new JLabel("");	
	
	//Constructors
	public PhysicalActivity()
	{		
		super(physicalActivities, new String("Add Physical Activity"), createPhysicalComponents());
				
		ok.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if (e.getSource() instanceof JButton) {
	            	
	            	if(Integer.parseInt(minutes.getText()) < 60 && Integer.parseInt(hours.getText()) < 24)
	            	{
	            		minutesStored = Integer.parseInt(minutes.getText());
	            		hoursStored = Integer.parseInt(hours.getText());
		            	memoStored = memo.getText();
		            	typeStored = (String) activities.getSelectedItem();
		            	
		            	dispose();
		            	
	            	}
	            	else
	            	{
	            		physicalNotice.setText("Error: Invalid Time Entered");
	            	}    
	            }
	        }
	    });
		
	}
	private static JPanel createPhysicalComponents()
	{
		physicalComponent = new JPanel();
		
		hours = new JTextField("Hours");		
		minutes = new JTextField("Minutes");
		memo = new JTextField("Memos");
				
		hours.setPreferredSize(new Dimension(97, 20));
		minutes.setPreferredSize(new Dimension(98, 20));
		memo.setPreferredSize(new Dimension(200, 100));
		
		physicalComponent.add(hours);
		physicalComponent.add(minutes);
		physicalComponent.add(memo);
		physicalComponent.add(physicalNotice);
		
		return physicalComponent;
	}
	
	//Accessors
	public int getHours()
	{
		return hoursStored;
	}
	public int getMinutes()
	{
		return minutesStored;
	}	
}

class HealthInformation extends Activity
{
	//Properties
	private static String[] healthInformation = { "Blood Pressure", "Blood Sugar", "Heart Rate"};
	private int bloodPressure, bloodSugar, heartRate;
	private	static JPanel healthComponent;
	private static JTextField value, memo;
	private static JLabel notice = new JLabel("");
	
	//Constructors
	public HealthInformation()
	{
		super(healthInformation, new String("Add Health Information"), createHealthComponents());
	
		ok.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if (e.getSource() instanceof JButton) {
	            	
	            	//If the user is entering Blood Pressure
	            	if(((String) activities.getSelectedItem()).compareTo(healthInformation[0]) == 0)
	            	{
	            		//need to find out how to extract data from entered value of "140/80"
	            	}
	            	
	            	//If the user is entering Blood Sugar
	            	if(((String) activities.getSelectedItem()).compareTo(healthInformation[1]) == 0)
	            	{
	            		if(Integer.parseInt(value.getText()) > 0 && Integer.parseInt(value.getText()) < 400)
	            		{
	            			bloodSugar = Integer.parseInt(value.getText());
	            			memoStored = memo.getText();
	    	            	typeStored = (String) activities.getSelectedItem();
	    	            	dispose();
	            		}
	            		else
	            		{
	            			notice.setText(new String("Error: Invalid Blood Sugar Levels"));	            			
	            		}
	            	}
	            	
	            	//If the user is entering Heart Rate
	            	if(((String) activities.getSelectedItem()).compareTo(healthInformation[2]) == 0)
	            	{
	            		if(Integer.parseInt(value.getText()) > 0 && Integer.parseInt(value.getText()) < 300)
	            		{
	            			heartRate = Integer.parseInt(value.getText());
	            			memoStored = memo.getText();
	    	            	typeStored = (String) activities.getSelectedItem();
	    	            	dispose();
	    	            	
	            		}
	            		else
	            		{
	            			notice.setText("Error: Invalid Heart Rate Levels");
	            		}
	            	}
	            }
	        }
	    });
	}
	private static JPanel createHealthComponents()
	{
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

	//Accessors
	public int getBloodPressure()
	{
		return bloodPressure;
	}
	public int getBloodSugar()
	{
		return bloodSugar;
	}
	public int getHeartRate()
	{
		return heartRate;
	}
}
