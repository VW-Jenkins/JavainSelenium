package TestCase_TestNGFrame;

import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReportLogs {
	private static  WebDriver driver = null;
	private static Logger Log = Logger.getLogger(Log.class.getName());
  @Test
  public void test() {
	  System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\v-victw\\Desktop\\geckodriver-v0.20.1-win64\\geckodriver.exe");
	  DOMConfigurator.configure("log4j.xml");
	  driver = new FirefoxDriver();
	  Log.info("New driver instantiated");
	  
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  Log.info("Implicit wait applied on the driver for 50 seconds");

	  String url = "http://www.store.demoqa.com";
	  driver.get(url);
	  Log.info("Web Application launched");
	  
	  Reporter.log("Application launched successfully !");
	  
	  driver.findElement(By.id("account")).click();
	  Log.info("Click action performed on My Account link");
	  
	  driver.findElement(By.id("log")).sendKeys("TestingLA4v@outlook.com");
	  Log.info("Username entered in the Username text box");
	  
	  driver.findElement(By.id("pwd")).sendKeys("9Esu%YxUmZuP1lBA");
	  Log.info("Password entered in the Username text box");
	  
	  driver.findElement(By.id("login")).click();
	  Log.info("Click action performed on Submit button");
	  
	  Reporter.log("Sign In Successful !");
	  driver.findElement(By.id("account_logout"));
	  Log.info("Click action performed on Log out link");
	  driver.quit();
	  
	  Log.info("Browser closed");
	  Reporter.log("User is Logged out and Application is closed!");
  }
}
