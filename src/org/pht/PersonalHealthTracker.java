package org.pht;

import javax.swing.JFrame;

import org.pht.ui.MainFrame;
import org.pht.ui.PrintViewPanel;

public class PersonalHealthTracker
{
	private static MainFrame MAINFRAME;
    public static void main(String[] args)
    {    	
        MAINFRAME = new MainFrame();
        JFrame frame = new JFrame();
        frame.add(new PrintViewPanel());
        frame.setVisible(true);
    }
    
    public static MainFrame getMainFrame() {return MAINFRAME;}
}
