package com.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavegacaoMultiplasTabsTest {
	
	private WebDriver driver;

	@BeforeEach
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/umov.me/Dev/drivers/chromedriver");
		
		driver = new ChromeDriver();
		driver.get("https://antoniotrindade.com.br/treinoautomacao");
	}

	@AfterEach
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testNavegacaoTabs() throws InterruptedException {
		assertEquals("Treino Automação de Testes", driver.getTitle());
		
		WebElement linkGeradorCpf = driver.findElement(By.linkText("Gerador de CPF"));
		linkGeradorCpf.click();
		Thread.sleep(3000);
		
		WebElement linkDragAndDrop = driver.findElement(By.linkText("Drag and Drop"));
		linkDragAndDrop.click();
		Thread.sleep(3000);
		
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		
		driver.switchTo().window(tabs.get(2));
		assertEquals("Gerador de CPF", driver.getTitle());
		
		driver.switchTo().window(tabs.get(1));
		assertEquals("Mootools Drag and Drop Example", driver.getTitle());
		
		driver.switchTo().window(tabs.get(0));
		assertEquals("Treino Automação de Testes", driver.getTitle());			
		
	}

}
