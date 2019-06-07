package com.ls.test;

import org.testng.annotations.Test;

import com.ls.generic.BaseTest;
import com.ls.generic.UtilityConstants;
import com.ls.pom.LoginPage;
import com.ls.pom.content.imgdocs.ImageLibraryPage;

public class TC extends BaseTest {

	String imagePath =System.getProperty("user.dir")+"/inputTestData/Image_Testdata1_GIF.gif";

	@Test
	public void name2() {

		LoginPage l1 = new LoginPage(driver);
		l1.testLogin(UtilityConstants.ADMIN_UN, UtilityConstants.ADMIN_PWD);
		ImageLibraryPage i1 =new ImageLibraryPage(driver);
		i1.hoverToContent();
		i1.uploadImage(imagePath);
		
		
	}

}
