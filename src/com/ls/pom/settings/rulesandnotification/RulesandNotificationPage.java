package com.ls.pom.settings.rulesandnotification;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ls.generic.BasePage;

public class RulesandNotificationPage extends BasePage {

	public RulesandNotificationPage(WebDriver driver) {
		super(driver);
	}
@FindBy(xpath="//span[text()='Rules and Notifications']/parent::a")
private WebElement rulesandnotificationLnk;

@FindBy(xpath="//button[contains(.,'Create') and@id='createButton']")
private WebElement createBtn;

@FindBy(xpath="//span[text()='Set Conditions']/parent::button")
private WebElement SetConditionsBtn;

@FindBy(xpath="//span[contains(.,'Provide Action Details')]/parent::button")
private WebElement provideactiondetailsBtn;

@FindBy(xpath="//span[contains(.,'Send Email')]/parent::a[1]")
private WebElement actiontypeDrpDwn;

@FindBy(xpath="(//a[contains(.,'Add Activity')])[1]")
private WebElement addactionOpt;



}
