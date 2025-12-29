package com.saucedemo.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
	private static Properties prop;

	static {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("./src/test/resources/config.properties");
			prop.load(fis);
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Method to get property value
	public static String getProperty(String key) {
		return prop.getProperty(key);
	}

}