package HybridAutomationFramework.automationFramework;

import org.testng.annotations.Test;

import HybridAutomationFramework.PageObject.PageObject_Home;
import HybridAutomationFramework.PageObject.PageObject_Login;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class POM_TC {
	private static WebDriver driver=null;
  @Test
  public void f() {
	  PageObject_Home.lnk_MyAccount(driver).click();
	  PageObject_Login.txtbx_UserName(driver).sendKeys("TestingLA4v@outlook.com");
	  PageObject_Login.txtbx_Password(driver).sendKeys("9Esu%YxUmZuP1lBA");
	  PageObject_Login.btn_LogIn(driver).click();
	  System.out.println("Login Successfully, now it is the time to Log Off buddy.");
	  PageObject_Home.lnk_LogOut(driver).click();
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\v-victw\\Desktop\\geckodriver-v0.20.1-win64\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  String url="http://www.store.demoqa.com";
	  driver.get(url); 
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
