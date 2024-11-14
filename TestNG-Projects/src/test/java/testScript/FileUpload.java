package testScript;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUpload extends Base {
	@Test(retryAnalyzer=reTry.Retry.class)
	public void sendkeys()
	{
		driver.navigate().to("https://practice.expandtesting.com/upload#google_vignette"); 
	 	WebElement selectpdf=driver.findElement(By.xpath("//input[@id='fileInput']"));	 
	 	selectpdf.sendKeys("C:\\Users\\user\\Documents\\sample.pdf"); 
	 	WebElement upload=driver.findElement(By.xpath("//button[@id='fileSubmit']")); 
	 	//wait.until(ExpectedConditions.visibilityOf(upload));
	 	upload.click();	;
	}
	@Test(retryAnalyzer=reTry.Retry.class)
	public void robotclass() throws AWTException
	{
		driver.navigate().to("https://www.ilovepdf.com/pdf_to_word"); 
 		WebElement selectpdf=driver.findElement(By.xpath("//a[@id='pickfiles']")); 
 		selectpdf.click(); 
 		StringSelection stringselection =new StringSelection("C:\\Users\\user\\Documents\\sample.pdf"); 
 		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null); //line for copy path to clipboard 
 		Robot robot=new Robot(); 
 		robot.delay(2500);  //increase delay like 2500 if wont work 
 		/*robot.keyPress(KeyEvent.VK_ENTER); 
 		robot.keyRelease(KeyEvent.VK_ENTER); */ //no need of these two lines 
 		robot.keyPress(KeyEvent.VK_CONTROL);  
 		robot.keyPress(KeyEvent.VK_V); //paste ctrl+v  
 		robot.keyRelease(KeyEvent.VK_CONTROL); //to release keys 
 		robot.keyRelease(KeyEvent.VK_V); 
 		robot.keyPress(KeyEvent.VK_ENTER); 
 		robot.keyRelease(KeyEvent.VK_ENTER); 
	}

}
