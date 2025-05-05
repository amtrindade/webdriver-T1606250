package com.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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
		WebElement textFieldEnable = driver.findElement(By.xpath("//*[@name='txtbox1']"));
		
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
	
	@Test
	public void testValidaDropDownSingle() throws InterruptedException {
		WebElement dropSingle = driver.findElement(By.name("dropdownlist"));		
		Select selectDropSingle = new Select(dropSingle);
		
		selectDropSingle.selectByIndex(0);
		//Sleep para travar o tempo em 3s //Não é uma boa prática
		Thread.sleep(3000);
		selectDropSingle.selectByValue("item9");
		Thread.sleep(3000);
		selectDropSingle.selectByVisibleText("Item 7");
		
		assertEquals("Item 7", selectDropSingle.getFirstSelectedOption().getText());
				
	}
	
	@Test
	public void testValidaDropDownMultiple() {
		WebElement dropMulti = driver.findElement(By.name("multiselectdropdown"));
		Select selectDropMulti = new Select(dropMulti);
		
		selectDropMulti.selectByVisibleText("Item 5");
		selectDropMulti.selectByVisibleText("Item 8");
		selectDropMulti.selectByVisibleText("Item 9");
		
		List<WebElement> listSelected = selectDropMulti.getAllSelectedOptions();
		
		//Valida quantos
		assertEquals(3, listSelected.size());
		
		//Valida quais
		assertEquals("Item 5", listSelected.get(0).getText());
		assertEquals("Item 8", listSelected.get(1).getText());
		assertEquals("Item 9", listSelected.get(2).getText());		
	}
	
	@Test
	public void testValidaIFrame() {
		//entra no iframe
		driver.switchTo().frame(0);
		
		WebElement tfIframe = driver.findElement(By.id("tfiframe"));
		tfIframe.sendKeys("Automação de teste");
		
		assertEquals("Automação de teste", tfIframe.getDomProperty("value"));
		
		//retorna para o contexto default
		driver.switchTo().defaultContent();
	}
	
	@Test
	public void testValidaAlerts() {
		WebElement btnAlert = driver.findElement(By.name("alertbtn"));
		btnAlert.click();
		
		Alert alert = driver.switchTo().alert();
		assertEquals("Eu sou um alerta!", alert.getText());
		
		alert.accept();
		
		WebElement btnConfirm = driver.findElement(By.name("confirmbtn"));
		btnConfirm.click();
		
		Alert confirm = driver.switchTo().alert();
		assertEquals("Pressione um botão!", confirm.getText());
		
		confirm.dismiss();	
		
	}
	
	@Test
	public void testFluxoAlerts() {
		WebElement btnPrompt = driver.findElement(By.id("promptBtn"));
		btnPrompt.click();
		
		Alert alertDigiteAno = driver.switchTo().alert();
		alertDigiteAno.sendKeys("2024");
		alertDigiteAno.accept();
		
		Alert alertValidaAno = driver.switchTo().alert();
		
		assertEquals("O ano é 2025?", alertValidaAno.getText());
		alertValidaAno.accept();
		
		Alert alertFeito = driver.switchTo().alert();
		
		assertEquals("Feito!", alertFeito.getText());
		alertFeito.accept();
	}
	

}
