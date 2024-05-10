package Library;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Objects.LoginObj;


public class CommonFunctions {
	public static WebDriver driver;
	public static FileInputStream stream;
	
	public static ExtentSparkReporter report;
	public static ExtentReports reports;
	public static ExtentTest test;
	public static ExtentTest node;
	public static WebDriverWait wait;
	
	@BeforeTest
	public void main() throws IOException, InterruptedException  
	   {
				
		FileInputStream stream = new FileInputStream("config.properties");
		Properties properties = new Properties(); 
		properties.load(stream); 
		driver = new ChromeDriver();
		
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4)); 
		String URL=properties.getProperty("url"); 
		driver.navigate().to(URL);
		PageFactory.initElements(driver,LoginObj.class);
		LoginObj.emailAddress.sendKeys(properties.getProperty("EmailAddress"));
		LoginObj.password.sendKeys(properties.getProperty("Password"));
		LoginObj.signIn.click();
		Thread.sleep(4000);
		} 
	@AfterTest
	public void close()
	{
		driver.close();
	}
}


