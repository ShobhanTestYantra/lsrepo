package com.ls.pom.profile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ls.generic.BasePage;

public class UserProfilePage extends BasePage {

	public UserProfilePage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "(//ul[@class='mx-top-nav'])[1]")
	private WebElement profileTab;

	@FindBy(xpath = "(//a[contains(.,'Billing')])[1]")
	private WebElement billingLnk;

	@FindBy(xpath = "(//a[contains(.,'Settings')])[2]")
	private WebElement settingsLnk;

	@FindBy(xpath = "(//a[contains(.,' Sign Out')])[1]")
	private WebElement signOutLnk;

	public void hoverToProfileTab() {
		System.out.println("Go to the Profile Tab  ");
		mouseHover(profileTab);
	}

	public void clkbillingLnk() {
		System.out.println("Go to the Profile Tab  ");
		clickElement(billingLnk);
	}

	public void clkSettingsLnk() {
		System.out.println("click on Settings Link");
		clickElement(settingsLnk);
	}

	public void clkSignOutLnk() {
		System.out.println("click on SignOut Link");
		clickElement(signOutLnk);
	}
}
