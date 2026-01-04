package com.shaffan.utils;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

	public static void takeScreenshot(String fileName, WebDriver driver) {
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			String screenShotPath = System.getProperty("user.dir") + "/screenshots/" + fileName + ".png";
			
			FileUtil.copyFile(src, new File(screenShotPath));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
