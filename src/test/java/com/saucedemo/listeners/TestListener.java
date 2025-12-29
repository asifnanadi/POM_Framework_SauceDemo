package com.saucedemo.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.saucedemo.utils.ExtentManager;

public class TestListener implements ITestListener{
	
	public static ExtentTest test;
	
	//method override
	public void onTestStart(ITestResult result) {
		test = ExtentManager.getInstance().createTest(result.getMethod().getMethodName());
	}
	
	public void onTestSuccess(ITestResult result) {
		test.pass("Test Passed");
	}
	
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
	}

}
