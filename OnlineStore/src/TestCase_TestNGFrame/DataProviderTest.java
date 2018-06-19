package TestCase_TestNGFrame;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DataProviderTest {
	
	private static WebDriver driver = null;
  
  @DataProvider(name="Authentication")
  public static Object[][] credentials(){
	  return new Object[][] {{"TestingLA4v@outlook.com","9Esu%YxUmZuP1lBA"},{"TestingLA4v@outlook.com","9Esu%YxUmZuP1lBA"}};
  }
  @Test(dataProvider = "Authentication")
  public void f(String sUsername, String sPassword) {
	  System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\v-victw\\Desktop\\geckodriver-v0.20.1-win64\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  
	  String url = "http://www.store.demoqa.com";
	  
	  driver.get(url);
	  driver.findElement(By.xpath(".//*[@id='account']/a")).click();
	  driver.findElement(By.id("log")).sendKeys(sUsername);
	  
	  driver.findElement(By.id("pwd")).sendKeys(sPassword);
	  driver.findElement(By.id("login")).click();
	  
	  driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();
	  driver.quit();
	  
  }
}
