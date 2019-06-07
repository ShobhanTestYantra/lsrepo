package com.ls.pom.lead.manageleads;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ls.generic.BasePage;

public class ManageLeads extends BasePage {

	public ManageLeads(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//a[.=' Images & Documents']")
	private WebElement imagesAndDocumentsDrpDwn;
	
}
