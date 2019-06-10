package com.ls.pom.marketing.landingpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.ls.generic.BasePage;

public class LandingPages extends BasePage {

	public LandingPages(WebDriver driver) {
		super(driver);
	}
	/* Create landing Page Burtton */

	@FindBy(xpath = "//div[@id='relatedAction_HR']/descendant::span[text()='Create Landing Page']")
	private WebElement createlpBtn;

	@FindBy(xpath = "//li[@class='dropdown' ]/a[contains(.,'Marketing')]/following-sibling::ul/descendant::a[text()=' Landing Pages']")
	private WebElement landingpagesDrpDwn;

	@FindBy(xpath = "//button[@class='dropdown-toggle settings-icon']")
	private WebElement actinsettingIcon;

	@FindBy(xpath = "//ul[@class='dropdown-menu']/descendant::a[text()='UnPublish']")
	private WebElement unpublishIcon;

	@FindBy(xpath = "//div[@class='modal-footer']/button[text()='Unpublish']")
	private WebElement unpublishBtn;

	@FindBy(xpath = "//div[@id='ConfirmPopupBody']/descendant::div[@id='FinishMessage']")
	private WebElement unpublishMsg;

	// div[@id='ConfirmPopupBody']/descendant::div[@id='FinishMessage']
	/**
	 * @author Shreya
	 * @description Clicking on the landing Page in DropDown
	 * 
	 * 
	 */

	public void selectLandingpages() {
		System.out.println("Click on create Landing Page DrpDwn ");

		landingpagesDrpDwn.click();
	}

	/**
	 * @author Shreya
	 * @description Clicking on the create landing Page
	 * 
	 * 
	 */
	public void clickCreateLPButton() {
		System.out.println("Click on create Landing Page Button ");
		createlpBtn.click();
	}

	public void mouseoverActionSettingIcon() {
		System.out.println("Click on Action Setting Button ");
		mouseHover(actinsettingIcon);
	}

	public void verifyUnpublish(String emsg) throws Exception

	{
		System.out.println("Click on Action Setting Button ");
		clickElement(unpublishIcon);
		clickElement(unpublishBtn);
		Thread.sleep(3000);
		String amsg = unpublishMsg.getText();
		Thread.sleep(3000);
		Assert.assertEquals(amsg, emsg);
	}

}
