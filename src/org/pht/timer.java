package org.pht;

import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class timer extends JFrame{
	
	 JLabel label = new JLabel("0hours  0minutes  0seconds");	

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
				
				time = hr + "hours  " + min + "minutes  " + sec + "seconds";
				label.setText(time);
				
			}});

	 public timer(){
	
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
						
						time = hr + "hours  " + min + "minutes  " + sec + "seconds";
						label.setText(time);
					}
				});
				
			}


			
	public static void main(String args[]){
		
		timer t = new timer();
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t.setSize(600, 200);
		t.setVisible(true);
		t.setTitle("Timer");
	
	}
	
}

