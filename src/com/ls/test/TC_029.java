package com.ls.test;

import org.testng.annotations.Test;

import com.ls.generic.BaseTest;
import com.ls.generic.UtilityConstants;
import com.ls.pom.LoginPage;
import com.ls.pom.lead.manageleads.ManageLeadsPage;
import com.ls.pom.leads.managetasks.ManageTasksPage;

public class TC_029 extends BaseTest  {

	@Test
	public void createTask() throws InterruptedException {
		LoginPage l1 = new LoginPage(driver);
		l1.testLogin(UtilityConstants.ADMIN_UN, UtilityConstants.ADMIN_PWD);
		l1.hoverToLeads();
		ManageLeadsPage m1 =new ManageLeadsPage(driver);
		String leadName=m1.quickAddLead();
		m1.hoverToLeads();
		ManageTasksPage m2 = new ManageTasksPage(driver);
		m2.clickOnmanageTasksDrpDwn();
		m2.createTask(leadName);

	}
}
