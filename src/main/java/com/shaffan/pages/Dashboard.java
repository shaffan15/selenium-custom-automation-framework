package com.shaffan.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.shaffan.base.BasePage;

public class Dashboard extends BasePage {

	@FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
	WebElement profileButton;
	
	@FindBy(xpath = "//ul[@role='menu']/li/a[contains(@href,'auth/logout')]")
	WebElement logoutButton;
	
	
	WebDriver driver;
	
	public Dashboard(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void logout() {
		click(profileButton);
		click(logoutButton);
	}
	
}
