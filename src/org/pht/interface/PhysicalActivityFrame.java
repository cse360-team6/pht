import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PhysicalActivityFrame extends Activity
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