package com.mindtree.pageobject;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mindtree.reusablecomponents.ReadPropertyFile;
import com.mindtree.uistore.TrackOrderDetails;
import com.mindtree.utilities.ExtentReporterNG;

public class TrackOrderPage extends ReadPropertyFile {

	public static Logger log = Logger.getLogger(ReadPropertyFile.class.getName());

	@BeforeTest
	public void initialise() throws IOException {

		driver = DriverInitialisation();
	}

	@Test
	public void logintest() throws InterruptedException {
		ExtentReporterNG er=new ExtentReporterNG(driver);
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		log.info("navigation to url");
		er.startTest("navigation to url");
		TrackOrderDetails td = new TrackOrderDetails(driver);
		td.getTrackOrder().sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));

		Set<String> ab = driver.getWindowHandles();
		Iterator<String> it = ab.iterator();
		String parentId = it.next();
		String childid = it.next();
		driver.switchTo().window(childid);

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\keert\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", "disable-popup-blocking");

		td.getEmail().sendKeys("Keerthananaidu1415@gmail.com");
		td.getOrderId().sendKeys("4136972");
		td.getFind().click();
        er.endTest();
	}

	@AfterTest
	public void close() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\keert\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", "disable-popup-blocking");

		driver.close();
		driver = null;

	}

}
