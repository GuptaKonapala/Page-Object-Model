package com.Guru99.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Guru99.qa.base.TestBase;

public class RadioDemoPage extends TestBase {
	
	@FindBy(xpath = "//input[@id='vfb-7-1']")
	WebElement radiobtn;
	
	@FindBy(xpath = "//input[@id='vfb-6-1']")
	WebElement checkbox;
	
	public RadioDemoPage() {
		PageFactory.initElements(driver, this);
	}
	public boolean validateRadioButton() {
		radiobtn.click();
		return radiobtn.isSelected();
	}
	public boolean validateCheckBox() {
		checkbox.click();
		return checkbox.isSelected();
	}

}
