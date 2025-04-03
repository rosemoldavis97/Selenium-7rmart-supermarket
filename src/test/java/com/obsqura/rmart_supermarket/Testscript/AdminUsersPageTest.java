package com.obsqura.rmart_supermarket.Testscript;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.obsqura.rmart.constant.Constant;
import com.obsqura.rmart.utilities.ExcelUtility;
import com.obsqura.rmart.utilities.FakerUtility;
import com.obsqura.rmart_supermarketPages.AdminUsersPage;
import com.obsqura.rmart_supermarketPages.HomePage;
import com.obsqura.rmart_supermarketPages.LoginPage;

public class AdminUsersPageTest extends Base {
	public HomePage homepage;
	public AdminUsersPage adminpage;
	FakerUtility fakerutility=new FakerUtility();

	@Test
	public void verifyUserCanCreateNewAdminUser() throws Exception {
		LoginPage loginpage = new LoginPage(driver);
		String username=ExcelUtility.readString(1, 0, "AdminUsersPage");
		String password=ExcelUtility.readString(1, 1, "AdminUsersPage");	
		loginpage.enterUsernameAndPassword(username,password);
		homepage = loginpage.clickSignin();
		adminpage = homepage.clickUsersMoreInfo();
		String usernam=fakerutility.getFakeFirstName();
		String password1=ExcelUtility.readString(1, 3, "AdminUsersPage");
		adminpage.clickNewField().enterUserInfo(usernam,password1,2).clickSaveButton();

		boolean expValue = adminpage.checkSuccessAlert();
		System.out.println(expValue);
		Assert.assertTrue(expValue, Constant.ERRORMESSAGEFORCREATINGNEWADMINUSER);
	}

	@Test
	public void creatingExistingAdminUser() throws Exception {
		LoginPage loginpage = new LoginPage(driver);
		String username=ExcelUtility.readString(2, 0, "AdminUsersPage");
		String password=ExcelUtility.readString(2, 1, "AdminUsersPage");	
		loginpage.enterUsernameAndPassword(username,password);
		homepage = loginpage.clickSignin();
		adminpage = homepage.clickUsersMoreInfo();
		String username1=ExcelUtility.readString(2, 2, "AdminUsersPage");
		String password1=ExcelUtility.readString(2, 3, "AdminUsersPage");	
		adminpage.clickNewField().enterUserInfo(username1,password1,2).clickSaveButton();

		boolean expValue = adminpage.checkAreadyExistAlert();
		System.out.println(expValue);
		Assert.assertTrue(expValue,Constant.ERRORMESSAGEFORCREATINGEXISTINGADMINUSER);
	}
	
	@Test
	
	public void verifyUserCanDeleteFirstAdminUser() throws Exception {
		LoginPage loginpage = new LoginPage(driver);
		String username=ExcelUtility.readString(3, 0, "AdminUsersPage");
		String password=ExcelUtility.readString(3, 1, "AdminUsersPage");	
		loginpage.enterUsernameAndPassword(username,password);
		homepage = loginpage.clickSignin();
		adminpage = homepage.clickUsersMoreInfo();
		adminpage.clickDeleteButton();
		
		boolean expValue = adminpage.checkSuccessAlert();
		Assert.assertTrue(expValue, Constant.ERRORMESSAGEFORDELETINGFIRSTADMINUSER);
		
	}
	@Test
	public void verifyUserCanSearchExistingAdminUsers() throws Exception {
		LoginPage loginpage = new LoginPage(driver);
		String username=ExcelUtility.readString(4, 0, "AdminUsersPage");
		String password=ExcelUtility.readString(4, 1, "AdminUsersPage");	
		loginpage.enterUsernameAndPassword(username,password);
		homepage = loginpage.clickSignin();
		adminpage = homepage.clickUsersMoreInfo();
		String username1=ExcelUtility.readString(4, 5, "AdminUsersPage");
		String usertype=ExcelUtility.readString(4, 6, "AdminUsersPage");
		adminpage.clickSearchButton().enterUsernameSearch(username1).enterUserTypeSearch(usertype).clickFinalSearch();
		
		boolean value=adminpage.isValueDisplayed();
		Assert.assertTrue(value, Constant.ERRORMESSAGEFORSEARCHINGEXISTINGADMIN);
	}
	
}
