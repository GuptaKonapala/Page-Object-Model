package com.Guru99.qa.extentReportListener;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Guru99.qa.util.TestUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportListener {

	ExtentReports extent;
	ExtentSparkReporter spark;
	ExtentTest test;
	
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
	
	@Test
	public void test() {
	test = extent.createTest("verifyManager3");
				test.info("Verifying login manger title");
	}
	
	@AfterTest
	public void endReport() {
		extent.flush();

	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
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
	}
}
