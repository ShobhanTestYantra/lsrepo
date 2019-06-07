package com.ls.test;

import org.testng.annotations.Test;

import com.ls.generic.BaseTest;
import com.ls.generic.UtilityConstants;
import com.ls.pom.LoginPage;
import com.ls.pom.content.imgdocs.DocumentLibrary;

public class TC_011 extends BaseTest{
	
	@Test
	public void uploadFileTest() throws InterruptedException {
		LoginPage l1 = new LoginPage(driver);
		l1.testLogin(UtilityConstants.ADMIN_UN, UtilityConstants.ADMIN_PWD);
		DocumentLibrary d1 = new DocumentLibrary(driver);
		d1.hoverToContent();
		d1.uploadFiles();
	}

}
