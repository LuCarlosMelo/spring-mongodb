package com.lucarlosmelo.springmongodb.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class URL {

	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	
	public static LocalDateTime date(String date) {
		var utc = ZoneId.of("GMT");
		var dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(utc);

		return ZonedDateTime.parse(date, dateFormat).toLocalDateTime();

	}
	
	public static LocalDateTime convertDate(String textDate, LocalDateTime defaultValue) {
		try {
			return date(textDate);
		} catch (DateTimeParseException e) {
			return defaultValue;
		}		
	}
	
}
