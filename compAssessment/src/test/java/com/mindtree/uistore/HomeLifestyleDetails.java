package com.mindtree.uistore;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;

	public class HomeLifestyleDetails {
		public WebDriver driver;

		By homelifestyle = By.xpath("//*[@id=\"myheader\"]/div[1]/div/div/ul/li[11]/a");
		By lamps = By.xpath("//*[@id=\"myheader\"]/div[1]/div/div/ul/li[11]/ul/li[3]/a");

		public HomeLifestyleDetails(WebDriver driver) {

			this.driver = driver;

		}

		public WebElement getHomeandLifestyle() {
			// TODO Auto-generated method stub
			return driver.findElement(homelifestyle);

		}

		public WebElement getLamps() {
			// TODO Auto-generated method stub
			return driver.findElement(lamps);

		}

	}
	