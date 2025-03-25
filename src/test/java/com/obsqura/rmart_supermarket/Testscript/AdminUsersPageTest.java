package com.obsqura.rmart_supermarket.Testscript;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.obsqura.rmart.constant.Constant;
import com.obsqura.rmart_supermarketPages.AdminUsersPage;
import com.obsqura.rmart_supermarketPages.HomePage;
import com.obsqura.rmart_supermarketPages.LoginPage;

public class AdminUsersPageTest extends Base {
	public HomePage homepage;
	public AdminUsersPage adminpage;

	@Test
	public void verifyUserCanCreateNewAdminUser() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameAndPassword("admin", "admin");
		homepage = loginpage.clickSignin();
		adminpage = homepage.clickUsersMoreInfo();
		adminpage.clickNewField().enterUserInfo("rosemowgh", "12345hi", 3).clickSaveButton();

		boolean expValue = adminpage.checkSuccessAlert();
		System.out.println(expValue);
		Assert.assertTrue(expValue, Constant.ERRORMESSAGEFORCREATINGNEWADMINUSER);
	}

	@Test
	public void creatingExistingAdminUser() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameAndPassword("admin", "admin");
		homepage = loginpage.clickSignin();
		adminpage = homepage.clickUsersMoreInfo();
		adminpage.clickNewField().enterUserInfo("rosemowgh", "12345hi", 3).clickSaveButton();

		boolean expValue = adminpage.checkAreadyExistAlert();
		System.out.println(expValue);
		Assert.assertTrue(expValue,Constant.ERRORMESSAGEFORCREATINGEXISTINGADMINUSER);
	}
}
