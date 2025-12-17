package com.saucelabs.utils;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	/*
	 * Features of this Utility Class: ✔ Handles clicking, typing, getting text, and
	 * dropdown selections ✔ Includes explicit waits for better stability ✔ Manages
	 * alerts and checkboxes ✔ Implements custom exception handling
	 * 
	 */

	private WebDriver driver;

	// Constructor
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	// Method to wait for an element to be visible
	public WebElement waitForElementVisible(int timeOut, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// Method to wait for an element to be clickable
	public WebElement waitForElementClickable(By locator, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public String fetchCurrentPageURL() {
		return driver.getCurrentUrl();
	}
	
	
	// Click method with explicit wait
	public void clickElement(By locator, int timeout) {
		waitForElementClickable(locator, timeout).click();
	}

	// Send keys method with explicit wait
	public void enterText(By locator, String text, int timeout) {
		WebElement element = waitForElementVisible(timeout, locator);
		element.clear();
		element.sendKeys(text);
	}

	// Get text from an element
	public String getElementText(By locator, int timeout) {
		return waitForElementVisible(timeout, locator).getText();
	}

	// Select value from dropdown by visible text
	public void selectDropdownByVisibleText(By locator, String value, int timeout) {
		WebElement dropdown = waitForElementVisible(timeout, locator);
		Select select = new Select(dropdown);
		select.selectByVisibleText(value);
	}

	// Select value from dropdown by index
	public void selectDropdownByIndex(By locator, int index, int timeout) {
		WebElement dropdown = waitForElementVisible(timeout, locator);
		Select select = new Select(dropdown);
		select.selectByIndex(index);
	}

	// Check if element is displayed
	public boolean isElementDisplayed(By locator, int timeout) {
		try {
			return waitForElementVisible(timeout, locator).isDisplayed();
		} catch (TimeoutException e) {
			return false;
		}
	}

	// Handle JavaScript Alerts
	public void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void dismissAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public String getAlertText() {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}

	// Handle checkboxes
	public void checkCheckbox(By locator, int timeout) {
		WebElement checkbox = waitForElementVisible(timeout, locator);
		if (!checkbox.isSelected()) {
			checkbox.click();
		}
	}

	public void uncheckCheckbox(By locator, int timeout) {
		WebElement checkbox = waitForElementVisible(timeout, locator);
		if (checkbox.isSelected()) {
			checkbox.click();
		}
	}

	// Get all elements from a list
	public List<WebElement> getElements(By locator, int timeout) {
		waitForElementVisible(timeout, locator);
		return driver.findElements(locator);
	}

	// Scroll to an element using JavaScript
	public void scrollToElement(By locator) {
		WebElement element = driver.findElement(locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// Capture screenshot
	public void captureScreenshot(String filename) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File destination = new File("./screenshots/" + filename + ".png");
			org.apache.commons.io.FileUtils.copyFile(source, destination);
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot: " + e.getMessage());
		}
	}

	/*
	 * Key Benefits of This Utility Class ✔ Code Reusability – Reduces duplication
	 * in test scripts ✔ Explicit Waits – Increases stability and avoids failures
	 * due to loading delays ✔ Exception Handling – Prevents test failures due to
	 * missing elements ✔ Dropdown, Alerts, and Checkbox Handling – Covers most
	 * common interactions ✔ Screenshot Functionality – Useful for debugging failed
	 * tests
	 * 
	 * This ElementUtil class will help make your Selenium Automation Framework more
	 * structured, reusable, and maintainable.
	 * 
	 */

}
