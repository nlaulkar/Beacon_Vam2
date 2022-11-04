package com.vam.pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.vam.page.BaseClass;
import com.vam.util.TakeScreenShots;

public class AuthorizationPage extends BaseClass {
	
	public AuthorizationPage() throws IOException 
	{
		super();
	}
	
	public boolean add_new_Authorization() throws Exception
	{	
		String timestamp = new SimpleDateFormat("yyMMddhhmmss").format(new Date());
		wait.until(ExpectedConditions.elementToBeClickable(findelement("New_Authorization_button")));
		act=new Actions(driver);
		act.moveToElement(findelement("New_Authorization_button"));
		TakeScreenShots.captureSS(driver, "Add new Auth button appearing");
		Thread.sleep(3000);
		click("New_Authorization_button");		
		sendKeys("Auth_Tracking_id", "1"+timestamp);
		click("Auth_Processing_Timeframe");
		wait.until(ExpectedConditions.elementToBeClickable(findelement("Auth_processing_timeframe_PTF_option")));
		click("Auth_processing_timeframe_PTF_option");
		wait.until(ExpectedConditions.elementToBeClickable(findelement("Auth_Case_type")));
		click("Auth_Case_type");
		wait.until(ExpectedConditions.elementToBeClickable(findelement("Auth_Case_type_Appeal_Part_C_pre_service_option")));
		click("Auth_Case_type_Appeal_Part_C_pre_service_option");
		wait.until(ExpectedConditions.elementToBeClickable(findelement("Auth_Receipt_Date")));
		sendKeys("Auth_Receipt_Date", "11/01/2022");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(findelement("Auth_Receipt_Time")));
		sendKeys("Auth_Receipt_Time", "06:22:55 PM");
		//wait.until(ExpectedConditions.elementToBeClickable(findelement("Auth_Timepicker")));
		//click("Auth_Timepicker");
		Thread.sleep(3000);
		click("Auth_Save_Button");
		return isLinkpreent("New_Authorization_button");
	}

}
