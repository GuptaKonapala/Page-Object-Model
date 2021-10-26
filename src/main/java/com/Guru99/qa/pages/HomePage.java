package com.Guru99.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Guru99.qa.base.TestBase;
import com.Guru99.qa.util.TestUtil;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//img[@alt='Guru99 Demo Sites']")
	WebElement logo;
	
	@FindBy(xpath = "//img[@alt='Guru99 Demo Sites']")
	WebElement pagename;
	
	@FindBy(xpath = "//a[contains(text(),'Selenium')]")
	WebElement selenium;
	
	@FindBy(xpath = "//a[contains(text(),'Flash Movie Demo')]")
	WebElement flashmoviedemo;
	
	@FindBy(xpath = "//a[contains(text(),'Radio & Checkbox Demo')]")
	WebElement radiodemo;
	
	@FindBy(name = "uid")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(name = "btnLogin")
	WebElement login;
	
	@FindBy(linkText = "here")
	WebElement signup;
	
	@FindBy(xpath = "//input[@name='btnReset']")
	WebElement reset;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	public boolean validateLogo() {
		TestUtil.flash(logo, driver, "red");
		return logo.isDisplayed();
	}
	public boolean validatePageName() {
		return pagename.isDisplayed();
	}
	public boolean validateSeleniumLink() {
		selenium.click();
		return flashmoviedemo.isDisplayed();
	}
	public String  validateFlashMovieDemoLink() {
		selenium.click();
		flashmoviedemo.click();
		return driver.getTitle();
	}
	public String validateRadioDemoLink() {
		selenium.click();
		radiodemo.click();
		return driver.getTitle();
	}
	public String validateLoginButton(String un, String pw) {
		username.sendKeys(un);
		password.sendKeys(pw);
		login.click();
		return driver.getTitle();
	}
	public String validateSignupLink() {
		signup.click();
		return driver.getTitle();
	}
	public String validateResetButton() {
		username.sendKeys("un");
		password.sendKeys("pw");
		reset.click();
		return username.getText();
	}
}
