package com.ls.test;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ls.generic.BaseTest;
import com.ls.generic.UtilityConstants;
import com.ls.pom.LoginPage;
import com.ls.pom.leads.managelist.ManageListsPage;

public class TC_021 extends BaseTest {
	@Test
	public void testsaveStaticList() throws Exception {
		ManageListsPage m1 = new ManageListsPage(driver);
		LoginPage l1 = new LoginPage(driver);

		Reporter.log("Enter Email.id  and password in the login page", true);
		l1.testLogin(UtilityConstants.ADMIN_UN, UtilityConstants.ADMIN_PWD);

		Thread.sleep(4000);
		/* Hover on the marketing Tab */
		m1.hoverToLeads();
		Thread.sleep(4000);
		/* Select the Manage List from the Drop Down*/
		m1.selectManagelist();
		Reporter.log("Creating the new Static list", true);
		Thread.sleep(4000);
		/* Select Click on create new list Button*/
		m1.clickCreateNewListButton();
		Thread.sleep(3000);
		Reporter.log("Selecting the activity ", true);
		  /* Select Any activity from the drop down*/
		m1.selectActivity();
		Thread.sleep(3000);
		/* Select Any Activity*/
		m1.selectAnyActivity();
		Reporter.log("Click on the add button after selecting the activity ", true);
		/* Click on Add Button*/
		m1.clickAddButton();
		Thread.sleep(3000);
		/* Click Find Leads Button*/
		m1.clickFindLeadsButton();
		Thread.sleep(3000);
		String listname = "Demo Staic List 45";
		String Description = "desc";
		m1.selectsticlist(listname, Description);
		Thread.sleep(3000);
		Reporter.log("Click on the save Button after entering all the details in the static list", true);
		 /* Click on the Save Button */
		m1.clicksaveButton();
		/* verify the list name present in the grid*/
		m1.verifyListGrid(listname);

	}

}
