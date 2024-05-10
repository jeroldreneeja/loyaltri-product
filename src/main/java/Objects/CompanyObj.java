package Objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompanyObj {
	
	@FindBy (xpath="(//p[text()='Company'])[1]")
	public static WebElement companyMenu;
	
	/*
	 * Locators of All Employee
	 * Author: Reneeja
	 */
	@FindBy (xpath="//a[text()='All Employees']")
	public static WebElement allEmployeesMenu;
	
	@FindBy (xpath="//p[text()='Employees']")
	public static WebElement employeesHeading; 
	
	@FindBy (xpath="//span[text()='Add Employee ']")
	public static WebElement addEmployeeButton;
	
	@FindBy (xpath="//h1[text()='Employee Onboarding']")
	public static WebElement addEmployeeHeading;
	
	@FindBy (xpath="//div[text()='Employee Details']")
	public static WebElement employeeDetailsWizard;
	
	@FindBy (xpath="//h1[text()='Personal Details']")
	public static WebElement PersonalDetailsHeading; 
	
	@FindBy (xpath="//input[@placeholder='Enter First Name']")
	public static WebElement firstName;
	
	@FindBy (xpath="//input[@placeholder='Enter Middle Name']")
	public static WebElement middleName;
	
	@FindBy (xpath="//input[@placeholder='Enter Last Name']")
	public static WebElement lastName;
	
	@FindBy (xpath="//input[@placeholder='Enter Nick Name']")
	public static WebElement nickName;
	
	@FindBy (xpath="//input[@placeholder='Enter Email']")
	public static WebElement email;
	
	@FindBy (xpath="//input[@placeholder='Enter Mobile Number']")
	public static WebElement mobileNumber;
	
	@FindBy (xpath="//input[@placeholder='Date of Birth']")
	public static WebElement dateOfBirth;
	
	@FindBy (xpath="//input[@name='radiogroup' and @value='male']")
	public static WebElement gender;
	
//	@FindBy (xpath="//input[@type='search']//following::span[text()='Choose Blood Group']")
	@FindBy (xpath="(//input[@role='combobox'])[1]")
	public static WebElement bloodGroup;
	
//	@FindBy (xpath="//input[@type='search']//following::span[text()='Choose Religion']")
	@FindBy (xpath="(//input[@role='combobox'])[2]")
	public static WebElement religion;
	
	@FindBy (xpath="//span[text()='Save & Continue ']")
	public static WebElement saveButton;
	
	@FindBy (xpath="//h1[text()='Communication Address']")
	public static WebElement commAddressHeading;
	
	@FindBy (xpath="(//textarea)[1]")
	public static WebElement address;
	
	@FindBy (xpath="(//input[@role='combobox'])[1]")
	public static WebElement countyListBox;
	
	@FindBy (xpath="(//input[@role='combobox'])[2]")
	public static WebElement stateListBox;
	
	@FindBy (xpath="(//input[@role='combobox'])[3]")
	public static WebElement cityListBox;
	
	@FindBy (xpath="(//input[@placeholder='Enter Postal/ZIP Code'])[1]")
	public static WebElement postalCode;
	
	@FindBy (xpath="//h1[text()='Permanent Address']")
	public static WebElement perAddressheading;
	
	@FindBy (xpath="//input[@type='checkbox']")
	public static WebElement checkbox;
	
	@FindBy (xpath="(//textarea)[2]")
	public static WebElement addressPer;
	
	@FindBy (xpath="(//input[@role='combobox'])[4]")
	public static WebElement countyListBox1;
	
	@FindBy (xpath="(//input[@role='combobox'])[5]")
	public static WebElement stateListBox1;
	
	@FindBy (xpath="(//input[@role='combobox'])[6]")
	public static WebElement cityListBox1;
	
	@FindBy (xpath="(//input[@placeholder='Enter Postal/ZIP Code'])[2]")
	public static WebElement postalCode1;
	
	//Work Details Wizard
	
	@FindBy (xpath="//h1[text()='Work Details']")
	public static WebElement workDetailsHeading;
	
	@FindBy (xpath="(//input[@role='combobox'])[1]")
	public static WebElement companyListBox;
	
	@FindBy (xpath="(//input[@role='combobox'])[2]")
	public static WebElement designationListBox;
	
	@FindBy (xpath="(//input[@role='combobox'])[3]")
	public static WebElement departmentListBox1;
	
	@FindBy (xpath="(//input[@role='combobox'])[4]")
	public static WebElement categoryListBox1;
	
	@FindBy (xpath="(//input[@role='combobox'])[5]")
	public static WebElement reportsListBox1;
	
	@FindBy (xpath="(//input[@role='combobox'])[6]")
	public static WebElement locationListBox;
	
	@FindBy (xpath="(//input[@role='combobox'])[7]")
	public static WebElement shiftscheme;
	
	@FindBy (xpath="//input[@placeholder='Select Date']")
	public static WebElement dateofJoin;
	
//	@FindBy (xpath="(//input[@role='combobox'])[1]")
//	public static WebElement company;
//	
//	@FindBy (xpath="(//input[@role='combobox'])[2]")
//	public static WebElement designation;
//	
//	@FindBy (xpath="(//input[@role='combobox'])[3]")
//	public static WebElement department;
//	
//	@FindBy (xpath="(//input[@role='combobox'])[4]")
//	public static WebElement category;
//	
//	@FindBy (xpath="(//input[@role='combobox'])[5]")
//	public static WebElement reportsTo;
//	
//	@FindBy (xpath="//label[text()='Date of Join']//following::div/input")
//	public static WebElement dateOfJoin;
//	
//	@FindBy (xpath="(//input[@role='combobox'])[6]")
//	public static WebElement location;
	
//	@FindBy (xpath="(//input[@role='combobox'])[7]")
//	public static WebElement shiftScheme;
//	
	//Contract Policy Wizard
	
	@FindBy (xpath="//h1[text()='Probation & Notice Period Details']")
	public static WebElement contractPolicyHeading;  
	
	@FindBy (xpath="//input[@placeholder='Enter Probation Period in Days']")
	public static WebElement probationPeriodInDays;
	
	@FindBy (xpath="//label[text()='Notice Period in Days']//following::input[1]")
	public static WebElement noticePeriodInDays;
	
	@FindBy (xpath="(//input[@role='combobox'])[1]")
	public static WebElement TimeinOutPolicy;
	
	@FindBy (xpath="(//input[@role='combobox'])[2]")
	public static WebElement overTimePolicy;
	
	@FindBy (xpath="(//input[@role='combobox'])[3]")
	public static WebElement shortTimePolicy;
	
	@FindBy (xpath="(//input[@role='combobox'])[4]")
	public static WebElement missPunchPolicy;
	
	@FindBy (xpath="//button//following::span[text()='Set Leave Types ']")
	public static WebElement setLeaveTypesButton;
	
	@FindBy (xpath="//h1[text()='Leave Presets']")
	public static WebElement leavePresetsChildWindow;
	
	@FindBy (xpath="//p[text()='Select All Types']//preceding::input[@type='checkbox']")
	public static WebElement selectAllLeave;
	
	@FindBy (xpath="//h1[text()='Asset Details']")
	public static WebElement assetDetailsHeading;
	
	@FindBy (xpath="(//input[@role='combobox'])[1]")
	public static WebElement assetType;
	
	
	
	

}
