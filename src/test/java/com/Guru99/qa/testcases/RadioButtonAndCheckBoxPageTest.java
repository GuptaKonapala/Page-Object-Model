package com.Guru99.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Guru99.qa.base.TestBase;
import com.Guru99.qa.pages.HomePage;
import com.Guru99.qa.pages.RadioDemoPage;

public class RadioButtonAndCheckBoxPageTest extends TestBase {
	
	HomePage homepage;
	RadioDemoPage radioandcheckbox;
	
	public RadioButtonAndCheckBoxPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		intialization();
		homepage = new HomePage();
		radioandcheckbox = new RadioDemoPage();
		homepage.validateRadioDemoLink();
	}
	
	@Test
	public void verifyRadioButtonTest() {
		boolean radio = radioandcheckbox.validateRadioButton();
		Assert.assertTrue(radio);
	}
	@Test
	public void verifyCheckBoxTest() {
		boolean checkbox = radioandcheckbox.validateCheckBox();
		Assert.assertTrue(checkbox);
	}
	

}
