package com.vam.pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.vam.page.BaseClass;
import com.vam.util.TakeScreenShots;

public class MemberPage extends BaseClass {

	public MemberPage() throws IOException 
	{
		super();
	}
	
	public boolean checkNewMemberButton()
	{
		wait.until(ExpectedConditions.visibilityOf(findelement("New_Member_button")));
		return isLinkpreent("New_Member_button");
	}
	
	public boolean clickNewMemberButton()
	{
		wait.until(ExpectedConditions.visibilityOf(findelement("New_Member_button")));
		click("New_Member_button");
		wait.until(ExpectedConditions.elementToBeClickable(findelement("Member_data_Save")));
		click("Cancel_button_New_Member");
		return isLinkpreent("Member_data_Save");
	}
	
	public boolean verifyErrorOnBlankMantoryFields() throws IOException, InterruptedException
	{	
		
		Thread.sleep(5000);
		click("New_Member_button");
		wait.until(ExpectedConditions.elementToBeClickable(findelement("Member_data_Save")));
		click("Member_data_Save");
		wait.until(ExpectedConditions.elementToBeClickable(findelement("New_Member_error")));
		act =new Actions(driver);
		act.moveToElement(findelement("New_Member_error")).build().perform();
		TakeScreenShots.captureSS(driver, "Blank Cell Error on MemberPage");
		click("Cancel_button_New_Member");
		return isLinkpreent("Member_data_Save");
	}
	
	public boolean checkAddMemberCoverageButton() throws Exception
	{	
		String timestamp = new SimpleDateFormat("yyMMddhhmmss").format(new Date());
		Thread.sleep(5000);
		click("New_Member_button");
		wait.until(ExpectedConditions.visibilityOf(findelement("Member_data_Save")));
		sendKeys("New_Member_First_name", "Nikhil");
		sendKeys("New_Member_Last_name", "Test");
		sendKeys("Member_DOB", "10/21/1990");
		sendKeys("Member_HICN", "Test-"+timestamp);
		sendKeys("Member_UMI", "Test-"+timestamp);
		click("Lang_field");
		List<WebElement> langauges = findelements("Member_Lang_list");
		langauges.get(10).click();
		act = new Actions(driver);
		act.moveToElement(findelement("Member_data_Save")).build().perform();
		click("Member_data_Save");
		Thread.sleep(3000);
		act.moveToElement(findelement("Add_Member_Coverage_button")).build().perform();
		TakeScreenShots.captureSS(driver, "Add Member Coverage button"+timestamp);
		Thread.sleep(3000);
		click("Close_addcoverage_popup");
		Thread.sleep(5000);
		click("Close_confirm_popup_coverage");
		wait.until(ExpectedConditions.visibilityOf(findelement("New_Member_button")));
		return isLinkpreent("New_Member_button");
		
	}
	public void checkAddMemberCoverage_Blankerror() throws Exception
	{
		String timestamp = new SimpleDateFormat("yyMMddhhmmss").format(new Date());
		Thread.sleep(5000);
		click("New_Member_button");
		wait.until(ExpectedConditions.visibilityOf(findelement("Member_data_Save")));
		sendKeys("New_Member_First_name", "Nikhil");
		sendKeys("New_Member_Last_name", "Test");
		sendKeys("Member_DOB", "10/21/1990");
		sendKeys("Member_HICN", "Test-"+timestamp);
		sendKeys("Member_UMI", "Test-"+timestamp);
		click("Lang_field");
		List<WebElement> langauges = findelements("Member_Lang_list");
		langauges.get(10).click();
		act = new Actions(driver);
		act.moveToElement(findelement("Member_data_Save")).build().perform();
		click("Member_data_Save");
		Thread.sleep(3000);
		act.moveToElement(findelement("Add_Member_Coverage_button")).build().perform();
		click("Add_coverage_button");
		Thread.sleep(3000);
		click("Save_btn_Add_coverage");
		Thread.sleep(3000);
		TakeScreenShots.captureSS(driver, "Error on blank Error on coverage");
		Thread.sleep(3000);
		click("cancel_button_coverage");
		Thread.sleep(3000);
		click("Close_addcoverage_popup");
		Thread.sleep(3000);
		click("Close_confirm_popup_coverage");
	}
	public boolean AddMemberCoverage() throws Exception
	{
		
		String timestamp1 = new SimpleDateFormat("yyMMddhhmmss").format(new Date());
		String timestamp2 = new SimpleDateFormat("yyMM").format(new Date());
		Thread.sleep(5000);
		click("New_Member_button");
		wait.until(ExpectedConditions.visibilityOf(findelement("Member_data_Save")));
		sendKeys("New_Member_First_name", "Nikhil");
		sendKeys("New_Member_Last_name", "Test");
		sendKeys("Member_DOB", "10/21/1990");
		sendKeys("Member_HICN", "Test-"+timestamp1);
		sendKeys("Member_UMI", "Test-"+timestamp1);
		click("Lang_field");
		List<WebElement> langauges = findelements("Member_Lang_list");
		langauges.get(10).click();
		act = new Actions(driver);
		act.moveToElement(findelement("Member_data_Save")).build().perform();
		click("Member_data_Save");
		Thread.sleep(3000);
		act.moveToElement(findelement("Add_Member_Coverage_button")).build().perform();
		click("Add_coverage_button");
		Thread.sleep(5000);
		sendKeys("Coverage_start_date", "11/01/2022");
		sendKeys("Coverage_end_date", "12/01/2022");
		sendKeys("contract_number", "1"+timestamp2);
		sendKeys("PBP", "1"+timestamp2);
		click("Save_btn_Add_coverage");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(findelement("Add_address_button")));
		act = new Actions(driver);
		act.moveToElement(findelement("Radio_button_Coverage")).build().perform();
		TakeScreenShots.captureSS(driver, "Newly added Member Coverage");
		click("Radio_button_Coverage");
		Thread.sleep(5000);
		click("Member_data_Save");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(findelement("next_icon")));
		return isLinkpreent("next_icon");
	}
	public boolean check_Address_MemberCoverage_blankerror() throws Exception
	{
		String timestamp = new SimpleDateFormat("yyMMddhhmmss").format(new Date());
		Thread.sleep(5000);
		click("New_Member_button");
		wait.until(ExpectedConditions.visibilityOf(findelement("Member_data_Save")));
		sendKeys("New_Member_First_name", "Nikhil");
		Thread.sleep(3000);
		sendKeys("New_Member_Last_name", "Test");
		sendKeys("Member_DOB", "10/21/1990");
		sendKeys("Member_HICN", "Test-"+timestamp);
		sendKeys("Member_UMI", "Test-"+timestamp);
		click("Lang_field");
		List<WebElement> langauges = findelements("Member_Lang_list");
		langauges.get(10).click();
		act = new Actions(driver);
		act.moveToElement(findelement("Member_data_Save")).build().perform();
		click("Member_data_Save");
		Thread.sleep(3000);
		act.moveToElement(findelement("Add_Member_Coverage_button")).build().perform();
		click("Add_address_button");
		Thread.sleep(3000);
		click("Save_btn_Add_Address");
		act.moveToElement(findelement("Error_Blank_address_field")).build().perform();
		TakeScreenShots.captureSS(driver, "Blank field Error on add adress pop-up on Member page");
		click("cancel_btn_add_address");
		Thread.sleep(3000);
		click("Close_addcoverage_popup");
		Thread.sleep(3000);
		click("Close_confirm_popup_coverage");
		return isLinkpreent("New_Member_button");
	}
	public boolean add_AddressOnMemberCoverage() throws Exception
	{
		String timestamp1 = new SimpleDateFormat("yyMMddhhmmss").format(new Date());
		String timestamp2 = new SimpleDateFormat("yyMM").format(new Date());
		Thread.sleep(5000);
		click("New_Member_button");
		wait.until(ExpectedConditions.visibilityOf(findelement("Member_data_Save")));
		sendKeys("New_Member_First_name", "Nikhil");
		sendKeys("New_Member_Last_name", "Test");
		sendKeys("Member_DOB", "10/21/1990");
		sendKeys("Member_HICN", "Test-"+timestamp1);
		sendKeys("Member_UMI", "Test-"+timestamp1);
		click("Lang_field");
		List<WebElement> langauges = findelements("Member_Lang_list");
		langauges.get(10).click();
		act = new Actions(driver);
		act.moveToElement(findelement("Member_data_Save")).build().perform();
		click("Member_data_Save");
		Thread.sleep(3000);
		act.moveToElement(findelement("Add_Member_Coverage_button")).build().perform();
		click("Add_coverage_button");
		Thread.sleep(5000);
		sendKeys("Coverage_start_date", "11/01/2022");
		sendKeys("Coverage_end_date", "12/01/2022");
		sendKeys("contract_number", "1"+timestamp2);
		sendKeys("PBP", "1"+timestamp2);
		click("Save_btn_Add_coverage");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(findelement("Radio_button_Coverage")));
		click("Radio_button_Coverage");
		wait.until(ExpectedConditions.visibilityOf(findelement("Add_address_button")));
		click("Add_address_button");
		Thread.sleep(3000);
		click("Select_address_type");
		Thread.sleep(3000);
		click("Address_type");
		sendKeys("Address_member_Primary_Email", "test@beaconhcs.com");
		sendKeys("Address_member_Primary_Phone", "1234567899");
		sendKeys("Address_member_Address_Line1", "test");
		sendKeys("Address_member_Address_Line2", "test");
		sendKeys("Address_member_Address_Line3", "test");
		Thread.sleep(3000);
		click("Save_address_button");
		Thread.sleep(3000);
		click("Primary_address_radio_button");
		TakeScreenShots.captureSS(driver, "New Primary Address on new Member page");
		click("Save_button_new_member");
		Thread.sleep(5000);
		return isLinkpreent("New_Member_button");
	}
	
	public boolean add_Coverage_Address_OnNewMemberwindow() throws Exception
	{
		String timestamp = new SimpleDateFormat("yyMMddhhmmss").format(new Date());
		String timestamp2 = new SimpleDateFormat("yyMM").format(new Date());
		Thread.sleep(5000);
		click("New_Member_button");
		wait.until(ExpectedConditions.visibilityOf(findelement("Member_data_Save")));
		sendKeys("New_Member_First_name", "Nikhil");
		sendKeys("New_Member_Last_name", "Test");
		sendKeys("Member_DOB", "10/21/1990");
		sendKeys("Member_HICN", "Test-"+timestamp);
		sendKeys("Member_UMI", "Test-"+timestamp);
		click("Lang_field");
		List<WebElement> langauges = findelements("Member_Lang_list");
		langauges.get(10).click();
		act = new Actions(driver);
		act.moveToElement(findelement("Member_data_Save")).build().perform();
		click("Member_data_Save");
		Thread.sleep(3000);
		act.moveToElement(findelement("Add_Member_Coverage_button")).build().perform();
		click("Add_coverage_button");
		Thread.sleep(5000);
		sendKeys("Coverage_start_date", "11/01/2022");
		sendKeys("Coverage_end_date", "12/01/2022");
		sendKeys("contract_number", "1"+timestamp2);
		sendKeys("PBP", "1"+timestamp2);
		click("Save_btn_Add_coverage");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(findelement("Add_address_button")));
		act = new Actions(driver);
		act.moveToElement(findelement("Radio_button_Coverage")).build().perform();
		click("Radio_button_Coverage");
		Thread.sleep(5000);
		act.moveToElement(findelement("Add_Member_Coverage_button")).build().perform();
		click("Add_address_button");
		Thread.sleep(3000);
		click("Select_address_type");
		Thread.sleep(3000);
		click("Address_type");
		sendKeys("Address_member_Primary_Email", "test@beaconhcs.com");
		sendKeys("Address_member_Primary_Phone", "1234567899");
		sendKeys("Address_member_Address_Line1", "test");
		sendKeys("Address_member_Address_Line2", "test");
		sendKeys("Address_member_Address_Line3", "test");
		Thread.sleep(3000);
		click("Save_address_button");
		Thread.sleep(3000);
		click("Primary_address_radio_button");
		click("Save_button_new_member");
		return isLinkpreent("New_Member_button");
	}
	
	public boolean edit_Member_Information() throws Exception
	{
		click("Sort_Members");
		click("Select_first_Memeber");
		Thread.sleep(5000);
		sendKeys("Member_PIN_info", "1234");
		click("Save_button_new_member");
		return isLinkpreent("New_Member_button");
	}
	
	public boolean edit_Member_Information_BlankError() throws Exception
	{
		wait.until(ExpectedConditions.visibilityOf(findelement("Sort_Members")));
		click("Sort_Members");
		click("Select_first_Memeber");
		Thread.sleep(5000);
		findelement("Member_HICN").clear();
		sendKeys("Member_PIN_info", "1234");
		click("Save_button_new_member");
		wait.until(ExpectedConditions.visibilityOf(findelement("New_Member_error")));
		act=new Actions(driver);
		act.moveToElement(findelement("New_Member_error")).build().perform();
		TakeScreenShots.captureSS(driver, "Blank field Error on edit Member page window");
		click("Close_addcoverage_popup");
		Thread.sleep(3000);
		click("Close_confirm_popup_coverage");
		return isLinkpreent("New_Member_button");
	}
	

}
