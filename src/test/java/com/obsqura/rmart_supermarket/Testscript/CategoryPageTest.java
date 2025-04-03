package com.obsqura.rmart_supermarket.Testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.rmart.constant.Constant;
import com.obsqura.rmart.utilities.ExcelUtility;
import com.obsqura.rmart.utilities.FakerUtility;
import com.obsqura.rmart_supermarketPages.CategoryPage;
import com.obsqura.rmart_supermarketPages.HomePage;
import com.obsqura.rmart_supermarketPages.LoginPage;

public class CategoryPageTest extends Base {
	public HomePage homepage;
	public CategoryPage categorypage;
	FakerUtility fakerutility=new FakerUtility();

	@Test(retryAnalyzer = com.obsqura.rmart.retry.Retry.class)
	public void verifyUserCanAddCategory() throws Exception {
		LoginPage loginpage = new LoginPage(driver);
		String username=ExcelUtility.readString(1, 0, "CategoryPage");
		String password=ExcelUtility.readString(1, 1, "CategoryPage");	
		loginpage.enterUsernameAndPassword(username,password);
		homepage = loginpage.clickSignin();
		categorypage = homepage.clickCategoryIcon();
		//String category=ExcelUtility.readString(1, 2, "CategoryPage");
		String category=fakerutility.getMaterial();
		categorypage.clickNewButton().enterCategoryInformation(category).clickSaveButton();

		boolean expected = categorypage.isAlertMessageShownSuccess();
		Assert.assertTrue(expected, Constant.ERRORMESSAGEFORUSERCANADDCATEGORY);
	}
}
