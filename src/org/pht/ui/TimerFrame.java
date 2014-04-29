package org.pht.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class TimerFrame extends JFrame{
	
	 JLabel label = new JLabel("0 h  0 min  0 sec");	

	 private int sec, min = 0, hr = 0;
	 private String time;


	
	 Timer tm = new Timer(1000, new ActionListener(){
		 
			
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
				
				time = hr + " h  " + min + " min  " + sec + " sec";
				label.setText(time);
				
			}});

	 public TimerFrame() {
	
		 		Font f = new Font("Serif", Font.PLAIN, 50);
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
					}
				});
				
				stop.addActionListener(new ActionListener(){		
					public void actionPerformed (ActionEvent event){
					
					tm.stop();	
					}
						});
				
				reset.addActionListener(new ActionListener(){
					public void actionPerformed (ActionEvent event){
						
						sec = 0; 
						min = 0; 
						hr = 0;
						
						time = hr + " h  " + min + " min  " + sec + " sec";
						label.setText(time);
					}
				});
				
			}
	
}

