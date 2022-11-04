package com.vam.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.vam.page.BaseClass;
import com.vam.pages.AuthorizationPage;
import com.vam.pages.HomePage;
import com.vam.pages.LoginPage;
import com.vam.util.TakeScreenShots;

public class AuthorizationPageTestCases extends BaseClass {
	
	public LoginPage lp;
	public HomePage homePage;
	public AuthorizationPage authpage;

	public AuthorizationPageTestCases() throws IOException 
	{
		super();
	}
	
	
	@BeforeTest
	public void init_lvl1() throws Exception
	{
		homePage = new HomePage();
		
	}
	@BeforeMethod
	public void init_lvl2() throws Exception
	{
		authpage = homePage.clickOnAuthorization();
	}
	
	@Test(priority = 1)
	public void verify_add_new_Authorization() throws Exception
	{
		Assert.assertTrue(authpage.add_new_Authorization(), "Not able to add authoration successfully");
	}
	
	@AfterMethod
	public void postTesting(ITestResult result) throws IOException
	{
		if(result.getStatus() == 1)
		{
			TakeScreenShots.captureSS(BaseClass.driver, result.getName());
		}
		else
		{
			TakeScreenShots.captureSS(BaseClass.driver, result.getName()+"failed");
		}
	}
	@AfterSuite
	public void teardown()
	{
		BaseClass.driver.quit();
	}

}
