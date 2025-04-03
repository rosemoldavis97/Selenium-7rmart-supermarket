package com.obsqura.rmart_supermarketPages;

import java.awt.AWTException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.rmart.constant.Constant;
import com.obsqura.rmart.utilities.FileUploadUtility;
import com.obsqura.rmart.utilities.PageUtility;
import com.obsqura.rmart.utilities.WaitUtility;

public class SubCategoryPage {
	public WebDriver driver;
	PageUtility pageutility=new PageUtility();
	WaitUtility waitutility=new WaitUtility();

	public SubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Subcategory/add']")
	WebElement newButton;
	@FindBy(xpath = "//select[@id='cat_id']")
	WebElement categoryField;
	@FindBy(xpath = "//input[@id='subcategory']")
	WebElement subCategoryField;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement chooseFile;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement save;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertSuccess;

	public SubCategoryPage clickNewButton() {
		newButton.click();
		return this;
	}

	public SubCategoryPage enterSubCategoryInformation(String text, String subCategory) throws AWTException {
		pageutility.selectByVisibleText(categoryField, text);
		subCategoryField.sendKeys(subCategory);
		waitutility.elementToBeClickable(driver, chooseFile);
		JavascriptExecutor executor=(JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();",chooseFile);
		
		FileUploadUtility fileuploadutility=new FileUploadUtility();
		//fileuploadutility.sendKeysForFileUpload(chooseFile, Constant.IMAGE);
		fileuploadutility.roboClassForFileUpload(chooseFile, Constant.IMAGE);
		return this;
	}

	public SubCategoryPage clickSaveButton() {
		pageutility.JavaScriptExecutor(driver, save);
		waitutility.elementToBeClickable(driver, save);
		
		save.click();
		return this;
	}
	
	public boolean isAlertMessageShownSuccess() {
		boolean alert = alertSuccess.isDisplayed();
		return alert;
	}

}
