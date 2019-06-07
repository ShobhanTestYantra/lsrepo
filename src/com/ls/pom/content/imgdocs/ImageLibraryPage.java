package com.ls.pom.content.imgdocs;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ls.generic.BasePage;

public class ImageLibraryPage extends BasePage {

	public ImageLibraryPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[.=' Images & Documents']")
	private WebElement imagesAndDocumentsDrpDwn;

	@FindBy(xpath = "//a[.='Upload Images']")
	private WebElement uploadImagesBtn;

	@FindBy(xpath = "//button[contains(.,'Upload')]")
	private WebElement uploadBtn;

	/**
	 * @author ShobhanKS
	 * @description upload and verify Image present
	 * @param imagePath
	 * 
	 */
	public void uploadImage(String imagePath) {
		imagesAndDocumentsDrpDwn.click();
		uploadImagesBtn.click();
		System.out.println("Uploading the Image");
		waitUntilLoadedAndVisibilityOfElementLocated(uploadBtn);
		uploadBtn.click();
		try {
			upload(imagePath);
		} catch (InterruptedException | AWTException e) {
			e.printStackTrace();
		}

	}

}
