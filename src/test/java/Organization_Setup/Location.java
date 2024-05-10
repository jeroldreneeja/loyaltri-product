package Organization_Setup;

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
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.github.javafaker.Faker;

import Library.CommonFunctions;
import Objects.MastersObj;
import Objects.OrganizationSetupObj;

public class Location   extends CommonFunctions{
	 static String screenShot;
	 @BeforeSuite
	 public void report() { 
	 	
	 	report = new ExtentSparkReporter("Reports/Location.html");
	 	reports = new ExtentReports();
	 	reports.attachReporter(report);
	 	
	 	reports.setSystemInfo("<b>Application<b>", "<b>Location<b>");
	 	reports.setSystemInfo("<b>Module<b>", "<b>Organization Setup - Location <b>");
	 	reports.setSystemInfo("<b>Author<b>", "<b>Testing Team<b>");
	 }

	 @Test(priority = 1)
	 public void LocationTest() throws Exception{
	 	Faker faker = new Faker();
	 	test = reports.createTest("Testcase for Location Page");
	 	PageFactory.initElements(driver,OrganizationSetupObj.class);
	 	PageFactory.initElements(driver,MastersObj.class);
	 	test.info("<b><font color = 'purple'>Test case-1 Verify the Location page is displayed </b>");
	 	MastersObj.settings.click();
	 	test.pass("Settings Menu Clicked");
	 	OrganizationSetupObj.organizationSetupMenu.click();
	 	test.pass("Organization Setup menu clicked");
	 	OrganizationSetupObj.locationMenu.click();
	 	test.pass("Location Menu clicked");
	 	String actLocation = OrganizationSetupObj.locationMenu.getText();
	 	if(actLocation.equals("Location")) {
	 		test.pass("Location Page is Displayed");
	 	}
	 	else {
	 		test.fail("<font color='red'>Location page is not displayed</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
	 	}
	 	
	 	
	 	test.info("<b><font color = 'purple'>Test case-2 Verify the create Location field is displayes </b>");
	 	OrganizationSetupObj.createLocationbtn.click();
	 	test.pass("Create Location Button Clicked");
	 	Thread.sleep(1000);
	 	System.out.println(OrganizationSetupObj.createLocationheading.getText()+"Create Location");
	 	if(OrganizationSetupObj.createLocationheading.getText().equals("Create Location")) {
	 		test.pass("Create Location child window is displayed.The heading is :"+OrganizationSetupObj.createLocationheading.getText());
	 	}else {
	 		test.fail("<font color='red'>Location page is not displayed</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
	      Thread.sleep(2000);
	 	}
	 	
	 	
	 	test.info("<b><font color = 'purple'>Test case-3 Verify the Cancel Button </b>");
	 	OrganizationSetupObj.locationCancelbtn.click();
	 	test.pass("Cancel Button Clicked");
	 	if(OrganizationSetupObj.createLocationbtn.isDisplayed()) {
	 		test.pass("Cancel button worked.Create Country child window is closed.");
	 	}else {
	 		test.fail("<font color='red'>The functionality of the cancel button did not execute as expected.</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
	 	}

	 	
	 	test.info("<b><font color = 'purple'>Test case- 4 Verify whether the user can successfully create a new Location </b>");
	 	OrganizationSetupObj.createLocationbtn.click();
	 	test.pass("Create Location Button Clicked");
	 	OrganizationSetupObj.createLocationbtn.isDisplayed();
	 	Thread.sleep(2000);
	 	
	 	String location = faker.letterify("Location "+"???");
	 	OrganizationSetupObj.enterLocation.click();
	 	OrganizationSetupObj.enterLocation.sendKeys(location);
	 	test.pass("Location entered");
	 	Thread.sleep(2000);
	 	 
	 	
	 	//String description=faker.letterify("Description" +"??????");
	 	OrganizationSetupObj.enterLocationdescription.click();
	 	OrganizationSetupObj.enterLocationdescription.sendKeys(location);
	 	test.pass("Description entered");
	 	
	 	OrganizationSetupObj.locationSavebtn.click();
	 	test.pass("Save Button Clicked");
	 	Thread.sleep(4000);
	 	
	 	OrganizationSetupObj.locationSearchbox.click();
	 	OrganizationSetupObj.locationSearchbox.sendKeys(location);
	 	OrganizationSetupObj.locationSearchbox.sendKeys(Keys.ENTER);
	 	Thread.sleep(2000);
	 	
	 	String actLocationDT=OrganizationSetupObj.locationDatatable.getText();
	 	System.out.println("comp1"+actLocationDT);
	 	if(actLocationDT.equals(location)) {
	 		test.pass("New Location displayed in data table");
	 		}else {
	 			test.fail("<font color='red'>Create Location failed.</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
	 		}
	 	
	 	//Update Location
	 	test.info("<b><font color='purple'>TestCase 5 - Verify the update location functionality </b></font>");
	 	OrganizationSetupObj.editLocation.click();
	 	test.pass("Edit Button Clicked");
	 	Thread.sleep(2000);
	 	 
	 	OrganizationSetupObj.editLocationname.sendKeys("Test");
	 	OrganizationSetupObj.editDescriptionfield.sendKeys("Test");
	 	OrganizationSetupObj.editLocationsaveBtn.click();
	 	test.pass("Save Button Clicked");
	 	Thread.sleep(2000);
	 	 
	 	String ExpectedLoc =location+"Test";
	 	OrganizationSetupObj.locationSearchbox.click();
	 	OrganizationSetupObj.locationSearchbox.sendKeys(Keys.CONTROL +"a");
	 	OrganizationSetupObj.locationSearchbox.sendKeys(Keys.DELETE);
	 	OrganizationSetupObj.locationSearchbox.sendKeys(ExpectedLoc);
	 	String locationupdate=OrganizationSetupObj.locationDatatable.getText();
	 	 if(locationupdate.equals(ExpectedLoc)) {
	 		 test.pass("Updated Location details displayed in data table");}
	 	 else {
	 		 test.pass("<font color='red'>Update Location failed.</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
	     	   		
	 	 }
	 	 
	 	//Delete Location
	 	test.info("<b><font color='purple'>TestCase 6 - Check the user is able to delete the Location </b></font>");
	 	OrganizationSetupObj.locationSearchbox.click();
	 	OrganizationSetupObj.locationSearchbox.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
	 	OrganizationSetupObj.locationSearchbox.sendKeys(ExpectedLoc);
	 	Thread.sleep(2000);
	 	OrganizationSetupObj.deleteLocationbtn.click();
	 	test.pass("Delete Button Clicked");
	 	 
	 	 //No Button Click
	 	OrganizationSetupObj.nobtnclick.click();
	 	if(locationupdate.equals(ExpectedLoc)) {
	 	test.pass("Data not deleted. No Button functionality working");}
	 	else {
	 		test.fail("<font color='red'>No button clicked.</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build()); 
	 	}
	 	Thread.sleep(2000);
	 	 
	 	 
	      //Delete Confirm BUtton
	 	OrganizationSetupObj.deleteLocationbtn.click();
	 	OrganizationSetupObj.confirmbtn.click();
	 	test.pass("Clicked the Confirm option") ;
	 	Thread.sleep(4000);
	 	System.out.println(locationupdate+ "111111111111111111");
	 	System.out.println(ExpectedLoc+ "2222222222222222222222");
	 	if(locationupdate.equals(ExpectedLoc)) {
	 		test.fail("<font color='red'>Data not deleted.Confirm button functionality not working</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
	 	 }else {
	 		test.pass("Data Deleted Successfully");
	 		 
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
}
