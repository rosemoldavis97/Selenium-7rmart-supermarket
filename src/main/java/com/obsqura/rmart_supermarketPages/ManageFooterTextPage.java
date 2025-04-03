package com.obsqura.rmart_supermarketPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterTextPage {
	public WebDriver driver;
	
	public ManageFooterTextPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(xpath="(//i[@class='fas fa-edit'])[1]")
	WebElement edit;
	@FindBy(xpath="//textarea[@name='address']")
	WebElement addressField;
	@FindBy(id="email")
	WebElement emailField;
	@FindBy(id="phone")
	WebElement phonenoField;
	@FindBy(xpath="//button[@name='Update']")
	WebElement update;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	
	public ManageFooterTextPage clickEditButton() {
		edit.click();
		return this;
	}
	
	public ManageFooterTextPage enterFooterTextInformations(String address,String email,String phone) {
		addressField.clear();
		addressField.sendKeys(address);
		emailField.clear();
		emailField.sendKeys(email);
		phonenoField.clear();
		phonenoField.sendKeys(phone);
		return this;
	}
	
	public ManageFooterTextPage clickUpdateButton() {
		update.click();
		return this;
	}
	
	public boolean isDisplayed() {
		return alert.isDisplayed();
		
	}

}
