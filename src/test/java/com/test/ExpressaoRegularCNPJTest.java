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

public class ExpressaoRegularCNPJTest {
	
	private WebDriver driver;

	@BeforeEach
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/umov.me/Dev/drivers/chromedriver");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://toolshub.com.br/gerador-cnpj-filial");
	}

	@AfterEach
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
	
	@Test
	public void testExpressaoRegularCNPJ() {
		WebElement btnGerar = driver.findElement(By.xpath("//button[contains(text(),'gerar cnpj')][1]"));
		btnGerar.click();
		
		WebElement tfCnpj = driver.findElement(By.xpath("//input[@id='input']"));
		String cnpjValue = tfCnpj.getDomProperty("value");
		
		assertTrue(cnpjValue.matches("^[0-9]{2}\\.[0-9]{3}\\.[0-9]{3}/0001-[0-9]{2}$"));
		
	}

}
