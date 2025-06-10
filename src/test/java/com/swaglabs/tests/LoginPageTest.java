package com.swaglabs.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucelabs.utils.ConfigurationReader;
import com.swaglabs.base.BaseTest;
import com.swaglabs.pages.LoginPage;

public class LoginPageTest extends BaseTest {

	@Test(priority = 0)
	public void loginPageURLTest() {
		String actLoginURL = loginPage.getLoginPageURL();
		Assert.assertEquals(actLoginURL, ConfigurationReader.getProperty("LoginPageURL"));

	}
	
	@Test()
	public void loginTest() {
		productPage=loginPage.doLogin(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
		Assert.assertEquals(productPage.getProductsURL(), ConfigurationReader.getProperty("productsPageURL"));
	}

}
