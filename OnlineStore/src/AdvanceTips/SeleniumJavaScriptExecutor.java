package AdvanceTips;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumJavaScriptExecutor {
	
	private static WebDriver driver = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver = new FirefoxDriver();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//Generate Alert Pop Window
		js.executeScript("alert('hello world');");
		//Click Action
		WebElement element = null;
		js.executeScript("arguments[0].click();", element);
		//Refresh Browser
		js.executeScript("history.go(0)");
		//Get InnerText of a Webpage
		String sText1 =  js.executeScript("return document.documentElement.innerText;").toString();
		//Get Title of a WebPage
		String sText2 =  js.executeScript("return document.title;").toString();
		//Scroll Page
		js.executeScript("window.scrollBy(0,150)");
	}

}
