package com.ls.test;

import org.testng.annotations.Test;

import com.ls.generic.BaseTest;
import com.ls.generic.UtilityConstants;
import com.ls.pom.LoginPage;
import com.ls.pom.content.imgdocs.ImageLibraryPage;

public class TC_012 extends BaseTest{

	@Test(priority=5)
	public void createFolderTest() throws InterruptedException {
		/* login to the application */
		LoginPage l1 = new LoginPage(driver);
		l1.testLogin(UtilityConstants.ADMIN_UN, UtilityConstants.ADMIN_PWD);

		/* Go to the Content Tab */
		l1.hoverToContent();

		/* Create the new folder */
		ImageLibraryPage i1 = new ImageLibraryPage(driver);
		i1.createAndverifyFolder();
	}
}
