package TestCase_TestNGFrame;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestngParameters {
	private static WebDriver driver = null;
	
  @Test
  @Parameters({"sUserName","sPassword"})
  
  public void test(String sUserName, String sPassword) {
	  System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\v-victw\\Desktop\\geckodriver-v0.20.1-win64\\geckodriver.exe");
	  
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	  
	  driver.get("http://www.store.demoqa.com");
	  driver.findElement(By.xpath("//div[@id='account']")).click();
	  driver.findElement(By.id("log")).sendKeys(sUserName);
	  driver.findElement(By.id("pwd")).sendKeys(sPassword);
	  driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();
	  
	  driver.quit();
	  
  }
}
