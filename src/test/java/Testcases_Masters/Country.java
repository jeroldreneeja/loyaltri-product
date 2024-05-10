package Testcases_Masters;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.github.javafaker.Faker;

import Library.CommonFunctions;
import Objects.MastersObj;

public class Country extends CommonFunctions{
	static String screenShot;

		@BeforeSuite
 
		public void report() {
			report = new ExtentSparkReporter("Reports/country.html");
			reports = new ExtentReports();
			reports.attachReporter(report);
			Faker faker = new Faker();
	 
			reports.setSystemInfo("<b>Application<b>", "<b>Loyaltri<b>");
			reports.setSystemInfo("<b>Module<b>", "<b>Monisha<\b>");
			reports.setSystemInfo("<b>Author<b>", "<b> Cordova Testing Team<b>");

		}

		@Test(priority = 1)

		public void eventlist() throws Exception {

			Faker faker = new Faker();             //for give the default value
	 		test = reports.createTest("Testcase for Country Page ");
			PageFactory.initElements(driver,MastersObj.class);
			test.info("<b><font color = 'purple'>Test case-1 Verify the country page is displayed </b>");
			MastersObj.settings.click();
			test.pass("Settings Menu clicked");
    		MastersObj.masters.click();
			test.pass("Master Menu Clicked");
			MastersObj.countryOpt.click();
			test.pass("Country option clicked");
			String actCountry = MastersObj.Country.getText(); 
			if (actCountry.equals("Country")) {
		            test.pass("Country page is displayed");

		        } else {
		        	test.fail("<font color='red'>Country page is not displayed</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
		        }
			
			
		    test.info("<b><font color = 'purple'>Test case-2 Check the Create country page is displayed </b>");
			MastersObj.createCountryOpt.click();
			test.pass("Create Country button clicked.");
			Thread.sleep(3000);
			System.out.println(MastersObj.createCountryHeading.getText()+"create heading");
			if(MastersObj.createCountryHeading.getText().equals("Create Country")) {
				test.pass("Create Country child window is displayed.The heading is :"+MastersObj.createCountryHeading.getText());
			}else {
				test.fail("<font color='red'>Create Country page navigation failed</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
			}
			
			
		    test.info("<b><font color = 'purple'>Test case-3 Verify if the Cancel button on the Create Country page is functioning correctly</b>");
			MastersObj.CancelOption.click();
			test.pass("Cancel Button is clicked.");
			//MastersObj.createCountryHeading.is
			if(MastersObj.createCountryOpt.isDisplayed()) {
				test.pass("Cancel button worked.Create Country child window is closed.");
			}else {
				test.fail("<font color='red'>The functionality of the cancel button did not execute as expected.</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
			}
		    
			
		    test.info("<b><font color = 'purple'>Test case-4 Verify whether the user can successfully create a new country./b>");
		    MastersObj.createCountryOpt.click();
			test.pass("Create country button clicked");
			String name = faker.letterify("???");
			String newCountryName="Country "+name;
			MastersObj.countryName.click();
			MastersObj.countryName.sendKeys(newCountryName);
			test.pass("Country Name is entered");
			MastersObj.countryCode.sendKeys(newCountryName);
			test.pass("Country Code is entered");
			MastersObj.countryDescription.sendKeys(newCountryName);
			test.pass("Country Description is entered");
			MastersObj.Savebtn.click();
			test.pass("Save button is clicked");
			//wait.until(ExpectedConditions.visibilityOf(MastersObj.searchBox));
			//wait.until(ExpectedConditions.visibilityOf(MastersObj.Action));
			Thread.sleep(3000);  
			
			/*if(MastersObj.successMesg.equals("Successful")) {
			test.pass("The success message is displayed", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
			}else {
				test.fail("aaaaaaaaaa");
			}
			Thread.sleep(3000);*/
			MastersObj.searchBox.click();
			MastersObj.searchBox.sendKeys(Keys.CONTROL + "a"); // Select all text
			MastersObj.searchBox.sendKeys(Keys.DELETE);
			MastersObj.searchBox.sendKeys(newCountryName);
			String actCountryName=MastersObj.countryDatatable.getText();
			if(actCountryName.equals(newCountryName)) { 
				test.pass("New country displayed in data table.");
			}else {
				test.fail("<font color='red'>Create new Country failed.</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());

			}
						
			//Update Country 
	        test.info("<b><font color = 'purple'>Test case-5 Verify the Update Country functionality </b>");
     		MastersObj.editButton.click();
			test.pass("Edit button clicked");
			//wait.until(ExpectedConditions.visibilityOf(MastersObj.editCountry));
			Thread.sleep(3000);
			MastersObj.editCountry.sendKeys("Test");
			MastersObj.countryCode.sendKeys("Test");
			MastersObj.countryDescription.sendKeys("Test");
			MastersObj.Savebtn.click();
			test.pass("Save button is clicked.");
			//wait.until(ExpectedConditions.visibilityOf(MastersObj.searchBox));
			
			Thread.sleep(2000);
			String Expected=newCountryName+"Test";
			MastersObj.searchBox.click();
			MastersObj.searchBox.sendKeys(Keys.CONTROL + "a"); // Select all text
			MastersObj.searchBox.sendKeys(Keys.DELETE);
			MastersObj.searchBox.sendKeys(Expected);
			String actCountryNameUpdate=MastersObj.countryDatatable.getText();
            if(actCountryNameUpdate.equals(Expected)) { 
				test.pass("Updated Country details displayed in data table.");
			}else {
				test.fail("<font color='red'>Update Country failed.</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());

			}
            
            
	        //Delete Country
			test.info("<b><font color = 'purple'>Test case-6 check the delete button is displyed </b>");
	        MastersObj.searchBox.click(); 
	        MastersObj.searchBox.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		    MastersObj.searchBox.sendKeys(Expected);
			MastersObj.DeleteOption.click();
			test.pass("Delete button clicked.");

			//no button click
			MastersObj.NoOption.click();
			if(actCountryNameUpdate.equals(newCountryName+"Test")) { 
				test.pass("Data not deleted.No nutton functionality working");
			}else {
				test.fail("<font color='red'>No button click failed.</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());

			}
			
			MastersObj.DeleteOption.click();
			//delete confirm button
			MastersObj.ConfirmOption.click(); 
			test.pass("Clicked the confirm option ");
			if(actCountryName.contains(newCountryName+"Test")) { 
				test.fail("Data not deleted.Confirm button functionality not working",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
			}else {
	            test.pass("Data deleted sucessfully");
			}


		} 
	 
		@AfterSuite

		public void reportflush() {

			reports.flush();

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
		 

		@AfterTest

		public void close() {

			driver.close();

		}
	 
		

	 
	}



