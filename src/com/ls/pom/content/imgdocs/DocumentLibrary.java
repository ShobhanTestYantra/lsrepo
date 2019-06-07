package com.ls.pom.content.imgdocs;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.ls.generic.BasePage;

public class DocumentLibrary extends BasePage {

	public DocumentLibrary(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[.=' Images & Documents']")
	private WebElement imagesAndDocumentsDrpDwn;

	@FindBy(xpath = "//a[contains(.,'Document Library')]")
	private WebElement documentLibraryLnk;

	@FindBy(xpath = "//a[.='Upload Files']")
	private WebElement uploadFilesBtn;

	@FindBy(xpath = "//div[@class='ajax-upload-dragdrop']/div")
	private WebElement uploadBtn;

	@FindBy(id = "searchfile")
	private WebElement searchtxtBx;

	@FindBy(xpath = "//span[@data-tool-component='searchbutton']")
	private WebElement searchIcon;

	@FindBy(xpath = "(//div[@class='item-name'])[1]")
	private WebElement fileIcon;

	/**
	 * @author ShobhanKS
	 * @description upload and verify File present
	 * @param imagePath
	 * @throws InterruptedException
	 * @throws AWTException
	 * 
	 */
	public void uploadFiles() throws InterruptedException {

		String filePath = System.getProperty("user.dir") + "\\inputTestData\\10mb2.txt";
		String fileName = "10mb2.txt";
		waitUntilLoadedAndVisibilityOfElementLocated(imagesAndDocumentsDrpDwn);
		clickElement(imagesAndDocumentsDrpDwn);
		clickElement(documentLibraryLnk);
		clickElement(uploadFilesBtn);
		clickElement(uploadBtn);
		Thread.sleep(2000);

		try {
			upload(filePath);
			
		} catch (InterruptedException | AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("File is not uploaded");
		}
		Thread.sleep(10000);
		System.out.println("search the uploaded file is present ");
		typeText(searchtxtBx, fileName);
		clickElement(searchIcon);
		waitUntilLoadedAndVisibilityOfElementLocated(fileIcon);
		String value = fileIcon.getText();
		String[] arr = value.split("/");
		System.out.println("Verifying the image presence");
		Assert.assertTrue(arr[(arr.length - 1)].contains(fileName), "Uploaded file is not displayed");

	}
}
