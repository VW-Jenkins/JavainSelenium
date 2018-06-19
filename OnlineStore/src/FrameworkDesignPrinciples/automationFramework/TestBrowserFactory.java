package FrameworkDesignPrinciples.automationFramework;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import FrameworkDesignPrinciples.Browser_Factory.*;
public class TestBrowserFactory {
	
	@BeforeMethod
	public static void BeforeMethod() {
		
	}
	
	@Test
	public static void sampleTest001() {
		// TODO Auto-generated method stub
		WebDriver driver = BrowserFactory.getBrowser("Firefox");
		driver.get("http://toolsqa.wpengine.com");
		WebDriver driver1 = BrowserFactory.getBrowser("Firefox");
		
		if(driver.equals(driver1)) {
			System.out.println("The two firefox drivers are same");
		}
	}
	
	@Test
	public static void sampleTest002() {
		WebDriver driver = BrowserFactory.getBrowser("Chrome");
		driver.get("http://toolsqa.wpengine.com");
		WebDriver driver1 = BrowserFactory.getBrowser("Chrome");
		
		if(driver.equals(driver1)) {
			System.out.println("The two chrome drivers are same");
		}
	}
	@AfterSuite
	public static void AfterMethod() {
		BrowserFactory.closeAllDriver();
	}

}
