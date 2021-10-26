 package com.Guru99.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.Guru99.qa.util.TestUtil;
import com.Guru99.qa.util.WebEventListener;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventlistener;
	
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;
	
	@BeforeTest
	public void setExtentReport() {
		
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("reports/Spark.html");
		extent.attachReporter(spark);

		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Functional Testing");
		spark.config().setReportName("Automation Testing");

		extent.setSystemInfo("HostNmae", "Local");
		extent.setSystemInfo("Operating System", "Winodw 10");
		extent.setSystemInfo("Tester", "Sunny");
		extent.setSystemInfo("Browser", "Chrome");
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		test = extent.createTest(result.getName());
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "TEST CASE FAILED IS : " + result.getName());
			test.log(Status.FAIL, "TEST CASE FAILED WITH THE ASSERTION : " + result.getThrowable());
			test.log(Status.FAIL, "TEST CASE FAILED IN THE CLASS : " + result.getTestClass());
			
			test.addScreenCaptureFromPath(TestUtil.takeScreenshotAtEndOfTest());

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "TEST CASE PASSED IS : " + result.getName());
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "TEST CASE SKIIPED IS : " + result.getName());
		}
		driver.quit();
	}

	@AfterTest
	public void endReport() {
		extent.flush();

	}
	
	public TestBase() {
		prop = new Properties();
		FileInputStream ip;
		try {
			ip = new FileInputStream("E:\\Java_Selenium\\Guru99\\src\\main\\java\\com\\Guru99\\qa\\config\\config.properties");
			prop.load(ip);
		} 
		catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void intialization() {
	
	String browsername = prop.getProperty("browser");
	if(browsername.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	else if(browsername.equals("IE")) {
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
	}
	
	e_driver = new EventFiringWebDriver(driver);
	eventlistener = new WebEventListener();
	e_driver.register(eventlistener);
	driver = e_driver;
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get(prop.getProperty("url"));
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);	
	}
	}

