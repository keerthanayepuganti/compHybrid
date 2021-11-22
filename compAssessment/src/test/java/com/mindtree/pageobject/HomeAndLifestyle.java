package com.mindtree.pageobject;


import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mindtree.reusablecomponents.ReadPropertyFile;
import com.mindtree.uistore.HomeLifestyleDetails;
import com.mindtree.utilities.ExtentReporterNG;

public class HomeAndLifestyle extends ReadPropertyFile {
	Logger log = Logger.getLogger(getClass());

	@BeforeTest
	public void initialise() throws IOException {

		driver = DriverInitialisation();
		
	}

	@Test
	public void HomeAndLifestyleHover() throws InterruptedException {
		ExtentReporterNG er=new ExtentReporterNG(driver);
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		Thread.sleep(3000);
		log.info("navigation to url");
		er.startTest("navigation to url");
		HomeLifestyleDetails h = new HomeLifestyleDetails(driver);
		Actions action = new Actions(driver);

		action.moveToElement(h.getHomeandLifestyle()).perform();
		h.getLamps().click();
		er.endTest();
	}

	@AfterTest
	public void close() {

		driver.quit();

	}

}
