package com.mindtree.pageobject;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mindtree.reusablecomponents.ReadPropertyFile;
import com.mindtree.uistore.GiftsPageDetails;
import com.mindtree.utilities.ExtentReporterNG;

public class Gifts extends ReadPropertyFile {
	Logger log = Logger.getLogger(getClass());
	
	@BeforeTest
	public void initialise() throws IOException {

		driver = DriverInitialisation();
		
	}

	@Test
	public void GiftHover() throws InterruptedException {
		ExtentReporterNG er=new ExtentReporterNG(driver);
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		Thread.sleep(3000);
		log.info("navigation to url");
		er.startTest("navigation to url");
		GiftsPageDetails g = new GiftsPageDetails(driver);
		Actions action = new Actions(driver);
 
		action.moveToElement(g.getGifts()).perform();
		g.getBaby().click();
		er.endTest();
	}

	@AfterTest
	public void close() {

		driver.quit();

	}

}
