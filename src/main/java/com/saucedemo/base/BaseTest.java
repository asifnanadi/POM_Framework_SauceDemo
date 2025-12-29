package com.saucedemo.base;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.utils.ConfigurationReader;
import com.saucedemo.utils.DriverManager;

public class BaseTest {

	protected WebDriver driver;
	public LoginPage loginPage;
	public InventoryPage inventoryPage;
	public CartPage cartPage;

	@BeforeTest
	public void setup() {
		System.out.println("Initializing the driver");
		driver = DriverManager.getDriver();// Initialization of WebDriver and Object has been created
		driver.get(ConfigurationReader.getProperty("LoginPageURL"));// Fetch Login Page URL from properties file
		loginPage = new LoginPage(driver); // LoginPage object has been created. Now this LoginPage object reference can
											// be used
											// anywhere in other child class.

	}

	@AfterTest
	public void tearDown() {
		DriverManager.quitDriver();

	}

}
