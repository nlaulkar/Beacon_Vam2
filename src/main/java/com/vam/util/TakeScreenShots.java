package com.vam.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class TakeScreenShots {

	public static void captureSS(WebDriver driver, String TCName) throws IOException
	{	
		//typecasting
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		//Add timestamp
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		
		//Copying a file to readable format
		FileHandler.copy(src, new File("D:\\BHCS_Automation_Data\\Beacon_Vam2\\test-output\\Screenshots\\"+TCName+" "+timestamp+".png"));
	}
}
