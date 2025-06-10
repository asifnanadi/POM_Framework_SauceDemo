package com.saucelabs.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
	private static WebDriver driver;

	// Method to initialize driver
	public static WebDriver getDriver() {
		if (driver == null) {
			String browserName = ConfigurationReader.getProperty("Browser");
			if (browserName.trim().equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else {
				System.out.println("Invalid Browser");
			}

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(ConfigurationReader.getProperty("LoginPageURL"));// Fetch Login Page URL from properties file.

			

		}
		return driver;
	}

	// Method to close WebDriver
	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
