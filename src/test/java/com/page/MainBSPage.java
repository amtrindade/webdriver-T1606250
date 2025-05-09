package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.core.DriverFactory.getDriver;

public class MainBSPage {
	
	public Boolean isLogged() {
		WebElement divAvailable = getDriver().findElement(By.id("available"));
		return divAvailable.isDisplayed();		
	}

}
