package org.pht;

import org.pht.datalib.*;
import org.pht.ui.MainFrame;
import org.pht.ui.activity.HealthActivityFrame;
import org.pht.ui.activity.PhysicalActivityFrame;

import javax.swing.JFrame;

public class PersonalHealthTracker
{

    public static void main(String[] args)
    {
        PHTData data = new PHTData();
        data.add(12, 25, 13, 80, 75, 120, 40.2);
        
        PHTDataElement e = new PHTDataElement();
        PHTDataElement e2 = new PHTDataElement(12,26,14,80,75,120,40.4);
        e.setYear(13);
        e.setDay(27);
        e.setMonth(12);
        e.setDiastolic(90);
        e.setSystolic(125);
        e.setRestingHeartRate(80);
        e.setBloodSugar(15.5);
        
        data.add(e);
        data.add(e2);
        
        data.save();

        PhysicalActivityFrame physical = new PhysicalActivityFrame();
        physical.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        physical.setVisible(true);

        HealthActivityFrame health = new HealthActivityFrame();
        health.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        health.setVisible(true);

        MainFrame mainFrame = new MainFrame();
    }

}
