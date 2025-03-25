package com.obsqura.rmart_supermarketPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement usernamefield;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement passwordfield;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signinfield;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement message;

	public LoginPage enterUsernameAndPassword(String username, String password) {
		usernamefield.sendKeys(username);
		passwordfield.sendKeys(password);
		return this;
	}

	public HomePage clickSignin() {
		signinfield.click();
		return new HomePage(driver);
	}

	public boolean isMessageIsDisplayed() {
		return message.isDisplayed();

	}

}
