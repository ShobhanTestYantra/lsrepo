package com.ls.pom.content.imgdocs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ls.generic.BasePage;

public class DocumentLibrary extends BasePage {

	public DocumentLibrary(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[.=' Images & Documents']")
	private WebElement imagesAndDocumentsDrpDwn;

}
