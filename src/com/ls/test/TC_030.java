package com.ls.test;

import org.testng.annotations.Test;

import com.ls.generic.BaseTest;
import com.ls.generic.UtilityConstants;
import com.ls.pom.LoginPage;
import com.ls.pom.settings.SettingsPage;
import com.ls.pom.settings.usersandpermissions.UsersPage;
import com.ls.pom.userprofile.UserProfilePage;

public class TC_030 extends BaseTest {

	@Test
	public void createuser() throws InterruptedException 
	{
		LoginPage l1 = new LoginPage(driver);
		l1.testLogin(UtilityConstants.ADMIN_UN, UtilityConstants.ADMIN_PWD);
		l1.hoverToUserProfileTab();
		UserProfilePage u1= new UserProfilePage(driver);
		u1.clkSettingsLnk();
		SettingsPage s1 = new SettingsPage(driver);
		s1.clkUsersAndPermissionsLink();
		UsersPage u2 = new UsersPage(driver);
		u2.clkUserLnk();
		u2.clkCreate();
		u2.fillCreateUserform("poorva@testyantra.com");
	}
}
