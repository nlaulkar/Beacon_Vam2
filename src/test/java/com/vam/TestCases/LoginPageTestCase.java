package com.vam.TestCases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vam.page.BaseClass;
import com.vam.pages.HomePage;
import com.vam.pages.LoginPage;
import com.vam.util.ReadExcelData;
import com.vam.util.TakeScreenShots;

public class LoginPageTestCase extends BaseClass
{
		public LoginPageTestCase() throws IOException 
		{
			super();
		}

		public LoginPage lp;
		public HomePage homePage;
		
		@BeforeTest
		public void init() throws IOException
		{
			initialize();
			lp = new LoginPage();
			homePage = lp.login();
		}
		
		@Test(priority = 1)
		public void testlogin() throws IOException 
		{	
			lp = new LoginPage();
			homePage = lp.login();
			
		}
		
		@Test (enabled = false)
		public void testforgotlink() throws IOException 
		{
			lp = new LoginPage();
			Assert.assertTrue(lp.forgot_password());
		}
					
		@DataProvider
		public Object[][] provideData() throws IOException
		{
			return (ReadExcelData.readData("Sheet1"));
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
