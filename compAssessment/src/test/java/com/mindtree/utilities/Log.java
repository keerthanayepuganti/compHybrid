package com.mindtree.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.FileAppender;

public class Log extends FileAppender {

	public void setFile(String filename) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd__hh-mm-ss");

		filename = filename.replaceAll("%pattern", format.format(date));

		super.setFile(filename);
	}
}