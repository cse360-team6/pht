package org.pht;

import java.io.IOException;

import org.pht.ui.MainFrame;
import org.pht.ui.activity.HealthActivityFrame;
import org.pht.ui.activity.PhysicalActivityFrame;
import org.pht.user.User.Gender;
import org.pht.user.Users;

import javax.swing.JFrame;

public class PersonalHealthTracker
{
    public static void main(String[] args)
    {
    	try {
			Users usr = new Users();
			usr.createUser("hi", Gender.MALE, 55, 180, 18);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        MainFrame mainFrame = new MainFrame();
    }
}
