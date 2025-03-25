package com.obsqura.rmart_supermarket.Testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.rmart.constant.Constant;
import com.obsqura.rmart_supermarketPages.HomePage;
import com.obsqura.rmart_supermarketPages.LoginPage;

public class HomePageTest extends Base {
	public HomePage homepage;

	@Test
	public void verifyUserCanLogout() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameAndPassword("admin", "admin");
		homepage = loginpage.clickSignin();
		homepage.clickAdmin().clickLogout();

		String expected = "Login | 7rmart supermarket";
		String actual = driver.getTitle();
		System.out.println(actual);
		Assert.assertEquals(expected, actual, Constant.ERRORMESSAGEFORLOGOUT);

	}
}
