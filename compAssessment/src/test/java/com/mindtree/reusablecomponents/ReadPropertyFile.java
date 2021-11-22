package com.mindtree.reusablecomponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadPropertyFile {

	public static WebDriver driver;
	public Properties prop;

	public WebDriver DriverInitialisation() throws IOException {
		// TODO Auto-generated method stub
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\keert\\eclipse-workspace\\compAssessment\\TestData\\configure.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\keert\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\keert\\eclipse-workspace\\compAssessment\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\keert\\eclipse-workspace\\compAssessment\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		return driver;
	}

}