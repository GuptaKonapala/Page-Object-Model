package com.Guru99.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Guru99.qa.base.TestBase;
import com.Guru99.qa.pages.HomePage;
import com.Guru99.qa.pages.LoginPage;
import com.Guru99.qa.pages.NewCustomerPage;

public class LoginPageTest extends TestBase {

	HomePage homepage;
	LoginPage loginpage;
	NewCustomerPage addcustomer;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		intialization();
		homepage = new HomePage();
		loginpage = new LoginPage();
		homepage.validateLoginButton(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void verifyNewCustomerLinkTest() {
		addcustomer = loginpage.validateNewCustomerLink();
		Assert.assertEquals(addcustomer.validateNewCustomerPageTitle(), "Guru99 Bank New Customer Entry Page");
	}
}
