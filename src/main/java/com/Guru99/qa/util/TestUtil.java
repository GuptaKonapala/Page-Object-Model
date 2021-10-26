package com.Guru99.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Guru99.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_TIMEOUT = 40;
	public static String filepath = "E:\\Java_Selenium\\Guru99\\src\\main\\java\\com\\Guru99\\qa\\testdata\\TestData2.xlsx";
	public static Workbook book;
	public static Sheet sheet;
	
	public static Object[][] getTestData(String sheetname) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			try {
				book = WorkbookFactory.create(file);
			} catch (InvalidFormatException e) {
				e.printStackTrace();
			}
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetname);
		Object [][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			System.out.println(data.length);
		for (int i = 0; i<sheet.getLastRowNum(); i++) {
			for(int k = 0; k<sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
	}
	
	public static void flash(WebElement element, WebDriver driver, String color) {
		String bgcolor = element.getCssValue("backgroundColor");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		for(int i = 0; i<10; i++) {
			js.executeScript("arguments[0].style.backgroundColor = ' "+color+" ' " , element);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			js.executeScript("arguments[0].style.backgroundColor = ' "+bgcolor+" ' " , element);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
}

	public static String takeScreenshotAtEndOfTest() {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		String destination=  currentDir+"/screenshots/"+"test_"+System.currentTimeMillis()+".png";
		
		File path = new File(destination);
		try {
			FileUtils.copyFile(src, path );
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destination;
	}	
}
