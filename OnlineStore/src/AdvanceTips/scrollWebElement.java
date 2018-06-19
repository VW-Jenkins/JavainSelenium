package AdvanceTips;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class scrollWebElement {
	
	private static WebDriver driver = null;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\v-victw\\Desktop\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		String url = "http://toolsqa.wpengine.com";
		driver.get(url);
		
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//Approach 1
		//element.scrollIntoView(alignWithTop)
		//js.executeScript("document.getElementById('text-33').scrollIntoView(true);");
		
		//Approach 2
		int x = 0;
		WebElement targetElemenet = driver.findElement(By.id("text-33"));
		while((double)js.executeScript("return document.getElementById('text-33').getBoundingClientRect().top")>0) {
			x=x+2;
			js.executeScript("window.scrollByLines(2)");
			System.out.println("Client top is = " + (double) js.executeScript("return document.getElementById('text-33').getBoundingClientRect().top"));
		}
		System.out.println("Element is visible after  " + x + " scrolls");
		
		driver.quit();
	}

}
