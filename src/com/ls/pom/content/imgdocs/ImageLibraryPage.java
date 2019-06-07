package com.ls.pom.content.imgdocs;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.ls.generic.BasePage;

public class ImageLibraryPage extends BasePage {
  
	String blankpagetxt = "No images found.";
	String folderName=	"TYSSFolder2";
	String imagePath = System.getProperty("user.dir") + "\\inputTestData\\Image_Testdata2_JPG.jpg";
	String imageName = "Image_Testdata2_JPG.jpg";
	
		
	public ImageLibraryPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[.=' Images & Documents']")
	private WebElement imagesAndDocumentsDrpDwn;
	
	
	@FindBy(xpath = "//div[@class='no-item']/h3[1]")
	private WebElement NoImagesFoundTxt ;
	
	@FindBy(xpath = "//a[.='Upload Images']")
	private WebElement uploadImagesBtn;

	@FindBy(xpath = "//div[@class='ajax-upload-dragdrop']/div")
	private WebElement uploadBtn;

	@FindBy(id = "searchfile")
	private WebElement searchtxtBx;

	@FindBy(xpath = "//span[@data-tool-component='searchbutton']")
	private WebElement searchIcon;

	@FindBy(xpath = "(//img[@data-type='thumbnail'])[1]")
	private WebElement imageIcon;

	@FindBy(xpath = "//a[@onclick='OpenManageFoldersPopup()']")
	private WebElement manageFoldersBtn;

	@FindBy(xpath = "//span[.='Add folder']")
	private WebElement addFolderBtn;

	@FindBy(xpath = "//input[@id='NewFolderName']")
	private WebElement newFolderTxtBx;

	@FindBy(xpath = "//span[@class='icon-save pull-right heading-popover']")
	private WebElement saveIcon;

	@FindBy(xpath = "//div[@class='alert-message']")
	private WebElement toastMsg;

	
	@FindBy(xpath = "//a[@class='close-link']")
	private WebElement closeLnk;
		
	@FindBy(xpath = "//span[contains(.,'All folders') and @class='ui-selectmenu-status']")
	private WebElement addFolderDrpDwn;
		
	public WebElement selectOption(String value)
	{
		String xpath="//li[@role='presentation']/a[.='"+value+"']";
		return  driver.findElement(By.xpath(xpath));
	}
	
	
	/**
	 * @author ShobhanKS
	 * @description upload and verify Image present
	 * @param imagePath
	 * @throws InterruptedException
	 * 
	 */
	public void uploadImage() throws InterruptedException {

	
		waitUntilLoadedAndVisibilityOfElementLocated(imagesAndDocumentsDrpDwn);
		clickElement(imagesAndDocumentsDrpDwn);
		Assert.assertEquals(NoImagesFoundTxt.getText(), blankpagetxt);
		clickElement(uploadImagesBtn);
		System.out.println("Uploading the Image");
		// waitUntilLoadedAndVisibilityOfElementLocated(uploadBtn);
		Thread.sleep(2000);
		clickElement(uploadBtn);
		try {
			upload(imagePath);
			Thread.sleep(3000);
		} catch (InterruptedException | AWTException e) {
			e.printStackTrace();
			System.out.println("image is not uploaded");
		}
		System.out.println("search the uploaded image is present ");
//		typeText(searchtxtBx, imageName);
//		clickElement(searchIcon);
		waitUntilLoadedAndVisibilityOfElementLocated(imageIcon);
		String value = imageIcon.getAttribute("src");
		String[] arr = value.split("/");
		System.out.println(" Verifying the file presence");
		Assert.assertTrue(arr[(arr.length - 1)].contains(imageName), "Uploaded image is not displayed");
		// Assert.assertTrue(imageIcon.isDisplayed(), "Uploaded image is not displayed"
		// );
	}

	/**
	 * @author ShobhanKS
	 * @description create folder and and verify the Toast message
	 */
	public void createAndverifyFolder() {
		
		clickElement(imagesAndDocumentsDrpDwn);
		waitUntilLoadedAndVisibilityOfElementLocated(manageFoldersBtn);
		clickElement(manageFoldersBtn);
		System.out.println("Creating the folder ");
		clickElement(addFolderBtn);
		typeText(newFolderTxtBx, "TYSSFolder");
		clickElement(saveIcon);
		System.out.println(" Verifying the Toast message");
		Assert.assertEquals(toastMsg.getText(), "Folder is added successfully.",
				"Toast message is not Displayed correctly");
	}

	
	/**
	 * @author ShobhanKS
	 * @throws InterruptedException 
	 * @description create folder and and verify the Toast message
	 */
	public void createFolderUploadImage() throws InterruptedException {
		
		clickElement(imagesAndDocumentsDrpDwn);
		waitUntilLoadedAndVisibilityOfElementLocated(manageFoldersBtn);
		clickElement(manageFoldersBtn);
		System.out.println("Creating the folder ");
		clickElement(addFolderBtn);
		typeText(newFolderTxtBx, folderName );
		clickElement(saveIcon);
		System.out.println("Verifying the Toast message");
		clickElement(closeLnk);
		clickElement(addFolderDrpDwn);
		clickElement(selectOption(folderName));
		clickElement(uploadImagesBtn);
		System.out.println("Uploading the Image");
		// waitUntilLoadedAndVisibilityOfElementLocated(uploadBtn);
		Thread.sleep(2000);
		clickElement(uploadBtn);
		try {
			upload(imagePath);
			Thread.sleep(3000);
		} catch (InterruptedException | AWTException e) {
			e.printStackTrace();
			System.out.println("image is not uploaded");
		}
		System.out.println("search the uploaded image is present ");
//		typeText(searchtxtBx, imageName);
//		clickElement(searchIcon);
		waitUntilLoadedAndVisibilityOfElementLocated(imageIcon);
		String value = imageIcon.getAttribute("src");
		String[] arr = value.split("/");
		System.out.println("Verifying the file presence");
		Assert.assertTrue(arr[(arr.length - 1)].contains(imageName), "Uploaded image is not displayed");
	
	}
	


	
}
