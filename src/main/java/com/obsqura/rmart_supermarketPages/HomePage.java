package com.obsqura.rmart_supermarketPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement admin;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")
	WebElement logout;
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'])[2]")
	WebElement adminUsersInfo;
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category'])[2]")
	WebElement category;
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'])[2]")
	WebElement manageNews;
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category'])[2]")
	WebElement subCategory;

	public HomePage clickAdmin() {
		admin.click();
		return this;
	}

	public HomePage clickLogout() {
		logout.click();
		return this;
	}

	public AdminUsersPage clickUsersMoreInfo() {
		adminUsersInfo.click();
		return new AdminUsersPage(driver);
	}

	public CategoryPage clickCategoryIcon() {
		category.click();
		return new CategoryPage(driver);
	}

	public ManageNewsPage clickManageNews() {
		manageNews.click();
		return new ManageNewsPage(driver);
	}

	public SubCategoryPage clickSubCategory() {
		subCategory.click();
		return new SubCategoryPage(driver);
	}

}
