package Company;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import Objects.CompanyObj;
import Objects.MastersObj;

public class AllEmployees extends CommonFunctions{
	
	static String screenShot;
	Faker faker = new Faker();
	@BeforeSuite
	public void report() {
		
		report = new ExtentSparkReporter("Reports/Allemployees.html");    
		report.config().setReportName("Selenium Automation Report");
		reports = new ExtentReports();
		reports.attachReporter(report); 
		reports.setSystemInfo("Application", "Loyaltri Product");
		reports.setSystemInfo("Module", "Company >> All Employees");
		reports.setSystemInfo("Author", "Reneeja");
		
	}
	
	@Test(priority=1)
	public void DocumentTypeTest()throws Exception{ 
		test=reports.createTest("Testcases of All Employees");
		FileInputStream stream = new FileInputStream("config.properties");
		Properties properties = new Properties(); 
		properties.load(stream);
		PageFactory.initElements(driver,CompanyObj.class);
		CompanyObj.companyMenu.click();
		test.pass("Company Menu clicked");
		test.info("<b><font color = 'purple'>Test case-1 Check Employees page is displayed </b>");
		CompanyObj.allEmployeesMenu.click();
		test.pass("All Employee Menu Clicked");
		if(CompanyObj.employeesHeading.getText().equals("Employees")) {
			test.pass("All Employees page is displayed. The heading is :"+ "<b>"+CompanyObj.employeesHeading.getText()+"</b>");
		}else {
            test.fail("<font color='red'>All Employee page navigation failed.</font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
		}
		/*
		 * Add Employee
		 */
		test.info("<b><font color = 'purple'>Test case-2 Check the user is able to add new employee </b>");
		CompanyObj.addEmployeeButton.isDisplayed();
		test.pass("Add Employee Button is present");
		CompanyObj.addEmployeeButton.click();
		test.pass("Add Employee button is clicked");
		if(CompanyObj.addEmployeeHeading.getText().equals("Employee Onboarding")) {
			test.pass("Employee Onboarding page is displayed");
		}else {
            test.fail("<font color='red'>Employee Onboarding page navigation failed </font>",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());

		}
		
		//Employee Details
		test.info("<b><font color = 'purple'>Test case-3 Check the user is able to add Employee Details </b>");
		CompanyObj.employeeDetailsWizard.isDisplayed();
		test.pass("Employee Details Wizard is displayed");
		String perHeading=CompanyObj.PersonalDetailsHeading.getText();
		test.pass("The heading is <b>"+perHeading +"</b>");
		String fName=faker.name().firstName();
		CompanyObj.firstName.sendKeys(fName);
		test.pass("Entered First name is: "+fName);
		String mName=faker.name().nameWithMiddle();
		CompanyObj.middleName.sendKeys(mName);
		test.pass("Entered Middle name is: "+mName);
		String lname=faker.name().lastName();
		CompanyObj.lastName.sendKeys(lname);
		test.pass("Entered last name is: "+lname);
		CompanyObj.nickName.sendKeys(fName);
		test.pass("Entered Nick name is: "+fName);
		String emailfake=faker.internet().emailAddress();
		CompanyObj.email.sendKeys(emailfake);
		test.pass("Emtered Email is: "+emailfake);
		String mNumber=faker.numerify("##########");
		CompanyObj.mobileNumber.sendKeys(mNumber);
		test.pass("Entered Mobile number is: "+mNumber);
		CompanyObj.dateOfBirth.sendKeys(properties.getProperty("DOB"));
		CompanyObj.dateOfBirth.sendKeys(Keys.ENTER);
//		Thread.sleep(4000);
		test.pass("Entered Date of Birth is: "+properties.getProperty("DOB"));
		CompanyObj.gender.click();
		test.pass("Gender is selected");
//		Thread.sleep(4000);
		CompanyObj.bloodGroup.click();
		CompanyObj.bloodGroup.sendKeys("A+");
		CompanyObj.bloodGroup.sendKeys(Keys.ENTER);
		test.pass("Blood Group is selected");
//		Thread.sleep(4000);
		CompanyObj.religion.sendKeys("Hindu");
		CompanyObj.religion.sendKeys(Keys.ENTER);	
		test.pass("Religion is selected");
		CompanyObj.saveButton.click();
		Thread.sleep(1000);
		test.pass("Employee Details Saved", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
		CompanyObj.commAddressHeading.isDisplayed();
		test.pass("Address Details Wizard is displayed");
		String faddress=faker.address().cityName();
		CompanyObj.address.sendKeys(faddress);
		test.pass("Entered address is :" + faddress);
		CompanyObj.countyListBox.sendKeys(properties.getProperty("Country"));
		CompanyObj.countyListBox.sendKeys(Keys.ENTER);
		test.pass("Country is selected");
		CompanyObj.stateListBox.sendKeys(properties.getProperty("State"));
		CompanyObj.stateListBox.sendKeys(Keys.ENTER);
		test.pass("State is selected");
		CompanyObj.cityListBox.sendKeys(properties.getProperty("City"));
		CompanyObj.cityListBox.sendKeys(Keys.ENTER);
		test.pass("City is selected");
		CompanyObj.postalCode.sendKeys(properties.getProperty("PostalCode"));
		test.pass("ZipCode is entered");
		CompanyObj.checkbox.click();
		test.pass("Set same as communication address check box is clicked");
		String actAddress=CompanyObj.addressPer.getText();
		if(actAddress.equals(faddress)) {
			test.pass("Same Communication Address is displayed in Permanenet Address");
		}else {
			test.fail("Same as communication address functionality failed",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
		}  
		String actCountryName=CompanyObj.countyListBox1.getText();
		System.out.println(actCountryName+" ---------actCountryName");
		if(actCountryName.equals(properties.getProperty("Country"))){
			test.pass("Country name in commaunication address is displayed.");
		}else {
			test.fail("Same as communication address functionality failed",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
		}
		String actStateName=CompanyObj.stateListBox1.getText();
		System.out.println(actStateName);
		if(actStateName.equals(properties.getProperty("State"))){
			test.pass("State name in commaunication address is displayed.");
		}else {
			test.fail("Same as communication address functionality failed",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
		}
		String actCityName=CompanyObj.cityListBox1.getText();
		if(actCityName.equals(properties.getProperty("City"))){
			test.pass("City name in commaunication address is displayed.");
		}else {
			test.fail("Same as communication address functionality failed",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
		}
		String actPin=CompanyObj.postalCode1.getText();
		if(actPin.equals(properties.getProperty("PostalCode"))){
			test.pass("Postal code in communication address is displayed.");
		}else {
			test.fail("Same as communication address functionality failed",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());
		}
		CompanyObj.saveButton.click();
		test.pass("Save & Continue button is clicked"); 
		
				
		/*
		 * Work Details
		 */
		
		test.info("<b><font color = 'purple'>Test case-4 Check the user is able to add Work Details </b>");
		if(CompanyObj.workDetailsHeading.getText().equals("Work Details")) {
			test.pass("Work Details Wizard is displayed");
		}else {
			test.fail("Work Details Wizard not displayed",MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(driver,screenShot)).build());

		}
		CompanyObj.companyListBox.click();
		CompanyObj.companyListBox.sendKeys(properties.getProperty("Company"));
		CompanyObj.companyListBox.sendKeys(Keys.ENTER);
		test.pass("Company is selected.");
		
		CompanyObj.designationListBox.click();
		CompanyObj.designationListBox.sendKeys(properties.getProperty("Designation"));
		CompanyObj.designationListBox.sendKeys(Keys.ENTER);
		test.pass("Designation is selected");
		
		CompanyObj.departmentListBox1.click();
		CompanyObj.departmentListBox1.sendKeys(properties.getProperty("Department"));
		CompanyObj.departmentListBox1.sendKeys(Keys.ENTER);
		test.pass("Designation is selected");
		
		CompanyObj.categoryListBox1.click();
		CompanyObj.categoryListBox1.sendKeys(properties.getProperty("Category"));
		CompanyObj.categoryListBox1.sendKeys(Keys.ENTER);
		test.pass("Designation is selected");
		
		CompanyObj.dateofJoin.sendKeys(properties.getProperty("DateofJoin"));
		CompanyObj.dateofJoin.sendKeys(Keys.ENTER);
		test.pass("Date of Join is selected");
		
		CompanyObj.locationListBox.click();
		CompanyObj.locationListBox.sendKeys(properties.getProperty("Location"));
		CompanyObj.locationListBox.sendKeys(Keys.ENTER);
		test.pass("Location is selected");
		
		CompanyObj.shiftscheme.click();
		CompanyObj.shiftscheme.sendKeys(properties.getProperty("ShiftScheme"));
		CompanyObj.shiftscheme.sendKeys(Keys.ENTER);
		test.pass("Shift Scheme is selected");
		
		
		
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




