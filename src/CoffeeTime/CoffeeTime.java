package CoffeeTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.text.DateFormat;

public class CoffeeTime {
	public static void main(String[] args) throws ParseException {
		Scanner scan = new Scanner(System.in);
		
		//These next three lines take in the current time
		DateFormat df = new SimpleDateFormat("HH:mm");
		Date dateobj = new Date();
		String timeNow = (df.format(dateobj));

		/*
		System.out.println("What time is it now? Please enter in HH:mm format.");
		String timeNow = scan.nextLine();
		*/

		System.out.println("What time would you like your coffee made? Please enter in HH:mm format.");
		String endTime = scan.nextLine();
		System.out.println("");
		
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		Date date1 = format.parse(timeNow);
		Date date2 = format.parse(endTime);
		
		if(date1.getTime() > date2.getTime()) {
			 Calendar c = Calendar.getInstance();
	         c.setTime(date2);
	         c.add(Calendar.DATE, 1);
	         date2 = c.getTime();
		}
		
		long differenceInSeconds = (date2.getTime() - date1.getTime()) / 1000;
		long differenceInMinutes = differenceInSeconds / 60;
		long differenceInHours = differenceInMinutes / 60;
		long leftoverMinutes = differenceInMinutes % 60;
		
		System.out.println("Time difference is: " + differenceInHours + " hours " + leftoverMinutes + " minutes.");
		
		int minutesAhead = (int)(differenceInMinutes * 1.2);
		differenceInHours = minutesAhead / 60;
		leftoverMinutes = minutesAhead % 60;
		
		System.out.println("The time on the coffee maker will elapse: " + differenceInHours + " hours "+ leftoverMinutes + " minutes. \n");
		
		System.out.println("What time is it on your coffee maker? Please enter in HH:mm format.");
		String timeOnMaker = scan.nextLine();
		Date date3 = format.parse(timeOnMaker);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date3);
		cal.add(Calendar.MINUTE, minutesAhead);
		String newTime = format.format(cal.getTime());
		 
		System.out.println("Set your coffee maker to make coffee at: " + newTime);
		
		scan.close();
		
	}
}
