package com.ls.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	public WebDriver driver;

//	ExtentHtmlReporter extentHtmlReporter;
//	ExtentReports extentReports;
//	ExtentTest extentTest;
//
//	public static String getCurrentTimeUsingDate() {
//		Date date = new Date();
//		String strDateFormat = "EEEE, MMMM dd, hh-mm-ss ";
//		DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
//		String formattedDate = dateFormat.format(date);
//		System.out.println("Current time of the day using Date - 12 hour format: " + formattedDate);
//		return formattedDate;
//	}
//
//	public static String captureScreenShot(WebDriver driver) {
//		String path = null;
//		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		try {
//			path = System.getProperty("user.dir") + "/xRep/shot/" + System.currentTimeMillis() + ".png";
//			Files.copy(src, new File(path));
//			return path;
//		} catch (IOException e) {
//			System.out.println(e.getMessage());
//		}
//		return path;
//	}
//
//	@Parameters({ "OS" })
//	@BeforeTest
//	public void startReport(@Optional("windows") String OS) {
//
//		extentHtmlReporter = new ExtentHtmlReporter(
//				System.getProperty("user.dir") + "/reports/" + getCurrentTimeUsingDate() + "RunReport.html");
//		extentReports = new ExtentReports();
//		extentReports.attachReporter(extentHtmlReporter);
//
//		// To add system or environment info by using the setSystemInfo method.
//		extentReports.setSystemInfo("OS", OS);
//		extentHtmlReporter.config().setDocumentTitle("LeadSquared");
//		extentHtmlReporter.config().setReportName("Test Report - AUT ");
//		extentHtmlReporter.config().setTheme(Theme.STANDARD);
//		extentHtmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
//
//	}

	@BeforeMethod
	public void beforeMethod() {
		ChromeOptions options = new ChromeOptions();
		// Add chrome switch to disable notification - "**--disable-notifications**"
		options.addArguments("--disable-notifications");
		System.out.println("open the browser");
		System.setProperty(UtilityConstants.CHROME_KEY, UtilityConstants.CHROME_PATH);
		driver = new ChromeDriver(options);
		driver.get(UtilityConstants.URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Close the browser");
		driver.close();
	}

//	@AfterTest
//	public void getResult(ITestResult result) throws IOException {
//		if (result.getStatus() == ITestResult.FAILURE) {
//			extentTest.addScreenCaptureFromPath(captureScreenShot(driver));
//			extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "  FAILED ", ExtentColor.RED));
//			extentTest.fail(result.getThrowable());
//		} else if (result.getStatus() == ITestResult.SUCCESS) {
//			extentTest.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "  PASSED ", ExtentColor.GREEN));
//		} else {
//			extentTest.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "  SKIPPED ", ExtentColor.YELLOW));
//			extentTest.skip(result.getThrowable());
//		}
//		extentReports.flush();
//	}
}
