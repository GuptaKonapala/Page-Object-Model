package com.Guru99.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.Guru99.qa.base.TestBase;
import com.Guru99.qa.pages.FlashMovieDemoPage;
import com.Guru99.qa.pages.HomePage;

public class FlashMovieDemoPageTest extends TestBase {
	
	HomePage homepage;
	FlashMovieDemoPage flashmoviedemopage;
	
	public FlashMovieDemoPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		intialization();
		homepage = new HomePage();
		flashmoviedemopage = new FlashMovieDemoPage();
		homepage.validateFlashMovieDemoLink();
		
	}
	
	@Test
	public void verifyHeadingTest() {
		boolean heading = flashmoviedemopage.validateHeading();
		System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(heading);
	}
	


}
