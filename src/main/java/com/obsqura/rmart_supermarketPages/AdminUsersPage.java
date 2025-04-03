package com.obsqura.rmart_supermarketPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.obsqura.rmart.utilities.PageUtility;
import com.obsqura.rmart.utilities.WaitUtility;

public class AdminUsersPage {
	public WebDriver driver;
	PageUtility pageutility=new PageUtility();
	WaitUtility waitutility=new WaitUtility();

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
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-danger btncss']")
	WebElement firstadminuserdelete;
	@FindBy(xpath="//a[@onclick='click_button(2)']")
	WebElement search;
	@FindBy(xpath="(//input[@type='text'])[1]")
	WebElement usernamesearch;
	@FindBy(xpath="//select[@name='ut']")
	WebElement usertypesearch;
	@FindBy(xpath="//button[@name='Search']")
	WebElement search2;
	@FindBy(xpath="//a[@class='page-link']")
	WebElement pagination;

	public AdminUsersPage clickNewField() {
		newField.click();
		return this;
	}

	public AdminUsersPage enterUserInfo(String username, String password, int i) {
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		pageutility.selectByIndex(usertypeField,i);
		return this;
	}

	public AdminUsersPage clickSaveButton() {
		saveField.click();
		return this;
	}
	
	public AdminUsersPage clickDeleteButton() {
		firstadminuserdelete.click();
		driver.switchTo().alert().accept();
		return this;
	}
	
	public AdminUsersPage clickSearchButton() {
		search.click();
		return this;
	}
	
	public AdminUsersPage enterUsernameSearch(String username) {
		
		usernamesearch.click();
		usernamesearch.sendKeys(username);
		return this;
	}
	
	public AdminUsersPage enterUserTypeSearch(String usertype) {
		usertypesearch.click();
		pageutility.selectByVisibleText(usertypesearch, usertype);
		return this;
	}
	
	public AdminUsersPage clickFinalSearch() {
		search2.click();
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
	
	public boolean isValueDisplayed() {
		return pagination.isDisplayed();
		}


}
