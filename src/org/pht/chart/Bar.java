package org.pht.chart;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.Group;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.pht.user.data.*;


public class Bar {
	public Scene dayPhysicalBar(Data entry, Calendar currentDate) {
		Scene scene = new Scene(new Group());
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		final BarChart<String, Number> dpb = new BarChart<String, Number>(xAxis, yAxis);
		int cardio = 0, strength = 0, work = 0, sleep = 0;		
		DataEntry e = entry.getEntry(currentDate);

		xAxis.setLabel("Type");
		yAxis.setLabel("Minutes");

		if(e.getCardioHours() == 0 && e.getStrengthHours() == 0 && e.getSleepHours() == 0 && e.getWorkHours() == 0)	{
			dpb.setTitle("No input data for current day");
			((Group) scene.getRoot()).getChildren().add(dpb);
			return (scene);
		}

		if(e.getCardioHours() > 0)
		{
			cardio = e.getCardioHours();
		}
		if(e.getStrengthHours() > 0)
		{
			strength = e.getStrengthHours();
		}
		if(e.getWorkHours() > 0)
		{
			work = e.getWorkHours();
		}
		if(e.getSleepHours() > 0)
		{
			sleep = e.getSleepHours();
		}

		XYChart.Series day = new XYChart.Series();
		day.setName("Current Day");
		day.getData().add(new XYChart.Data("Cardio", cardio));
		day.getData().add(new XYChart.Data("Strength", strength));
		day.getData().add(new XYChart.Data("Work", work));
		day.getData().add(new XYChart.Data("Sleep", sleep));

		//XYChart.Series quota = new XYChart.Series();

		dpb.setTitle("Current Day Physical Summary");
		dpb.getData().add(day);
		((Group) scene.getRoot()).getChildren().add(dpb);
		return (scene);
	}
	
public Scene dayPhysicalBar(Data entry, int day, int month, int year) {
		Scene scene = new Scene(new Group());
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		final BarChart<String, Number> sdpb = new BarChart<String, Number>(xAxis, yAxis);
		int cardio = 0, strength = 0, work = 0, sleep = 0;	
		xAxis.setLabel("Type");
		yAxis.setLabel("Minutes");

		Calendar today = new GregorianCalendar();
		today.set(Calendar.MONTH, month);
		if(day > 0 & day <= today.getActualMaximum(Calendar.MONTH))
		{
			today.set(Calendar.DAY_OF_MONTH, day);
		}
		today.set(Calendar.YEAR, year);

		DataEntry e = entry.getEntry(today);

		if(e.getCardioHours() == 0 && e.getStrengthHours() == 0 && e.getSleepHours() == 0 && e.getWorkHours() == 0)	{
			sdpb.setTitle("No input data for specified day");
			((Group) scene.getRoot()).getChildren().add(sdpb);
			return (scene);
		}	

		if(e.getCardioHours() > 0)
		{
			cardio = e.getCardioHours();
		}
		if(e.getStrengthHours() > 0)
		{
			strength = e.getStrengthHours();
		}
		if(e.getWorkHours() > 0)
		{
			work = e.getWorkHours();
		}
		if(e.getSleepHours() > 0)
		{
			sleep = e.getSleepHours();
		}

		XYChart.Series sday = new XYChart.Series();
		sday.setName("Current Day");
		sday.getData().add(new XYChart.Data("Cardio", cardio));
		sday.getData().add(new XYChart.Data("Strength", strength));
		sday.getData().add(new XYChart.Data("Work", work));
		sday.getData().add(new XYChart.Data("Sleep", sleep));

		//XYChart.Series quota = new XYChart.Series();

		sdpb.setTitle("Specified Day Physical Summary");
		sdpb.getData().add(sday);
		((Group) scene.getRoot()).getChildren().add(sdpb);
		return (scene);
	}

	public Scene dayHealthBar(Data entry, Calendar currentDate) {
		Scene scene = new Scene(new Group());
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		final BarChart<String, Number> dhb = new BarChart<String, Number>(xAxis, yAxis);
		DataEntry e = entry.getEntry(currentDate);
		int systolic = 0, diastolic = 0, heartRate = 0;
		double bloodSugar = 0.0;
		xAxis.setLabel("Type");
		yAxis.setLabel("Value");

		if(e.getSystolic() == 0 && e.getDiastolic() == 0 && e.getBloodSugar() == 0 && e.getRestingHeartRate() == 0) {
			dhb.setTitle("No input data for current day");
			((Group) scene.getRoot()).getChildren().add(dhb);
			return (scene);
		}
		if(e.getSystolic() > 0)
		{
			systolic = e.getSystolic();
		}
		if(e.getDiastolic() > 0)
		{
			diastolic = e.getDiastolic();
		}
		if(e.getBloodSugar() > 0)
		{
			bloodSugar = e.getBloodSugar();
		}
		if(e.getRestingHeartRate() > 0)
		{
			heartRate = e.getRestingHeartRate();
		}


		XYChart.Series day = new XYChart.Series();
		day.setName("Current Day");
		day.getData().add(new XYChart.Data("Systolic", systolic));
		day.getData().add(new XYChart.Data("Diastolic", diastolic));
		day.getData().add(new XYChart.Data("Blood Sugar", bloodSugar));
		day.getData().add(new XYChart.Data("Heart Rate", heartRate));

		//XYChart.Series quota = new XYChart.Series();

		dhb.setTitle("Current Day Health Summary");
		dhb.getData().add(day);
		((Group) scene.getRoot()).getChildren().add(dhb);
		return (scene);
	}

	public Scene dayHealthBar(Data entry, int day, int month, int year) {
		Scene scene = new Scene(new Group());
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		final BarChart<String, Number> sdhb = new BarChart<String, Number>(xAxis, yAxis);
		int systolic = 0, diastolic = 0, heartRate = 0;
		double bloodSugar = 0.0;
		xAxis.setLabel("Type");
		yAxis.setLabel("Value");

		Calendar today = new GregorianCalendar();
		today.set(Calendar.MONTH, month);
		if(day > 0 && day <= today.getActualMaximum(Calendar.MONTH))
		{
			today.set(Calendar.DAY_OF_MONTH, day);
		}
		today.set(Calendar.YEAR, year);

		DataEntry e = entry.getEntry(today);

		if(e.getSystolic() == 0 && e.getDiastolic() == 0 && e.getBloodSugar() == 0 && e.getRestingHeartRate() == 0) {
			sdhb.setTitle("No input data for specified day");
			((Group) scene.getRoot()).getChildren().add(sdhb);
			return (scene);
		}

		if(e.getSystolic() > 0)
		{
			systolic = e.getSystolic();
		}
		if(e.getDiastolic() > 0)
		{
			diastolic = e.getDiastolic();
		}
		if(e.getBloodSugar() > 0)
		{
			bloodSugar = e.getBloodSugar();
		}
		if(e.getRestingHeartRate() > 0)
		{
			heartRate = e.getRestingHeartRate();
		}


		XYChart.Series sday = new XYChart.Series();
		sday.setName("Current Day");
		sday.getData().add(new XYChart.Data("Systolic", systolic));
		sday.getData().add(new XYChart.Data("Diastolic", diastolic));
		sday.getData().add(new XYChart.Data("Blood Sugar", bloodSugar));
		sday.getData().add(new XYChart.Data("Heart Rate", heartRate));

		//XYChart.Series quota = new XYChart.Series();

		sdhb.setTitle("Specified Day Health Summary");
		sdhb.getData().add(sday);
		((Group) scene.getRoot()).getChildren().add(sdhb);
		return (scene);
	}

	public Scene weekPhysicalBar(Data entry, Calendar currentWeek) {
		Scene scene = new Scene(new Group());
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		final BarChart<String, Number> wpb = new BarChart<String, Number>(xAxis, yAxis);
		DataEntry e = new DataEntry();
		int cardio = 0, strength = 0, work = 0, sleep = 0;

		//Check how many days in to the week it is. For final entry in to chart
		int daysIn = currentWeek.get(Calendar.DAY_OF_WEEK);

		xAxis.setLabel("Type");
		yAxis.setLabel("Average Minutes");

		//If there is only one days worth of data, return an empty chart (there is no point)
		if(daysIn == 0)	{
			wpb.setTitle("Not enough data for current week");
			((Group) scene.getRoot()).getChildren().add(wpb);
			return (scene);
		}
		//Loop through each day in the current week
		for(int i = 0; i <= daysIn; i++)
		{
			Calendar temp = currentWeek;
			temp.set(Calendar.DAY_OF_WEEK, i);
			e = entry.getEntry(temp);
			cardio += e.getCardioHours();
			strength += e.getStrengthHours();
			work += e.getWorkHours();
			sleep += e.getSleepHours();
		}


		if(cardio == 0 && strength == 0 && sleep == 0 && work == 0)	{
			wpb.setTitle("No input data for current week");
			((Group) scene.getRoot()).getChildren().add(wpb);
			return (scene);
		}


		XYChart.Series week = new XYChart.Series();
		week.setName("Current Week");
		week.getData().add(new XYChart.Data("Cardio", cardio/daysIn));
		week.getData().add(new XYChart.Data("Strength", strength/daysIn));
		week.getData().add(new XYChart.Data("Work", work/daysIn));
		week.getData().add(new XYChart.Data("Sleep", sleep/daysIn));

		wpb.setTitle("Current Week Physical Summary");
		wpb.getData().add(week);
		((Group) scene.getRoot()).getChildren().add(wpb);
		return (scene);

	}

	public Scene weekHealthBar(Data entry, Calendar currentWeek) {
		Scene scene = new Scene(new Group());
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		final BarChart<String, Number> whb = new BarChart<String, Number>(xAxis, yAxis);
		int systolic = 0, diastolic = 0, heartRate = 0;	
		double bloodSugar = 0.0;
		DataEntry e = new DataEntry();
		xAxis.setLabel("Type");
		yAxis.setLabel("Average Value");

		//Check how many days in to the week it is. For final entry in to chart
		int daysIn = currentWeek.get(Calendar.DAY_OF_WEEK);

		//If there is only one days worth of data, return an empty chart (there is no point)
		if(daysIn == 0)	{
			whb.setTitle("Not enough data for current week");
			((Group) scene.getRoot()).getChildren().add(whb);
			return (scene);
		}
		//Loop through each day in the current week
		for(int i = 0; i <= daysIn; i++)
		{
			Calendar temp = currentWeek;
			temp.set(Calendar.DAY_OF_WEEK, i);
			e = entry.getEntry(temp);
			systolic += e.getSystolic();
			diastolic += e.getDiastolic();
			bloodSugar += e.getBloodSugar();
			heartRate += e.getRestingHeartRate();
		}
		
		if(systolic == 0 && diastolic == 0 && bloodSugar == 0.0 && heartRate == 0)	{
			whb.setTitle("No input data for current week");
			((Group) scene.getRoot()).getChildren().add(whb);
			return (scene);
		}

		XYChart.Series week = new XYChart.Series();
		week.setName("Specified Day");
		week.getData().add(new XYChart.Data("Systolic", systolic/daysIn));
		week.getData().add(new XYChart.Data("Diastolic", diastolic/daysIn));
		week.getData().add(new XYChart.Data("Blood Sugar", bloodSugar/daysIn));
		week.getData().add(new XYChart.Data("Heart Rate", heartRate/daysIn));

		//XYChart.Series quota = new XYChart.Series();

		whb.setTitle("Current Week Health Summary");
		whb.getData().add(week);
		((Group) scene.getRoot()).getChildren().add(whb);
		return (scene);
	}

	public Scene monthPhysicalBar(Data entry, Calendar currentMonth) {
		Scene scene = new Scene(new Group());
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		final BarChart<String, Number> mpb = new BarChart<String, Number>(xAxis, yAxis);
		int cardio = 0, strength = 0, sleep = 0, work = 0, daysIn = currentMonth.get(Calendar.DAY_OF_MONTH);		
		DataEntry e = new DataEntry();
		xAxis.setLabel("Type");
		yAxis.setLabel("Average Minutes");

		if(daysIn == 1)	{
			mpb.setTitle("Not enough data for current month");
			((Group) scene.getRoot()).getChildren().add(mpb);
			return (scene);
		}

		for(int i = 1; i <= daysIn; i++)
		{
			Calendar temp = currentMonth;
			temp.set(Calendar.DAY_OF_MONTH, i);
			e = entry.getEntry(temp);
			cardio += e.getCardioHours();
			strength += e.getStrengthHours();
			sleep += e.getSleepHours();
			work += e.getWorkHours();
		}
		
		if(cardio == 0 && strength == 0 && sleep == 0 && work == 0)	{					
			mpb.setTitle("No input data for current month");
			((Group) scene.getRoot()).getChildren().add(mpb);
			return (scene);
		}

		XYChart.Series month = new XYChart.Series();
		month.setName("Current Month");
		month.getData().add(new XYChart.Data("Cardio", cardio/daysIn));
		month.getData().add(new XYChart.Data("Strength", strength/daysIn));
		month.getData().add(new XYChart.Data("Work", work/daysIn));
		month.getData().add(new XYChart.Data("Sleep", sleep/daysIn));

		mpb.setTitle("Current Month Physical Summary");
		mpb.getData().add(month);
		((Group) scene.getRoot()).getChildren().add(mpb);
		return (scene);	
	}

	public Scene monthHealthBar(Data entry, Calendar currentMonth) {
		Scene scene = new Scene(new Group());
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		final BarChart<String, Number> mhb = new BarChart<String, Number>(xAxis, yAxis);
		int systolic = 0, diastolic = 0, heartRate = 0, daysIn = currentMonth.get(Calendar.DAY_OF_MONTH);	
		double bloodSugar = 0.0;
		DataEntry e = new DataEntry();
		xAxis.setLabel("Type");
		yAxis.setLabel("Average Value");

		if(daysIn == 1) {
			mhb.setTitle("Not enough data for current month");
			((Group) scene.getRoot()).getChildren().add(mhb);
			return (scene);
		}
		
		for(int i = 1; i <= daysIn; i++)
		{
			Calendar temp = currentMonth;
			temp.set(Calendar.DAY_OF_MONTH, i);
			e = entry.getEntry(temp);
			systolic += e.getSystolic();
			diastolic += e.getDiastolic();
			heartRate += e.getRestingHeartRate();
			bloodSugar += e.getBloodSugar();
		}
		
		if(systolic == 0 && diastolic == 0 && bloodSugar == 0 && heartRate == 0) {
			mhb.setTitle("No input data for current month");
			((Group) scene.getRoot()).getChildren().add(mhb);
			return (scene);
		}

		XYChart.Series month = new XYChart.Series();
		month.setName("Current Month");
		month.getData().add(new XYChart.Data("Systolic", systolic/daysIn));
		month.getData().add(new XYChart.Data("Diastolic", diastolic/daysIn));
		month.getData().add(new XYChart.Data("Blood Sugar", bloodSugar/daysIn));
		month.getData().add(new XYChart.Data("Heart Rate", heartRate/daysIn));

		mhb.setTitle("Current Week Physical Summary");
		mhb.getData().add(month);
		((Group) scene.getRoot()).getChildren().add(mhb);
		return (scene);				
	}
}