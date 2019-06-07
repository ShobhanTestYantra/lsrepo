package com.ls.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ls.generic.BasePage;

public class LoginPage extends BasePage {


	//By userNameTB = By.xpath("//input[@id='__xmlview1--userName-inner']");
	// passwordTB = By.xpath("//input[@id='__xmlview1--password-inner']");
	//By clkDropdown = By.xpath("//span[@id='__xmlview1--site-arrow']");
	//By clkTSK = By.xpath("//*[@id='__item4'][text()='TSK']");
	//By clkLogin = By.xpath("//bdi[text()='Log In']");

	
	@FindBy(id="EmailID")
	private WebElement userNameTxtBx;
	
	@FindBy(id="Password")
	private WebElement passwordTxtBx;

	@FindBy(id="login")
	private WebElement loginBtn;


	public LoginPage(WebDriver driver) {
      super(driver);
	}
	
	public void testLogin(String username, String password) {
    typeText(userNameTxtBx, username);
    typeText(passwordTxtBx, password);
    clickElement(loginBtn);
	}

}
