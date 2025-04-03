package com.obsqura.rmart_supermarket.Testscript;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.obsqura.rmart.constant.Constant;
import com.obsqura.rmart.utilities.ExcelUtility;
import com.obsqura.rmart_supermarketPages.HomePage;
import com.obsqura.rmart_supermarketPages.LoginPage;

public class LoginPageTest extends Base {
	public HomePage homepage;

	@Test
	public void validUsernameAndPassword() throws Exception {
		LoginPage loginpage = new LoginPage(driver);
		String username=ExcelUtility.readString(1, 0, "LoginPage");
		String password=ExcelUtility.readString(1, 1, "LoginPage");	
		loginpage.enterUsernameAndPassword(username, password);
		homepage = loginpage.clickSignin();

		String expected = "Dashboard | 7rmart supermarket";
		String actual = driver.getTitle();
		System.out.println(actual);
		Assert.assertEquals(expected, actual,Constant.ERRORMESSAGEFORLOGIN);
	}

	@Test
	public void invalidUsernameAndValidPassword() throws Exception {
		LoginPage loginpage = new LoginPage(driver);
		String username=ExcelUtility.readString(2, 0, "LoginPage");
		String password=ExcelUtility.readString(2, 1, "LoginPage");	
		loginpage.enterUsernameAndPassword(username, password);
		homepage = loginpage.clickSignin();

		boolean isloginpage = loginpage.isMessageIsDisplayed();
		Assert.assertTrue(isloginpage, Constant.ERRORMESSAGEFORINVALIDLOGIN);
	}

	@Test
	@Parameters({ "username", "password" })
	public void validUsernameAndInvalidPassword(String username, String password) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameAndPassword(username, password);
		homepage = loginpage.clickSignin();

		boolean isloginpage = loginpage.isMessageIsDisplayed();
		Assert.assertTrue(isloginpage,Constant.ERRORMESSAGEFORINVALIDLOGIN);
	}

	@Test(dataProvider = "credentials")
	public void invalidUsernameAndInvalidPassword(String username, String password) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameAndPassword(username, password);
		homepage = loginpage.clickSignin();

		boolean isloginpage = loginpage.isMessageIsDisplayed();
		Assert.assertTrue(isloginpage,Constant.ERRORMESSAGEFORINVALIDLOGIN);
	}

	@DataProvider(name = "credentials")

	public Object[][] testData() {
		Object data[][] = { { "core", "123" }, { "abc", "89c" }, { "rose", "hdf" } };
		return data;

	}
}
