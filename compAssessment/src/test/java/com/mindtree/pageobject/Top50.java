package com.mindtree.pageobject;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mindtree.reusablecomponents.ReadPropertyFile;
import com.mindtree.uistore.Top50Details;
import com.mindtree.utilities.ExtentReporterNG;

public class Top50 extends ReadPropertyFile {
	public static Logger log = Logger.getLogger(ReadPropertyFile.class.getName());

	@BeforeTest
	public void initialise() throws IOException {

		driver = DriverInitialisation();
	}

	@Test
	public void Top50() throws InterruptedException {
		ExtentReporterNG er=new ExtentReporterNG(driver);
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		Thread.sleep(3000);
		log.info("navigation to url");
		er.startTest("navigation to url");
		Top50Details t = new Top50Details(driver);
		t.getPgifts().click();
		t.getFeatures().click();
		t.getBest().click();

		Assert.assertEquals(t.getBook().getText(), "Scratch World Map");
		log.info("Assertion passed");
		er.endTest();
	}

	@AfterTest
	public void close() {

		driver.quit();

	}

}