package th.co.extosoft.app.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
	public static String format(Date date, String pattern) {
		//return new SimpleDateFormat(pattern, Locale.ENGLISH).format(date);
		//return new SimpleDateFormat(pattern, Locale.getDefault()).format(date);
		return new SimpleDateFormat(pattern, new Locale("th", "TH")).format(date);
	}

	public static String format(long date, String pattern) {
		return format(new Date(date), pattern);
	}

	public static java.sql.Date format(String dateText, String pattern) {
		java.sql.Date date = new java.sql.Date(new Date().getTime());
		try {
			date = new java.sql.Date(new SimpleDateFormat(pattern, new Locale("th", "TH")).parse(dateText).getTime());
		} catch (Exception e) {
		}
		return date;
	}
	public static java.util.Date current( String pattern) {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		 try {
			return new java.util.Date(new SimpleDateFormat(pattern).parse(sdf.format(now)).getTime());
		} catch (ParseException e) {		
			e.printStackTrace();
		}
		return null;
	}
	public static Date parse(String dateText, String pattern) {
		try {
			return new SimpleDateFormat(pattern, Locale.ENGLISH).parse(dateText);
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static boolean isActive(String startDate, String endDate, String formater) {
		boolean result = false;
		SimpleDateFormat dtFormat = new SimpleDateFormat(formater, Locale.US);
		Date dtCurrent = new Date();
		Date dtStartDate = null;
		Date dtEndDate = null;
		
		try {
			dtFormat.setLenient(false);
			if ((startDate != null) && (startDate.trim().length() > 0)) {
				dtStartDate = dtFormat.parse(startDate);
			}
			if ((endDate != null) && (endDate.trim().length() > 0)) {
				dtEndDate = dtFormat.parse(endDate);
			}
		} catch (Exception err) {
			
		}
		
		if (((dtStartDate == null) || (dtStartDate.compareTo(dtCurrent) <= 0))
				&& ((dtEndDate == null) || (dtEndDate.compareTo(dtCurrent) >= 0))) {
			result = true;
		}
		
		return result;
	}
}
