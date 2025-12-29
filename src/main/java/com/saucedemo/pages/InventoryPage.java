package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.saucedemo.base.BasePage;
import com.saucedemo.utils.ConfigurationReader;
import com.saucedemo.utils.ElementUtil;

public class InventoryPage extends BasePage {

	private WebDriver driver;
//	private ElementUtil eleUtil;

	// constructor
	public InventoryPage(WebDriver driver) {
		super(driver); //initializes driver and ElementUtil
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
