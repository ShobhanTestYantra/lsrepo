package com.ls.pom.leads.managetasks;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.ls.generic.BasePage;

public class ManageTasksPage extends BasePage {

	public ManageTasksPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//li/a[contains(.,'Manage Tasks')]")
	private WebElement manageTasksDrpDwn;

	@FindBy(xpath = "//button[@type='button']//span[.='Create Task']")
	private WebElement createTaskBtn;

	@FindBy(xpath = "(//label[.='Calendar Invite'])[1]")
	private WebElement calendarInvite1Btn;

	@FindBy(xpath = "//div[@id='lead-control']/descendant::input[@type='text' and @placeholder='Type to Search']")
	private WebElement associatedLeadTxtBx;

	@FindBy(xpath = "(//label[.='Calendar Invite'])[2]")
	private WebElement calendarInvite2Btn;

	@FindBy(xpath = "//label[@title='Subject']/../..//input")
	private WebElement subjectTxtBx;

	@FindBy(xpath = "//label[@title='Location']/../..//input" + "")
	private WebElement locationTxtBx;

	@FindBy(xpath = "//label[@title='Description']/../..//textarea")
	private WebElement descriptionTxtBx;

	@FindBy(xpath = "(//label[.='Calendar Invite'])[3]")
	private WebElement calendarInvite3Btn;

	@FindBy(xpath = "//button[.='Save']")
	private WebElement saveBtn;

	@FindBy(xpath = "//div[@class='alert-message']")
	private WebElement toastMsg;

	/**
	 * @author ShobhanKS
	 * @description Clicking on the Task dropdown
	 */
	public void clickOnmanageTasksDrpDwn() {
		System.out.println("Clicking on the Task dropdown");
		waitUntilLoadedAndVisibilityOfElementLocated(manageTasksDrpDwn);
		clickElement(manageTasksDrpDwn);
		System.out.println("Verifying user is in the Task Page");
		Assert.assertEquals(driver.getTitle(), "Tasks", "User is not present in the Tasks Page");
	}

	/**
	 * @author ShobhanKS
	 * @desription Creating New Task
	 * @param leadName
	 * @throws InterruptedException
	 */
	public void createTask(String leadName) throws InterruptedException {
		System.out.println("Clicking on the Create Task button");
		waitUntilLoadedAndVisibilityOfElementLocated(createTaskBtn);
		clickElement(createTaskBtn);
		System.out.println("Fill all the details ");
		clickElement(calendarInvite1Btn);
		clickElement(associatedLeadTxtBx);
		Thread.sleep(2000);
		typeText(associatedLeadTxtBx, leadName);
		Thread.sleep(2000);
		associatedLeadTxtBx.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		associatedLeadTxtBx.sendKeys(Keys.ENTER);
		clickElement(calendarInvite2Btn);
		// associatedLeadTxtBx.sendKeys(Keys.ENTER);
		clickElement(subjectTxtBx);
		typeText(subjectTxtBx, "Automation TestSubject");
		typeText(locationTxtBx, "TestLoaction: bangalore ");
		typeText(descriptionTxtBx, "Automation TestDescription");
		clickElement(calendarInvite3Btn);
		System.out.println("Click on Save button");
		clickElement(saveBtn);
		Assert.assertEquals(toastMsg.getText(), "Task created successfully.");
		System.out.println(toastMsg.getText());
	}
}
