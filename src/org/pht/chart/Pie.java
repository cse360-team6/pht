package org.pht.chart;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;

import java.util.ArrayList;
import java.util.Calendar;

import org.pht.ui.activity.PhysicalActivityFrame;

public class Pie 
{

	public Scene dayPhysicalPie(ArrayList<PhysicalActivityFrame> activity, Calendar currentDate) {

		//Loop through array of activities, check if they are same day and month. 
		//If they are, add the totals to a temporary variable

		Scene scene = new Scene(new Group());
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
		int cardio = 0, strength = 0, sleep = 0, work = 0;
		final PieChart chart = new PieChart(pieChartData);
		
		for(int i = 0; i < activity.size(); i++) {		

			//If the date of the activity is after the entered date, break from the loop
			if((activity.get(i).getDate().get(Calendar.YEAR) == currentDate.get(Calendar.YEAR) && activity.get(i).getDate().get(Calendar.MONTH) == currentDate.get(Calendar.MONTH) && activity.get(i).getDate().get(Calendar.DAY_OF_MONTH) > currentDate.get(Calendar.DAY_OF_MONTH)) 
					|| (activity.get(i).getDate().get(Calendar.YEAR) == currentDate.get(Calendar.YEAR) && activity.get(i).getDate().get(Calendar.MONTH) > currentDate.get(Calendar.MONTH))) {
				
				if(cardio == 0 && strength == 0 && sleep == 0 && work == 0)	{
					chart.setTitle("No input data for current day");
					((Group) scene.getRoot()).getChildren().add(chart);
					return (scene);
				}
				
				else {
					break;
				}
			}		

			if(activity.get(i).getDate().get(Calendar.DAY_OF_MONTH) == currentDate.get(Calendar.DAY_OF_MONTH) 
					&& activity.get(i).getDate().get(Calendar.MONTH) == currentDate.get(Calendar.MONTH)
					&& activity.get(i).getDate().get(Calendar.YEAR) == currentDate.get(Calendar.YEAR)) {
				//Update the info if they are from the current date
				if(activity.get(i).getActivityType() == "Cardio Workout") {
					cardio += ((activity.get(i).getHours() * 60) + activity.get(i).getMinutes());				
				}

				if(activity.get(i).getActivityType() == "Strength Workout") {
					strength += ((activity.get(i).getHours() * 60) + activity.get(i).getMinutes());				
				}

				if(activity.get(i).getActivityType() == "Work Hours") {
					work += ((activity.get(i).getHours() * 60) + activity.get(i).getMinutes());
				}

				if(activity.get(i).getActivityType() == "Time Slept") {
					sleep += ((activity.get(i).getHours() * 60) + activity.get(i).getMinutes());
				}
				
			}
		}

		pieChartData.add(new PieChart.Data("Cardio", cardio));
		pieChartData.add(new PieChart.Data("Strength", strength));
		pieChartData.add(new PieChart.Data("Work", work));
		pieChartData.add(new PieChart.Data("Sleep", sleep));


		System.out.print(cardio + "\n" + strength + "\n" + work + "\n" + sleep + "\n");

		chart.setTitle("Current Day Physical Summary");

		((Group) scene.getRoot()).getChildren().add(chart);

		return (scene);
	}

	public Scene dayPhysicalPie(ArrayList<PhysicalActivityFrame> activity, int day, int month, int year) {
		Scene scene = new Scene(new Group());
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
		int cardio = 0, strength = 0, sleep = 0, work = 0;
		final PieChart chart = new PieChart(pieChartData);

		for(int i = 0; i <  activity.size(); i++) {

			//If the date of the activity is after the entered date, break from the loop
			//If day entered in to the function does not match any records, no data will be returned
			if((activity.get(i).getDate().get(Calendar.YEAR) == year && activity.get(i).getDate().get(Calendar.MONTH) > month 
					|| (activity.get(i).getDate().get(Calendar.YEAR) == year && activity.get(i).getDate().get(Calendar.MONTH) == month && activity.get(i).getDate().get(Calendar.DATE) > day))) {
				
				if(cardio == 0 && strength == 0 && sleep == 0 && work == 0)	{
					chart.setTitle("No input data for specified day");
					((Group) scene.getRoot()).getChildren().add(chart);
					return (scene);
				}
				else {
					break;
				}
			}

			if(activity.get(i).getDate().get(Calendar.MONTH) == month 
					&& activity.get(i).getDate().get(Calendar.DATE) == day
					&& activity.get(i).getDate().get(Calendar.YEAR) == year) {
				
				//Update the info if they are from the date entered
				if(activity.get(i).getActivityType() == "Cardio Workout") {
					cardio += ((activity.get(i).getHours() * 60) + activity.get(i).getMinutes());				
				}

				if(activity.get(i).getActivityType() == "Strength Workout") {
					strength += ((activity.get(i).getHours() * 60) + activity.get(i).getMinutes());				
				}

				if(activity.get(i).getActivityType() == "Work Hours") {
					work += ((activity.get(i).getHours() * 60) + activity.get(i).getMinutes());
				}

				if(activity.get(i).getActivityType() == "Time Slept") {
					sleep += ((activity.get(i).getHours() * 60) + activity.get(i).getMinutes());
				}
			}


		}

		pieChartData.add(new PieChart.Data("Cardio", cardio));
		pieChartData.add(new PieChart.Data("Strength", strength));
		pieChartData.add(new PieChart.Data("Work", work));
		pieChartData.add(new PieChart.Data("Sleep", sleep));		

		chart.setTitle("Specified Day Physical Summary");

		((Group) scene.getRoot()).getChildren().add(chart);

		return (scene);
	}

	public Scene weekPhysicalPie(ArrayList<PhysicalActivityFrame> activity, int month, int week, int year) {
		Scene scene = new Scene(new Group());
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
		int cardio = 0, strength = 0, sleep = 0, work = 0;
		final PieChart chart = new PieChart(pieChartData);

		for(int i = 0; i <  activity.size(); i++) {

			//If the loop goes past the specified month
			if((activity.get(i).getDate().get(Calendar.YEAR) == year && activity.get(i).getDate().get(Calendar.MONTH) > month 
					|| ((activity.get(i).getDate().get(Calendar.YEAR) == year && activity.get(i).getDate().get(Calendar.MONTH) == month) && activity.get(i).getDate().get(Calendar.WEEK_OF_MONTH) > week))) {
				
				if(cardio == 0 && strength == 0 && sleep == 0 && work == 0)	{
					chart.setTitle("No input data for specified week");
					((Group) scene.getRoot()).getChildren().add(chart);
					return (scene);
				}
				else {
					break;
				}
			}
			
			if(activity.get(i).getDate().get(Calendar.MONTH) == month 
					&& activity.get(i).getDate().get(Calendar.WEEK_OF_MONTH) == week
					&& activity.get(i).getDate().get(Calendar.YEAR) == year) {
				
				if(activity.get(i).getActivityType() == "Cardio Workout") { 
					cardio += ((activity.get(i).getHours() * 60) + activity.get(i).getMinutes());				
				}

				if(activity.get(i).getActivityType() == "Strength Workout") {
					strength += ((activity.get(i).getHours() * 60) + activity.get(i).getMinutes());				
				}

				if(activity.get(i).getActivityType() == "Work Hours") {
					work += ((activity.get(i).getHours() * 60) + activity.get(i).getMinutes());
				}

				if(activity.get(i).getActivityType() == "Time Slept") {
					sleep += ((activity.get(i).getHours() * 60) + activity.get(i).getMinutes());
				}
			}
		}



		pieChartData.add(new PieChart.Data("Cardio", cardio));
		pieChartData.add(new PieChart.Data("Strength", strength));
		pieChartData.add(new PieChart.Data("Work", work));
		pieChartData.add(new PieChart.Data("Sleep", sleep));		

		chart.setTitle("Specified Week Physical Summary");

		((Group) scene.getRoot()).getChildren().add(chart);

		return (scene);
	}

	public Scene weekPhysicalPie(ArrayList<PhysicalActivityFrame> activity, Calendar currentWeek) {
		//Create a pie chart displaying daily summary of physical activities		
		//Loop through array of activities, check if they are same day and month. 
		//If they are, add the totals to a temporary variable
		Scene scene = new Scene(new Group());
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
		int cardio = 0, strength = 0, sleep = 0, work = 0;
		final PieChart chart = new PieChart(pieChartData);

		for(int i = 0; i <  activity.size(); i++) {

			//If the loop goes past the specified month
			if((activity.get(i).getDate().get(Calendar.YEAR) == currentWeek.get(Calendar.YEAR) && activity.get(i).getDate().get(Calendar.MONTH) > currentWeek.get(Calendar.MONTH)) 
					|| (activity.get(i).getDate().get(Calendar.YEAR) == currentWeek.get(Calendar.YEAR) && activity.get(i).getDate().get(Calendar.MONTH) == currentWeek.get(Calendar.MONTH) && activity.get(i).getDate().get(Calendar.WEEK_OF_MONTH) > currentWeek.get(Calendar.WEEK_OF_MONTH))) {
				
				if(cardio == 0 && strength == 0 && sleep == 0 && work == 0)	{
					chart.setTitle("No input data for current week");
					((Group) scene.getRoot()).getChildren().add(chart);
					return (scene);
				}
				else {
					break;
				}
			}
			
			if(activity.get(i).getDate().get(Calendar.MONTH) == currentWeek.get(Calendar.MONTH) 
					&& activity.get(i).getDate().get(Calendar.WEEK_OF_MONTH) == currentWeek.get(Calendar.WEEK_OF_MONTH)
					&& activity.get(i).getDate().get(Calendar.YEAR) == currentWeek.get(Calendar.YEAR)) {
				
				if(activity.get(i).getActivityType() == "Cardio Workout") { 
					cardio += ((activity.get(i).getHours() * 60) + activity.get(i).getMinutes());				
				}

				if(activity.get(i).getActivityType() == "Strength Workout") {
					strength += ((activity.get(i).getHours() * 60) + activity.get(i).getMinutes());				
				}

				if(activity.get(i).getActivityType() == "Work Hours") {
					work += ((activity.get(i).getHours() * 60) + activity.get(i).getMinutes());
				}

				if(activity.get(i).getActivityType() == "Time Slept") {
					sleep += ((activity.get(i).getHours() * 60) + activity.get(i).getMinutes());
				}
			}
		}

		System.out.print(cardio + "\n" + strength + "\n" + work + "\n" + sleep + "\n");

		pieChartData.add(new PieChart.Data("Cardio", cardio));
		pieChartData.add(new PieChart.Data("Strength", strength));
		pieChartData.add(new PieChart.Data("Work", work));
		pieChartData.add(new PieChart.Data("Sleep", sleep));		

		chart.setTitle("Current Week Physical Summary");

		((Group) scene.getRoot()).getChildren().add(chart);

		return (scene);
	}

	public Scene monthPhysicalPie(ArrayList<PhysicalActivityFrame> activity, int month, int year) {
		//Create a pie chart displaying daily summary of physical activities		
		//Loop through array of activities, check if they are same day and month. 
		//If they are, add the totals to a temporary variable
		Scene scene = new Scene(new Group());
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
		int cardio = 0, strength = 0, sleep = 0, work = 0;
		final PieChart chart = new PieChart(pieChartData);

		for(int i = 0; i <  activity.size(); i++) {

			//If the loop goes past the specified month
			if(activity.get(i).getDate().get(Calendar.YEAR) == year 
					&& activity.get(i).getDate().get(Calendar.MONTH) > month) {
				
				if(cardio == 0 && strength == 0 && sleep == 0 && work == 0)	{
					chart.setTitle("No input data for specified month");
					((Group) scene.getRoot()).getChildren().add(chart);
					return (scene);
				}
				else {
					break;
				}
			}
			
			if(activity.get(i).getDate().get(Calendar.YEAR) == year 
					&& activity.get(i).getDate().get(Calendar.MONTH) == month) {
				
				if(activity.get(i).getActivityType() == "Cardio Workout") { 
					cardio += ((activity.get(i).getHours() * 60) + activity.get(i).getMinutes());				
				}

				if(activity.get(i).getActivityType() == "Strength Workout") {
					strength += ((activity.get(i).getHours() * 60) + activity.get(i).getMinutes());				
				}

				if(activity.get(i).getActivityType() == "Work Hours") {
					work += ((activity.get(i).getHours() * 60) + activity.get(i).getMinutes());
				}

				if(activity.get(i).getActivityType() == "Time Slept") {
					sleep += ((activity.get(i).getHours() * 60) + activity.get(i).getMinutes());
				}
			}
		}

		System.out.print(cardio + "\n" + strength + "\n" + work + "\n" + sleep + "\n");

		pieChartData.add(new PieChart.Data("Cardio", cardio));
		pieChartData.add(new PieChart.Data("Strength", strength));
		pieChartData.add(new PieChart.Data("Work", work));
		pieChartData.add(new PieChart.Data("Sleep", sleep));		

		chart.setTitle("Specified Month Physical Summary");

		((Group) scene.getRoot()).getChildren().add(chart);

		return (scene);
	}

	public Scene monthPhysicalPie(ArrayList<PhysicalActivityFrame> activity, Calendar currentMonth) {
		//Create a pie chart displaying daily summary of physical activities		
		//Loop through array of activities, check if they are same day and month. 
		//If they are, add the totals to a temporary variable
		Scene scene = new Scene(new Group());
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
		int cardio = 0, strength = 0, sleep = 0, work = 0;
		final PieChart chart = new PieChart(pieChartData);

		for(int i = 0; i <  activity.size(); i++) {

			//If the loop goes past the specified month
			if(activity.get(i).getDate().get(Calendar.YEAR) == currentMonth.get(Calendar.YEAR) 
					&& activity.get(i).getDate().get(Calendar.MONTH) > currentMonth.get(Calendar.MONTH)) {
				
				if(cardio == 0 && strength == 0 && sleep == 0 && work == 0)	{
					chart.setTitle("No input data for current month");
					((Group) scene.getRoot()).getChildren().add(chart);
					return (scene);
				}
				
				else {
					break;
				}
			}
			if(activity.get(i).getDate().get(Calendar.YEAR) == currentMonth.get(Calendar.YEAR) 
					&& activity.get(i).getDate().get(Calendar.MONTH) == currentMonth.get(Calendar.MONTH)) {
				
				if(activity.get(i).getActivityType() == "Cardio Workout") { 
					cardio += ((activity.get(i).getHours() * 60) + activity.get(i).getMinutes());				
				}

				if(activity.get(i).getActivityType() == "Strength Workout") {
					strength += ((activity.get(i).getHours() * 60) + activity.get(i).getMinutes());				
				}

				if(activity.get(i).getActivityType() == "Work Hours") {
					work += ((activity.get(i).getHours() * 60) + activity.get(i).getMinutes());
				}

				if(activity.get(i).getActivityType() == "Time Slept") {
					sleep += ((activity.get(i).getHours() * 60) + activity.get(i).getMinutes());
				}
			}
		}

		System.out.print(cardio + "\n" + strength + "\n" + work + "\n" + sleep + "\n");

		pieChartData.add(new PieChart.Data("Cardio", cardio));
		pieChartData.add(new PieChart.Data("Strength", strength));
		pieChartData.add(new PieChart.Data("Work", work));
		pieChartData.add(new PieChart.Data("Sleep", sleep));		

		chart.setTitle("Specified Month Physical Summary");

		((Group) scene.getRoot()).getChildren().add(chart);

		return (scene);
	}

}
