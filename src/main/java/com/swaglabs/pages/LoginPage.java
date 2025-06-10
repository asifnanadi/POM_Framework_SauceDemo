package com.swaglabs.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.saucelabs.utils.ConfigurationReader;
import com.saucelabs.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private WebDriverWait wait;
	private ElementUtil eleUtil;

	// locators
	private By usernameField = By.id("user-name");
	private By passwordField = By.id("password");
	private By loginButton = By.id("login-button");

	// constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
//		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		eleUtil = new ElementUtil(driver);
	}

	// Actions
	public ProductsPage doLogin(String username, String password) {
		eleUtil.waitForElementVisible(5, usernameField).sendKeys(username);
		eleUtil.waitForElementVisible(5, passwordField).sendKeys(password);
		eleUtil.waitForElementVisible(5, loginButton).click();

		return new ProductsPage(driver);
	}

	public String getLoginPageURL() {
		String loginPageURL = eleUtil.waitForURLAndFetch(ConfigurationReader.getProperty("LoginPageURL"),5);
		return loginPageURL;
	}

}
