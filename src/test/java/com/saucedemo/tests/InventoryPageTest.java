package com.saucedemo.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.saucedemo.base.BaseTest;
import com.saucedemo.utils.ConfigurationReader;

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
