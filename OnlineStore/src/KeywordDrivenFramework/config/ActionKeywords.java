package KeywordDrivenFramework.config;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;
import static KeywordDrivenFramework.utility.ORUtils.OR;
import static KeywordDrivenFramework.executionEngine.DriverScript.bResult;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import KeywordDrivenFramework.utility.Log;

public class ActionKeywords {
	public static WebDriver driver = null;

	public static void openBrowser(String object, String data) {
		try {
			Log.info("Opening Browser");
			System.setProperty(Constants.Driver_FFName, Constants.Driver_Path);
			if(data.equals("Mozilla")) {
				driver= new FirefoxDriver();
				Log.info("Mozilla browser started");
			}else if (data.equals("IE")) {
				driver= new InternetExplorerDriver();
				Log.info("IE broowser started");
			}else if(data.equals("Chrome")) {
				driver = new ChromeDriver();
				Log.info("Chrome browser started");
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (Exception e) {
			// TODO: handle exception
			Log.info("Not able to open Browser --- " + e.getMessage());
			bResult = false;
		}
	}

	public static void navigate(String object, String data) {		
		try {
			Log.info("Navigating to URL");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.get(Constants.URL);
		} catch (Exception e) {
			// TODO: handle exception
			Log.info("Not able to navigate --- " + e.getMessage());
			bResult = false;
		}		
	}

	public static void click_MyAccount(String object, String data) {
		try {
			Log.info("Clicking on Webelement " + object);
			driver.findElement(By.xpath(OR.getProperty(object))).click();
		} catch (Exception e) {
			// TODO: handle exception
			Log.error("Not able to click --- " + e.getMessage());
			bResult = false;
		}
	}
	
	public static void input(String object, String data) {
		try {
			Log.info("Extering the text in " + object);
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(data);
		} catch (Exception e) {
			// TODO: handle exception
			 Log.error("Not able to Enter text --- " + e.getMessage());
			 bResult = false;
		}
	}
/*
	public static void input_Username(String object, String data) {
		try {
			Log.info("Entering the text in UserName");
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(Constants.UserName);
		} catch (Exception e) {
			// TODO: handle exception
			Log.error("Not able to Enter UserName --- " + e.getMessage());
			bResult = false;
		}
	}

	public static void input_Password(String object, String data) {	
		try {
			Log.info("Entering the text in Password");
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(Constants.Password);
		} catch (Exception e) {
			// TODO: handle exception
			Log.error("Not able to Enter Password --- " + e.getMessage());
			bResult=false;
		}
	}
*/
	public static void click_Login(String object, String data) {	
		try {
			Log.info("Clicking the login btn");
			driver.findElement(By.xpath(OR.getProperty(object))).click();
		} catch (Exception e) {
			// TODO: handle exception
			Log.error("Not able to click --- " + e.getMessage());
			bResult=false;
		}
	}

	public static void waitFor(String object, String data) throws InterruptedException {
		try {
			Log.info("Wait for 5 seconds");
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
			Log.error("Not able to Wait --- " + e.getMessage());
			bResult = false;
		}	
	}

	public static void click_LogOut(String object, String data) {
		try {
			Log.info("Click logout btn");
			driver.findElement(By.xpath(OR.getProperty(object))).click();	
		} catch (Exception e) {
			// TODO: handle exception
			Log.error("Not able to click --- " + e.getMessage());
			bResult = false;
		}		
	}

	public static void closeBrowser(String object, String data) {
		try {
			Log.info("Closing the browser");
			driver.quit();
			
		} catch (Exception e) {
			// TODO: handle exception
			Log.error("Not able to Close the Browser --- " + e.getMessage());
			bResult = false;
		}		
	}

}
