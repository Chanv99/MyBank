package com.chango.myBank.utility;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateManager {
	public static String myDateFormat(Timestamp timestamp,String requiredFormat) throws ParseException , NullPointerException {
//		String requiredFormat = "dd-MM-yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(requiredFormat); 
		Date curDate = timestamp;
		return sdf.format(curDate);
	}
}
