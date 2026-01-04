package com.shaffan.base;

import org.testng.annotations.Test;

import com.shaffan.utils.ConfigReader;

import io.qameta.allure.testng.AllureTestNg;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertNull;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;

@Listeners(AllureTestNg.class)
public class BaseTest {

	protected WebDriver driver;

	@BeforeMethod
	public void setup() {
		
		driver = createDriver(ConfigReader.getProperty("browserName"));
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String baseUrl = ConfigReader.getProperty("baseUrl");
		driver.get(baseUrl);
	}

	@Parameters("closeBrowser")
	@AfterMethod
	public void afterMethod(@Optional("true")String closeBrowser) {
		if(driver != null && "true".equals(closeBrowser))
			driver.quit();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	private WebDriver createDriver(String browserName) throws RuntimeException {
		
		switch (browserName) {
		case "chrome":
			if(System.getenv("isHeadless") != null) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=new");
				return new ChromeDriver(options);
			}
			return new ChromeDriver();
		case "firefox":
			if(System.getenv("isHeadless") != null) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				return new FirefoxDriver(options);
			}
			return new FirefoxDriver();
		default:
			break;
		}
		throw new RuntimeException("Invalid Browser name:");
	}
	
}
