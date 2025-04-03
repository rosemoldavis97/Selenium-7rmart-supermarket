package com.obsqura.rmart_supermarket.Testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.rmart.constant.Constant;
import com.obsqura.rmart.utilities.ExcelUtility;
import com.obsqura.rmart_supermarketPages.HomePage;
import com.obsqura.rmart_supermarketPages.LoginPage;
import com.obsqura.rmart_supermarketPages.ManageNewsPage;

public class ManageNewsPageTest extends Base {
	public HomePage homepage;
	public ManageNewsPage managenewspage;

	@Test
	public void verifyUserCanEnterTheNewsInformation() throws Exception {
		LoginPage loginpage = new LoginPage(driver);
		String username = ExcelUtility.readString(1, 0, "ManageNewsPage");
		String password = ExcelUtility.readString(1, 1, "ManageNewsPage");
		loginpage.enterUsernameAndPassword(username, password);
		homepage = loginpage.clickSignin();
		managenewspage = homepage.clickManageNews();
		String news = ExcelUtility.readString(1, 2, "ManageNewsPage");
		managenewspage.clickNewButton().enterTheNews(news).clickSaveButton();

		boolean expected = managenewspage.isAlertMessageShownSuccess();
		Assert.assertTrue(expected, Constant.ERRORMESSAGEFORUSERCANCREATENEWS);
	}
}
