package practiceTestCases;


import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class PracticeiFrame {

	public static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\v-victw\\Desktop\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		String url="http://toolsqa.wpengine.com/iframe-practice-page/";
		driver.get(url);
		// Get the iFrame number at the page
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
		System.out.println("Number of iframes on the page are " + numberOfFrames);
		
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println("The total number of iframes are " + iframeElements.size());
		
		//switch iFrame with index
		//driver.switchTo().frame(0);
		
		//switch iFrame with name
		//driver.switchTo().frame("iframe1");
		
		//switch iFrame with id
		//driver.switchTo().frame("IF1")
		
		//switch Frame by WebElement
		/*
		WebElement iframeElement = driver.findElement(By.id("IF1"));
		driver.switchTo().frame(iframeElement);
		driver.switchTo().defaultContent();
		*/
		
		driver.switchTo().frame(0);
		
		/*	 
		WebElement firstName = driver.findElement(By
				.xpath("//*[@id='content']/form/fieldset/div[1]/p[3]/input"));
 	
		WebElement lastName = driver.findElement(By
				.xpath("//*[@id='content']/form/fieldset/div[1]/p[4]/input"));
 
		firstName.sendKeys("Virender");
		lastName.sendKeys("Singh");	
		*/
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
 
		//Step 5: Find image element and click on that
		WebElement imageElement = driver.findElement(By
				.xpath("//*[@id='post-9']/div/div[1]/div/p[1]/a/img"));
 
		imageElement.click();
		System.out.println("Switching successfull");
		
		driver.close();
		
	}

}
