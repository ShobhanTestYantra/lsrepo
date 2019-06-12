package com.ls.pom.leads.managelist;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.ls.generic.BasePage;

public class ManageListsPage extends BasePage {

	public ManageListsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//li/a[@ href=\"/ManageLists\"]")
	private WebElement managelistDrpDwn;

	@FindBy(xpath = "//div[@id='relatedAction_HR']/descendant::span[text()='Create New List']")
	private WebElement createNewListBtn;

	@FindBy(xpath = "(//a[@title='Show All Items'])[2]")
	private WebElement seleactivityDrpDwn;

	@FindBy(xpath = "//a[text()='Any Activity']")
	private WebElement selectAnyActivityOtn;

	@FindBy(xpath = "//button[@id='btnAddRow']")
	private WebElement addBtn;

	@FindBy(xpath = "//button[text()='Find Leads']")
	private WebElement findleadsBtn;

	@FindBy(xpath = "//a[@id='staticList']")
	private WebElement savestaticListBtn;

	@FindBy(xpath = "//input[@id='Name']")
	private WebElement listNameTxtBx;

	@FindBy(xpath = "//textarea[@id='Description']")
	private WebElement descriptionTxtArea;

	@FindBy(xpath = "//div[@id='saveList']/descendant::button[@id='save' and @class='btn-primary btn']")
	private WebElement saveBtn;
	

    @FindBy(xpath="//tbody/tr/td[@class='grid-col-name ']/descendant::a")
    private List<WebElement> listGrid;
    
    

	public void selectManagelist() {
		Reporter.log("Click on manage list",true);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",managelistDrpDwn );
		Assert.assertEquals(driver.getTitle(), "Manage Lists");
	}

	public void clickCreateNewListButton() {


		Reporter.log("Clicking on create new List Button",true);
		clickElement(createNewListBtn);
	}

	public void selectActivity() throws Exception {
		Thread.sleep(2000);
		Reporter.log("Click on on the select activity arrow",true);
		clickElement(seleactivityDrpDwn);
	
	}
	public void selectAnyActivity() throws InterruptedException {
		Thread.sleep(2000);
		Reporter.log("Click on on the any Activity",true);
		clickElement(selectAnyActivityOtn);
	
	}
	public void clickAddButton() {
		Reporter.log("Click on addBtn",true);
		clickElement(addBtn);

	}

	public void clickFindLeadsButton() {
		Reporter.log("Click on find Leads ",true);
		clickElement(findleadsBtn);
	}

	public void selectsticlist(String listname, String Description) {
		Reporter.log("Click on save static list",true);
		clickElement(savestaticListBtn);
		Reporter.log("enetr the List Name",true);
		typeText(listNameTxtBx, listname);
		Reporter.log("enetr the Description",true);
		typeText(descriptionTxtArea, Description);
	}

	public void clicksaveButton() {
		Reporter.log("Click on save button",true);
		clickElement(saveBtn);
	}
	
	public void verifyListGrid(String listname) throws Exception
	{
		//List<WebElement> ls = driver.findElements(By.xpath("//tbody/tr/td[@class='grid-col-name ']/descendant::a"));
		String arr=null;
		boolean a = false;
	for(int i=0;i<listGrid.size();i++)
	{
//		a=listGrid.contains(elistname);
		//WebDriver wait=new WebDriver
	     arr=listGrid.get(i).getText();
	     Thread.sleep(3000);
	     if(arr.equalsIgnoreCase(listname))
	     {
	    	a=true;
	    	break;
	     }
	   
	    
	}


		Assert.assertTrue(a);
	}
	
	public void clicksaveDyanicList(String listname,String Description)
	{
		Reporter.log("Click on save static list",true);
		clickElement(savestaticListBtn);
		Reporter.log("enetr the List Name",true);
		typeText(listNameTxtBx, listname);
		Reporter.log("enetr the Description",true);
		typeText(descriptionTxtArea, Description);
	}
	

}
