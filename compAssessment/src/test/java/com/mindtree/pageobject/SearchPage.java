package com.mindtree.pageobject;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mindtree.reusablecomponents.ReadPropertyFile;
import com.mindtree.uistore.SearchPageDetails;
import com.mindtree.utilities.ExtentReporterNG;

public class SearchPage extends ReadPropertyFile {

	public static Logger log = Logger.getLogger(ReadPropertyFile.class.getName());

	@BeforeTest
	public void initialise() throws IOException {

		driver = DriverInitialisation();
	}

	@Test
	public void SearchBar() throws InterruptedException {
		ExtentReporterNG er=new ExtentReporterNG(driver);
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		Thread.sleep(3000);
		log.info("navigation to url");
		er.startTest("navigation to url");
		SearchPageDetails s = new SearchPageDetails(driver);
		s.getSearch().sendKeys("harry potter gifts");
		s.getHarry().click();

		Assert.assertEquals(s.getImage().getText(), "Harry Potter Plush Soft Toy");
		er.endTest();
	}

	@AfterTest
	public void close() {

		driver.quit();

	}
}
