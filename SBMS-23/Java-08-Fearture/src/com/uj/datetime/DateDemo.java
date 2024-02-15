package com.uj.datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {
	
	public static void main(String ...args) throws ParseException {
		Date d = new Date();
		System.out.println(d);
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy");
		String format = sdf1.format(d);
		System.out.println(format);
		Date parse = sdf1.parse("02/3/2024");
		System.out.println(parse);
	}

}
