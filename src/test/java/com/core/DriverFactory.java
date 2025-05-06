package com.core;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	
	private static WebDriver driver = null;
	
	public static WebDriver getDriver() {
		
		if (driver == null) {
			driver = createDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
				
		return driver;
	}
	
	private static WebDriver createDriver() {
		
		System.setProperty("webdriver.chrome.driver", "/Users/umov.me/Dev/drivers/chromedriver");
		driver = new ChromeDriver();
		
		return driver;
	}
	
	public static void killDriver() {	
		driver.quit();
		driver = null;		
	}

}
