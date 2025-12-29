package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.base.BaseTest;
import com.saucedemo.utils.ConfigurationReader;

public class LoginPageTest extends BaseTest {

	@Test(priority = 0)
	public void loginPageURLTest() {
		String actLoginURL = loginPage.getLoginPageURL();
		Assert.assertEquals(actLoginURL, ConfigurationReader.getProperty("LoginPageURL"));

	}
	
	@Test(priority = 1)
	public void loginPageTest() {
		inventoryPage=loginPage.doLogin(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
		Assert.assertEquals(inventoryPage.getProductsPageURL(), ConfigurationReader.getProperty("inventoryPageURL"));
		
	}

}
