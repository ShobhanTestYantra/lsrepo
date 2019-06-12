package com.ls.test;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ls.generic.BaseTest;
import com.ls.generic.UtilityConstants;
import com.ls.pom.LoginPage;
import com.ls.pom.marketing.landingpages.BuildLandingPage;
import com.ls.pom.marketing.landingpages.LandingPages;
import com.ls.pom.marketing.landingpages.SelectTemplatePage;

public class TC_005 extends BaseTest{
	
	@Test
	public void testpublishLandingPage() throws Exception
	{ 
		
		LoginPage l1 = new LoginPage(driver);
		Reporter.log("Enter Email.id  and password in the login page",true);
		l1.testLogin(UtilityConstants.ADMIN_UN, UtilityConstants.ADMIN_PWD);
		
		LandingPages lp1 =new LandingPages(driver);
		/* Hover on the marketing Tab*/
		Reporter.log("Hover on the Marketing tab",true);
		Thread.sleep(3000);
		lp1.hoverToMarketing();
		Thread.sleep(3000);
		/* Select the landing pages option from the Drop Down*/
		Reporter.log("Select the landing pages from drop down ",true);
		
		lp1.selectLandingpages();
		Thread.sleep(3000);
		/* Click on the create landing pages button */
		Reporter.log("Click on the create landing pages button",true);
		lp1.clickCreateLPButton();
		Thread.sleep(3000);
		SelectTemplatePage sp=new SelectTemplatePage(driver);
		
		Reporter.log("Selecting the Landing Template",true);
		Thread.sleep(3000);
		String lpname="Landing page 07";
		String tagname="tag 03";
		/* Entering the Landing Page name and TagName*/
		sp.enterlandingPageName(lpname,tagname);
		/* Select The Template*/
		sp.selectTemplate();
		Thread.sleep(3000);
		BuildLandingPage bp=new BuildLandingPage(driver);
		Thread.sleep(3000);
		/*Click On Publish Button*/
		bp.clickOnPublishBtn(700);
		Thread.sleep(3000);
		/*Click On Publish Button in the Confirmation Box*/
		bp.clickOnConfirmPublishBtn();
		Thread.sleep(3000);
		String emsg="Finished publishing landing page. 1 successful. 0 failed.";
		/*Verify the Message in the confirmation box*/
		bp.verifymessage(emsg);		
	}

}
