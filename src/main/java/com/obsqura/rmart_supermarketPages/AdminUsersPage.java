package com.obsqura.rmart_supermarketPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.obsqura.rmart.utilities.PageUtility;

public class AdminUsersPage {
	public WebDriver driver;
	PageUtility pageutility=new PageUtility();

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newField;
	@FindBy(xpath = "//input[@id='username']")
	WebElement usernameField;
	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordField;
	@FindBy(xpath = "//select[@name='user_type']")
	WebElement usertypeField;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement saveField;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alert1;

	public AdminUsersPage clickNewField() {
		newField.click();
		return this;
	}

	public AdminUsersPage enterUserInfo(String username, String password, int number) {
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		pageutility.selectByIndex(usertypeField,number);
		return this;
	}

	public AdminUsersPage clickSaveButton() {
		saveField.click();
		return this;
	}

	public boolean checkSuccessAlert() {
		boolean alertSuccess = alert.isDisplayed();
		return alertSuccess;
	}

	public boolean checkAreadyExistAlert() {
		boolean alertDanger = alert1.isDisplayed();
		return alertDanger;
	}

}
