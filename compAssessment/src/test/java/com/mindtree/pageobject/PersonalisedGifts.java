package com.mindtree.pageobject;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mindtree.reusablecomponents.ReadPropertyFile;
import com.mindtree.uistore.PersonalizedGiftDetails;
import com.mindtree.utilities.ExtentReporterNG;

public class PersonalisedGifts extends ReadPropertyFile {
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
		er.startTest("navigation to url");
		PersonalizedGiftDetails p = new PersonalizedGiftDetails(driver);
		p.getPgifts().click();
		p.getFeatures().click();
		p.getBest().click();

		Assert.assertEquals(p.getBook().getText(), "Personalized Moon Lamp - COD Not Available");
		log.info("Assertion passed");
		er.endTest();
	}

	@AfterTest
	public void close() {

		driver.quit();

	}

}