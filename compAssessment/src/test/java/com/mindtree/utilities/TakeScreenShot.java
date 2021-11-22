package com.mindtree.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.mindtree.reusablecomponents.ReadPropertyFile;

public class TakeScreenShot extends ReadPropertyFile{
	
	public String capture(WebDriver driver) throws IOException
	{
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File(System.getProperty("user.dir") + "\\Screenshots\\" + System.currentTimeMillis() + ".png");
		String completepath = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		return completepath;

	}
	public String getCurrentDate() {

		DateFormat df = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date date = new Date();
		return df.format(date);

	}

}
