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

        PhysicalActivityFrame physical = new PhysicalActivityFrame();
        physical.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        physical.setVisible(true);

        HealthActivityFrame health = new HealthActivityFrame();
        health.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        health.setVisible(true);

        MainFrame mainFrame = new MainFrame();
    }

}
