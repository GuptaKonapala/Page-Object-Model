package com.Guru99.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Guru99.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(linkText = "New Customer")
	WebElement newcustomer;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	public NewCustomerPage validateNewCustomerLink() {
		 newcustomer.click();
		 return new NewCustomerPage();
	}
	
}
