package TestCase_TestNGFrame;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// *.jar list
			//testng-6.0.jar
			//jcommander-1.7.jar
			//bsh-2.0b4.jar

public class TestNG {
	
	public WebDriver driver = null;
	
  @Test
  public void f() {

      driver.findElement(By.id("account")).click();
 
      driver.findElement(By.id("log")).sendKeys("TestingLA4v@outlook.com");
 
      driver.findElement(By.id("pwd")).sendKeys("9Esu%YxUmZuP1lBA");
 
      driver.findElement(By.id("login")).click();
 
      System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
 
      driver.findElement(By.id("account_logout"));
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\v-victw\\Desktop\\geckodriver-v0.20.1-win64\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  String url = "http://www.store.demoqa.com";
	  driver.get(url);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
