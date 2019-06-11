package com.ls.test;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ls.generic.BaseTest;
import com.ls.generic.UtilityConstants;
import com.ls.pom.LoginPage;

public class TC_031 extends BaseTest {
	@Test
	public void testpublishLP() throws Exception
	{ 
		
		LoginPage l1 = new LoginPage(driver);
		Reporter.log("Enter Email.id  and password in the login page",true);
		l1.testLogin(UtilityConstants.ADMIN_UN, UtilityConstants.ADMIN_PWD);
	}
}

