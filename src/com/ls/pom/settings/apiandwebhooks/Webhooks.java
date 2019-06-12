package com.ls.pom.settings.apiandwebhooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ls.generic.BasePage;

public class Webhooks extends BasePage {

	public Webhooks(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[.='Webhooks' and @id='childSubMenu1052']")
	private WebElement webhooksLnk;

	@FindBy(xpath = "//button[.='Create' and @id='edit']")
	private WebElement createBtn;

	@FindBy(xpath = "//label[.='Event']/../../..//span[@class='t-input']")
	private WebElement eventBtn;

	@FindBy(xpath = "//li[.='Lead Creation' and @class='t-item']")
	private WebElement selectLeadCreationEventOtn;

	@FindBy(xpath = "//label[.='Webhook URL']/../../..//input[@class='no-curved-border']")
	private WebElement webhookURLTxtBx;

	@FindBy(xpath = "//label[.='Description']/../../..//textarea[@class='no-curved-border']")
	private WebElement descriptionTxtBx;
	
	@FindBy(xpath="//button[@class='dropdown-toggle settings-icon']")
	private WebElement actionsettingIcon;

	@FindBy(xpath="//a[text()='View History']")
	private WebElement viewhistoryIcon;

	@FindBy(id="save")
	private WebElement saveBtn;

	public void clkWebhooksLink() {
		System.out.println("click on Webhooks Link");
		clickElement(webhooksLnk);
	}

	public void clkCreate() {
		System.out.println("click on 'Create' button");
		clickElement(createBtn);
	}

	public void addWebhook() throws InterruptedException {
		System.out.println("adding Webhook");
		clickElement(eventBtn);
		Thread.sleep(3000);
		clickElement(selectLeadCreationEventOtn);
		typeText(webhookURLTxtBx, "jsonplaceholder.typicode.com/todos/1");
		typeText(descriptionTxtBx, "Automation generated text");
		waitTillPageLoad();
		scrollwithvalue(600);
		waitUntilLoadedAndVisibilityOfElementLocated(saveBtn);
		clickElement(saveBtn);
		mouseHover(actionsettingIcon);
	}
}
