package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExpressaoRegularTest {
	
	private WebDriver driver;
	private WebElement btnGerarCPF;
	private WebElement tfNumeroCpf;
	private WebElement chkPontos;
	

	@BeforeEach
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/umov.me/Dev/drivers/chromedriver");
		
		driver = new ChromeDriver();
		driver.get("https://www.geradordecpf.org/");
		
		//mapeando componentes usados em mais de um teste dentro da classe
		btnGerarCPF = driver.findElement(By.id("btn-gerar-cpf"));
		tfNumeroCpf = driver.findElement(By.id("numero"));
		chkPontos = driver.findElement(By.id("cbPontos"));
	}

	@AfterEach
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public void testValidaCPFComMascara() {
		
		chkPontos.click();			
		btnGerarCPF.click();
		
		String numeroCpf = tfNumeroCpf.getDomProperty("value");
		
		System.out.println(numeroCpf);
		
		assertTrue(numeroCpf.matches("^[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}$"));		
	}
	
	@Test
	public void testValidaCPFSemMascara() {
		
		btnGerarCPF.click();	
		
		String numeroCpf = tfNumeroCpf.getDomProperty("value");
		
		System.out.println(numeroCpf);
		
		assertTrue(numeroCpf.matches("^[0-9]{11}$"));		
						
	}


}
