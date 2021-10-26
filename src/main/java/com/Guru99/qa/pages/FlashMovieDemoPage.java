package com.Guru99.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Guru99.qa.base.TestBase;

public class FlashMovieDemoPage extends TestBase {
	
	@FindBy(xpath = "//font[contains(text(),'DEMO Flash Movie')]")
	WebElement heading;
	
	public FlashMovieDemoPage() {
		PageFactory.initElements(driver, this);
	}
	public boolean validateHeading() {
		return heading.isDisplayed();
	}

}
