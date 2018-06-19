package TestCase_TestNGFrame;

import org.testng.annotations.Test;

import utility.ExcelUtils_TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DataProviderTest_Excel {
	private static WebDriver driver = null;
	
  @BeforeMethod
  public void beforeMethod()throws Exception {
	  System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\v-victw\\Desktop\\geckodriver-v0.20.1-win64\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  String url="http://www.store.demoqa.com";
	  driver.get(url);
  }
  
  @Test(dataProvider = "dp")
  public void f(String sUsername, String sPassword) {
	   
	  driver.findElement(By.xpath(".//*[@id='account']/a")).click();
	  driver.findElement(By.id("log")).sendKeys(sUsername);
	  driver.findElement(By.id("pwd")).sendKeys(sPassword);
	  driver.findElement(By.id("login")).click();
	  driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();
	  
  }
  
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
  
  @DataProvider
  public Object[][] dp()throws Exception {
	  /*
    return new Object[][] {
      new Object[] { "TestingLA4v@outlook.com", "9Esu%YxUmZuP1lBA" },
      new Object[] { "TestingLA4v@outlook.com", "9Esu%YxUmZuP1lBA" },
    };
    */
	  Object[][] testObjectArray = ExcelUtils_TestNG.getTableArray("D:\\ToolsQA\\OnlineStore\\src\\testData\\TestData_TestNG_Excel.xlsx", "Sheet1");
	  return testObjectArray;
  }
}
