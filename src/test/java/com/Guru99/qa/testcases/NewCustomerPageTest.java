package com.Guru99.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Guru99.qa.base.TestBase;
import com.Guru99.qa.pages.HomePage;
import com.Guru99.qa.pages.LoginPage;
import com.Guru99.qa.pages.NewCustomerPage;
import com.Guru99.qa.util.TestUtil;

public class NewCustomerPageTest extends TestBase {
	
	HomePage homepage;
	LoginPage loginpage;
	NewCustomerPage newcustomer;
	
	public NewCustomerPageTest() {
		super();
	}
	
	@BeforeMethod()
	public void setup() {
		intialization();
		homepage = new HomePage();
		loginpage = new LoginPage();
		newcustomer = new NewCustomerPage();
		homepage.validateLoginButton(prop.getProperty("username"), prop.getProperty("password"));
		loginpage.validateNewCustomerLink();
	}
	@Test
	public void verifyNewCustomerPageTitleTest() {
		String title = newcustomer.validateNewCustomerPageTitle();
		Assert.assertEquals(title, "Guru99 Bank New Customer Entry Page");	
		}
	@DataProvider
	public Object[][] getTestData() {
		return TestUtil.getTestData("Sheet1");
	}
	@Test(dataProvider = "getTestData")
	public void verifyNewCustomerPageTest(String name, String gender, String date, String address, String city, String state, String pin, String phone, String mail, String password) {
		newcustomer.validateNewCustomerPage(name, gender, date, address, city, state, pin, phone, mail, password);
	}

}
