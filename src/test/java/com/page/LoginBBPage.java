package com.page;

import static com.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;;

public class LoginBBPage {
	
	public LoginBBPage open(String url) {
		getDriver().get(url);		
		return this;
	}
	
	public RegisterBBPage clickRegister() {
		WebElement btnRegistrar = getDriver().findElement(By.xpath("//button[.='Registrar']"));
		btnRegistrar.click();
		
		return new RegisterBBPage();
	}
	
	public LoginBBPage sendEmail(String email){
		WebElement tfEmail = getDriver().findElement(By.xpath("//div[@class='card__login']//input[@name='email']"));
		tfEmail.sendKeys(email);
		return this;
	}
	
	public LoginBBPage sendPassword(String pass) {
		WebElement tfPass = getDriver().findElement(By.xpath("//div[@class='card__login']//input[@name='password']"));
		tfPass.sendKeys(pass);
		return this;
	}
	
	public MainPage clickAcessar() {
		WebElement btnRegistrar = getDriver().findElement(By.xpath("//button[.='Acessar']"));
		btnRegistrar.click();
		
		return new MainPage();
	}

}
