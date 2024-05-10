package Testcases_Masters;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.github.javafaker.Faker;

import Library.CommonFunctions;

public class MastersTest extends CommonFunctions {
	static String screenShot;
	Faker faker = new Faker();
	
	@BeforeSuite
	public void report() { 
		
		report = new ExtentSparkReporter("Reports/Masters.html");    
		report.config().setReportName("Selenium Automation Report");
		reports = new ExtentReports();
		reports.attachReporter(report); 
		reports.setSystemInfo("Application", "Loyaltri Product");
		reports.setSystemInfo("Module", "Masters");
		reports.setSystemInfo("Author", "Reneeja");
		
	}
	
	@Test(priority=1)
	public void DesignationTest() throws Exception {
		test=reports.createTest("<b><font color='Blue'>Testcases of Designation</b></font>");
		node=test.createNode("<font color='purple'>Testcase1 - Check Designation page is displayed</font>"); 
		node.pass("Designation page is displayed.");
		node=test.createNode("Testcase2 - Check Add Designation");
		node.pass("aaaaaaaaaaaa");
		node=test.createNode("Testcase3 - Check Update Designation");
		test.fail("<font color='red'>Manage Client Contract Page not displayed.</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());

	} 
	
	@Test(priority=2)
	public void DocumentTypesTest() throws Exception {
		test=reports.createTest("<b><font color='Blue'>Testcases of Document Types</b></font>");
		node=test.createNode("<font color='purple'>Testcase1 - Check Document Types page is displayed</font>");
		node.pass("Document Types Page is displayed.");
		node=test.createNode("Testcase2 - Check Add Document Types");
		node=test.createNode("Testcase3 - Check Update Document Types");
		test.fail("<font color='red'>Manage Client Contract Page not displayed.</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());

	} 
	
	/*
	 * Code for taking Screenshot
	 */

	public static String takeScreenshot(WebDriver driver, String screenshotName) throws Exception {
		String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		screenShot = System.getProperty("user.dir") + "/screenshots/" + screenshotName + "_" + timestamp + ".png";
		File screenshotfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotfile, new File(screenShot));
		return screenShot;

	}
	 
	
	
	
	@AfterSuite 
   	public void reportflush() {
   		reports.flush();
   	}



}
