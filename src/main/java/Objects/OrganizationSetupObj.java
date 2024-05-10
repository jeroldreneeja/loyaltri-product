package Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrganizationSetupObj{
		
			
	/*
	 * Category Locators
	 * Author: Nayana
	 */
		
	@FindBy (xpath="//a[text()='Organization Setup']")
	public static WebElement organizationSetupMenu;
	
	@FindBy (xpath="//p[text()='Category']")
	public static WebElement category;

	@FindBy(xpath="//p[contains(text(),'Category')]")
	public static WebElement categoryMenu;

	@FindBy(xpath="//span[contains(text(),'Create Category')] ")
	public static WebElement createcategoryBtn;

	@FindBy(xpath="//input[@placeholder='Enter Category']")
	public static WebElement categoryTextBox;

	@FindBy(xpath="//textarea[@placeholder='Enter Description']")
	public static WebElement enterDescription;

	@FindBy(xpath="//span[contains(text(),'Save')] ")
	public static WebElement saveBtn;

	@FindBy(xpath="//p[contains(text(),'Hryiwnsilkjmvguordsxbombd')]")
	public static WebElement dataCompare;

	@FindBy(xpath="//input[@type='text'] [@placeholder='Search']")
	public static WebElement searchBox;

	@FindBy(xpath="//tr[1]//td[2]")
	public static WebElement compare;

	@FindBy(xpath="//span[contains(text(),'Cancel')] ")
	public static WebElement cancelBtn;

	@FindBy(xpath="(//button[@type='button'])[1]")
	public static WebElement statusCheck;

	@FindBy(xpath="(//button[@class='w-8 h-8 2xl:w-10 2xl:h-10 rounded-full vhcenter hover:bg-primaryalpha/20 dark:hover:bg-primaryalpha/30 text-accent transition-all duration-300'])[1]")
	public static WebElement editBtn;

	@FindBy(xpath="//input[@placeholder='Enter Category']")
	public static WebElement editCategory;

	@FindBy(xpath="//textarea[@placeholder='Enter Description']")
	public static WebElement editDescription;

	@FindBy(xpath="//span[contains(text(),'Save ')]")
	public static WebElement editSavebtn;

	@FindBy(xpath="//tr[1]//td[2]")
	public static WebElement editCompare;

	@FindBy(xpath="//td[5]//button[2]")
	public static WebElement deleteBtn;

	@FindBy(xpath="//span[contains(text(),'No')]")
	public static WebElement noBtnclick;

	@FindBy(xpath="//span[contains(text(),'Confirm')]")
	public static WebElement confirmBtn;

	/*
	 * Location Locators
	 *  Author: Nayana
	 */
	@FindBy(xpath="//p[contains(text(),'Location')]")
	public static WebElement locationMenu;

	@FindBy(xpath="//span[contains(text(),'Create Location')] ")
	public static WebElement createLocationbtn;

	@FindBy(xpath="//h1[contains(text(),'Create Location')]")
	public static WebElement createLocationheading;

	@FindBy(xpath="//span[contains(text(),'Cancel ')]")
	public static WebElement locationCancelbtn;

	@FindBy(xpath="//input[@placeholder='Enter Location']")
	public static WebElement enterLocation;

	@FindBy(xpath="//textarea[@placeholder='Enter Description']")
	public static WebElement enterLocationdescription;

	@FindBy(xpath="//span[contains(text(),'Save')]")
	public static WebElement locationSavebtn;

	@FindBy(xpath="//input[@placeholder='Search']")
	public static WebElement locationSearchbox;

	@FindBy(xpath="//tr[1]//td[2]")
	public static WebElement locationDatatable;

	@FindBy(xpath="(//button[@class='w-8 h-8 2xl:w-10 2xl:h-10 rounded-full vhcenter hover:bg-primaryalpha/20 dark:hover:bg-primaryalpha/30 text-accent transition-all duration-300'])[1]")
	public static WebElement editLocation;

	@FindBy(xpath="//input[@placeholder='Enter Location']")
	public static WebElement editLocationname;

	@FindBy(xpath="//textarea[@placeholder='Enter Description']")
	public static WebElement editDescriptionfield;

	@FindBy(xpath="//span[contains(text(),'Save ')]")
	public static WebElement editLocationsaveBtn;

	@FindBy(xpath="(//tr)[2]//td[5]//button[2]")
	public static WebElement deleteLocationbtn;

	@FindBy(xpath="//span[contains(text(),'No')]")
	public static WebElement nobtnclick;

	@FindBy(xpath="//span[contains(text(),'Confirm')]")
	public static WebElement confirmbtn;


	/*
	 * Department Locators
	 *  Author: Nayana
	 */
	@FindBy(xpath="(//p[contains(text(),'Department')])[1]")
	public static WebElement departmentMenu;

	@FindBy(xpath="//span[contains(text(),'Create Department')] ")
	public static WebElement createDepartmentbtn;

	@FindBy(xpath="//h1[contains(text(),'Create Department')]")
	public static WebElement createDepartmentheading;

	@FindBy(xpath="//span[contains(text(),'Cancel ')]")
	public static WebElement departmentCancelbtn;


	@FindBy(xpath="//input[@placeholder='Enter Department']")
	public static WebElement enterDepartment;

	@FindBy(xpath="//textarea[@placeholder='Enter Description']")
	public static WebElement enterDepartmentdescription;

	@FindBy(xpath="//span[contains(text(),'Save')] ")
	public static WebElement departmentSavebtn;

	@FindBy(xpath="//input[@placeholder='Search']")
	public static WebElement departmentSearchbox;

	@FindBy(xpath="//tr[1]//td[2]")
	public static WebElement departmentDatatable;

	@FindBy(xpath="//button[@class='w-8 h-8 2xl:w-10 2xl:h-10 rounded-full vhcenter hover:bg-primaryalpha/20 dark:hover:bg-primaryalpha/30 text-accent transition-all duration-300'][1]")
	public static WebElement editDepartment;

	@FindBy(xpath="//input[@placeholder='Enter Department']")
	public static WebElement editDepartmentfield;

	@FindBy(xpath="//textarea[@placeholder='Enter Description']")
	public static WebElement editDescriptionfield1;

	@FindBy(xpath="//span[contains(text(),'Save ')]")
	public static WebElement editDepartmentsavebtn;

	@FindBy(xpath="(//tr)[2]//td[5]//button[2]")
	public static WebElement deleteDepartment;

	@FindBy(xpath="//span[contains(text(),'No')]")
	public static WebElement noDepartmentbtn;

	@FindBy(xpath="//span[contains(text(),'Confirm')]")
	public static WebElement confirmDepartmentbtn;

	
	
	

}
