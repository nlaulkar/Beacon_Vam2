package com.vam.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.vam.page.BaseClass;
import com.vam.pages.HomePage;
import com.vam.pages.LoginPage;
import com.vam.pages.MemberPage;
import com.vam.util.TakeScreenShots;

public class MemberPageTestCases extends BaseClass{
	
	public LoginPage lp;
	public HomePage homePage;
	public MemberPage memberpage;
	
	public MemberPageTestCases() throws IOException 
	{
		super();
		
	}
	
	@BeforeTest
	public void init_lvl() throws Exception
	{	
		//initialize();
		//lp= new LoginPage();
		//homePage=lp.login();
		homePage = new HomePage();		
	}
	@BeforeMethod
	public void init_lvl2() throws Exception
	{
		memberpage = homePage.clickOnMember();
	}
	
	@Test(priority = 1)  
	
	public void check_NewMemberButton()
	{
		//Assert.assertTrue(memberpage.checkNewMemberButton(),"New Agentlink is not present");
		memberpage.checkNewMemberButton();
	}
	
	@Test(priority = 2) 
	public void click_NewMemberButton()
	{
		//Assert.assertTrue(memberpage.clickNewMemberButton(),"New Agentlink is not present");
		memberpage.clickNewMemberButton();
	}
	
	@Test(priority = 3)  
	public void verify_ErrorOnBlankMantoryFields() throws IOException, InterruptedException
	{
		//Assert.assertTrue(memberpage.verifyErrorOnBlankMantoryFields(),"New Agentlink is not present");
		memberpage.verifyErrorOnBlankMantoryFields();
	}
	
	@Test(priority = 4) 
	public void check_AddMemberCoverageButton() throws Exception
	{
		Assert.assertTrue(memberpage.checkAddMemberCoverageButton(),"Button not found");
		
	}
	
	@Test(priority = 5) 
	public void check_AddMemberCoverage_Blankerror() throws Exception
	{
		//Assert.assertTrue(memberpage.checkAddMemberCoverage_Blankerror(),"New Agentlink is not present");
		memberpage.checkAddMemberCoverage_Blankerror();
	}
	@Test(priority = 6) 
	public void Add_MemberCoverage() throws Exception
	{
		Assert.assertTrue(memberpage.AddMemberCoverage(),"not able to add Member Coverage");
		
	}
	@Test(priority = 7) 
	public void check_Add_Address_MemberCoverage_blankerror() throws Exception
	{
		Assert.assertTrue(memberpage.check_Address_MemberCoverage_blankerror(),"Not able to performe this testcase");
		
	}
	
	@Test(priority = 8) 
	public void verify_Add_Address_MemberCoverage() throws Exception
	{
		Assert.assertTrue(memberpage.add_AddressOnMemberCoverage(),"Not able to add address");
		
	}
	
	@Test(priority = 9) 
	public void verify_Add_Coverage_Address_OnNewMemberwindow() throws Exception
	{
		Assert.assertTrue(memberpage.add_Coverage_Address_OnNewMemberwindow(),"Not able to add the address and the Member Coverage");
		
	}
	@Test(priority = 10) 
	public void verify_edit_Member_Information() throws Exception
	{
		Assert.assertTrue(memberpage.edit_Member_Information(), "Not Able to Edit the member information");
		
	}
	
	@Test(priority = 11) 
	public void verify_Edit_Member_Information_BlankError() throws Exception
	{
		Assert.assertTrue(memberpage.edit_Member_Information_BlankError(), "Not able to get error on blank window");
		
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
