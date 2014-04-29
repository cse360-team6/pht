package org.pht.ui.activity;



import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import org.pht.PersonalHealthTracker;
import org.pht.user.data.Data;
import org.pht.user.data.DataEntry;

import com.xeiam.xchart.Chart;
import com.xeiam.xchart.ChartBuilder;
import com.xeiam.xchart.XChartPanel;
import com.xeiam.xchart.StyleManager.ChartTheme;
import com.xeiam.xchart.StyleManager.ChartType;
import com.xeiam.xchart.StyleManager.LegendPosition;

import java.awt.print.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class ViewReportFrame extends JFrame implements Printable {


    private JComboBox<String> jComboBox1;                  
    private JButton jButton1;
    private JButton jButton2;
    private JScrollPane jScrollPane1;
    private JTextArea jTextArea1;
    private JPanel printPanel, chartPanel;
    
	public ViewReportFrame() {
        initComponents();
    }
                         
    private void initComponents() {
        jButton1 = new JButton("Print");
        jButton2 = new JButton("Cancel");
        jComboBox1 = new JComboBox<String>();
        jTextArea1 = new JTextArea();
        jScrollPane1 = new JScrollPane(jTextArea1);
        chartPanel = new JPanel();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        
        jComboBox1.addItem("Weekly");
        jComboBox1.addItem("Monthly");
        jComboBox1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				chartPanel.removeAll();
				chartPanel.add(getChart());
				jTextArea1.setText(getTable());
				revalidate();
				repaint();
			}
        	
        });
        
        JPanel optionPanel = new JPanel();
        optionPanel.add(jComboBox1);
        optionPanel.add(jButton1);
        optionPanel.add(jButton2);
        
        printPanel = new JPanel(new GridLayout(2,1));
        printPanel.add(jScrollPane1);
        chartPanel.add(getChart());
        printPanel.add(chartPanel);
		jTextArea1.setText(getTable());
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(printPanel, BorderLayout.CENTER);
        getContentPane().add(optionPanel, BorderLayout.SOUTH);
        setSize(565, 825);
        setResizable(false);
    }

    private XChartPanel getChart() {
    	if (PersonalHealthTracker.getMainFrame().getUsers() == null)
			return null;
		Chart chart = new ChartBuilder().chartType(ChartType.Bar).width(480).height(350).title(jComboBox1.getSelectedItem().toString()+" Review")
				.xAxisTitle("Day").yAxisTitle("Hours").theme(ChartTheme.GGPlot2).build();
		Data data = PersonalHealthTracker.getMainFrame().getUsers().getUsers().get(
				PersonalHealthTracker.getMainFrame().getCurrentUser()).getData();
		switch(jComboBox1.getSelectedItem().toString()) {
		case "Weekly":
			ArrayList<String> days = new ArrayList<String>(Arrays.asList(new String[] { "Sun", "Mon", "Tues", "Wed", "Thur", "Fri", "Sat" }));
			chart.addSeries("Cardio", days, data.getWeeklySummary(DataEntry.CARDIO_HOURS));
			chart.addSeries("Strength", days, data.getWeeklySummary(DataEntry.STRENGTH_HOURS));
			chart.addSeries("Work", days, data.getWeeklySummary(DataEntry.WORK_HOURS));
			chart.addSeries("Sleep", days, data.getWeeklySummary(DataEntry.SLEEP_HOURS));
			chart.getStyleManager().setYAxisMax(24.0);
		    chart.getStyleManager().setLegendPosition(LegendPosition.InsideNE); 	
			break;
		case "Monthly":
			ArrayList<String> weeks = new ArrayList<String>(Arrays.asList(new String[] { "1", "2", "3", "4", "5", "6" }));
			chart.addSeries("Cardio", weeks, data.getMonthlySummary(DataEntry.CARDIO_HOURS));
			chart.addSeries("Strength", weeks, data.getMonthlySummary(DataEntry.STRENGTH_HOURS));
			chart.addSeries("Work", weeks, data.getMonthlySummary(DataEntry.WORK_HOURS));
			chart.addSeries("Sleep", weeks, data.getMonthlySummary(DataEntry.SLEEP_HOURS));
			chart.getStyleManager().setYAxisMax(168.0);
		    chart.getStyleManager().setLegendPosition(LegendPosition.InsideNE); 	
			break;
		}
		return new XChartPanel(chart);
    }
    
    private String getTable() {
    	String str = "\t\t\tDays\n";
    	
    	return str;
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
    	PrinterJob printJob = PrinterJob.getPrinterJob();
        printJob.setPrintable(this);
        if (printJob.printDialog()) {
            try {
                printJob.print();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }    
    
    public int print(Graphics g, PageFormat pf, int index) throws
	    PrinterException {
	
		Graphics2D g2 = (Graphics2D) g;
		if (index >= 1) {
		    return Printable.NO_SUCH_PAGE;
		} else {
		
		    printPanel.printAll(g2);
		    return Printable.PAGE_EXISTS;
		}
	
	}

    private void jButton2ActionPerformed(ActionEvent evt) {                                        
    	dispose();
    } 
    
}
