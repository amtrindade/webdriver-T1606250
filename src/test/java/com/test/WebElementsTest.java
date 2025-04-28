package com.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementsTest {
	
	private WebDriver driver;

	@BeforeEach
	public void setUp() throws Exception {
		//para mac
		System.setProperty("webdriver.chrome.driver", "/Users/umov.me/Dev/drivers/chromedriver");
	
		//para windows
		//System.setProperty("webdriver.chrome.driver", "C:\\Dev\\drivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("https://antoniotrindade.com.br/treinoautomacao/elementsweb.html");
	}

	@AfterEach
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testEscreveHelloWorld() {		
		//1. Localizar um elemento na tela
		WebElement textFieldEnable = driver.findElement(By.name("txtbox1"));
		
		//2. Interagir com o elemento
		textFieldEnable.sendKeys("Hello World!!!");
		
		//3. Validar o resultado 
		assertEquals("Hello World!!!", textFieldEnable.getDomProperty("value"));
	}
	
	@Test
	public void testValidaTitle() {
		assertEquals("WebElements Test Page Lab", driver.getTitle());
	}
	
	@Test
	public void testHabilitadoEDesabilitado() {
		WebElement textFieldEnable = driver.findElement(By.name("txtbox1"));
		WebElement textFieldDisable = driver.findElement(By.name("txtbox2"));
		
		assertTrue(textFieldEnable.isEnabled());
		assertFalse(textFieldDisable.isEnabled());		
	}
	
	@Test
	public void testValidaRadioButton() {
		List<WebElement> listRadio = driver.findElements(By.name("radioGroup1"));		
		assertEquals(4, listRadio.size());
		
		for (WebElement radio : listRadio) {
			if (radio.getDomProperty("value").equals("Radio 3")) {
				radio.click();
			}
		}
		
		//listRadio.get(2).click();
		
		assertTrue(listRadio.get(2).isSelected());
		assertFalse(listRadio.get(0).isSelected());
		assertFalse(listRadio.get(1).isSelected());
		assertFalse(listRadio.get(3).isSelected());		
	}
	
	@Test
	public void testValidaCheckBoxes() {
		List<WebElement> listCheck = driver.findElements(By.name("chkbox"));
		
		//validar o tamanho da lista
		assertEquals(4, listCheck.size());
		
		for (WebElement check : listCheck) {
			//System.out.println(check.getDomProperty("value"));
			
			// Operador lógico ou (||)
			if ((check.getDomProperty("value").equals("Check 3")) 
					|| (check.getDomProperty("value").equals("Check 4"))) {
				check.click();
			}		
		}
		
		assertTrue(listCheck.get(2).isSelected());
		assertTrue(listCheck.get(3).isSelected());
		assertFalse(listCheck.get(0).isSelected());
		assertFalse(listCheck.get(1).isSelected());
		
	}

}
