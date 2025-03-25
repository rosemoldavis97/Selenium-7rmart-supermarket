package com.obsqura.rmart_supermarket.Testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.rmart.constant.Constant;
import com.obsqura.rmart_supermarketPages.CategoryPage;
import com.obsqura.rmart_supermarketPages.HomePage;
import com.obsqura.rmart_supermarketPages.LoginPage;

public class CategoryPageTest extends Base {
	public HomePage homepage;
	public CategoryPage categorypage;

	@Test
	public void verifyUserCanAddCategory() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameAndPassword("admin", "admin");
		homepage = loginpage.clickSignin();
		categorypage = homepage.clickCategoryIcon();
		categorypage.clickNewButton().enterCategoryInformation("fruits").clickSaveButton();

		boolean expected = categorypage.isAlertMessageShownSuccess();
		Assert.assertTrue(expected, Constant.ERRORMESSAGEFORUSERCANADDCATEGORY);
	}
}
