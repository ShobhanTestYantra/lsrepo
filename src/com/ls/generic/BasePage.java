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

	// #################################################################//
	// Selenium methods
	public void waitForPageLoaded() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for Page Load Request to complete.");
		}
	}

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
}
