package com.ls.pom.marketing.landingpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ls.generic.BasePage;

public class SelectTemplatePage extends BasePage {

	public SelectTemplatePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='Name']")
	private WebElement lpnameTxtBx;

	@FindBy(xpath = "//input[@id='tag-input-box']")
	private WebElement addMarkettagTxtBx;

	@FindBy(xpath = "//div[@title='Real Estate Luxury Apartment']")
	private WebElement realEstateImg;

	@FindBy(xpath = "//div[@title='Real Estate Luxury Apartment']/following-sibling::div[contains(.,'SELECT')]")
	private WebElement realEstateTemplateselectBtn;

	public void enterlandingPageName(String lpname, String tagname) {
		System.out.println("Entering the Landing Page Name after clearing the default name");
		lpnameTxtBx.clear();
		typeText(lpnameTxtBx, lpname);
		System.out.println("Entering the Landing Page Tag");
		typeText(addMarkettagTxtBx, tagname);
		System.out.println("MouseOver on the Template");
	}
	public void selectTemplate()
	{
		mouseHover(realEstateImg);
		System.out.println("click on the select Button over the template");
		clickElement(realEstateTemplateselectBtn);
	}
}
