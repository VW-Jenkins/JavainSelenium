package HybridAutomationFramework.automationFramework;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import HybridAutomationFramework.utility.Log;

public class ExceptionHandling {
	private static WebElement element = null;
	private static WebDriver myTestDriver=null;
	
	public static WebElement btn_ReportCategory(WebDriver driver) throws Exception {

		try {
			element = driver.findElement(By.linkText("+ Report Categories"));

		} catch (Exception e) {
			// Printing logs for my report
			Log.error("Report Category button element is not found.");

			// Taking screenshot for defect reporting
			//Utils.captureScreenShot();
			// After doing my work, now i want to stop my test case
			throw (e);

		}
		// This will return the Element in case of no Exception
		return element;
	}
	
	public static void handingTImeException() throws TimeoutException {
		try{
			 
		    myTestDriver.findElement(By.xpath("//*[@id='register']")).click();
		 
		}catch (Exception e) {
		 
			Log.error("Register element is not found.");
		 
			throw(e);
		 
		    }
	}
	
	public static boolean verifyObjectPresent(WebDriver driver) {
		 
	    try {
 
	    	driver.findElement(By.linkText("+ Report Categories"));
 
	    	return true;
 
	    } catch (Exception e) { 
 
	    	return false;
 
	    }
 
	}
	
}
