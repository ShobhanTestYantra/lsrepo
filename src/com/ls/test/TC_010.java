package com.ls.test;

import org.testng.annotations.Test;

import com.ls.generic.BaseTest;
import com.ls.generic.UtilityConstants;
import com.ls.pom.LoginPage;
import com.ls.pom.content.imgdocs.ImageLibraryPage;

public class TC_010 extends BaseTest {

	@Test
	public void uploadImageTest() throws InterruptedException {

		/* login to the application */
		LoginPage l1 = new LoginPage(driver);
		l1.testLogin(UtilityConstants.ADMIN_UN, UtilityConstants.ADMIN_PWD);

		/* Go to the Content Tab */
		l1.hoverToContent();

		/* Upload the Image */
		ImageLibraryPage i1 = new ImageLibraryPage(driver);
		i1.uploadImage();

	}
}
