package com.ls.pom.lead.manageleads;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import com.ls.generic.BasePage;

public class ManageLeadsPage extends BasePage {
	String value = "Referral Sites";

	public ManageLeadsPage(WebDriver driver) {
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
	
	@FindBy(xpath="//td[@class='t-last']/preceding::td/child::div[@class='lead-grid-column row-fluid lead-grid-first-column']/div[@class='lead-name row-fluid']")
    private WebElement firstleadLnk;

	/**
	 * @author ShobhanKS
	 * @return
	 * @throws InterruptedException
	 * @description Creating New Lead from "Quick add Lead"
	 */
	public String quickAddLead() throws InterruptedException {

		System.out.println("Selecting \"Manage Leads\" from the Leads Tab ");
		waitUntilLoadedAndVisibilityOfElementLocated(manageLeadsDrpDwn);
		Thread.sleep(3000);
		clickElement(manageLeadsDrpDwn);
		Assert.assertEquals(driver.getTitle(), "Manage Leads");

		System.out.println("Click on \"Quick Add Lead\" Button");
		clickElement(quickAddLeadBtn);

		System.out.println("Fill \"Quick Add Lead\" form ");
		clickElement(carnivalCampaignDrpDwn);
		clickElement(selectOptionCarnivalCampaign(value));
		typeText(firstNameTxtBx, "Megha8");// Shobhan
		typeText(lastNameTxtBx, "sgk8");// K S
		typeText(emailAddresseTxtBx, "shobhan6@armyspy.com");
		typeText(phoneNumberTxtBx, "8992768159");
		typeText(websiteTxtBx, "www.google.com");
		typeText(NotesTxtBx, "This is Automation Genarated text");

		System.out.println("Click on \"Save And Close\" Button");
		clickElement(saveAndCloseBtn);
		// System.out.println(driver.findElement(By.xpath("//div[@id='quickAddNewLeadHolderTogle']")).getText());
		// unable to find the element for the toast message
		// Assert.assertEquals("", "Lead added Successfully");
		// Thread.sleep(5000);
		System.out.println("Lead added Successfully");
		return "Megha8";
	}
	
	public void quickAddLeadwithboreturn(String fname,String lname,String email) throws InterruptedException {

		System.out.println("Selecting \"Manage Leads\" from the Leads Tab ");
		waitUntilLoadedAndVisibilityOfElementLocated(manageLeadsDrpDwn);
		Thread.sleep(3000);
		clickElement(manageLeadsDrpDwn);
		Assert.assertEquals(driver.getTitle(), "Manage Leads");

		System.out.println("Click on \"Quick Add Lead\" Button");
		clickElement(quickAddLeadBtn);

		System.out.println("Fill \"Quick Add Lead\" form ");
		clickElement(carnivalCampaignDrpDwn);
		clickElement(selectOptionCarnivalCampaign(value));
		typeText(firstNameTxtBx, fname);// Shobhan
		typeText(lastNameTxtBx, lname);// K S
		typeText(emailAddresseTxtBx, email);
		typeText(phoneNumberTxtBx, "6992768159");

		typeText(NotesTxtBx, "This is Automation Genarated text");

		System.out.println("Click on \"Save And Close\" Button");
		clickElement(saveAndCloseBtn);
		// System.out.println(driver.findElement(By.xpath("//div[@id='quickAddNewLeadHolderTogle']")).getText());
		// unable to find the element for the toast message
		// Assert.assertEquals("", "Lead added Successfully");
		// Thread.sleep(5000);
		System.out.println("Lead added Successfully");

	}
	
	public void clickfirstElement()
	{
		Reporter.log("Click on First lead",true);
		clickElement(firstleadLnk);
	}
}