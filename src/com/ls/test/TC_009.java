package com.ls.test;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ls.generic.BaseTest;
import com.ls.generic.UtilityConstants;
import com.ls.pom.LoginPage;
import com.ls.pom.marketing.landingpages.BuildLandingPage;
import com.ls.pom.marketing.landingpages.LandingPages;
import com.ls.pom.marketing.landingpages.SelectTemplatePage;

public class TC_009 extends BaseTest {
	@Test(priority=2)
	public void testUnpublish() throws Exception{
		
	LoginPage l1 = new LoginPage(driver);
	Reporter.log("Enter Email.id  and password in the login page",true);
	l1.testLogin(UtilityConstants.ADMIN_UN, UtilityConstants.ADMIN_PWD);
	/* Hover on the marketing Tab*/
	LandingPages lp1 =new LandingPages(driver);
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
	/* Entering the Landing Page name and TagName*/
	
	Reporter.log("Selecting the Landing Template",true);
	Thread.sleep(3000);
	String lpname="Landing page 99";
	String tagname="tag Demo";

	sp.enterlandingPageName(lpname,tagname);
	/* Select The Template*/
	sp.selectTemplate();
	Thread.sleep(3000);
	
	BuildLandingPage bp=new BuildLandingPage(driver);
	Thread.sleep(3000);
	/*Click On Publish Button*/
	bp.clickOnPublishBtn(700);
	Thread.sleep(3000);
	/*Click On Publish Button in confirmation box*/
	bp.clickOnConfirmPublishBtn();
	/*Click On Get List Button in Confirmation box*/
	bp.clickOnGetListBtn();
	Thread.sleep(3000);
	String emsg="Finished unpublishing landing pages. 1 successful. 0 failed.";
	/*MouseOver on the Action settings*/
	lp1.mouseoverActionSettingIcon();
	/*verify the unpublish message*/
	lp1.verifyUnpublish(emsg);
	
	}
}
