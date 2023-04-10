package br.com.attornatus.peopleManagement.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateConverterUtil {

	private DateConverterUtil() {}
	
	public static Date convertStringToDate(String date) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date formatedDate = format.parse(date);
		return formatedDate; 
	}
	
	public static String convertDateToString(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		return format.format(date);
	}
}
