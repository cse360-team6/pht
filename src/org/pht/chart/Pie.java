package org.pht.chart;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.pht.user.data.*;

public class Pie 
{

	public Scene dayPhysicalPie(Data entry, Calendar currentDate) {
		Scene scene = new Scene(new Group());
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
		int cardio = 0, strength = 0, sleep = 0, work = 0;
		final PieChart chart = new PieChart(pieChartData);
		DataEntry e = entry.getEntry(currentDate);		

		if(e.getCardioHours() == 0 && e.getStrengthHours() == 0 && e.getSleepHours() == 0 && e.getWorkHours() == 0)	{
			chart.setTitle("No input data for current day");
			((Group) scene.getRoot()).getChildren().add(chart);
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


		pieChartData.add(new PieChart.Data("Cardio", cardio));
		pieChartData.add(new PieChart.Data("Strength", strength));
		pieChartData.add(new PieChart.Data("Work", work));
		pieChartData.add(new PieChart.Data("Sleep", sleep));
		chart.setTitle("Current Day Physical Summary");

		((Group) scene.getRoot()).getChildren().add(chart);

		return (scene);
	}

	public Scene dayPhysicalPie(Data entry, int day, int month, int year) {
		Scene scene = new Scene(new Group());
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
		int cardio = 0, strength = 0, sleep = 0, work = 0;
		final PieChart chart = new PieChart(pieChartData);
		Calendar temp = new GregorianCalendar();
		DataEntry e = new DataEntry();
		temp.set(Calendar.MONTH, month);
		if(day > 0 && day <= temp.getActualMaximum(Calendar.MONTH))
		{
			temp.set(Calendar.DAY_OF_MONTH, day);
		}
		temp.set(Calendar.YEAR, year);
		e = entry.getEntry(temp);		

		if(e.getCardioHours() == 0 && e.getStrengthHours() == 0 && e.getSleepHours() == 0 && e.getWorkHours() == 0)	{
			chart.setTitle("No input data for current day");
			((Group) scene.getRoot()).getChildren().add(chart);
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

		pieChartData.add(new PieChart.Data("Cardio", cardio));
		pieChartData.add(new PieChart.Data("Strength", strength));
		pieChartData.add(new PieChart.Data("Work", work));
		pieChartData.add(new PieChart.Data("Sleep", sleep));		

		chart.setTitle("Specified Day Physical Summary");

		((Group) scene.getRoot()).getChildren().add(chart);

		return (scene);
	}

	public Scene weekPhysicalPie(Data entry, Calendar currentWeek) {
		Scene scene = new Scene(new Group());
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
		int cardio = 0, strength = 0, sleep = 0, work = 0;
		final PieChart chart = new PieChart(pieChartData);

		//Check how many days in to the week it is. For final entry in to chart
		int daysIn = currentWeek.get(Calendar.DAY_OF_WEEK);
		DataEntry e = entry.getEntry(currentWeek);

		//If there is only one days worth of data, return an empty chart (there is no point)
		if(daysIn == 0)	{
			chart.setTitle("Not enough data for current week");
			((Group) scene.getRoot()).getChildren().add(chart);
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
			chart.setTitle("No input data for current week");
			((Group) scene.getRoot()).getChildren().add(chart);
			return (scene);
		}

		pieChartData.add(new PieChart.Data("Cardio", cardio/daysIn));
		pieChartData.add(new PieChart.Data("Strength", strength/daysIn));
		pieChartData.add(new PieChart.Data("Work", work/daysIn));
		pieChartData.add(new PieChart.Data("Sleep", sleep/daysIn));		

		chart.setTitle("Current Week Physical Summary");

		((Group) scene.getRoot()).getChildren().add(chart);

		return (scene);
	}

	public Scene monthPhysicalPie(Data entry, Calendar currentMonth) {
		//Create a pie chart displaying daily summary of physical activities		
		//Loop through array of activities, check if they are same day and month. 
		//If they are, add the totals to a temporary variable
		Scene scene = new Scene(new Group());
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
		int cardio = 0, strength = 0, sleep = 0, work = 0, daysIn = currentMonth.get(Calendar.DAY_OF_MONTH);
		final PieChart chart = new PieChart(pieChartData);
		DataEntry e = entry.getEntry(currentMonth);

		if(daysIn == 1)	{
			chart.setTitle("Not enough data for current month");
			((Group) scene.getRoot()).getChildren().add(chart);
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
			chart.setTitle("No input data for current month");
			((Group) scene.getRoot()).getChildren().add(chart);
			return (scene);
		}

		pieChartData.add(new PieChart.Data("Cardio", cardio/daysIn));
		pieChartData.add(new PieChart.Data("Strength", strength/daysIn));
		pieChartData.add(new PieChart.Data("Work", work/daysIn));
		pieChartData.add(new PieChart.Data("Sleep", sleep/daysIn));		

		chart.setTitle("Specified Month Physical Summary");

		((Group) scene.getRoot()).getChildren().add(chart);

		return (scene);
	}

}
