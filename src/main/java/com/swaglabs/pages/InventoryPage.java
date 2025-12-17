package com.swaglabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.saucelabs.utils.ConfigurationReader;
import com.saucelabs.utils.ElementUtil;

public class InventoryPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// constructor
	public InventoryPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// locators
	private By cartOption = By.xpath("//select[@class='product_sort_container']");

	// Actions
	public String getProductsPageURL() {
		String productPageURL = eleUtil.fetchCurrentPageURL();
		return productPageURL;
	}

	public Boolean productCartOption() {
		return eleUtil.isElementDisplayed(cartOption, 2);
	}
	
	public CartPage clickProductCartOption() {
		driver.findElement(cartOption).click();
		return new CartPage();
	}

}
