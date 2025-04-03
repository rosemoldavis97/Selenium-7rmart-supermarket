package com.obsqura.rmart_supermarketPages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.rmart.constant.Constant;
import com.obsqura.rmart.utilities.FileUploadUtility;
import com.obsqura.rmart.utilities.PageUtility;
import com.obsqura.rmart.utilities.WaitUtility;

public class CategoryPage {
	public WebDriver driver;
	PageUtility pageutility=new PageUtility();
	WaitUtility waitutility=new WaitUtility();

	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newButton;
	@FindBy(xpath = "//input[@type='text']")
	WebElement categoryField;
	@FindBy(xpath = "//span[text()='discount']")
	WebElement discount;
	@FindBy(xpath = "//input[@id=\"main_img\"]")
	WebElement chooseFile;
	@FindBy(xpath = "(//input[@value='no'])[2]")
	WebElement noButton1;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertSuccess;

	public CategoryPage clickNewButton() {
		newButton.click();
		return this;
	}

	public CategoryPage enterCategoryInformation(String category) {
		categoryField.sendKeys(category);
		discount.click();
		
		FileUploadUtility fileuploadutility=new FileUploadUtility();
		fileuploadutility.sendKeysForFileUpload(chooseFile, Constant.IMAGE);
		pageutility.JavaScriptExecutor(driver, noButton1);
		waitutility.elementToBeClickable(driver,noButton1);
		//noButton1.click();
		return this;
	}
	public CategoryPage clickSaveButton() {
		pageutility.JavaScriptExecutor(driver, saveButton);
		waitutility.elementToBeClickable(driver,saveButton);
		saveButton.click();
		return this;
	}
	
	public boolean isAlertMessageShownSuccess() {
		boolean alert = alertSuccess.isDisplayed();
		return alert;
	}

}
