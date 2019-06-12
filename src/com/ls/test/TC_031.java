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
	public void testcreaterule() throws Exception {

		LoginPage l1 = new LoginPage(driver);
		Reporter.log("Enter Email.id  and password in the login page", true);
		l1.testLogin(UtilityConstants.ADMIN_UN, UtilityConstants.ADMIN_PWD);

		UserProfilePage usp = new UserProfilePage(driver);
		/* Hover on the User Profile Tab */
		usp.hoverToUserProfileTab();
		/* Click on The Settings Link */
		usp.clkSettingsLnk();

		SettingsPage sp = new SettingsPage(driver);
		/* Click on Rules and Notification */
		sp.clkRulesAndNotificationsLnk();

		RulesandNotificationPage rp = new RulesandNotificationPage(driver);
		String rulename = "Create Rule Demo1";
		rp.createRule(rulename);
		usp.hoverToLeads();
		ManageLeadsPage msp = new ManageLeadsPage(driver);
		String lname = "SK";
		String fname = "smita";
		String email = "smita.s@testyantra.com";
		msp.quickAddLeadwithboreturn(lname, fname, email);
		usp.hoverToUserProfileTab();
		usp.clkSettingsLnk();
		sp.clkRulesAndNotificationsLnk();
		String eemail = "siya.s@testyantra.com";
		rp.verifyrule(eemail);
	}
}
