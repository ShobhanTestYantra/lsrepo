package com.ls.pom.leads.managelist;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.ls.generic.BasePage;


public class ManageListsPage extends BasePage{

	public ManageListsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
@FindBy(xpath="//li/a[@ href=\"/ManageLists\"]")
private WebElement ManagelistDrpDwn;

@FindBy(xpath="//div[@id='relatedAction_HR']/descendant::span[text()='Create New List']")
private WebElement createNewListBtn;

@FindBy(xpath="//ul[@id='ui-id-168']/following-sibling::a[@title='Show All Items']")
private WebElement seleactivityDrpDwn;

@FindBy(xpath="//ul[@id='ui-id-168']/descendant::a[text()='Any Activity']")
private WebElement selectAnyActivityOtn;

@FindBy(xpath="//button[@id='btnAddRow']")
private WebElement addBtn;

@FindBy(xpath="//button[text()='Find Leads']")
private WebElement findleadsBtn;

@FindBy(xpath="//a[@id='staticList']")
private WebElement savestaticListBtn;

@FindBy(xpath="//input[@id='Name']")
private WebElement listNameTxtBx;

@FindBy(xpath="//textarea[@id='Description']")
private WebElement descriptionTxtArea;

@FindBy(xpath="//div[@id='saveList']/descendant::button[@id='save' and @class='btn-primary btn']")
private WebElement saveBtn;

public void selectManagelist()
{
	Reporter.log("Click on manage list");
	clickElement(ManagelistDrpDwn);
}
public void clickCreateNewListButton()
{
//	try {
//		Thread.sleep(5000);
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}

	
   Reporter.log("Clicking on create new List Button");
    clickElement(createNewListBtn);

}
public void selectActivity()
{
	Reporter.log("Click on on the select activity arrow");
	clickElement(seleactivityDrpDwn);
	Select select=new Select(selectAnyActivityOtn);
	
}
public void clickAddButton()
{
	Reporter.log("Click on addBtn");
	clickElement(addBtn);
	
}
public void clickFindLeadsButton()
{
	Reporter.log("Click on find Leads ");
	clickElement(findleadsBtn);
	
}
public void selectsticlist(String listname,String Description)
{
	Reporter.log("Click on save static list");
	clickElement(savestaticListBtn);
	Reporter.log("enetr the List Name");
	typeText(listNameTxtBx, listname);
	Reporter.log("enetr the Description");
	typeText(descriptionTxtArea, Description);
	
}
public void clicksaveButton()
{
	Reporter.log("Click on save button");
	clickElement(saveBtn);
}

}
