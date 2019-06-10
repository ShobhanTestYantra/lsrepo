package com.ls.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.ls.generic.BasePage;

public class LoginPage extends BasePage {

	@FindBy(id = "EmailID")
	private WebElement userNameTxtBx;

	@FindBy(id = "Password")
	private WebElement passwordTxtBx;

	@FindBy(id = "login")
	private WebElement loginBtn;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * @author ShobhanKS
	 * @description Logging to the Application 
	 * @param username
	 * @param password
	 */
	public void testLogin(String username, String password) {
		
		Assert.assertEquals(driver.getTitle(),"LeadSquared Application");
		System.out.println("Login to the LS Application with valid credentails");
		typeText(userNameTxtBx, username);
		typeText(passwordTxtBx, password);
		clickElement(loginBtn);
		Assert.assertEquals(driver.getTitle(),"Administrator Dashboard");
	}

}
