package com.obsqura.rmart_supermarket.Testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.rmart.constant.Constant;
import com.obsqura.rmart.utilities.ExcelUtility;
import com.obsqura.rmart_supermarketPages.HomePage;
import com.obsqura.rmart_supermarketPages.LoginPage;
import com.obsqura.rmart_supermarketPages.ManageProductPage;

public class ManageProductPageTest extends Base {
	public HomePage homepage;
	public ManageProductPage manageproduct;

	@Test
	public void verifyUserCanSeachProduct() throws Exception {
		LoginPage loginpage = new LoginPage(driver);
		String username = ExcelUtility.readString(1, 0, "ManageProductPage");
		String password = ExcelUtility.readString(1, 1, "ManageProductPage");
		loginpage.enterUsernameAndPassword(username, password);
		homepage=loginpage.clickSignin();
		manageproduct=homepage.clickManageProduct();
		String title = ExcelUtility.readString(1, 2, "ManageProductPage");
		String productcode = ExcelUtility.readString(1, 3, "ManageProductPage");
		String category = ExcelUtility.readString(1, 4, "ManageProductPage");
		String subcategory = ExcelUtility.readString(1, 5, "ManageProductPage");
		manageproduct.clickSearchButton().enterTitleAndProductCode(title, productcode).enterCategoryField(category).enterSubCategoryField(subcategory).clickSearch();
		
		boolean value=manageproduct.isDisplayed();
		Assert.assertTrue(value, Constant.ERRORMESSAGEFORSEARCHINGPRODUCT);
	}
}
