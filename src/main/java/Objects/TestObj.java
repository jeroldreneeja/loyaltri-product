package Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestObj {
	@FindBy (xpath="(//p[@class ='text-[9px] 2xl:text-xs text-white'])[8]")
		public static WebElement settingsIcon;
		
		
		@FindBy (xpath="(//a[@class='2xl:text-sm text-[10px] dark:text-white'])[10]")
		public static WebElement master;
		
		@FindBy (xpath="//p[@class='relative z-20 text-white']")
		public static WebElement countryOpt;
		
	 
		@FindBy (xpath="//p[text()='Country']")
		public static WebElement Country;
		
		
		
		@FindBy (xpath="(//p[@class=' text-black dark:text-white group-hover:text-primary'])[3]")
		public static WebElement createCountry;
		
		@FindBy (xpath="//span[text() ='Create Country']")
		public static WebElement create_country;
		
		@FindBy (xpath="//button[@class='w-8 h-8 2xl:w-10 2xl:h-10 rounded-full vhcenter hover:bg-violet-200 text-accent transition-all duration-300']")
		public static WebElement editButton;
	 
		@FindBy (xpath="//input[@placeholder='Country']")
		public static WebElement editCountry;
		
		@FindBy (xpath="//input[@placeholder='Country Code']")
		public static WebElement editCode;
		
		@FindBy (xpath="//textarea[@placeholder='Enter Description']")
		public static WebElement editDescription;
		
		
		@FindBy (xpath="//span[text()='Save']")
		public static WebElement Savebtn;
		
		//create country
		
		@FindBy (xpath="//span[text()='Create Country']")
		public static WebElement createCountryOpt;
		
		
		@FindBy (xpath="//input[@placeholder='Country']")
		public static WebElement countryName;
		
		@FindBy (xpath="//input[@placeholder='Country Code']")
		public static WebElement countryCode;
		
		
	 
	 
		@FindBy (xpath="//textarea[@placeholder='Enter Description']")
		public static WebElement countryDescription;
		
		
		@FindBy (xpath="(//button[@class='w-8 h-8 2xl:w-10 2xl:h-10 rounded-full vhcenter hover:bg-violet-200 text-accent transition-all duration-300'])[1]")
		public static WebElement delete;
	 
		//cANCEL OPTION
		
	 
		@FindBy (xpath="//span[text()='Cancel']")
		public static WebElement CancelOption;
		
		//seacrh option home page
		
		@FindBy (xpath="//input[@placeholder='Search']")
		public static WebElement SearchlOption;
		
		//delete the country
		@FindBy (xpath="(//button[@class='w-8 h-8 2xl:w-10 2xl:h-10 rounded-full vhcenter hover:bg-violet-200 text-accent transition-all duration-300'])[1]")
		public static WebElement DeleteOption;

}
