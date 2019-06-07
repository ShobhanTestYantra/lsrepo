package com.ls.test;

import org.testng.annotations.Test;

import com.ls.generic.BaseTest;
import com.ls.generic.UtilityConstants;
import com.ls.pom.LoginPage;
import com.ls.pom.content.imgdocs.ImageLibraryPage;

public class TC_013 extends BaseTest {
	
	@Test
	public void uploadImageToFolderTest() throws InterruptedException {
		LoginPage l1 = new LoginPage(driver);
		l1.testLogin(UtilityConstants.ADMIN_UN, UtilityConstants.ADMIN_PWD);
		ImageLibraryPage i1 = new ImageLibraryPage(driver);
		i1.hoverToContent();
		i1.createFolderUploadImage();
	}

}
