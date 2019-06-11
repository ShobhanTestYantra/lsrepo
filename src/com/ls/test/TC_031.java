package com.ls.test;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ls.generic.BaseTest;
import com.ls.generic.UtilityConstants;
import com.ls.pom.LoginPage;
import com.ls.pom.lead.manageleads.ManageLeadsPage;
import com.ls.pom.settings.SettingsPage;
import com.ls.pom.settings.rulesandnotification.RulesandNotificationPage;
import com.ls.pom.userprofile.UserProfilePage;

public class TC_031 extends BaseTest {
	@Test
	public void testpublishLP() throws Exception
	{ 
		
		LoginPage l1 = new LoginPage(driver);
		Reporter.log("Enter Email.id  and password in the login page",true);
		l1.testLogin(UtilityConstants.ADMIN_UN, UtilityConstants.ADMIN_PWD);
		
		UserProfilePage usp=new UserProfilePage(driver);
		usp.hoverToUserProfileTab();
		usp.clkSettingsLnk();
		
		SettingsPage sp=new SettingsPage(driver);
		
		sp.clkRulesAndNotificationsLnk();
		
		RulesandNotificationPage rp=new RulesandNotificationPage(driver);
		String rulename="Create Rule Demo1";
		rp.createRule(rulename);
		
		usp.hoverToLeads();
		ManageLeadsPage msp=new ManageLeadsPage(driver);
		msp.quickAddLeadwithboreturn();
		
		
		usp.hoverToUserProfileTab();
		usp.clkSettingsLnk();
		sp.clkRulesAndNotificationsLnk();
		rp.verifyrule();
	}
}

