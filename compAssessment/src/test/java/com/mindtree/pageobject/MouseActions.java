package com.mindtree.pageobject;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mindtree.reusablecomponents.ReadPropertyFile;
import com.mindtree.uistore.MouseActionsDetails;
import com.mindtree.utilities.ExtentReporterNG;

public class MouseActions extends ReadPropertyFile {
	public static Logger log = Logger.getLogger(ReadPropertyFile.class.getName());

	@BeforeTest
	public void initialise() throws IOException {

		driver = DriverInitialisation();
	}

	@Test
	public void logintest() throws InterruptedException {
		MouseActionsDetails m = new MouseActionsDetails(driver);
		ExtentReporterNG er=new ExtentReporterNG(driver);
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		Thread.sleep(3000);
		log.info("navigation to url");
		er.startTest("navigation to url");
		m.getallofit().click();
		Thread.sleep(3000);
		Actions action = new Actions(driver);

		action.moveToElement(m.getimagemovment()).perform();
		Thread.sleep(10000);
		er.endTest();
	}

	@AfterTest
	public void close() {

		driver.close();
		driver = null;

	}
}
