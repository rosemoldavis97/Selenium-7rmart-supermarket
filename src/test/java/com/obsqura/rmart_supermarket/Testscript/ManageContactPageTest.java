package com.obsqura.rmart_supermarket.Testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.rmart.constant.Constant;
import com.obsqura.rmart.utilities.ExcelUtility;
import com.obsqura.rmart.utilities.FakerUtility;
import com.obsqura.rmart_supermarketPages.HomePage;
import com.obsqura.rmart_supermarketPages.LoginPage;
import com.obsqura.rmart_supermarketPages.ManageContactPage;

public class ManageContactPageTest extends Base {
	public HomePage homepage;
	public ManageContactPage managecontact;
	FakerUtility fakerutility=new FakerUtility();

	@Test
  public void verifyUserCanEditContactDetails() throws Exception {
	  LoginPage loginpage=new LoginPage(driver);
	  String username=ExcelUtility.readString(1, 0, "ManageContactPage");
	  String password=ExcelUtility.readString(1, 1, "ManageContactPage");	
	  loginpage.enterUsernameAndPassword(username, password);
	  homepage=loginpage.clickSignin();
	  managecontact=homepage.clickManageContact();
	  String phone=fakerutility.getPhoneNumber();
	  //String phone=ExcelUtility.readNumber(1, 2, "ManageContactPage");
	  String email=ExcelUtility.readString(1, 3, "ManageContactPage");
	  String address=ExcelUtility.readString(1, 4, "ManageContactPage");
	  String delTime=ExcelUtility.readNumber(1, 5, "ManageContactPage");
	  String delCharge=ExcelUtility.readNumber(1, 6, "ManageContactPage");
	  managecontact.clickEditButton().enterPhoneno(phone).enterEmail(email).enterAddress(address).enterDeliveryTime(delTime).enterDeliveryChargeLimit(delCharge).clickUpdateButton();
	  
	  boolean value=managecontact.isValueDisplayed();
	  Assert.assertTrue(value, Constant.ERRORMESSAGEFOREDITINGCONTACTS);
	  
  }
}
