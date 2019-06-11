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
	private WebElement LPNameTxtBx;

	@FindBy(xpath = "//input[@id='tag-input-box']")
	private WebElement AddMarketTagTxtBx;

	@FindBy(xpath = "//div[@title='Real Estate Luxury Apartment']")
	private WebElement RealEstateImg;

	@FindBy(xpath = "//div[@title='Real Estate Luxury Apartment']/following-sibling::div[contains(.,'SELECT')]")
	private WebElement RealEstateTemplateSelectBtn;

	public void selectTemplate(String lpname, String tagname) {
		System.out.println("Entering the Landing Page Name");
		typeText(LPNameTxtBx, lpname);
		System.out.println("Entering the Landing Page Tag");
		typeText(AddMarketTagTxtBx, tagname);
		System.out.println("MouseOver on the Template");
		mouseHover(RealEstateImg);
		System.out.println("click on the select Button over the template");
		clickElement(RealEstateTemplateSelectBtn);
	}
}
