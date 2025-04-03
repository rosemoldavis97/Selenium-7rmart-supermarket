package com.obsqura.rmart_supermarketPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.rmart.utilities.PageUtility;
import com.obsqura.rmart.utilities.WaitUtility;

public class ManageContactPage {
	public WebDriver driver;
	PageUtility pageutility=new PageUtility();
	WaitUtility waitutility=new WaitUtility();
	
	
	public ManageContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[@role='button']")
	WebElement edit;
	@FindBy(xpath="//input[@id='phone']")
	WebElement phonenoField;
	@FindBy(xpath="//input[@id='email']")
	WebElement emailField;
	@FindBy(xpath="//textarea[@name='address']")
	WebElement addressField;
	@FindBy(xpath="//textarea[@placeholder='Enter Delivery Time']")
	WebElement deliverytimeField;
	@FindBy(xpath="//input[@name='del_limit']")
	WebElement deliverychargelimitField;
	@FindBy(xpath="//button[@type='submit']")
	WebElement update;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	
	public ManageContactPage clickEditButton() {
		edit.click();
		return this;
	}
	
	public ManageContactPage enterPhoneno(String phoneno) {
		phonenoField.clear();
		phonenoField.sendKeys(phoneno);
		return this;
	}
	
	public ManageContactPage enterEmail(String email) {
		emailField.clear();
		emailField.sendKeys(email);
		return this;
	}
	
	public ManageContactPage enterAddress(String address) {
		addressField.clear();
		addressField.sendKeys(address);
		return this;		
	}
	
	public ManageContactPage enterDeliveryTime(String deliverytime) {
		deliverytimeField.clear();
		deliverytimeField.sendKeys(deliverytime);
		return this;	
	}
	
	public ManageContactPage enterDeliveryChargeLimit(String chargelimit) {
		deliverychargelimitField.clear();
		deliverychargelimitField.sendKeys(chargelimit);
		return this;
	}
	public ManageContactPage clickUpdateButton() {
		pageutility.JavaScriptExecutor(driver, update);
		waitutility.elementToBeClickable(driver, update);
		update.click();
		return this;
	}
	
	public boolean isValueDisplayed() {
		return alert.isDisplayed();
	}

}
