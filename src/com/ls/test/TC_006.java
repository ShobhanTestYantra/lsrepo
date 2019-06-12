package com.ls.test;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ls.generic.BaseTest;
import com.ls.generic.UtilityConstants;
import com.ls.pom.LoginPage;
import com.ls.pom.marketing.landingpages.BuildLandingPage;
import com.ls.pom.marketing.landingpages.LandingPages;
import com.ls.pom.marketing.landingpages.SelectTemplatePage;

public class TC_006  extends BaseTest{
	@Test
	public void testAccessLandingPage() throws Exception
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
	/* Select the Landing page Tamplate */
	Reporter.log("Selecting the Landing Template",true);
	Thread.sleep(3000);
	String lpname="Landing page 08";
	String tagname="tag 09";
	
	sp.enterlandingPageName(lpname,tagname);
	Thread.sleep(3000);
	BuildLandingPage bp=new BuildLandingPage(driver);
	Thread.sleep(3000);
	int value=700;
	bp.clickOnPublishBtn(value);
	Thread.sleep(3000);
	bp.clickOnConfirmPublishBtn();
	bp.clickOnConfirmUrl();
	
	
	}
}
