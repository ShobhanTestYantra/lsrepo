package com.ls.pom.settings.usersandpermissions;

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
	
	@FindBy(xpath="")
	private WebElement createBtn;
	
	@FindBy(id="FirstName")
	private WebElement firstNameTxtBx;
	
	@FindBy(id="LastName")
	private WebElement lastNameTxtBx;
	
	@FindBy(id="EmailAddress")
	private WebElement emailAddressTxtBx;
	
	@FindBy(xpath="//input[@class='ui-widget-content ui-autocomplete-input']")
	private WebElement phoneTxtBx;
	
	@FindBy(xpath="//span[@class='custom-combobox']")
	private WebElement reportingToTxtBx;
	
	@FindBy(xpath="//button[.='Create User']")
	private WebElement createUserBtn;

	@FindBy(xpath="//div[@class='alert-message']")
	private WebElement toastMsg;
		
	public void clkCreateUser() {
		clickElement(createBtn);	
	}
	
	public void fillCreateUserform() {
		clickElement(createBtn);	
	}
}
