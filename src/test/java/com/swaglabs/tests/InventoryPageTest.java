package com.swaglabs.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.saucelabs.utils.ConfigurationReader;
import com.swaglabs.base.BaseTest;

public class InventoryPageTest extends BaseTest {

	@BeforeClass
	public void login() {
		inventoryPage = loginPage.doLogin(ConfigurationReader.getProperty("username"),
				ConfigurationReader.getProperty("password"));

	}

	@Test
	public void testProductContainerOption() {
		inventoryPage.productCartOption();
	}

}
