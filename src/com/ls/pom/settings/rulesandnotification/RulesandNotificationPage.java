package com.ls.pom.settings.rulesandnotification;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import com.ls.generic.BasePage;

public class RulesandNotificationPage extends BasePage {

	public RulesandNotificationPage(WebDriver driver) {
		super(driver);
	}
//@FindBy(xpath="//span[text()='Rules and Notifications']/parent::a")
//private WebElement rulesandnotificationLnk;

@FindBy(id="action")
private WebElement createBtn;

@FindBy(xpath="//span[text()='Set Conditions']/parent::button")
private WebElement SetConditionsBtn;

@FindBy(xpath="//span[contains(.,'Provide Action Details')]/parent::button")
private WebElement provideactiondetailsBtn;

@FindBy(xpath="//span[contains(.,'Send Email')]/parent::a[1]")
private WebElement actiontypeDrpDwn;

@FindBy(xpath="(//a[contains(.,'Add Activity')])[1]")
private WebElement addactivityOpt;


@FindBy(xpath="//span[@class='span1 action-edit']")
private WebElement editIcon;


@FindBy(xpath="//a[@id='ActivityEventName-button']")
private WebElement selectActivityDrpDwn;

@FindBy(xpath="//a[text()='Meeting']")
private WebElement meetingOpt;


@FindBy(xpath="//button[@id='saveActivity']")
private WebElement saveBtn;


@FindBy(xpath="//span[text()='Provide Additional Details']/parent::button")
private WebElement provideadditonaldetailsBtn;

@FindBy(xpath="//input[@id='Name']")
private WebElement nameTxtBx;


@FindBy(xpath="//span[.='Save and Enable']/parent::button")
private WebElement saveandenableBtn;

@FindBy(xpath="//button[@class='dropdown-toggle settings-icon']")
private WebElement actionsettingIcon;

@FindBy(xpath="//a[text()='View History']")
private WebElement viewhistoryIcon;

@FindBy(xpath="//a[text()=' Show']")
private WebElement showIcon;

@FindBy(xpath="(//tbody/tr/td[3]/div[@class='rulefield-holder'])[3]")
private WebElement emailTxt;

public void createRule(String rulename) throws Exception
{
	Assert.assertEquals(driver.getTitle(), "Settings: Rules and Notifications");
	Thread.sleep(4000);
	boolean s = createBtn.isDisplayed();
	System.out.println(s);
	Thread.sleep(7000);
	Reporter.log("Click on create Button", true);
	waitUntilLoadedAndVisibilityOfElementLocated(createBtn);
	waitTillPageLoad();
	clickElement(createBtn);
	Reporter.log("Click on setConditions Button", true);
	Thread.sleep(3000);
	clickElement(SetConditionsBtn);
	Reporter.log("Click on provide action details Button", true);
	Thread.sleep(3000);
	clickElement(provideactiondetailsBtn);
	Reporter.log("Click on provide action Type Drop Down", true);
	Thread.sleep(3000);
	clickElement(actiontypeDrpDwn);
	Reporter.log("select the add activity", true);
	Thread.sleep(3000);
	clickElement(addactivityOpt);
	Reporter.log("select the edit Icon", true);
	Thread.sleep(3000);
	clickElement(editIcon);
	Reporter.log("select the selectActivityDrpDwn", true);
	Thread.sleep(3000);
	clickElement(selectActivityDrpDwn);
	Reporter.log("select the meeting Option", true);
	Thread.sleep(3000);
	clickElement(meetingOpt);
	Reporter.log("click on save Button", true);
	Thread.sleep(3000);
	clickElement(saveBtn);
	Reporter.log("Click ON PROVIDE Action Details Button", true);
	Thread.sleep(3000);
	clickElement(provideadditonaldetailsBtn);
	Reporter.log("Enter the rule name", true);
	Thread.sleep(3000);
	nameTxtBx.clear();
	typeText(nameTxtBx, rulename);
	Reporter.log("Clickon save and enable Button", true);
	Thread.sleep(3000);
	clickElement(saveandenableBtn);
	
	
	
}
public void verifyrule(String eemail) throws Exception
{
	Reporter.log("Click on Select Activity DropDown", true);
	Thread.sleep(3000);
	clickElement(actionsettingIcon);
	Reporter.log("Clickon view History Icon", true);
	Thread.sleep(3000);
	clickElement(viewhistoryIcon);
	refreshPage();
	Reporter.log("Clickon view show Icon", true);
	Thread.sleep(3000);
	clickElement(showIcon);
    String aemail=	emailTxt.getText();
    Assert.assertEquals(aemail, eemail);
    
    
	
}
}
