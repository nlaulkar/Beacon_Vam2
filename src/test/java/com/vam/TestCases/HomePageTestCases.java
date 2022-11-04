package com.vam.TestCases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.vam.page.BaseClass;
import com.vam.pages.HomePage;
import com.vam.pages.LoginPage;
import com.vam.util.TakeScreenShots;

public class HomePageTestCases extends BaseClass {

	public HomePageTestCases() throws IOException 
	{
		super();		
	}

	public LoginPage lp;
	public HomePage homePage;
	
	@BeforeTest
	public void init() throws IOException
	{
		//lp = new LoginPage();
		//homePage = lp.login();
		homePage =new HomePage();
	}
			
	@Test(priority = 1)
	public void check_FilterAssingedCases() throws IOException, InterruptedException 
	{	
		homePage.filterAssingedCases();
	}
	@Test(priority = 2)
	public void verify_OpenCases() throws IOException, InterruptedException 
	{	
		homePage.verifyOpenCases();
	}
	
	@Test(priority = 3)
	public void verify_FlaggedCases()
	{
		homePage.verifyFlaggedCases();
	}
	
	@Test(priority = 4)
	public void verify_AlertCases()
	{
		homePage.verifyAlertCases();
	}
	
	@Test(priority = 5)
	public void verify_PendingItems()
	{
		homePage.verifyPendingItems();
	}
	
	@Test(priority = 6)
	public void verify_PendingItemsCases() throws InterruptedException
	{
		homePage.verifyPendingItemsCases();
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
	@AfterTest
	public void teardown()
	{
		BaseClass.driver.quit();
	}
	
}
