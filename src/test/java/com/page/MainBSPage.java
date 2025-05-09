package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.core.DriverFactory.getDriver;

public class MainBSPage {
	
	public Boolean isLogged() {
		WebElement divAvailable = getDriver().findElement(By.id("available"));
		return divAvailable.isDisplayed();		
	}
	
	public MainBSPage sendCoreJava(String quantity) {
		WebElement tfCoreJava = getDriver().findElement(By.name("q"));
		tfCoreJava.sendKeys(quantity);
		
		return this;
	}

	public MainBSPage clickAdd() {
		WebElement btnAdd = getDriver().findElement(By.xpath("//input[@value='Add']"));
		btnAdd.click();
		
		return this;		
	}
	
	public String getValueTotal() {
		WebElement tfTotal = getDriver().findElement(By.id("total"));
		return tfTotal.getDomProperty("value");		
	}

}
