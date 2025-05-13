package com.test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.core.BaseTest;
import com.page.LoginBBPage;
import com.page.MainPage;
import com.page.RegisterBBPage;

public class LoginBBTest extends BaseTest{
	
	private LoginBBPage loginPage;
	private RegisterBBPage registerPage;
	private MainPage mainPage;
	
	
	@BeforeEach
	public void setUp() {
		loginPage = new LoginBBPage();
		loginPage.open("https://bugbank.netlify.app/#");
		
	}
	
	@Test
	public void testLoginSuccess() throws InterruptedException {
		registerPage = loginPage.clickRegister();
		
		Thread.sleep(1000);
		registerPage.sendEmail("targettrust@mail.com.br");
		registerPage.sendName("TargetTrust");
		registerPage.sendPassword("123456");
		registerPage.sendConfirmationPassword("123456");		
		registerPage.toogleAddBalance();
		
		registerPage.clickCadastrar();		
		
		String message = registerPage.getSuccessMessage();
		System.out.println(message);
		assertTrue(message.contains("foi criada com sucesso"));	
		
		registerPage.closeModalMessage();
		
		loginPage.sendEmail("targettrust@mail.com.br");
		loginPage.sendPassword("123456");
		mainPage = loginPage.clickAcessar();
		
		Thread.sleep(2000);
		assertEquals("Olá TargetTrust,", mainPage.getUserLogged());
		
	}

}
