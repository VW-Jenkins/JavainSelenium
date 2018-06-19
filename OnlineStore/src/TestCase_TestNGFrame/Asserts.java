package TestCase_TestNGFrame;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Asserts {
	
	private static WebDriver driver = null;
  @Test
  public void f() {
	  System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\v-victw\\Desktop\\geckodriver-v0.20.1-win64\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	 
	  String url = "http://www.store.demoqa.com";
	  driver.get(url);
	  
	  WebElement myAccount = driver.findElement(By.xpath("//div[@id='account']"));
	  
	  Assert.assertTrue(myAccount.isDisplayed());
	  
	  myAccount.click();
  }
  @Test 
  public void test(){
	  String sValue = "Victor Wang";
	  System.out.println("What is your full name: ");
	  Assert.assertEquals("Victor Wang", sValue);
	  System.out.println(sValue);
  }
}
