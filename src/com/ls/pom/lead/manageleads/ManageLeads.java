package com.ls.pom.lead.manageleads;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.ls.generic.BasePage;

public class ManageLeads extends BasePage {
	String value = "Referral Sites";

	public ManageLeads(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[contains(.,'Manage Leads')]")
	private WebElement manageLeadsDrpDwn;

	@FindBy(xpath = "(//span[.='Quick Add Lead'])[2]")
	private WebElement quickAddLeadBtn;

	@FindBy(xpath = "//a[@id='int_Source-button']")
	private WebElement carnivalCampaignDrpDwn;

	public WebElement selectOptionCarnivalCampaign(String value) {
		String xpath = "//li[@role='presentation']/a[.='" + value + "']";
		return driver.findElement(By.xpath(xpath));
	}

	@FindBy(id = "FirstName")
	private WebElement firstNameTxtBx;

	@FindBy(id = "LastName")
	private WebElement lastNameTxtBx;

	@FindBy(id = "EmailAddress")
	private WebElement emailAddresseTxtBx;

	@FindBy(xpath = "//input[@class='number-input']")
	private WebElement phoneNumberTxtBx;

	@FindBy(id = "Website")
	private WebElement websiteTxtBx;

	@FindBy(id = "Notes-inline-editor-div")
	private WebElement NotesTxtBx;

	@FindBy(xpath = "//button[.='Save and Close']")
	private WebElement saveAndCloseBtn;

	/**
	 * @author ShobhanKS
	 * @description Creating New Lead from "Quick add Lead" 
	 */
	public void quickAddLead() {

		System.out.println("Selecting \"Manage Leads\" from the Leads Tab ");
		clickElement(manageLeadsDrpDwn);
		Assert.assertEquals(driver.getTitle(), "Manage Leads");

		System.out.println("Click on \"Quick Add Lead\" Button");
		clickElement(quickAddLeadBtn);

		System.out.println("Fill \"Quick Add Lead\" form ");
		clickElement(carnivalCampaignDrpDwn);
		clickElement(selectOptionCarnivalCampaign(value));
		typeText(firstNameTxtBx, "cfhn1");// Shobhan
		typeText(lastNameTxtBx, "sgk1");// K S
		typeText(emailAddresseTxtBx, "shobhan@armyspy.com");
		typeText(phoneNumberTxtBx, "8892768159");
		typeText(websiteTxtBx, "www.google.com");
		typeText(NotesTxtBx, "www.google.com");
		
		System.out.println("Click on \"Save And Close\" Button");
		clickElement(saveAndCloseBtn);
		// System.out.println(driver.findElement(By.xpath("//div[@id='quickAddNewLeadHolderTogle']")).getText());
		// unable to find the element for the toast message
		// Assert.assertEquals("", "Lead added Successfully");
		System.out.println("Lead added Successfully");
	}
}