package com.mindtree.pageobject;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.mindtree.reusablecomponents.ReadPropertyFile;
import com.mindtree.uistore.CorporateGiftDetails;
import com.mindtree.utilities.ExtentReporterNG;

public class CorporateGifts extends ReadPropertyFile {
	public static Logger log = Logger.getLogger(ReadPropertyFile.class.getName());

	@BeforeTest
	public void initialise() throws IOException {

		driver = DriverInitialisation();
	}

	@Test
	public void PersonalizedGift() throws InterruptedException {
		ExtentReporterNG er=new ExtentReporterNG(driver);
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		Thread.sleep(3000);
		log.info("navigation to url");
		er.startTest("navigation to url ");
		CorporateGiftDetails c = new CorporateGiftDetails(driver);
		c.getCorporate().click();
		c.getFullName().sendKeys("Keerthana Yepuganti");
		c.getEmail().sendKeys("Keerthananaidu1415@gmail.com");
		c.getPhone().sendKeys("9182994822");
		c.getDesc().sendKeys("this is description");
		c.getSubmit().click();
		log.info("Submitted successfully");
		er.endTest();
	}

	@AfterTest
	public void close() {

		driver.quit();

	}

}