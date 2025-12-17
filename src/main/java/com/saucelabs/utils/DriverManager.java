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
				throw new RuntimeException("Invalid Browser");
//				System.out.println("Invalid Browser");
			}

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();

			// 1. DriverManager class should only manage driver
			// 2. Navigation belongs to BaseTest class, not DriverManager class.
			// 3. Hence, commenting below line of code
			// driver.get(ConfigurationReader.getProperty("LoginPageURL"));

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
