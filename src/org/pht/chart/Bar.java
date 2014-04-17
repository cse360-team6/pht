package org.pht.chart;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.Group;
import java.util.Calendar;

public class Bar {

	public Scene dayPhysicalBar(ArrayList<PhysicalActivity> activity, Calendar currentDate) {
		Scene scene = new Scene(new Group());
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		final BarChart<String, Number> dpb = new BarChart<String, Number>(xAxis, yAxis);
		int cardio = 0, strength = 0, sleep = 0, work = 0;		

		xAxis.setLabel("Type");
		yAxis.setLabel("Minutes");

		for(int i = 0; i < activity.size(); i++) {		
			if((activity.get(i).getDate().get(Calendar.MONTH) == currentDate.get(Calendar.MONTH) && activity.get(i).getDate().get(Calendar.DAY_OF_MONTH) > currentDate.get(Calendar.DAY_OF_MONTH)) || (activity.get(i).getDate().get(Calendar.MONTH) > currentDate.get(Calendar.MONTH))) {
				if(cardio == 0 && strength == 0 && sleep == 0 && work == 0)	{
					dpb.setTitle("No input data for current day");
					((Group) scene.getRoot()).getChildren().add(dpb);
					return (scene);
				}
			}		

			if(activity.get(i).getDate().get(Calendar.DAY_OF_MONTH) == currentDate.get(Calendar.DAY_OF_MONTH) && activity.get(i).getDate().get(Calendar.MONTH) == currentDate.get(Calendar.MONTH)) {
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

	public Scene dayPhysicalBar(ArrayList<PhysicalActivity> activity, int day, int month) {
		Scene scene = new Scene(new Group());
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		final BarChart<String, Number> sdpb = new BarChart<String, Number>(xAxis, yAxis);
		int cardio = 0, strength = 0, sleep = 0, work = 0;		

		xAxis.setLabel("Type");
		yAxis.setLabel("Minutes");

		for(int i = 0; i < activity.size(); i++) {
			if((activity.get(i).getDate().get(Calendar.MONTH) > month || (activity.get(i).getDate().get(Calendar.MONTH) == month && activity.get(i).getDate().get(Calendar.DATE) > day))) {
				if(cardio == 0 && strength == 0 && sleep == 0 && work == 0)	{
					sdpb.setTitle("No input data for specified day");
					((Group) scene.getRoot()).getChildren().add(sdpb);
					return (scene);
				}
			}

			if(activity.get(i).getDate().get(Calendar.MONTH) == month && activity.get(i).getDate().get(Calendar.DATE) == day) {
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

		XYChart.Series sday = new XYChart.Series();
		sday.setName("Specified Day");
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

	public Scene dayHealthBar(ArrayList<HealthInformation> health, Calendar currentDate) {
		Scene scene = new Scene(new Group());
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		final BarChart<String, Number> dhb = new BarChart<String, Number>(xAxis, yAxis);
		int systolic = 0, diastolic = 0, bloodSugar = 0, heartRate = 0;		

		xAxis.setLabel("Type");
		yAxis.setLabel("Value");

		for(int i = 0; i < health.size(); i++) {
			if((health.get(i).getDate().get(Calendar.MONTH) == currentDate.get(Calendar.MONTH) && health.get(i).getDate().get(Calendar.DAY_OF_MONTH) > currentDate.get(Calendar.DAY_OF_MONTH)) || (health.get(i).getDate().get(Calendar.MONTH) > currentDate.get(Calendar.MONTH))) {
				if(systolic == 0 && diastolic == 0 && bloodSugar == 0 && heartRate == 0) {
					dhb.setTitle("No input data for current day");
					((Group) scene.getRoot()).getChildren().add(dhb);
					return (scene);
				}
			}		

			if(health.get(i).getDate().get(Calendar.DAY_OF_MONTH) == currentDate.get(Calendar.DAY_OF_MONTH) && health.get(i).getDate().get(Calendar.MONTH) == currentDate.get(Calendar.MONTH)) {
				if(health.get(i).getActivityType() == "Blood Pressure") {
					systolic += health.get(i).getSystolic();
					diastolic += health.get(i).getDiastolic();
				}

				if(health.get(i).getActivityType() == "Blood Sugar") {
					bloodSugar += health.get(i).getBloodSugar();				
				}

				if(health.get(i).getActivityType() == "Heart Rate") {
					heartRate += health.get(i).getHeartRate();
				}			
			}
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

	public Scene dayHealthBar(ArrayList<HealthInformation> health, int day, int month) {
		Scene scene = new Scene(new Group());
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		final BarChart<String, Number> sdhb = new BarChart<String, Number>(xAxis, yAxis);
		int systolic = 0, diastolic = 0, bloodSugar = 0, heartRate = 0;		

		xAxis.setLabel("Type");
		yAxis.setLabel("Value");

		for(int i = 0; i < health.size(); i++) {
			if((health.get(i).getDate().get(Calendar.MONTH) > month || (health.get(i).getDate().get(Calendar.MONTH) == month && health.get(i).getDate().get(Calendar.DATE) > day))) {
				if(systolic == 0 && diastolic == 0 && bloodSugar == 0 && heartRate == 0) {
					sdhb.setTitle("No input data for specified day");
					((Group) scene.getRoot()).getChildren().add(sdhb);
					return (scene);
				}
			}

			if(health.get(i).getDate().get(Calendar.MONTH) == month && health.get(i).getDate().get(Calendar.DATE) == day) {
				if(health.get(i).getActivityType() == "Blood Pressure") {
					systolic += health.get(i).getSystolic();
					diastolic += health.get(i).getDiastolic();
				}

				if(health.get(i).getActivityType() == "Blood Sugar") {
					bloodSugar += health.get(i).getBloodSugar();				
				}

				if(health.get(i).getActivityType() == "Heart Rate") {
					heartRate += health.get(i).getHeartRate();
				}
			}
		}

		XYChart.Series sday = new XYChart.Series();
		sday.setName("Specified Day");
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

	public Scene weekPhysicalBar(ArrayList<PhysicalActivity> activity, Calendar currentWeek) {
		Scene scene = new Scene(new Group());
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		final BarChart<String, Number> wpb = new BarChart<String, Number>(xAxis, yAxis);
		int cardio = 0, strength = 0, sleep = 0, work = 0, daysIn = currentWeek.get(Calendar.DAY_OF_WEEK);		

		xAxis.setLabel("Type");
		yAxis.setLabel("Average Minutes");

		if(daysIn == 0)	{
			wpb.setTitle("Not enough data for current week");
			((Group) scene.getRoot()).getChildren().add(wpb);
			return (scene);
		}

		for(int i = 0; i < activity.size(); i++) {
			if(activity.get(i).getDate().get(Calendar.MONTH) > currentWeek.get(Calendar.MONTH) || (activity.get(i).getDate().get(Calendar.MONTH) == currentWeek.get(Calendar.MONTH) && activity.get(i).getDate().get(Calendar.WEEK_OF_MONTH) > currentWeek.get(Calendar.WEEK_OF_MONTH))) {
				if(cardio == 0 && strength == 0 && sleep == 0 && work == 0)	{
					wpb.setTitle("No input data for current week");
					((Group) scene.getRoot()).getChildren().add(wpb);
					return (scene);
				}
			}

			if(activity.get(i).getDate().get(Calendar.MONTH) == currentWeek.get(Calendar.MONTH) && activity.get(i).getDate().get(Calendar.WEEK_OF_MONTH) == currentWeek.get(Calendar.WEEK_OF_MONTH)) {
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

	public Scene weekHealthBar(ArrayList<HealthInformation> health, Calendar currentWeek) {
		Scene scene = new Scene(new Group());
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		final BarChart<String, Number> whb = new BarChart<String, Number>(xAxis, yAxis);
		int systolic = 0, diastolic = 0, bloodSugar = 0, heartRate = 0, daysIn = currentWeek.get(Calendar.DAY_OF_WEEK);	

		xAxis.setLabel("Type");
		yAxis.setLabel("Average Value");

		if(daysIn == 0)	{
			whb.setTitle("Not enough data for current week");
			((Group) scene.getRoot()).getChildren().add(whb);
			return (scene);
		}

		for(int i = 0; i < health.size(); i++) {
			if(health.get(i).getDate().get(Calendar.MONTH) > currentWeek.get(Calendar.MONTH) || (health.get(i).getDate().get(Calendar.MONTH) == currentWeek.get(Calendar.MONTH) && health.get(i).getDate().get(Calendar.WEEK_OF_MONTH) > currentWeek.get(Calendar.WEEK_OF_MONTH))) {
				if(systolic == 0 && diastolic == 0 && bloodSugar == 0 && heartRate == 0) {
					whb.setTitle("No input data for current week");
					((Group) scene.getRoot()).getChildren().add(whb);
					return (scene);
				}
			}

			if(health.get(i).getDate().get(Calendar.MONTH) == currentWeek.get(Calendar.MONTH) && health.get(i).getDate().get(Calendar.WEEK_OF_MONTH) == currentWeek.get(Calendar.WEEK_OF_MONTH)) {
				if(health.get(i).getActivityType() == "Blood Pressure") {
					systolic += health.get(i).getSystolic();
					diastolic += health.get(i).getDiastolic();
				}

				if(health.get(i).getActivityType() == "Blood Sugar") {
					bloodSugar += health.get(i).getBloodSugar();				
				}

				if(health.get(i).getActivityType() == "Heart Rate") {
					heartRate += health.get(i).getHeartRate();
				}
			}
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

	public Scene monthPhysicalBar(ArrayList<PhysicalActivity> activity, Calendar currentMonth) {
		Scene scene = new Scene(new Group());
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		final BarChart<String, Number> mpb = new BarChart<String, Number>(xAxis, yAxis);
		int cardio = 0, strength = 0, sleep = 0, work = 0, daysIn = currentMonth.get(Calendar.DAY_OF_MONTH);		

		xAxis.setLabel("Type");
		yAxis.setLabel("Average Minutes");

		if(daysIn == 0)	{
			mpb.setTitle("Not enough data for current month");
			((Group) scene.getRoot()).getChildren().add(mpb);
			return (scene);
		}

		for(int i = 0; i < activity.size(); i++) {
			if(activity.get(i).getDate().get(Calendar.MONTH) > currentMonth.get(Calendar.MONTH)) {
				if(cardio == 0 && strength == 0 && sleep == 0 && work == 0)	{
					mpb.setTitle("No input data for current month");
					((Group) scene.getRoot()).getChildren().add(mpb);
					return (scene);
				}
			}

			if(activity.get(i).getDate().get(Calendar.MONTH) == currentMonth.get(Calendar.MONTH)) {
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

	public Scene monthHealthBar(ArrayList<HealthInformation> health, Calendar currentMonth) {
		Scene scene = new Scene(new Group());
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		final BarChart<String, Number> mhb = new BarChart<String, Number>(xAxis, yAxis);
		int systolic = 0, diastolic = 0, bloodSugar = 0, heartRate = 0, daysIn = currentMonth.get(Calendar.DAY_OF_MONTH);	

		xAxis.setLabel("Type");
		yAxis.setLabel("Average Value");

		if(daysIn == 0) {
			mhb.setTitle("Not enough data for current month");
			((Group) scene.getRoot()).getChildren().add(mhb);
			return (scene);
		}

		for(int i = 0; i < health.size(); i++) {
			if(health.get(i).getDate().get(Calendar.MONTH) > currentMonth.get(Calendar.MONTH)) {
				if(systolic == 0 && diastolic == 0 && bloodSugar == 0 && heartRate == 0) {
					mhb.setTitle("No input data for current month");
					((Group) scene.getRoot()).getChildren().add(mhb);
					return (scene);
				}
			}

			if(health.get(i).getDate().get(Calendar.MONTH) == currentMonth.get(Calendar.MONTH)) {
				if(health.get(i).getActivityType() == "Blood Pressure") {
					systolic += health.get(i).getSystolic();
					diastolic += health.get(i).getDiastolic();
				}

				if(health.get(i).getActivityType() == "Blood Sugar") {
					bloodSugar += health.get(i).getBloodSugar();				
				}

				if(health.get(i).getActivityType() == "Heart Rate") {
					heartRate += health.get(i).getHeartRate();
				}
			}
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