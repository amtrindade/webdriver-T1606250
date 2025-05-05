package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsTest {
	
	private WebDriver driver;
	private String nome;
	private String mail;

	@BeforeEach
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/umov.me/Dev/drivers/chromedriver");
		
		driver = new ChromeDriver();
		driver.get("https://antoniotrindade.com.br/treinoautomacao/localizandovalorestable.html");
		
		nome = "Antônio";
		mail = "antoniosilva@gmail.com";
	}

	@AfterEach
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}
	
	@Test
	public void testReservaVaga() {		
		
		WebElement labelEmail = driver.findElement(By.xpath("//td[contains(text(),'" + nome + "')]/..//td[2]"));
		String email = labelEmail.getText();
		
		WebElement tfEmailReserva = driver.findElement(By.xpath("//input[@id='txt01']"));
		tfEmailReserva.sendKeys(email);
		
		assertEquals(mail, tfEmailReserva.getDomProperty("value"));
		
	}
	
	@Test
	public void testCheckVaga() {
		WebElement chkVaga = driver.findElement(By.xpath("//td[contains(text(),'Fulano')]/following-sibling::td/input"));
		chkVaga.click();
		assertTrue(chkVaga.isSelected());
	}

}
