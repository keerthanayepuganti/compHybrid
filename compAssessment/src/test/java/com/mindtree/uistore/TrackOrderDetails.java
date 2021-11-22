package com.mindtree.uistore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TrackOrderDetails {
	public WebDriver driver;

	By trackorder = By.linkText("Track your order");
	By email = By.xpath("//*[@id='ola_email']");
	By orderId = By.xpath("//*[@id='ola_orderNumber']");
	By find = By.xpath("//*[@id='ola_submitButton']");

	public TrackOrderDetails(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement getTrackOrder() {
		return driver.findElement(trackorder);
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getOrderId() {
		return driver.findElement(orderId);
	}

	public WebElement getFind() {
		return driver.findElement(find);
	}
}
