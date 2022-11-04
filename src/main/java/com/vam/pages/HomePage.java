package com.vam.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.vam.page.BaseClass;

public class HomePage extends BaseClass {

	public HomePage() throws IOException
	{
		super();
	}
	
	public void filterAssingedCases() throws InterruptedException
	{	
		
		wait.until(ExpectedConditions.elementToBeClickable(findelement("Admin_DropDown")));
		click("Admin_DropDown");
		wait.until(ExpectedConditions.elementToBeClickable(findelement("Admin_Users")));
		click("Admin_Users");
		wait.until(ExpectedConditions.visibilityOf(findelement("Users_username_txtbox")));
		sendKeys("Users_username_txtbox", "admin");
		Thread.sleep(5000);
		act =new Actions(driver);
		wait.until(ExpectedConditions.visibilityOf(findelement("admin_user_from_table")));
		act.moveToElement(findelement("admin_user_from_table")).doubleClick().build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(findelement("filterUserAssignedCases_chkbox")));
		act.moveToElement(findelement("admin_user_from_table")).build().perform();
		click("filterUserAssignedCases_chkbox");
		wait.until(ExpectedConditions.visibilityOf(findelement("save_button")));
		click("save_button");
		wait.until(ExpectedConditions.visibilityOf(findelement("admin_user")));
		click("admin_user");
		wait.until(ExpectedConditions.visibilityOf(findelement("Sign_out")));
		click("Sign_out");
		wait.until(ExpectedConditions.visibilityOf(findelement("login_button")));
		findelement("username_txtbox").sendKeys(prop.getProperty("username"));
		findelement("password_txtbox").sendKeys(prop.getProperty("password"));
		click("login_button");
		wait.until(ExpectedConditions.elementToBeClickable(findelement("Admin_DropDown")));
		
	}
	
	public void verifyOpenCases() throws InterruptedException
	{	
		int j=0;
		wait.until(ExpectedConditions.elementToBeClickable(findelement("Search_dropdown")));
		click("Search_dropdown");
		wait.until(ExpectedConditions.elementToBeClickable(findelement("Case_option")));
		click("Case_option");
		wait.until(ExpectedConditions.elementToBeClickable(findelement("Search_button")));
		click("Search_button");
		Thread.sleep(5000);
		List<WebElement> pagenumber = findelements("Pagenumber");
		for(int i=0; i<pagenumber.size();i++)
		{	
			
			List<WebElement> opencases = findelements("opencase");
			j=j+opencases.size();
			click("next_icon");
			Thread.sleep(5000);
			
		}
		System.out.println("The number of opencases are "+j);
	}
	
	public void verifyFlaggedCases()
	{
		wait.until(ExpectedConditions.elementToBeClickable(findelement("flaggedcase")));
		act =new Actions(driver);
		act.moveToElement(findelement("flaggedcase")).build().perform();
		click("flaggedcase");
		wait.until(ExpectedConditions.elementToBeClickable(findelement("footer")));
	}
	
	public void verifyAlertCases()
	{
		wait.until(ExpectedConditions.visibilityOf(findelement("alertcaseid")));
		act =new Actions(driver);
		act.moveToElement(findelement("alertcaseid")).build().perform();
		click("alertcaseid");
		wait.until(ExpectedConditions.visibilityOf(findelement("alertno")));
	}
	public void verifyPendingItems()
	
	{
		click("Hompage_link");
		act =new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(findelement("pending_task")));
		act.moveToElement(findelement("pending_task")).build().perform();
		
	}
	
	public void verifyPendingItemsCases() throws InterruptedException
	{
		click("Hompage_link");
		wait.until(ExpectedConditions.elementToBeClickable(findelement("task")));
		click("task");
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOf(findelement("void_checkbox")));
		click("Hompage_link");
	}
	
	public AgentPage clickOnAgent() throws IOException
	{
		click("Search_dropdown");
		wait.until(ExpectedConditions.elementToBeClickable(findelement("Agent_option")));
		click("Agent_option");
		return new AgentPage();
	}
	
	public MemberPage clickOnMember() throws Exception
	{
		Thread.sleep(5000);
		click("Hompage_link");
		wait.until(ExpectedConditions.elementToBeClickable(findelement("Search_dropdown")));
		click("Search_dropdown");
		wait.until(ExpectedConditions.elementToBeClickable(findelement("Member_option")));
		click("Member_option");
		return new MemberPage();
	}
	
	public AuthorizationPage clickOnAuthorization() throws Exception
	{
		Thread.sleep(5000);
		click("Hompage_link");
		wait.until(ExpectedConditions.elementToBeClickable(findelement("Search_dropdown")));
		click("Search_dropdown");
		wait.until(ExpectedConditions.elementToBeClickable(findelement("Authorization_option")));
		click("Authorization_option");
		return new AuthorizationPage();
	}
}
