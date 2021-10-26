package com.Guru99.qa.testcases;



import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Guru99.qa.base.TestBase;
import com.Guru99.qa.pages.HomePage;

public class HomePageTest extends TestBase {
	
	HomePage homepage;
	SoftAssert  softassert;
	
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		intialization();
		homepage = new HomePage();
		softassert = new SoftAssert();
	}
	
	@Test
	public void verifyHomePageTitleTest() {
		String title = homepage.validateHomePageTitle();
		Assert.assertEquals(title, "Guru99 Bank Home Page");
	}
	@Test
	public void verifyLogoTest() {
		boolean logo = homepage.validateLogo();
		Assert.assertTrue(logo);
	}
	@Test
	public void verifyPageNameTest() {
		boolean pagename = homepage.validatePageName();
		Assert.assertTrue(pagename);
	}
	@Test
	public void verifySeleniumLinkTest() {
		boolean selenium = homepage.validateSeleniumLink();
		Assert.assertTrue(selenium);
	}
	@Test
	public void verifyFlashMovieDemoLinkTest() {
		String flashmoviedemo = homepage.validateFlashMovieDemoLink();
		Assert.assertEquals(flashmoviedemo, "Flash Movie Demo");
	}
	@Test
	public void verifyRadioDemoLinkTest() {
		String radiodemo = homepage.validateRadioDemoLink();
		Assert.assertEquals(radiodemo, "Radio Button & Check Bx Demo");
	}
	@Test
	@Parameters({"username", "password"})
	public void verifyLoginButtonTest(String user, String pass) {
		String login = homepage.validateLoginButton(user, pass);
		Assert.assertEquals(login, "Guru99 Bank Manager HomePage");
	}
	@Test
	public void verifySignupLinkTest() {
		String signup = homepage.validateSignupLink();
		Assert.assertEquals(signup, "Guru99 Bank Hme Page");
	}
	@Test
	public void verifyResetButtonTest() {
		String reset = homepage.validateResetButton();
		softassert.assertEquals(reset, "");																		//				intentionally fail
		System.out.println("hey moms");																				//				softassert is used to execute the script after the testcase is failed
		softassert.assertAll();																									//				softassert
	}

}
