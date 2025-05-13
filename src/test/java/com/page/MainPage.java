package com.page;

import static com.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;;

public class MainPage {
	
	public String getUserLogged() {
		
		WebElement labeLogged = getDriver().findElement(By.id("textName"));
		return labeLogged.getText();
		
	}

}
