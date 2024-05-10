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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.github.javafaker.Faker;

import Library.CommonFunctions;
import Objects.MastersObj;
import Objects.OrganizationSetupObj;

public class Department extends CommonFunctions {
	static String screenShot;
	
	@BeforeSuite
	public void report() {
		
		report = new ExtentSparkReporter("Reports/Department.html");
		reports = new ExtentReports(); 
		reports.attachReporter(report);
		
		reports.setSystemInfo("<b>Application<b>", "<b>Loyaltri<b>");
		reports.setSystemInfo("<b>Module<b>", "<b>Organization Setup - Department <b>");
		reports.setSystemInfo("<b>Author<b>", "<b>Testing Team<b>");
		
	}
	
	@Test(priority = 1)
	public void DepartmentTest() throws Exception{
		Faker faker = new Faker();
		test = reports.createTest("Testcase for Location Page");
		PageFactory.initElements(driver,OrganizationSetupObj.class);
		PageFactory.initElements(driver,MastersObj.class);
		test.info("<b><font color = 'purple'>Test case-1 Verify the Department page is displayed </b>");
		MastersObj.settings.click();
		test.pass("Settings Menu Clicked");
		OrganizationSetupObj.organizationSetupMenu.click();
		test.pass("Organization Setup menu clicked");
		OrganizationSetupObj.departmentMenu.click();
		test.pass("Department Menu Clicked");
		String actDepartment= OrganizationSetupObj.departmentMenu.getText();
		if(actDepartment.equals("Department")) {
			test.pass("Department Page is Displayed");
		}
		else {
			test.fail("<font color='red'>Department page is not displayed</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
			Thread.sleep(2000);
		}
		
		test.info("<b><font color = 'purple'>Test case-2 Verify the create Department field is displayes </b>");
		OrganizationSetupObj.createDepartmentbtn.click();
		test.pass("Create Department Button Clicked");
		Thread.sleep(1000);
		System.out.println(OrganizationSetupObj.createDepartmentheading.getText()+"Create Location");
		if(OrganizationSetupObj.createDepartmentheading.getText().equals("Create Department")) {
			test.pass("Create Department child window is displayed.The heading is :"+OrganizationSetupObj.createDepartmentheading.getText());
		}else {
			test.fail("<font color='red'>Department page is not displayed</font>", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
	     Thread.sleep(2000);
		}
		

		test.info("<b><font color = 'purple'>Test case-3 Verify the Cancel Button </b>");
		OrganizationSetupObj.departmentCancelbtn.click();
		test.pass("Cancel Button Clicked");
		if(OrganizationSetupObj.createDepartmentbtn.isDisplayed()) {
			test.pass("Cancel button worked.Create Country child window is closed.");
		}else {
			test.fail("<font color='red'>The functionality of the cancel button did not execute as expected.</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
		}

		
		
		test.info("<b><font color = 'purple'>Test case- 4 Verify whether the user can successfully create a new Department </b>");
		OrganizationSetupObj.createDepartmentbtn.click();
		test.pass("Create Department Button Clicked");
		OrganizationSetupObj.createDepartmentbtn.isDisplayed();
		Thread.sleep(2000);
		
		String department = faker.letterify("Department " + "???");
		OrganizationSetupObj.enterDepartment.click();
		OrganizationSetupObj.enterDepartment.sendKeys(department);
		test.pass("Department entered");
		Thread.sleep(2000);
		
		
		//String description=faker.letterify("Description" +"??????");
		OrganizationSetupObj.enterDepartmentdescription.click();
		OrganizationSetupObj.enterDepartmentdescription.sendKeys(department);
		test.pass("Description entered");
		
		OrganizationSetupObj.departmentSavebtn.click();
		test.pass("Save Button Clicked");
		Thread.sleep(4000);
		
		OrganizationSetupObj.departmentSearchbox.click();
		OrganizationSetupObj.departmentSearchbox.sendKeys(department);
		OrganizationSetupObj.departmentSearchbox.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		String comp1=OrganizationSetupObj.departmentDatatable.getText();
		if(comp1.equals(department)) {
			test.pass("New Department displayed in data table");
			}else {
			test.fail("<font color='red'>Create new Department failed</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
		}
		
		//Update Location
		 test.info("<b><font color='purple'>TestCase 5 - Verify the update Department functionality </b></font>");
		 OrganizationSetupObj.editDepartment.click();
		 test.pass("Edit Button Clicked");
		 Thread.sleep(2000);
		 
		OrganizationSetupObj.editDepartmentfield.sendKeys("Test");
		 OrganizationSetupObj.editDescriptionfield1.sendKeys("Test");
		 OrganizationSetupObj.editLocationsaveBtn.click();
		 test.pass("Save Button Clicked");
		 Thread.sleep(2000);
		 
		 String Expected = department+"Test";
		 OrganizationSetupObj.departmentSearchbox.click();
		 OrganizationSetupObj.departmentSearchbox.sendKeys(Keys.CONTROL +"a");
		 OrganizationSetupObj.departmentSearchbox.sendKeys(Keys.DELETE);
		 OrganizationSetupObj.departmentSearchbox.sendKeys(Expected);
		 String departmentupdate=OrganizationSetupObj.departmentDatatable.getText();
		 if(departmentupdate.equals(Expected)) {
			 test.pass("Updated Department details displayed in data table");}
		 else {
			 test.pass("<font color='red'>Update Department failed.</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
	    	   		
		 }
		 
		 //Delete Location
		 test.info("<b><font color='purple'>TestCase 6 - Check the user is able to delete the Department </b></font>");
		 OrganizationSetupObj.departmentSearchbox.click();
		 OrganizationSetupObj.departmentSearchbox.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		 OrganizationSetupObj.departmentSearchbox.sendKeys(Expected);
		 Thread.sleep(2000);
		 OrganizationSetupObj.deleteDepartment.click();
		 test.pass("Delete Button Clicked");
		 
		 //No Button Click
		 OrganizationSetupObj.noDepartmentbtn.click();
		 if(departmentupdate.equals(department+"Test")) {
			 test.pass("No button click verified,data not deleted. No Button functionality working");}
		 else {
			 test.fail("<font color='red'>No button click failed.</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build()); 
		 }
		 Thread.sleep(2000);
		 
		 //Delete Confirm BUtton
		 OrganizationSetupObj.deleteDepartment.click();
		 OrganizationSetupObj.confirmDepartmentbtn.click();
		 test.pass("Clicked the Confirm option") ;
		 if(departmentupdate.contains(department+"Test")) {
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
	 

	@AfterTest

	public void close() {

		driver.close();

	}
}
