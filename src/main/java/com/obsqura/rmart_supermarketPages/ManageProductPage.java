package com.obsqura.rmart_supermarketPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.rmart.utilities.PageUtility;
import com.obsqura.rmart.utilities.WaitUtility;

public class ManageProductPage {
	public WebDriver driver;
	PageUtility pageutility=new PageUtility();
	WaitUtility waitutility=new WaitUtility();
	
	public ManageProductPage( WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(xpath="//a[@onclick='click_button(2)']")
	WebElement search1;
	@FindBy(xpath="//input[@placeholder='Title']")
	WebElement titleField;
	@FindBy(xpath="//input[@placeholder='Product Code']")
	WebElement productcodeField;
	@FindBy(xpath="//select[@id='cat_id']")
	WebElement categoryField;
	@FindBy(xpath="//select[@id='sb']")
	WebElement subcategoryField;
	@FindBy(xpath="(//button[@type='submit'])[1]")
	WebElement search2;
	@FindBy(xpath="//table/thead/tr")
	WebElement header;
	
	public ManageProductPage clickSearchButton() {
		search1.click();
		return this;
	}
	
	public ManageProductPage enterTitleAndProductCode(String title,String code) {
		titleField.sendKeys(title);
		productcodeField.sendKeys(code);
		return this;
	}
	
	public ManageProductPage enterCategoryField(String text) {
		categoryField.click();
		pageutility.selectByVisibleText(categoryField, text);
		waitutility.elementToBeClickable(driver, categoryField);
		return this;			
	}
	
	public ManageProductPage enterSubCategoryField(String text) {
		waitutility.elementToBeClickable(driver, subcategoryField);
		subcategoryField.click();
		pageutility.selectByVisibleText(subcategoryField, text);
		return this;
	}
	
	public ManageProductPage clickSearch() {
		search2.click();
		return this;
	}
	
	public boolean isDisplayed() {
		return header.isDisplayed();
	}
	

}
