package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.saucedemo.base.BasePage;
import com.saucedemo.utils.ElementUtil;

public class LoginPage extends BasePage{

//	private WebDriver driver;
	private WebDriverWait wait;
//	private ElementUtil eleUtil;

	// locators
	private By usernameField = By.id("user-name");
	private By passwordField = By.id("password");
	private By loginButton = By.id("login-button");

	// constructor
	public LoginPage(WebDriver driver) {
		super(driver); //initializes driver and ElementUtil
	}

	// Actions
	public InventoryPage doLogin(String username, String password) {
		eleUtil.waitForElementVisible(5, usernameField).sendKeys(username);
		eleUtil.waitForElementVisible(5, passwordField).sendKeys(password);
		eleUtil.waitForElementVisible(5, loginButton).click();

		return new InventoryPage(driver);
	}

	public String getLoginPageURL() {
		String loginPageURL = eleUtil.fetchCurrentPageURL();
		return loginPageURL;
	}

}
