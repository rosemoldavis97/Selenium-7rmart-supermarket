package com.obsqura.rmart_supermarketPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newButton;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement enterNews;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement save;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertSuccess;

	public ManageNewsPage clickNewButton() {
		newButton.click();
		return this;
	}

	public ManageNewsPage enterTheNews(String news) {
		enterNews.sendKeys(news);
		return this;
	}

	public ManageNewsPage clickSaveButton() {
		save.click();
		return this;
	}

	public boolean isAlertMessageShownSuccess() {
		boolean alert = alertSuccess.isDisplayed();
		return alert;
	}

}