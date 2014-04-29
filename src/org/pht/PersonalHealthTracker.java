package org.pht;

import org.pht.ui.MainFrame;

public class PersonalHealthTracker
{
	private static MainFrame MAINFRAME;
    public static void main(String[] args)
    {    	
        MAINFRAME = new MainFrame();
    }
    
    public static MainFrame getMainFrame() {return MAINFRAME;}
}
