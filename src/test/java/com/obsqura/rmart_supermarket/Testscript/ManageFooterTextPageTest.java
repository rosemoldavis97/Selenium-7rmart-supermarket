package com.obsqura.rmart_supermarket.Testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.rmart.constant.Constant;
import com.obsqura.rmart.utilities.ExcelUtility;
import com.obsqura.rmart_supermarketPages.HomePage;
import com.obsqura.rmart_supermarketPages.LoginPage;
import com.obsqura.rmart_supermarketPages.ManageFooterTextPage;

public class ManageFooterTextPageTest extends Base {
	public HomePage homepage;
	public ManageFooterTextPage managefooter;

	@Test
	public void verifyUserCanEditFooterTextInformation() throws Exception {
		LoginPage loginpage = new LoginPage(driver);
		String username = ExcelUtility.readString(1, 0, "ManageFooterTextPage");
		String password = ExcelUtility.readString(1, 1, "ManageFooterTextPage");
		loginpage.enterUsernameAndPassword(username, password);
		homepage = loginpage.clickSignin();
		managefooter = homepage.clickManageFooterText();
		String address = ExcelUtility.readString(1, 2, "ManageFooterTextPage");
		String email = ExcelUtility.readString(1, 3, "ManageFooterTextPage");
		String phone = ExcelUtility.readNumber(1, 4, "ManageFooterTextPage");
		managefooter.clickEditButton().enterFooterTextInformations(address, email, phone).clickUpdateButton();

		boolean value = managefooter.isDisplayed();
		Assert.assertTrue(value, Constant.ERRORMESSAGEFOREDITINGFOOTERTEXT);

	}
}
