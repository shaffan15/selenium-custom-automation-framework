package com.shaffan.listeners;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.shaffan.base.BaseTest;
import com.shaffan.utils.FileUtil;

import io.qameta.allure.Attachment;

public class TestListener implements ITestListener {

	@Attachment(value = "Page Screenshot", type = "image/png")
	public byte[] saveScreenshotPng(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		Object testClass = result.getInstance();
		WebDriver driver = ((BaseTest) testClass).getDriver();
		
		try {
			if(driver != null) {
				File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				saveScreenshotPng(driver);
				File savedScreenshot = FileUtil.copyScreenshot(src, result.getName());
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
}
