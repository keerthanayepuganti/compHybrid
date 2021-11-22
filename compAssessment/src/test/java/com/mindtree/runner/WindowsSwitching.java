package com.mindtree.runner;

import java.io.IOException;
import java.util.Set;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.mindtree.reusablecomponents.ReadPropertyFile;

public class WindowsSwitching extends ReadPropertyFile {

	public static Logger log = Logger.getLogger(ReadPropertyFile.class.getName());

	@BeforeTest
	public void initialise() throws IOException {

		driver = DriverInitialisation();
	}

	@Test
	public void windowtest() throws InterruptedException {

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		Thread.sleep(3000);
		log.info("navigation to url");

		WebElement columnfooter = driver
				.findElement(By.xpath("//*[@id='shopify-section-footer']/footer[1]/div[1]/div[2]/div[1]"));
		int n = columnfooter.findElements(By.tagName("a")).size();
		System.out.println(n);

		for (int i = 0; i < n; i++) {
			String clickonlink = Keys.chord(Keys.CONTROL, Keys.ENTER);
			columnfooter.findElements(By.tagName("a")).get(i).sendKeys(clickonlink);
			Thread.sleep(5000L);
		}

		// switching to the windows and printing the tittle of each window
		Set<String> abc = driver.getWindowHandles();
		java.util.Iterator<String> it = abc.iterator();

		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
			System.setProperty("webdriver.chrome.driver", "//chrome path in system//");
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("excludeSwitches", "disable-popup-blocking");
			driver.close();
		}
		// popup
		System.setProperty("webdriver.chrome.driver", "//chrome path in system//");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", "disable-popup-blocking");

	}

	/*
	 * @AfterTest public void close() {
	 * 
	 * driver.close(); driver = null;
	 * 
	 * }
	 */

}
