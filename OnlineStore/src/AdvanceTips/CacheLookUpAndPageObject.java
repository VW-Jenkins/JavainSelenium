package AdvanceTips;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class CacheLookUpAndPageObject {
	private static WebDriver driver = null;
  @Test
  public void f() {
	  PracticeFormPageObject pageObject = PageFactory.initElements(driver, PracticeFormPageObject.class);
	  pageObject.firstName.sendKeys("Victor");
	  pageObject.lastName.sendKeys("Wang");
	  
	  pageObject.firstName.getText();
	  pageObject.lastName.getText();
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\v-victw\\Desktop\\geckodriver-v0.20.1-win64\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  String url = "http://toolsqa.com/automation-practice-form/";
	  driver.get(url);  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
