package org.pht.user;

import java.io.IOException;
import java.util.Calendar;

import org.pht.user.data.CALENDAR;

public class UsersTestDriver {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
// CALENDAR test
		Calendar date = Calendar.getInstance();
		date.set(1970, date.JANUARY, 1, 1, 1, 1);
		System.out.println(date.getTime());
		for (int i = 0; i < 100; i++) {
			System.out.println(CALENDAR.getDays(date));
			date.roll(date.DAY_OF_YEAR, true);
		}
		Long millis = Calendar.getInstance().getTimeInMillis();
		for (int i = 0; i < 100; i++) {
			date.setTimeInMillis(millis);
			System.out.println(date.getTime());
			millis = millis - CALENDAR.MILLIS_DAY.longValue();
		}
		
		
// DataEntry test
		
		

// Testing serialization
//
//		try {
//			DataEntry entry = new DataEntry(date, 4,4,4,4,4,4,4,4.56);
//			out.writeObject(entry);
//			System.out.println("Data entry pass");
//		} catch (Exception e) {
//			out.close();
//			e.printStackTrace();
//		}
//		try {
//			Data data = new Data();
//			//data.addEntry(new DataEntry(Calendar.getInstance(), 4,4,4,4,4,4,4,4.56));
//			data.addEntry(new DataEntry(date, 5,4,4,4,4,4,4,4.56));
//			out.writeObject(data);
//			System.out.println("Data pass");
//		} catch (Exception e) {
//			out.close();
//			e.printStackTrace();
//		}
//		out.close();
//		
//		
//		Data data = (Data) in.readObject();
//		System.out.println("\nEntry by date: " + data.getEntryByDate(date).toString());
//		System.out.println(entry.toString() + data.toString());
	}

}
