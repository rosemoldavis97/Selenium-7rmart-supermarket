package com.obsqura.rmart_supermarket.Testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.rmart.constant.Constant;
import com.obsqura.rmart.utilities.ExcelUtility;
import com.obsqura.rmart.utilities.FakerUtility;
import com.obsqura.rmart_supermarketPages.HomePage;
import com.obsqura.rmart_supermarketPages.LoginPage;
import com.obsqura.rmart_supermarketPages.SubCategoryPage;

public class SubCategoryPageTest extends Base {
	public HomePage homepage;
	public SubCategoryPage subcategorypage;
	FakerUtility fakerutility=new FakerUtility();

	@Test
	public void verifyUserCanAddSubCategory() throws Exception {
		LoginPage loginpage = new LoginPage(driver);
		String username=ExcelUtility.readString(1, 0, "SubCategoryPage");
		String password=ExcelUtility.readString(1, 1, "SubCategoryPage");	
		loginpage.enterUsernameAndPassword(username,password);
		homepage = loginpage.clickSignin();
		subcategorypage = homepage.clickSubCategory();
		String category=ExcelUtility.readString(1, 2, "SubCategoryPage");
		String subcategory=ExcelUtility.readString(1, 3, "SubCategoryPage");
		//String subcategory=fakerutility.getMaterial();
		subcategorypage.clickNewButton().enterSubCategoryInformation(category, subcategory).clickSaveButton();

		boolean expected = subcategorypage.isAlertMessageShownSuccess();
		Assert.assertTrue(expected, Constant.ERRORMESSAGEFORCREATINGSUBCATEGORY);
	}
}
