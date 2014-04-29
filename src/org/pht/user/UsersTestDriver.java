package org.pht.user;

import java.io.IOException;
import java.util.Calendar;

import org.pht.user.data.CALENDAR;
import org.pht.user.data.DataEntry;

public class UsersTestDriver {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
// DataEntry test
		DataEntry data = new DataEntry(Calendar.getInstance(), 1,2,3,4,5,6,7,8.0,"");
		
		

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
