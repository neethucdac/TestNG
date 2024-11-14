package testScript;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constants;
import utilities.ScreenShortUtilities;

public class Base {
	public WebDriver driver; // is an interface,declared globally
	public  ScreenShortUtilities scrshot;
	 public Properties properties; 
	 public FileInputStream fis;
@BeforeMethod(alwaysRun = true)
@Parameters("browser")
	public void initializeBrowser(String browser) throws Exception {//for crossbrowsing parameter is given
	
		//driver = new ChromeDriver();
	 try { 
			properties = new Properties(); 
			fis = new FileInputStream(Constants.CONFIGFILE); 
			properties.load(fis); 

		} catch (FileNotFoundException exception) { 
			exception.printStackTrace(); 
		} 
		if (browser.equalsIgnoreCase("chrome")) { 
			driver = new ChromeDriver(); 
		} else if (browser.equalsIgnoreCase("edge")) { 
			driver = new EdgeDriver(); 
		} else if (browser.equalsIgnoreCase("firefox")) { 
			driver = new FirefoxDriver(); 
		} else { 
			throw new Exception("invalid browser"); 
		}
		// driver=new EdgeDriver();
		// driver=new FirefoxDriver();
		//driver.get("https://selenium.qabible.in/index.php");
		driver.get( properties.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// implicit wait
	}
@AfterMethod
public void browserQuit(ITestResult iTestResult) throws IOException { 
		if (iTestResult.getStatus() == ITestResult.FAILURE) { 
			scrshot = new ScreenShortUtilities(); 
			scrshot.getScreenShot(driver, iTestResult.getName()); 
		} 

		driver.quit(); 
	}

	//no need for main method

}
