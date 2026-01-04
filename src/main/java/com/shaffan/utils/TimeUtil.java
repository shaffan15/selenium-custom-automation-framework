package com.shaffan.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtil {

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss-SSS");
	
	private TimeUtil() {}
	
	public static String now() {
		return LocalDateTime.now().format(FORMATTER);
	}
	
}
