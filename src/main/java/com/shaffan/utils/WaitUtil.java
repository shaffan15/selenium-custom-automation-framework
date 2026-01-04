package com.shaffan.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {

	private WebDriverWait wait;
	private int timeoutSec = 10;
	
	public WaitUtil(WebDriver driver, int timeoutSec) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSec));
	}
	
	public void setTimeOutSecond(int timeOutSec) {
		this.timeoutSec = timeOutSec;
	}
	
	public void waitForClickability(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForVisibility(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForAlert() {
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
}
