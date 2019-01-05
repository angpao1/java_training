package th.co.extosoft.trainning;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDateFormat {

	public static void main(String args[]) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date currentDate = new Date();
		System.out.println("Current Date --> " + currentDate);
		String dateStr = sdf.format(currentDate);
		System.out.println("Current Date to String Format(dd/MM/yyyy HH:mm:ss) --> " + dateStr);
		
		Date d1 = null;
		try {
			d1 = sdf.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("String Format(dd/MM/yyyy HH:mm:ss) to Date  --> " + d1);
		
	}
	
}
