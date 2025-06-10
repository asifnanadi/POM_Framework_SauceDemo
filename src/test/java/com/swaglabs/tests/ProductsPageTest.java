package com.swaglabs.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.saucelabs.utils.ConfigurationReader;
import com.swaglabs.base.BaseTest;

public class ProductsPageTest extends BaseTest {

	@BeforeClass
	public void login() {
		productPage=loginPage.doLogin(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
		
	}
	
	@Test
	public void productPageTest() {
		System.out.println("Landed to Products Page");
	}

}
