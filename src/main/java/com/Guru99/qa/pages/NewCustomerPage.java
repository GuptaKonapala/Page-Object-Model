package com.Guru99.qa.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Guru99.qa.base.TestBase;

public class NewCustomerPage extends TestBase {
	
	@FindBy(name = "name")
	WebElement customername;
	
	@FindBy(xpath = "//input[@name='dob']")
	WebElement dat;
	
	@FindBy(name ="addr")
	WebElement addres;
	
	@FindBy(name = "city")
	WebElement cit;
	
	@FindBy(name = "state")
	WebElement stat;
	
	@FindBy(name = "pinno")
	WebElement pincode;
	
	@FindBy(name = "telephoneno")
	WebElement telephone;
	
	@FindBy(name = "emailid")
	WebElement email;
	
	@FindBy(name = "password")
	WebElement passcode;
	
	@FindBy(name = "sub")
	WebElement submit;
	
	public NewCustomerPage() {
		PageFactory.initElements(driver, this);
	}
	public String  validateNewCustomerPageTitle() {
	return	driver.getTitle();
	}
	
	public void gende(String gen) {
		List<WebElement> radio = driver.findElements(By.xpath("//input[@type='radio']"));
		Iterator<WebElement> it = radio.iterator();
		while(it.hasNext()) {
			WebElement btn = it.next();
			 if ( btn.getAttribute("value").equalsIgnoreCase(gen))
			 {
				 btn.click();
				 break;
			 }
		}
	}
	
	public void validateNewCustomerPage(String cname, String gender, String date, String address, String city, String state, String pin, String phone, String mail, String password) {
		customername.sendKeys(cname);
		gende(gender);
		dat.sendKeys(date);
		addres.sendKeys(address);
		cit.sendKeys(city);
		stat.sendKeys(state);
		pincode.sendKeys(pin);
		telephone.sendKeys(phone);
		email.sendKeys(mail);
		passcode.sendKeys(password);
		submit.click();
	}
	

}
