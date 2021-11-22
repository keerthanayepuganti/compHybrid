package com.mindtree.uistore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GiftsPageDetails {
	public WebDriver driver;

	By gift = By.xpath("//*[@id=\'myheader\']/div[1]/div/div/ul/li[7]");
	By baby = By.xpath("//*[@id=\'myheader\']/div[1]/div/div/ul/li[7]/ul/li[9]/a");

	public GiftsPageDetails(WebDriver driver) {

		this.driver = driver;

	}

	public WebElement getGifts() {
		// TODO Auto-generated method stub
		return driver.findElement(gift);

	}

	public WebElement getBaby() {
		// TODO Auto-generated method stub
		return driver.findElement(baby);

	}

}
