package proj1.model;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeMethods {

	public static Timestamp getCurrentTime() {
		 java.util.Date date = new java.util.Date();
		 Timestamp timestamp1 = new Timestamp(date.getTime());
		 return timestamp1;
	}
	
	//REMEMBER: the more recent one goes in second.
	public static int numberOfDays(Timestamp t1, Timestamp t2) {
		  // get time difference in seconds
	    long milliseconds = t2.getTime() - t1.getTime();
	    int seconds = (int) milliseconds / 1000;
	 
	    // calculate hours minutes and seconds
	    int days = seconds / (3600 * 24);
	    return days;
	}
	
	public static Timestamp getTimeFromInput(int year, int month, int day) throws ParseException {
		
		String date1 = Integer.toString(year)+"-"+Integer.toString(month)+"-"+Integer.toString(day)
		+ " 00:00:00";
		
		SimpleDateFormat datetimeFormatter1 = new SimpleDateFormat(
                "yyyy-MM-dd hh:mm:ss");
		Date lFromDate1 = datetimeFormatter1.parse(date1);
		Timestamp fromTS1 = new Timestamp(lFromDate1.getTime());
		return fromTS1;
	}		


public static void main(String[] args) {
	Timestamp t1 = getCurrentTime();
	try {
		Timestamp t2 = getTimeFromInput(2019,12,15);
		int test = numberOfDays(t1,t2);
		System.out.println(test);
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}