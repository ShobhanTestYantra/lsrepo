package com.ls.test;

import org.testng.annotations.Test;

import com.ls.generic.BaseTest;
import com.ls.generic.UtilityConstants;
import com.ls.pom.LoginPage;
import com.ls.pom.content.imgdocs.DocumentLibraryPage;

public class TC_011 extends BaseTest {

	@Test
	public void uploadFileTest() throws InterruptedException {
		/* login to the application */
		LoginPage l1 = new LoginPage(driver);
		l1.testLogin(UtilityConstants.ADMIN_UN, UtilityConstants.ADMIN_PWD);

		/* Go to the Content Tab */
		l1.hoverToContent();

		/* Upload the Files */
		DocumentLibraryPage d1 = new DocumentLibraryPage(driver);
		d1.uploadFiles();
	}
}
