package org.pht.ui.activity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class TimerFrame extends JFrame{
	
	JLabel label = new JLabel("0h  0min  0sec");
	 private JTextField hours, minutes;

	 private int sec, min = 0, hr = 0;
	 private String time;
	
	 Timer tm = new Timer(1000, new ActionListener() {			
			public void actionPerformed(ActionEvent evt) {
				sec++;
				if (sec == 60){
					min++;
					sec = sec - 60;
				}
				
				if (min == 60){
					hr++;
					min = min - 60;
				}
				
				time = hr + "h  " + min + "min  " + sec + "sec";
				label.setText(time);
				
			}});

	 public TimerFrame(JTextField h, JTextField m){
		hours = h;
		minutes = m;
		hours.setText("0");
		minutes.setText("0");
		setPreferredSize(new Dimension(535, 90));
		setTitle("Timer");
 		Font f = new Font("Serif", Font.PLAIN, 32);
 		label.setFont(f);
		
		JButton start = new JButton("Start");
		JButton stop = new JButton("Stop");
		JButton reset = new JButton("Reset");
		JButton save = new JButton("Save");
		
		setLayout(new FlowLayout());
		add(label);
		add(start);
		add(stop);
		add(reset);
		add(save);
		
		start.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent event){				
				tm.start();	
			}});
		
		stop.addActionListener(new ActionListener(){		
			public void actionPerformed (ActionEvent event){			
				tm.stop();	
			}});
		
		reset.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent event){
				
				sec = 0; 
				min = 0; 
				hr = 0;

				time = hr + "h  " + min + "min  " + sec + "sec";
				label.setText(time);
			}});
		
		save.addActionListener(new ActionListener(){		
			public void actionPerformed (ActionEvent event){
				hours.setText(String.valueOf(hr));
				minutes.setText(String.valueOf(min));
				setVisible(false);
				sec = 0;
				min = 0;
				hr = 0;
				time = hr + "h  " + min + "min  " + sec + "sec";
				label.setText(time);
			}});
				
	}


			
	public static void main(String args[]){
		
		timer t = new timer();
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t.setVisible(true);
	
	}
	
}

