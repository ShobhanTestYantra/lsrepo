package com.ls.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.ls.generic.BaseTest;
import com.ls.generic.UtilityConstants;
import com.ls.pom.LoginPage;

public class TC extends BaseTest {


	@Test
	public void name2() {

		LoginPage l1 = new LoginPage(driver);
		l1.testLogin(UtilityConstants.ADMIN_UN, UtilityConstants.ADMIN_PWD);
	}

}
