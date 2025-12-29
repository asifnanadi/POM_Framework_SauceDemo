package com.saucedemo.base;

import org.openqa.selenium.WebDriver;

import com.saucedemo.utils.ElementUtil;

public class BasePage {
	
	protected WebDriver driver;
	protected ElementUtil eleUtil;
	
	// constructor
		public BasePage(WebDriver driver) {
			this.driver = driver;
			eleUtil = new ElementUtil(driver);
		}
	

}
