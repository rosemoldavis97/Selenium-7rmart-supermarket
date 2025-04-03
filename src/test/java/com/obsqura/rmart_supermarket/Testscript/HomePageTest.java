package com.obsqura.rmart_supermarket.Testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.rmart.constant.Constant;
import com.obsqura.rmart.utilities.ExcelUtility;
import com.obsqura.rmart_supermarketPages.HomePage;
import com.obsqura.rmart_supermarketPages.LoginPage;

public class HomePageTest extends Base {
	public HomePage homepage;

	@Test
	public void verifyUserCanLogout() throws Exception {
		LoginPage loginpage = new LoginPage(driver);
		String username = ExcelUtility.readString(1, 0, "HomePage");
		String password = ExcelUtility.readString(1, 1, "HomePage");
		loginpage.enterUsernameAndPassword(username, password);
		homepage = loginpage.clickSignin();
		homepage.clickAdmin().clickLogout();

		String expected = "Login | 7rmart supermarket";
		String actual = driver.getTitle();
		System.out.println(actual);
		Assert.assertEquals(expected, actual, Constant.ERRORMESSAGEFORLOGOUT);

	}
}
