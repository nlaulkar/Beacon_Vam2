package com.vam.TestCases;

import java.io.IOException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.vam.page.BaseClass;
import com.vam.pages.AgentPage;
import com.vam.pages.HomePage;
import com.vam.pages.LoginPage;
import com.vam.util.TakeScreenShots;

public class AgentPageTestCases extends BaseClass{
	
	public LoginPage lp;
	public AgentPage agentpage;
	public HomePage homePage;

	public AgentPageTestCases() throws IOException
	{
		super();
	}
	
	@BeforeTest
	public void init_lvl() throws IOException
	{	
		homePage = new HomePage();
	}
	@BeforeMethod
	public void init_lvl2() throws IOException
	{
		agentpage =homePage.clickOnAgent();
	}
	@Test(priority= 1)
	public void check_NewAgentButton()
	{
		agentpage.checkNewAgentButton();
		//Assert.assertTrue(agentpage.checkNewAgentButton(),"New Agentlink is not present");
	}
	
	@Test(priority= 2)
	public void click_NewAgentButton()
	{
		agentpage.clickNewAgentButton();
		//Assert.assertTrue(agentpage.clickNewAgentButton());
	}
		
	@Test(priority= 2)
	public void verify_ErrorOnBlankMantoryFields()
	{
		agentpage.verifyErrorOnBlankMantoryFields();
		//Assert.assertTrue(agentpage.verifyErrorOnBlankMantoryFields());
	}
	
	@Test(priority= 3)
	public void verify_AddNewAgent()
	{
		agentpage.addNewAgent();
		//Assert.assertTrue(agentpage.addNewAgent());
	}
	
	@Test(priority= 4)
	public void verify_addingInvalidDataonNewAgentPopup()
	{
		agentpage.addInvalidDataonNewAgentPopup();
		//Assert.assertTrue(agentpage.addInvalidDataonNewAgentPopup());
		
	}
	
	@Test(priority= 5)
	public void verify_CancleButton()
	{
		agentpage.verifyCancleButton();
		//Assert.assertTrue(agentpage.verifyCancleButton());
	}
	
	@Test(priority= 6)
	public void verify_EditAgent()
	{
		agentpage.verifyEditAgent();
		//Assert.assertTrue(agentpage.verifyEditAgent());
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
