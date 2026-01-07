package com.shaffan.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	private static Properties properties = new Properties();

	static {
		try {
			FileInputStream fis = new FileInputStream("src/test/resources/config/config.properties");
			properties.load(fis);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public static String getProperty(String key) {
		
		String propertyValue = System.getProperty(key); 
		
		if(propertyValue == null || propertyValue.isEmpty()) {
			propertyValue = properties.getProperty(key);
		}
		System.out.println("value of " + key + " is: " + propertyValue);
		
		return propertyValue;
	}
}
