package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropTest {
	
	private WebDriver driver;

	@BeforeEach
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/umov.me/Dev/drivers/chromedriver");
		
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
	}

	@AfterEach
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public void testDragAndDrop() {
		WebElement origem = driver.findElement(By.id("draggable"));
		WebElement destino = driver.findElement(By.id("droppable"));
		
		assertEquals("Drop here", destino.getText());
		
		new Actions(driver).dragAndDrop(origem, destino).perform();
		
		assertEquals("Dropped!", destino.getText());
	}

}
