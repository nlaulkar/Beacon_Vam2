package com.vam.pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.vam.page.BaseClass;
import com.vam.util.TakeScreenShots;

public class AgentPage extends BaseClass{

	public AgentPage() throws IOException 
	{
		super();
	}
	
	public boolean checkNewAgentButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(findelement("New_Agent_button")));
		return isLinkpreent("New_Agent_button");
	}
	
	public boolean clickNewAgentButton()
	{	
		wait.until(ExpectedConditions.elementToBeClickable(findelement("next_icon")));
		click("New_Agent_button");
		wait.until(ExpectedConditions.elementToBeClickable(findelement("Cancel_button")));
		click("Cancel_button");
		return isLinkpreent("Cancel_button");
	}
	
	public boolean verifyErrorOnBlankMantoryFields()
	{	
		wait.until(ExpectedConditions.elementToBeClickable(findelement("next_icon")));
		click("New_Agent_button");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		click("New_agent_save_button");
		wait.until(ExpectedConditions.elementToBeClickable(findelement("New_agent_error")));
		try {
			TakeScreenShots.captureSS(driver, "invalid data error");
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		click("Cancel_button");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		return isLinkpreent("Cancel_button");
	}
	
	public boolean addNewAgent()
	{	
		String timestamp = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
		click("Sort_option_ID");
		wait.until(ExpectedConditions.elementToBeClickable(findelement("next_icon")));
		click("New_Agent_button");
		wait.until(ExpectedConditions.elementToBeClickable(findelement("New_agent_save_button")));
		click("Agent_type");
		wait.until(ExpectedConditions.elementToBeClickable(findelement("internal_agent")));
		click("internal_agent");
		wait.until(ExpectedConditions.elementToBeClickable(findelement("agent_lastname")));
		sendKeys("agent_lastname", "Test"+timestamp);
		sendKeys("agent_ID", "2022"+timestamp);
		sendKeys("Agent_Effective_Date", "10/17/2022");
		click("New_agent_save_button");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		sendKeys("Serch_Option_Lastname", "Test");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		return isLinkpreent("New_Agent_button");
	}
	
	public boolean addInvalidDataonNewAgentPopup()
	{
		wait.until(ExpectedConditions.elementToBeClickable(findelement("next_icon")));
		click("New_Agent_button");
		wait.until(ExpectedConditions.elementToBeClickable(findelement("New_agent_save_button")));
		click("Agent_type");
		wait.until(ExpectedConditions.elementToBeClickable(findelement("internal_agent")));
		click("internal_agent");
		wait.until(ExpectedConditions.elementToBeClickable(findelement("agent_lastname")));
		sendKeys("agent_lastname", "Test_Lastname");
		sendKeys("agent_ID", "2022");
		sendKeys("agent_contract", "456");
		sendKeys("Agent_Effective_Date", "10/17/2022");
		click("New_agent_save_button");
		try {
			TakeScreenShots.captureSS(driver, "invalid data error");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		click("Cancel_button");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		return isLinkpreent("New_agent_error");
		
	}
	
	public boolean verifyCancleButton()
	{	
		wait.until(ExpectedConditions.elementToBeClickable(findelement("next_icon")));
		click("New_Agent_button");
		wait.until(ExpectedConditions.elementToBeClickable(findelement("Cancel_button")));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		click("Cancel_button");
		return isLinkpreent("New_Agent_button");
	}
	
	public boolean verifyEditAgent()
	{
		wait.until(ExpectedConditions.elementToBeClickable(findelement("Serch_Option_Lastname")));
		findelement("Serch_Option_Lastname").clear();
		sendKeys("Serch_Option_Lastname", "Test");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		act = new Actions(driver);
		act.moveToElement(findelement("Agent_Table_Data")).build().perform();
		click("Agent_Table_Data");
		sendKeys("agent_ID", "2");
		click("New_agent_save_button");
		click("Popup_yes_button");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		return isLinkpreent("New_Agent_button");
		
	}
	

}
