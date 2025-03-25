package com.obsqura.rmart.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class PageUtility {
	public WebDriver driver;
	
	public void selectByIndex(WebElement element,int num) {
		Select select = new Select(element);
		select.selectByIndex(num);
	}
	
	public void selectByVisibleText(WebElement element,String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	public void selectByVisibleValue(WebElement element,String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	public void JavaScriptExecutor(WebDriver driver,WebElement element) {
		JavascriptExecutor executor=(JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0,10000)");
	}
	
	public void actionClass(WebElement dragelement,WebElement dropspace) {
		Actions actions=new Actions(driver);
		actions.moveToElement(dragelement);
		actions.doubleClick(dragelement).perform();
		actions.dragAndDrop(dragelement, dropspace);			
	}
	public void roboClass(WebDriver driver,WebElement element) throws AWTException {
		StringSelection selection=new StringSelection("C:\\Users\\User\\Desktop\\Capture.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);
		Robot robo=new Robot();
		robo.delay(2000);
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyRelease(KeyEvent.VK_V);
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
	}

}
