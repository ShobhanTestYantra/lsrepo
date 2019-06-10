package com.ls.test;

import org.testng.annotations.Test;

import com.ls.generic.BaseTest;
import com.ls.generic.UtilityConstants;
import com.ls.pom.LoginPage;
import com.ls.pom.lead.manageleads.ManageLeadsPage;

public class TC_014 extends BaseTest {

	@Test
	public void uploadImageToFolderTest() throws InterruptedException {
		LoginPage l1 = new LoginPage(driver);
		l1.testLogin(UtilityConstants.ADMIN_UN, UtilityConstants.ADMIN_PWD);
		l1.hoverToLeads();
		ManageLeadsPage m1 = new ManageLeadsPage(driver);
		m1.quickAddLead();
	}
}
