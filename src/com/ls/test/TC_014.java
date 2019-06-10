package com.ls.test;

import org.testng.annotations.Test;

import com.ls.generic.BaseTest;
import com.ls.generic.UtilityConstants;
import com.ls.pom.LoginPage;
import com.ls.pom.lead.manageleads.ManageLeads;

public class TC_014 extends BaseTest {
	
	@Test
	public void uploadImageToFolderTest() throws InterruptedException {
		LoginPage l1 = new LoginPage(driver);
		l1.testLogin(UtilityConstants.ADMIN_UN, UtilityConstants.ADMIN_PWD);
		l1.hoverToLeads();
		ManageLeads m1 =new ManageLeads(driver);
		m1.quickAddLead();

	}

}
