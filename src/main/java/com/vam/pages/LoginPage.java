package com.vam.pages;

import java.io.IOException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.vam.page.BaseClass;
import com.vam.util.TakeScreenShots;

public class LoginPage extends BaseClass
{
	

	public LoginPage() throws IOException 
	{
		super();
	}

	public HomePage login() throws IOException
	{
		sendKeys("username_txtbox", prop.getProperty("username"));
		//Enter password
		sendKeys("password_txtbox", prop.getProperty("password"));
		//Click on login button
		click("login_button");
		//WebElement Test = ;
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.visibilityOf(findelement("NewCaseButton")));
		//return isLinkpreent("NewCaseButton");
		return new HomePage();
	}
	 
	public boolean forgot_password()
	{
		//Click on Forgotten password linlk
		click("forgottenPassword_link");
		wait.until(ExpectedConditions.visibilityOf(findelement("forgotUserName_txtbox")));
		sendKeys("forgotUserName_txtbox", "nikhil_auto");
		sendKeys("forgotEmail_txtbox", "nlaulkar@beaconhcs.com");
		click("save_button");
		try {
			TakeScreenShots.captureSS(driver, "ForgotPassword_Data");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		//click("Cancel_button");
		return isLinkpreent("login_button");
	}
}
