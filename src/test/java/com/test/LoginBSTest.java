package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.core.BaseTest;
import com.page.LoginBSPage;
import com.page.MainBSPage;


public class LoginBSTest extends BaseTest{
	
	private LoginBSPage loginPage;
	private MainBSPage mainPage;
	
	@BeforeEach
	public void setUp() throws Exception  {
		loginPage = new LoginBSPage();		
		loginPage.openSite("https://sahitest.com/demo/training/login.htm");
	}

	@Test
	public void testLoginInvalid() {		
		
		loginPage.sendUser("test");
		loginPage.sendPassword("wrongpassword");		
		loginPage.clickLogginInvalid();
		
		assertEquals("Invalid username or password", loginPage.getMessageError());			
	}
	
	@Test
	public void testLoginValid() {
		
		loginPage.sendUser("test");
		loginPage.sendPassword("secret");		
		mainPage = loginPage.clickLogginValid();
		
		assertTrue(mainPage.isLogged());
		
	}
	
}
