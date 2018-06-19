package AdvanceTips;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class FindingBrokenLinks {
	private static WebDriver driver;
	public static List<WebElement> findAllLinks(WebDriver driver) {
		
		List<WebElement> elementList = new ArrayList<WebElement>();
		elementList = driver.findElements(By.tagName("a"));
		elementList.addAll(driver.findElements(By.tagName("img")));
		List<WebElement> finalList = new ArrayList<WebElement>();
		
		for(WebElement element:elementList ) {
			if(element.getAttribute("href")!=null) {
				finalList.add(element);
			}
		}
		
		return finalList;
	}
	
	public static String isLinkBroken(URL url)throws Exception{
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		
		try {
			connection.connect();
			String response  = connection.getResponseMessage();
			connection.disconnect();
			return response;
		}catch (Exception e) {
			// TODO: handle exception
			return e.getMessage();
		}
	}
  @Test
  public void f() {
	  List<WebElement> allImages = findAllLinks(driver);
	  System.out.println("Total number of elements found " + allImages.size());
	  for(WebElement element:allImages) {
		  try {
			  System.out.println("URL:" + element.getAttribute("href")+"  returned"+isLinkBroken(new URL(element.getAttribute("href"))));
			  
		  }catch (Exception e) {
			// TODO: handle exception
			  System.out.println("At " + element.getAttribute("innerHTML") + "Exception occured -&gt; " + e.getMessage());
		}
	  }
  }
  @BeforeMethod
  public void beforeMethod() {
		System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\v-victw\\Desktop\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		String url = "http://wwww.baidu.com";
		driver.get(url);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
