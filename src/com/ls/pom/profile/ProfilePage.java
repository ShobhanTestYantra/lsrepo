package com.ls.pom.profile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ls.generic.BasePage;

public class ProfilePage extends BasePage {

	public ProfilePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(xpath = "(//ul[@class='mx-top-nav'])[1]")
	private WebElement ProfileTab;

	//tba billing
	
	@FindBy(xpath="(//a[contains(.,'Settings')])[2]")
	private WebElement settingsLnk;
	
	//tba logout
	
	public void hoverToProfileTab() {
		System.out.println("Go to the Profile Tab  ");
		mouseHover(ProfileTab);

	}
	
	//tba billing
	
	public void clickSettings() {
		clickElement(settingsLnk);
	}
	
	//tba logout
	
	
	
}
