package com.obsqura.rmart.utilities;

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

}
