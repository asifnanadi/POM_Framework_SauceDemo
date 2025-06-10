package com.swaglabs.pages;

import org.openqa.selenium.WebDriver;

import com.saucelabs.utils.ConfigurationReader;
import com.saucelabs.utils.ElementUtil;

public class ProductsPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;

	//constructor
	public ProductsPage(WebDriver driver) {
		this.driver=driver;
		eleUtil = new ElementUtil(driver);
	}
	
	//locators
	
	
	//Actions
	public String getProductsURL() {
		String productPageURL=eleUtil.waitForURLAndFetch(ConfigurationReader.getProperty("productsPageURL"), 5);
		return productPageURL;
	}
}
