package TestCase_TestNGFrame;

import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class MultiBrowser {
	private WebDriver driver = null;
	String url="http://www.store.demoqa.com";
	
  @Test
  public void f() {
		driver.findElement(By.xpath(".//*[@id='account']/a")).click();
		 
	    driver.findElement(By.id("log")).sendKeys("TestingLA4v@outlook.com");
	 
	    driver.findElement(By.id("pwd")).sendKeys("9Esu%YxUmZuP1lBA");
	 
	    driver.findElement(By.id("login")).click();
  }
  @BeforeClass
  @Parameters("browser") //pay attention parameter position 
  public void beforeTest(String browser) {
	  if(browser.equalsIgnoreCase("firefox")) {
		  System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\v-victw\\Desktop\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		  driver = new FirefoxDriver();
		  driver.get(url);
	  }else if(browser.equalsIgnoreCase("ie")) {
		  System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\v-victw\\Desktop\\chromedriver_win32\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.get(url);
	  }
  }

  @AfterClass
  public void afterTest() {
	  driver.quit();
  }

}
