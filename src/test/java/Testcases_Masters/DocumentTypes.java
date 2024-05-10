package Testcases_Masters;

import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Library.CommonFunctions;
import Objects.MastersObj;

public class DocumentTypes extends CommonFunctions {
	static String screenShot;
	@BeforeSuite
	public void report() {
		
		report = new ExtentSparkReporter("Reports/DocumentType.html");    
		report.config().setReportName("Selenium Automation Report");
		reports = new ExtentReports();
		reports.attachReporter(report); 
		reports.setSystemInfo("Application", "Loyaltri Product");
		reports.setSystemInfo("Module", "Masters");
		reports.setSystemInfo("Author", "Reneeja");
		
	}
	
	@Test(priority=1)
	public void DocumentTypeTest()throws IOException{ 
		try {
			test=reports.createTest("<b><font color='Blue'>Testcases of Designation module</b></font>");
			/*
			 * Code for document type page navigation checking
			 */
			test.info("<b><font color='purple'>Testcase 1- Check the Document Type page is displayed </b></font>");
			PageFactory.initElements(driver,MastersObj.class);
			MastersObj.settings.click();
			//Thread.sleep(2000);
			MastersObj.masters.click();
			//Thread.sleep(2000);
			test.pass("The Masters menu clicked");
			MastersObj.documentTypeMenu.click();
			test.pass("The Document Type button clicked");
			MastersObj.documentTypeHeading.isDisplayed();
			String documentTypeheading=MastersObj.documentTypeHeading.getText();
			test.pass("The Document Types page is displayed.The heading of the page is: "+ documentTypeheading);
			
			/*
			 * Code for Add Document Type 
			 */
			//test.createNode("");
			test.info("<b><font color='purple'>Testcase 2 - Check the user is able to Add new Document Type</b> </font>");
			MastersObj.createDocumentTypeBtn.click();
			test.pass("Create Document Type button is clicked");
			MastersObj.createDocumentTypeHeading.isDisplayed();
			test.pass("Create Document Type child window is displayed. The heading of is:" +MastersObj.createDocumentTypeHeading.getText() );
			
			
			
			
		}catch(Exception E) {
			
		}
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
