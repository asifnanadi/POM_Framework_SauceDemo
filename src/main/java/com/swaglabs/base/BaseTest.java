package com.swaglabs.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.saucelabs.utils.ConfigurationReader;
import com.saucelabs.utils.DriverManager;
import com.saucelabs.utils.ElementUtil;
import com.swaglabs.pages.ProductsPage;
import com.swaglabs.pages.LoginPage;

public class BaseTest {

	protected WebDriver driver;
	public LoginPage loginPage;
	public ProductsPage productPage;

	@BeforeTest
	public void setup() {
		System.out.println("Initializing the driver");
		driver = DriverManager.getDriver();// Initialize WebDriver and Object has been created
		loginPage = new LoginPage(driver); // Object has been created. Now this object reference can be used anywhere in other child class.

	}

	@AfterTest
	public void tearDown() {
		DriverManager.quitDriver();
	}

}
