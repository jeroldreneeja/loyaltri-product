package Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MastersObj {
	
	@FindBy (xpath="//p[contains(text(),'Settings')]")
	public static WebElement settings;
	
	@FindBy (xpath="//a[contains(text(),'Masters')]")
	public static WebElement masters;
	
	
	@FindBy (xpath="//span[contains(text(),'Designation')]//parent::button")
	public static WebElement designation;
	
	/*
	 * Locators of Document Types
	 */
	
	@FindBy (xpath="//span[contains(text(),'Document Type')]//parent ::button")
	public static WebElement documentTypeMenu;
	
	@FindBy (xpath="//p[contains(text(),'Document Type')]")
	public static WebElement documentTypeHeading; //need to change after bug fix
	
	@FindBy (xpath="//span[contains(text(),'Create Document Type')]")
	public static WebElement createDocumentTypeBtn; //need to change after bug fix
	
	@FindBy (xpath="//h1[text()='Create a New Document Type']")
	public static WebElement createDocumentTypeHeading; //need to change after bug fix 
	
	@FindBy (xpath="//input[@placeholder='Document Type']")
	public static WebElement documentType; 
	
	@FindBy (xpath="//textarea[@placeholder='Enter Description here']")
	public static WebElement description; 
	
	@FindBy (xpath="//span[text()='Save']")
	public static WebElement saveDocumentButton; 
	
	
	/*
	 * Locators of Country
	 */
	@FindBy (xpath="//p[text()=\"Country\"]")
	public static WebElement countryOpt;
	
 
	@FindBy (xpath="//p[text()='Country']")
	public static WebElement Country;
	
	@FindBy (xpath="(//p[text()='Country'])[2]")
	public static WebElement countryHeading;
	
	@FindBy (xpath="//h1[text()='Create Country']")
	public static WebElement createCountryHeading;
	
	//edit country
	
	@FindBy (xpath="(//button[@class ='w-8 h-8 2xl:w-10 2xl:h-10 rounded-full vhcenter hover:bg-primaryalpha/20 dark:hover:bg-primaryalpha/30 text-accent transition-all duration-300'])[1]")
	public static WebElement editButton;
 
	@FindBy (xpath="//input[@placeholder='Enter Country']")
	public static WebElement editCountry;
	
	@FindBy (xpath="//input[@placeholder='Enter Country Code']")
	public static WebElement editCode;
	
	@FindBy (xpath="//textarea[@placeholder='Enter Description']")
	public static WebElement editDescription;
	
	
	@FindBy (xpath="//span[text()='Save ']")
	public static WebElement Savebtn;
	
	//create country
	
	@FindBy (xpath="//span[text()='Create Country ']")
	public static WebElement createCountryOpt;
	
	
	@FindBy (xpath="//input[@placeholder='Enter Country']")
	public static WebElement countryName;
	
	@FindBy (xpath="//input[@placeholder='Enter Country Code']")
	public static WebElement countryCode;
	
 
 
	@FindBy (xpath="//textarea[@placeholder=' Description']")
	public static WebElement countryDescription;
	
	
	@FindBy (xpath="((//button[@class='w-8 h-8 2xl:w-10 2xl:h-10 rounded-full vhcenter hover:bg-primaryalpha/20 dark:hover:bg-primaryalpha/30 text-accent transition-all duration-300'])[2])[1]")
	public static WebElement delete;
 
	
	//cANCEL OPTION
	
 
	@FindBy (xpath="//span[text()='Cancel ']")
	public static WebElement CancelOption;
	
	
	//seacrh option home page
	@FindBy (xpath="//input[@placeholder='Search']")
	public static WebElement searchBox;
	
//search the country name
	
	@FindBy (xpath="//span[@class='ant-input-affix-wrapper css-1r82puo ant-input-outlined w-full border focus:outline-none  mt-0 w-ful md:w-auto']")
	public static WebElement searchValue;
 
	
	
	
	//delete the country
	@FindBy (xpath="((//button[@class='w-8 h-8 2xl:w-10 2xl:h-10 rounded-full vhcenter hover:bg-primaryalpha/20 dark:hover:bg-primaryalpha/30 text-accent transition-all duration-300'])[2])[1]")
	public static WebElement DeleteOption;
	
	@FindBy (xpath="//span[contains(text(), 'Confirm')]")
	public static WebElement ConfirmOption;
	
	@FindBy (xpath="(//span[text()='No'])[1]")
	public static WebElement NoOption;
	
	@FindBy (xpath="//div[@class='ant-notification-notice-message']")
	public static WebElement successMesg; 
	@FindBy (xpath="//div[@class='ant-notification-notice-description']")
	public static WebElement successMesgDescription; 
	
	@FindBy (xpath="//table/tbody/tr[1]/td[2]")
	public static WebElement countryDatatable; 
	
	@FindBy (xpath="//table/thead/tr/th[6]")
	public static WebElement Action;
	

}
