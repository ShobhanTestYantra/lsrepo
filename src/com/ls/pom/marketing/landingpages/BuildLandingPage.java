package com.ls.pom.marketing.landingpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import com.ls.generic.BasePage;

public class BuildLandingPage extends BasePage {

	public BuildLandingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//button[text()='Publish']")
	private WebElement publishBtn;

	@FindBy(id = "ButtonOk")
	private WebElement publishconfirmBtn;

	@FindBy(xpath = "//div[@id='ConfirmPopupBody']/descendant::div[@id='FinishMessage']")
	private WebElement aMsg;

	@FindBy(xpath = "//button[@id='GotoList']")
	private WebElement getListBtn;

	@FindBy(xpath = "//div[@id='http-lp-url']/descendant::a")
	private WebElement confirmurlLnk;

	public void clickpublishBtn(int value) {
		System.out.println("Scroll down to the publish button");
		scrollwithvalue(value);
		System.out.println("click on  publish button");
		clickElement(publishBtn);
	}

	public void clickconfirmpublishBtn() {
		System.out.println("click on confirm publish");

		clickElement(publishconfirmBtn);
	}

	public void verifymessage(String emsg) throws Exception {

		Reporter.log("Verify the confirmation Message");
		Thread.sleep(3000);
		String amsg = aMsg.getText();
		Thread.sleep(3000);
		Assert.assertEquals(amsg, emsg);

	}

	public void clickGetListBtn() {
		System.out.println("click on confirm publish");

		clickElement(getListBtn);

	}

	public void clickconfirmUrl() {
		System.out.println("click on confirm Url Lnk");

		clickElement(confirmurlLnk);

	}

}
