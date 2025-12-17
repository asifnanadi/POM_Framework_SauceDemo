package com.swaglabs.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.saucelabs.utils.ConfigurationReader;
import com.swaglabs.base.BaseTest;

public class CartPageTest extends BaseTest{
	
	@BeforeClass
	public void login() {
		inventoryPage = loginPage.doLogin(ConfigurationReader.getProperty("username"),
				ConfigurationReader.getProperty("password"));
		//Return type of clickProductCartOption method should be InventoryPage in CartPage 
		cartPage=inventoryPage.clickProductCartOption();

	}
	
	@Test
	public void cartPageTest() {
		
		  
	}

}
