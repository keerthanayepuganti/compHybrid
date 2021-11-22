package com.mindtree.uistore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Top50Details {
	public WebDriver driver;

	By Pgifts = By.xpath("//*[@id=\"myheader\"]/div[1]/div/div/ul/li[6]/a");
	By features = By.id("sortBy");
	By best = By.xpath("//*[@id=\'sortBy\']/option[3]");
	By book = By.xpath("//*[@id=\"CollectionAjaxContent\"]/div[1]/div[1]/div/a/div[2]/div[1]");

	public Top50Details(WebDriver driver) {

		this.driver = driver;

	}

	public WebElement getPgifts() {

		return driver.findElement(Pgifts);

	}

	public WebElement getFeatures() {

		return driver.findElement(features);

	}

	public WebElement getBest() {

		return driver.findElement(best);

	}

	public WebElement getBook() {

		return driver.findElement(book);

	}

}
