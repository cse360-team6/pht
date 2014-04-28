package org.pht.chart;

import java.util.Calendar;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import org.pht.user.data.Data;
import org.pht.user.data.DataEntry;


public class Line {

	public Scene weeklyLinePhysical(Data entry, Calendar currentWeek)
	{
		Scene scene = new Scene(new Group());
		final NumberAxis xAxis = new NumberAxis();
		final NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("Day of Week");
		yAxis.setLabel("Hours");
		final LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);
		lineChart.setTitle("Weekly Physical Line Chart");
		int daysIn = currentWeek.DAY_OF_WEEK;
		DataEntry e = new DataEntry();
		XYChart.Series cwSeries = new XYChart.Series<>();
		XYChart.Series swSeries = new XYChart.Series<>();
		XYChart.Series sSeries = new XYChart.Series<>();
		XYChart.Series wSeries = new XYChart.Series<>();
		cwSeries.setName("Cardio");
		swSeries.setName("Strength");
		sSeries.setName("Sleep");
		wSeries.setName("Work");

		if(daysIn == 0)
		{
			lineChart.setTitle("Not enough data for current week");
			((Group) scene.getRoot()).getChildren().add(lineChart);
			return (scene);
		}
		//Add the data to each of the series for the corresponding days
		for(int i = 0; i <= daysIn; i++)
		{
			Calendar temp = currentWeek;
			temp.set(Calendar.DAY_OF_WEEK, i);
			e = entry.getEntry(temp);
			cwSeries.getData().add(new XYChart.Data(i+1, e.getCardioHours()));
			swSeries.getData().add(new XYChart.Data(i+1, e.getStrengthHours()));
			sSeries.getData().add(new XYChart.Data(i+1, e.getSleepHours()));
			wSeries.getData().add(new XYChart.Data(i+1, e.getWorkHours()));
		}		

		lineChart.getData().add(cwSeries);
		lineChart.getData().add(swSeries);
		lineChart.getData().add(sSeries);
		lineChart.getData().add(wSeries);

		((Group) scene.getRoot()).getChildren().add(lineChart);
		return (scene);

	}

	public Scene weeklyLineHealth(Data entry, Calendar currentWeek)
	{
		Scene scene = new Scene(new Group());
		final NumberAxis xAxis = new NumberAxis();
		final NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("Day of Week");
		yAxis.setLabel("Value");
		final LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);
		lineChart.setTitle("Weekly Physical Line Chart");
		int daysIn = currentWeek.DAY_OF_WEEK;
		DataEntry e = new DataEntry();
		XYChart.Series sSeries = new XYChart.Series<>();
		XYChart.Series dSeries = new XYChart.Series<>();
		XYChart.Series bsSeries = new XYChart.Series<>();
		XYChart.Series hrSeries = new XYChart.Series<>();
		sSeries.setName("Systolic");
		dSeries.setName("Diastolic");
		bsSeries.setName("Blood Sugar");
		hrSeries.setName("Heart Rate");

		if(daysIn == 0)
		{
			lineChart.setTitle("Not enough data for current week");
			((Group) scene.getRoot()).getChildren().add(lineChart);
			return (scene);
		}
		//Add the data to each of the series for the corresponding days
		for(int i = 0; i <= daysIn; i++)
		{
			Calendar temp = currentWeek;
			temp.set(Calendar.DAY_OF_WEEK, i);
			e = entry.getEntry(temp);
			sSeries.getData().add(new XYChart.Data(i+1, e.getSystolic()));
			dSeries.getData().add(new XYChart.Data(i+1, e.getDiastolic()));
			bsSeries.getData().add(new XYChart.Data(i+1, e.getBloodSugar()));
			hrSeries.getData().add(new XYChart.Data(i+1, e.getWorkHours()));
		}		

		lineChart.getData().add(sSeries);
		lineChart.getData().add(dSeries);
		lineChart.getData().add(bsSeries);
		lineChart.getData().add(hrSeries);

		((Group) scene.getRoot()).getChildren().add(lineChart);
		return (scene);

	}

	public Scene monthLinePhysical(Data entry, Calendar currentMonth)
	{
		Scene scene = new Scene(new Group());
		final NumberAxis xAxis = new NumberAxis();
		final NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("Day of Month");
		yAxis.setLabel("Hours");
		final LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);
		lineChart.setTitle("Weekly Physical Line Chart");
		int daysIn = currentMonth.DAY_OF_MONTH;
		DataEntry e = new DataEntry();
		XYChart.Series cwSeries = new XYChart.Series<>();
		XYChart.Series swSeries = new XYChart.Series<>();
		XYChart.Series sSeries = new XYChart.Series<>();
		XYChart.Series wSeries = new XYChart.Series<>();
		cwSeries.setName("Cardio");
		swSeries.setName("Strength");
		sSeries.setName("Sleep");
		wSeries.setName("Work");

		if(daysIn == 1)
		{
			lineChart.setTitle("Not enough data for current week");
			((Group) scene.getRoot()).getChildren().add(lineChart);
			return (scene);
		}
		//Add the data to each of the series for the corresponding days
		for(int i = 1; i <= daysIn; i++)
		{
			Calendar temp = currentMonth;
			temp.set(Calendar.DAY_OF_MONTH, i);
			e = entry.getEntry(temp);
			cwSeries.getData().add(new XYChart.Data(i+1, e.getCardioHours()));
			swSeries.getData().add(new XYChart.Data(i+1, e.getStrengthHours()));
			sSeries.getData().add(new XYChart.Data(i+1, e.getSleepHours()));
			wSeries.getData().add(new XYChart.Data(i+1, e.getWorkHours()));
		}		

		lineChart.getData().add(cwSeries);
		lineChart.getData().add(swSeries);
		lineChart.getData().add(sSeries);
		lineChart.getData().add(wSeries);

		((Group) scene.getRoot()).getChildren().add(lineChart);
		return (scene);
	}

	public Scene monthLineHealth(Data entry, Calendar currentMonth)
	{

		Scene scene = new Scene(new Group());
		final NumberAxis xAxis = new NumberAxis();
		final NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("Day of Week");
		yAxis.setLabel("Value");
		final LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);
		lineChart.setTitle("Weekly Physical Line Chart");
		int daysIn = currentMonth.DAY_OF_MONTH;
		DataEntry e = new DataEntry();
		XYChart.Series sSeries = new XYChart.Series<>();
		XYChart.Series dSeries = new XYChart.Series<>();
		XYChart.Series bsSeries = new XYChart.Series<>();
		XYChart.Series hrSeries = new XYChart.Series<>();
		sSeries.setName("Systolic");
		dSeries.setName("Diastolic");
		bsSeries.setName("Blood Sugar");
		hrSeries.setName("Heart Rate");

		if(daysIn == 1)
		{
			lineChart.setTitle("Not enough data for current week");
			((Group) scene.getRoot()).getChildren().add(lineChart);
			return (scene);
		}
		//Add the data to each of the series for the corresponding days
		for(int i = 1; i <= daysIn; i++)
		{
			Calendar temp = currentMonth;
			temp.set(Calendar.DAY_OF_MONTH, i);
			e = entry.getEntry(temp);
			sSeries.getData().add(new XYChart.Data(i+1, e.getSystolic()));
			dSeries.getData().add(new XYChart.Data(i+1, e.getDiastolic()));
			bsSeries.getData().add(new XYChart.Data(i+1, e.getBloodSugar()));
			hrSeries.getData().add(new XYChart.Data(i+1, e.getWorkHours()));
		}		

		lineChart.getData().add(sSeries);
		lineChart.getData().add(dSeries);
		lineChart.getData().add(bsSeries);
		lineChart.getData().add(hrSeries);

		((Group) scene.getRoot()).getChildren().add(lineChart);
		return (scene);
	}
}
