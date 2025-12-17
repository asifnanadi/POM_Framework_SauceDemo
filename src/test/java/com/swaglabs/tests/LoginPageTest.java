package com.swaglabs.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucelabs.utils.ConfigurationReader;
import com.swaglabs.base.BaseTest;

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
