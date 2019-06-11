package com.ls.pom.settings.usersandpermissions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ls.generic.BasePage;

public class UsersPage extends BasePage {

	public UsersPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//a[text()='Users']")
	private WebElement userLnk;
	
	@FindBy(id="createUser")
	private WebElement createBtn;
	
	@FindBy(id="FirstName")
	private WebElement firstNameTxtBx;
	
	@FindBy(id="LastName")
	private WebElement lastNameTxtBx;
	
	@FindBy(id="EmailAddress")
	private WebElement emailAddressTxtBx;
	
	@FindBy(xpath="//input[@class='ui-widget-content ui-autocomplete-input']")
	private WebElement phoneTxtBx;
	
	@FindBy(xpath="//span[@class='custom-combobox']/input")
	private WebElement reportingToTxtBx;
	
	@FindBy(xpath="//button[.='Create User']")
	private WebElement createUserBtn;

	@FindBy(xpath="//div[@class='alert-message']")
	private WebElement toastMsg;
	
	public void clkUserLnk() {
		System.out.println("Click on user Link");
		clickElement(userLnk);	
	}
	
	public void clkCreate() {
		System.out.println("Click on create Button ");
		clickElement(createBtn);	
	}
	
	public void fillCreateUserform(String email) throws InterruptedException {
		System.out.println("Fill Create User form");
		typeText(firstNameTxtBx, "Rohith");
		typeText(lastNameTxtBx, "Ln");
		typeText(emailAddressTxtBx, email); 
		typeText(phoneTxtBx, "+91-8892768161");  
		clickElement(reportingToTxtBx);
		Thread.sleep(2000);
		typeText(reportingToTxtBx, "Shobhan K S");
		Thread.sleep(2000);
		reportingToTxtBx.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		reportingToTxtBx.sendKeys(Keys.ENTER);	
		clickElement(createUserBtn);
		Thread.sleep(3000);
		assertEquals(toastMsg.getText(),"User created successfully! Invitation has been sent to "+email);
	}
}
