package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.core.DriverFactory.getDriver;

import java.time.Duration;

public class RegisterBBPage {
	
	private WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
	
	public RegisterBBPage sendEmail(String email) {
		WebElement tfEmail = getDriver().findElement(By.xpath("//div[@class='card__register']//input[@name='email']"));		
		tfEmail.sendKeys(email);
		return this;
	}
	
	public RegisterBBPage sendName(String name) {
		WebElement tfName = getDriver().findElement(By.name("name"));
		tfName.sendKeys(name);
		return this;
	}
	
	public RegisterBBPage sendPassword(String pass) {
		WebElement tfPass = getDriver().findElement(By.xpath("//div[@class='card__register']//input[@name='password']"));
		tfPass.sendKeys(pass);
		return this;
	}
	
	public RegisterBBPage sendConfirmationPassword(String pass) {
		WebElement tfConfirmationPass = getDriver().findElement(By.name("passwordConfirmation"));
		tfConfirmationPass.sendKeys(pass);		
		return this;
	}
	
	public RegisterBBPage toogleAddBalance() {
		//wait.until(ExpectedConditions.elementToBeClickable(By.id("toggleAddBalance")));
		
		WebElement chkBalance = getDriver().findElement(By.id("toggleAddBalance"));
		
		if(!chkBalance.isSelected()) {
			chkBalance.click();
		}
		return this;		
	}
	
	public String getSuccessMessage() {		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalText")));
		
		WebElement modalMessage = getDriver().findElement(By.id("modalText"));
		return modalMessage.getText();
	}
	
	public void closeModalMessage() {
		WebElement btnClose = getDriver().findElement(By.id("btnCloseModal"));
		btnClose.click();		
		
	}
	
	public LoginBBPage clickCadastrar() {
		WebElement btnCadastrar = getDriver().findElement(By.xpath("//button[.='Cadastrar']"));
		btnCadastrar.click();
		return new LoginBBPage();
	}

}
