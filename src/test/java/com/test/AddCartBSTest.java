package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.core.BaseTest;
import com.page.LoginBSPage;
import com.page.MainBSPage;

public class AddCartBSTest extends BaseTest{
	
	private LoginBSPage loginPage;
	private MainBSPage mainPage;
	
	@BeforeEach
	public void setUp() throws Exception  {
		loginPage = new LoginBSPage();		
		loginPage.openSite("https://sahitest.com/demo/training/login.htm");
		
		loginPage.sendUser("test");
		loginPage.sendPassword("secret");		
		mainPage = loginPage.clickLogginValid();
	}
	
	@Test
	public void testAddCartCoreJava() {
		mainPage.sendCoreJava("10");		
		mainPage.clickAdd();
		assertEquals("3000", mainPage.getValueTotal());
	}

}
