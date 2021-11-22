package com.mindtree.uistore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CorporateGiftDetails {
	public WebDriver driver;
	By corporate = By.xpath("//*[@id='myheader']/div[1]/div/div/ul/li[1]/a");
	By fullName = By.id("contactFormName");
	By email = By.id("contactFormEmail");
	By phone = By.id("contactFormPhone");
	By desc = By.id("contactFormMessage");
	By submit = By.xpath("//*[@id='contactFormWrapper']/div/input[4]");

	public CorporateGiftDetails(WebDriver driver) {

		this.driver = driver;

	}

	public WebElement getCorporate() {

		return driver.findElement(corporate);

	}

	public WebElement getFullName() {

		return driver.findElement(fullName);

	}

	public WebElement getEmail() {

		return driver.findElement(email);

	}

	public WebElement getPhone() {

		return driver.findElement(phone);

	}

	public WebElement getDesc() {

		return driver.findElement(desc);

	}

	public WebElement getSubmit() {

		return driver.findElement(submit);

	}

}
