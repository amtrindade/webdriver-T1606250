package com.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculadoraTest {
	
	private WebDriver driver;
	private WebDriverWait wait;

	@BeforeEach
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/umov.me/Dev/drivers/chromedriver");
		driver = new ChromeDriver();
		
		//espera implicita
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://antoniotrindade.com.br/treinoautomacao/desafiosoma.html");
		//Cria o wait
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	}

	@AfterEach
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public void testSomaDoisNumeros() throws InterruptedException {
		WebElement tfNumber1 = driver.findElement(By.id("number1"));
		tfNumber1.sendKeys("78");
		
		WebElement tfNumber2 = driver.findElement(By.id("number2"));
		tfNumber2.sendKeys("10");
		
		WebElement btnSomar = driver.findElement(By.id("somar"));
		btnSomar.click();
		
		WebElement tfTotal = driver.findElement(By.id("total"));
		
		//expera explícita		
		wait.until(ExpectedConditions.textToBePresentInElementValue(tfTotal, "88"));
		
		assertEquals("88", tfTotal.getDomProperty("value"));	
		
	}

}
