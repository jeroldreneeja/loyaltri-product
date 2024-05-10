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
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

import Library.CommonFunctions;
import Objects.TestObj;

public class Testcases extends CommonFunctions{
	
	static String screenShot;
	Faker faker = new Faker();
	
	@BeforeSuite
	public void report() {
		
		report = new ExtentSparkReporter("Reports/test.html");    
		report.config().setReportName("Selenium Automation Report");
		reports = new ExtentReports();
		reports.attachReporter(report); 
		reports.setSystemInfo("Application", "Loyaltri Product");
		reports.setSystemInfo("Module", "Masters");
		reports.setSystemInfo("Author", "Reneeja");
		
	}
	
	@Test(priority=1)

	public void eventlist() throws Exception {
			
		test = reports.createTest("Testcase for Country Page ");
		PageFactory.initElements(driver,TestObj.class);
		node = test.createNode("Test case for view details ");
		Thread.sleep(3000);
						
		//settings icon clicked
		TestObj.settingsIcon.click();
		node.log(Status.PASS," Settings Menu clicked");
		Thread.sleep(3000);
		
		//master optn
		
		TestObj.master.click();
		node.log(Status.PASS, "Master Option Clicked");
		Thread.sleep(3000);
		
		
		 test.createNode("Testcase 1- Check the Country Dashboard page is displayed ");
		//		Country_option
		TestObj.countryOpt.click();
		node.log(Status.PASS, "countryoptn clicked");
		Thread.sleep(4000);
		
		test.createNode("Testcase 2- Check the Create Country page is displayed");
		
		TestObj.createCountry.click();
		node.log(Status.PASS, "Create country button Clicked Successfully");
		Thread.sleep(4000);
			
		
		  String actCountry = TestObj.Country.getText();
	        if (actCountry.equals("Country")) {
	            node.pass("Country page is displayed");
	        } else {
	            Assert.fail("Country page is not displayed");
	        }
	
			
	       
	
		//create country
		
	        TestObj.createCountryOpt.click();
		node.log(Status.PASS, "Saved successfully");
		Thread.sleep(3000);
	
		
		
		//give the default country name\
		
		String name = faker.letterify("??????");
		TestObj.countryName.click();
		TestObj.countryName.sendKeys(name);
		node.log(Status.PASS, "country name Entered");
		Thread.sleep(3000);
 
		
		//default country code
		
		String code = faker.letterify("??????");
		TestObj.countryCode.click();
		TestObj.countryCode.sendKeys(code);
		node.log(Status.PASS, "country name Entered");
		Thread.sleep(3000);
		
		//default description
		
		String description = faker.letterify("??????");
		TestObj.countryDescription.click();
		TestObj.countryDescription.sendKeys(description);
		node.log(Status.PASS, "country name Entered");
		Thread.sleep(3000);
		
//		//cancel option
//		
//		MastersObj.CancelOption.click();
//		node.log(Status.PASS, "Canceled Successfully");
//		Thread.sleep(3000);
		
//		Save option
		TestObj.Savebtn.click();
		node.log(Status.PASS, "Saved successfully");
		Thread.sleep(3000);
		
 
		
		
		
//		UPDATE THE COUNTRY
		
//		Edit_btn clicking
		test.createNode("Testcase 3- Check the Edit Country Dashboard page is displayed ");
//		
		TestObj.editButton.click();
		node.log(Status.PASS, "clicked successfully");
		Thread.sleep(3000);
		
//	edit _country
		TestObj.editCountry.clear();
		Thread.sleep(3000);
		TestObj.editCountry.sendKeys("country1");
		node.log(Status.PASS, "cleared the country name ");
		Thread.sleep(3000);
 
//      clear the value country code
		TestObj.editCode.clear();
		node.log(Status.PASS, "cleared the Country Code");
		Thread.sleep(3000);
		
////    send new country_code
		
		TestObj.editCode.sendKeys("AR");
		node.log(Status.PASS, "Successfully changed the  Country Code");
		Thread.sleep(3000);
//		
////	Clear country_description
//		
		TestObj.editDescription.clear();
		node.log(Status.PASS, "cleared the descrisption");
		Thread.sleep(3000);
//		
////	Send  new description value
		TestObj.editDescription.sendKeys("AR");
		node.log(Status.PASS, "Successfully changed the Country Descrisption");
		Thread.sleep(3000);
//		
//		Save option
		TestObj.Savebtn.click();
		node.log(Status.PASS, "Saved successfully");
		Thread.sleep(3000);
			
		
		
		
		
	        
	        
	        
		
		
		
		
		
	}
 
	@AfterSuite
	public void reportflush() {
		reports.flush();
	}
 
	public static String takeScreenshot(WebDriver driver, String screenshotName) throws Exception {
		String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		screenShot = System.getProperty("user.dir") + "/screenshots/" + screenshotName + "_" + timestamp + ".png";
		File screenshotfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotfile, new File(screenShot));
		return screenShot;

	}
}