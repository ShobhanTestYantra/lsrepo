package com.ls.pom.marketing.landingpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ls.generic.BasePage;

public class LandingPages extends BasePage {

	public LandingPages(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	   /*Create landing Page Burtton */

		@FindBy(xpath="//div[@id='relatedAction_HR']/descendant::span[text()='Create Landing Page']")
		private WebElement createlpBtn;
		
		@FindBy(xpath="//li[@class='dropdown' ]/a[contains(.,'Marketing')]/following-sibling::ul/descendant::a[text()=' Landing Pages']")
		private WebElement landingpagesDrpDwn;
		
		@FindBy(xpath="//button[@class='dropdown-toggle settings-icon']")
		private WebElement actinsettingIcon;
		/**
		 * @author Shreya
		 * @description Clicking on the  landing Page in DropDown
		 * 
		 * 
		 */
		
		public void selectLandingpages()
		{
			   System.out.println("Click on create Landing Page DrpDwn ");
				
				landingpagesDrpDwn.click();
		}
		/**
		 * @author Shreya
		 * @description Clicking on the create landing Page
		 * 
		 * 
		 */
		public void clickCreateLPButton()
		{  
			System.out.println("Click on create Landing Page Button ");
			createlpBtn.click();	
		}
		public void clickActionSettingIcon()
		{  
			System.out.println("Click on Action Setting Button ");
			mouseHover(actinsettingIcon);	
		}
	



}
