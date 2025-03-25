package com.obsqura.rmart_supermarket.Testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.rmart.constant.Constant;
import com.obsqura.rmart_supermarketPages.HomePage;
import com.obsqura.rmart_supermarketPages.LoginPage;
import com.obsqura.rmart_supermarketPages.ManageNewsPage;

public class ManageNewsPageTest extends Base {
	public HomePage homepage;
	public ManageNewsPage managenewspage;

	@Test
	public void verifyUserCanEnterTheNewsInformation() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameAndPassword("admin", "admin");
		homepage = loginpage.clickSignin();
		managenewspage = homepage.clickManageNews();
		managenewspage.clickNewButton().enterTheNews("20% discount for fruits").clickSaveButton();

		boolean expected = managenewspage.isAlertMessageShownSuccess();
		Assert.assertTrue(expected, Constant.ERRORMESSAGEFORUSERCANCREATENEWS);
	}
}
