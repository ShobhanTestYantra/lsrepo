package com.ls.pom.settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ls.generic.BasePage;

public class SettingsPage extends BasePage {

	public SettingsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[text()='Profile']/parent::a")
	private WebElement profileLnk;

	@FindBy(xpath = "//span[text()='Users and Permissions']/parent::a")
	private WebElement usersAndPermissionsLnk;

	@FindBy(xpath = "//span[text()='Security']/parent::a")
	private WebElement securityLnk;

	@FindBy(xpath = "//span[text()='Customization']/parent::a")
	private WebElement customizationLnk;

	@FindBy(xpath = "//span[text()='Mobile App']/parent::a")
	private WebElement mobileAppLnk;

	@FindBy(xpath = "//span[text()='Lead Tracking']/parent::a")
	private WebElement leadTrackingLnk;

	@FindBy(xpath = "//span[text()='Lead Prioritization']/parent::a")
	private WebElement leadPrioritizationLnk;

	@FindBy(xpath = "//span[text()='Email Settings']/parent::a")
	private WebElement emailSettingsLnk;

	@FindBy(xpath = "//span[text()='API and Webhooks']/parent::a")
	private WebElement aPIAndWebhooksLnk;

	@FindBy(xpath = "//span[text()='Rules and Notifications']/parent::a")
	private WebElement rulesAndNotificationsLnk;

	@FindBy(xpath = "//span[text()='Data Protection & Privacy']/parent::a")
	private WebElement dataProtectionAndPrivacyLnk;

	public void clkProfileLink() {
		System.out.println("Go to Profile");
		clickElement(profileLnk);
	}

	public void clkUsersAndPermissionsLink() {
		System.out.println("Go to Users And Permissions");
		clickElement(usersAndPermissionsLnk);
	}

	public void clkSecurityLink() {
		System.out.println("Go to Security");
		clickElement(securityLnk);
	}

	public void clkCustomizationLink() {
		System.out.println("Go to Customization");
		clickElement(customizationLnk);
	}

	public void clkMobileAppLink() {
		System.out.println("Go to Mobile App ");
		clickElement(mobileAppLnk);
	}

	public void clkLeadTrackingLink() {
		System.out.println("Go to Lead Tracking");
		clickElement(leadTrackingLnk);
	}

	public void clkLeadPrioritizationLink() {
		System.out.println("Go to Lead Prioritization");
		clickElement(leadPrioritizationLnk);
	}

	public void clkEmailSettingsLink() {
		System.out.println("Go to Email Settings");
		clickElement(emailSettingsLnk);
	}

	public void clkAPIAndWebhooksLink() {
		System.out.println("Go to API And Webhooks");
		clickElement(aPIAndWebhooksLnk);
	}

	public void clkRulesAndNotificationsLnk() {
		clickElement(rulesAndNotificationsLnk);
	}

	public void clkDataProtectionAndPrivacyLnk() {
		clickElement(dataProtectionAndPrivacyLnk);
	}
}
