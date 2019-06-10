package com.ls.pom.content.imgdocs;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.ls.generic.BasePage;

public class DocumentLibraryPage extends BasePage {

	public DocumentLibraryPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
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
			System.out.println(" Uploading File...");
			upload(filePath);
			
		} catch (InterruptedException | AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("File is not uploaded");
		}
		Thread.sleep(10000);
//		typeText(searchtxtBx, fileName);
//		clickElement(searchIcon);
		System.out.println("Checking for uploaded File ");
		waitUntilLoadedAndVisibilityOfElementLocated(fileIcon);
		String value = fileIcon.getText();
		String[] arr = value.split("/");
		System.out.println("Verifying the File  presence");
		Assert.assertTrue(arr[(arr.length - 1)].contains(fileName), "Uploaded file is not displayed");
	}
}
