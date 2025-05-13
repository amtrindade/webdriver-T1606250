package com.page;

import static com.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginBSPage {

	public LoginBSPage openSite(String url) {	
		getDriver().get(url);
		return this;
	}
	
	public LoginBSPage sendUser(String user) {
		WebElement tfUser = getDriver().findElement(By.name("user"));
		tfUser.sendKeys(user);		
		return this;
	}
	
	public LoginBSPage sendPassword(String pass) {
		WebElement tfPass = getDriver().findElement(By.name("password"));
		tfPass.sendKeys(pass);
		return this;
	}
	
	public LoginBSPage clickLogginInvalid() {
		WebElement btnLogar = getDriver().findElement(By.xpath("//input[@value='Login']"));
		btnLogar.click();
		return this;
	}
	
	public String getMessageError() {
		WebElement divMsgError = getDriver().findElement(By.id("errorMessage"));
		return divMsgError.getText();		
	}
	
	public MainBSPage clickLogginValid() {
		WebElement btnLogar = getDriver().findElement(By.xpath("//input[@value='Login']"));
		btnLogar.click();
		
		return new MainBSPage();
	}
	
	public MainBSPage login(String user, String pass) {
		sendUser(user);
		sendPassword(pass);
		clickLogginValid();
		
		return new MainBSPage();
	}

}
