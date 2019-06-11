package com.ls.generic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {

	public WebDriver driver;
	WebDriverWait wait;
	public long ETO=0;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// To click on the required element
	public void clickElement(WebElement element) {
		element.click();
	}

	// To enter Required String in the textbox
	public void typeText(WebElement element, String string) {
		element.sendKeys(string);
	}

	// ################# Page Methods ######################

	@FindBy(xpath = "//li[@class='dropdown' and @data-name='UserDashboards']/a[contains(.,'Dashboard')]")
	private WebElement dashboardTab;

	@FindBy(xpath = "//li[@class='dropdown' and @menu='Content']/a[contains(.,'Content')]")
	private WebElement ContentTab;

	@FindBy(xpath = "//li[@class='dropdown' and @menu='Marketing']/a[contains(.,'Marketing')]")
	private WebElement MarketingTab;

	@FindBy(xpath = "//li[@class='dropdown' and @menu='Leads']/a[contains(.,'Leads')]")
	private WebElement LeadsTab;

	@FindBy(xpath = "//li[@class='dropdown' and @menu='Workflow']/a[contains(.,'Workflow')]")
	private WebElement WorkflowTab;

	@FindBy(xpath = "//li[@class='dropdown' and @menu='Apps']/a[contains(.,'Apps')]")
	private WebElement AppsTab;

	@FindBy(xpath = "//li[@class='dropdown' and @menu='Reports']/a[contains(.,'Reports')]")
	private WebElement ReportsTab;

	@FindBy(xpath = "(//ul[@class='mx-top-nav'])[1]")
	private WebElement profileTab;

	public void hoverToDashboard() {
		System.out.println("Go to the Dashboard Tab ");
		mouseHover(dashboardTab);
	}

	public void hoverToContent() {
		System.out.println("Go to the Content Tab ");
		mouseHover(ContentTab);
	}

	public void hoverToMarketing() {
		System.out.println("Go to the Marketing Tab ");
		mouseHover(MarketingTab);
	}

	public void hoverToLeads() {
		System.out.println("Go to the Leads Tab ");
		mouseHover(LeadsTab);
	}

	public void hoverToWorkflow() {
		System.out.println("Go to the Workflow Tab ");
		mouseHover(WorkflowTab);
	}

	public void hoverToApps() {
		System.out.println("Go to the Apps Tab  ");
		mouseHover(AppsTab);
	}

	public void hoverToReports() {
		System.out.println("Go to the Reports Tab  ");
		mouseHover(ReportsTab);

	}
	
	public void hoverToUserProfileTab() {
		System.out.println("Go to the Profile Tab  ");
		mouseHover(profileTab);
	}

	// #################################################################//
	// Selenium methods
//	

	public void waitUntilLoadedAndVisibilityOfElementLocated(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void mouseHover(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public void upload(String imagePath) throws InterruptedException, AWTException {
		StringSelection stringSelection = new StringSelection(imagePath);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);

		Robot robot = new Robot();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void scrollwithvalue(int value) {
		String stvalue = "window.scrollBy(0," + value + ")";
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript(stvalue, "");
	}
	
	 
    /*wait till the page to load*/
    public void waitTillPageLoad() {
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
         ExpectedCondition<Boolean> jsLoad = webdriver -> ((JavascriptExecutor) driver)
                .executeScript("return document.readyState").toString().equals("complete");
        boolean jsReady = (Boolean) jsExec.executeScript("return document.readyState").toString().equals("complete");
        if (!jsReady) {
   //         generic.logMessage("FAIL","JS in NOT Ready!");
            wait.until(jsLoad);
        } else {
   //         generic.logMessage("PASS","JS is Ready!");
        }
   //     generic.logMessage("PASS"," page is in ready state ");
    }
    
    /* Verify the Element is Clickable or Not */
    public boolean isElementClickable(WebElement element,String elementName)  {
        waitTillPageLoad();
   //     generic.logMessage("INFO","---------Verifying Element is Clickable or Not ---------");
        try {           
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
            } catch (Exception e) {
        //        generic.logMessage("INFO",elementName +"  is not clickable ");
            return false;
        }
    }
	
	/* Verify the Element is Displayed or Not */
    /* Verify the Element is Displayed or Not */
   public  void isElementDisplayed(WebElement element, String elementName){
       try {
       //    generic.logMessage("INFO","---------Verifying element is displayed or not ---------");
           waitTillPageLoad();
           WebDriverWait wait = new WebDriverWait(driver,ETO);
           wait.until(ExpectedConditions.visibilityOf(element));
           Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(element)) != null);
      //     generic.logMessage("PASS",elementName + "------ is displayed");
       } 
       catch (Exception e) {
   //        generic.logMessage("PASS",elementName + "------ is not displayed");
       }
   }
	
	/* Get the Text From the Page */
    public String getText(WebElement element, String elementName)  {
  //      generic.logMessage("INFO","Get the text from the element:");
        String eleText = null;
        try {
            waitTillPageLoad();
            isElementDisplayed(element, elementName);
            eleText = element.getText();
            if (eleText.equals(null)) {
         //       generic.logMessage("INFO","Unable to fetch text from " + "\'" + elementName );
                //MyExtentListners.test.addScreenCaptureFromPath(capture(driver)); // exception
                Assert.fail("Unable to fetch text from " + "\'" + elementName + "\'");
            }
        } catch (Exception e) {
         //   generic.logMessage("INFO","Unable to fetch text from " + "\'" + elementName + "\'");
            //MyExtentListners.test.addScreenCaptureFromPath(capture(driver)); // exception
            Assert.fail("Unable to fetch text from " + elementName);
        }
        return eleText;
    }
    public void refreshPage()
    {
    	driver.navigate().refresh();
    }
}
