package com.ls.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	 public WebDriver driver;
	WebDriverWait wait;


	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// To click on the required element
	public void clickElement(WebElement element) {
		element.click();
	}

	// To enter Required String in the textbox
	public void typeText(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	
}
