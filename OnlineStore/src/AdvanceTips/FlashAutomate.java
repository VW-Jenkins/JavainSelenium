package AdvanceTips;

import org.testng.annotations.Test;

import Flash.FlashObjectWebDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FlashAutomate {
	private static WebDriver driver = null;
	private static FlashObjectWebDriver flashApp = null;

	@Test
	public void f() throws InterruptedException {
		Thread.sleep(5000);
		flashApp.callFlashObject("Play");
		//driver.findElement(By.name("Play")).click();			
	  	Thread.sleep(5000);		
		flashApp.callFlashObject("StopPlay");			
		Thread.sleep(5000);		
		flashApp.callFlashObject("SetVariable","/:message","Flash testing using selenium Webdriver");
	    System.out.println(flashApp.callFlashObject("GetVariable","/:message"));
	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Users\\v-victw\\Desktop\\chromedriver_win32\\chromedriver.exe");
		
		/*
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = Collections.singletonMap("profile.content_settings.exceptions.plugins.*,.per_resource.adobe-flash-player",1);
		options.setExperimentalOption("prefs", prefs);
		 */
		
		//below code enable flash on Chrome
		ChromeOptions options = new ChromeOptions();
	    Map<String, Object> prefs = new HashMap<String, Object>();
	    prefs.put("profile.default_content_setting_values.plugins", 1);
	    prefs.put("profile.content_settings.plugin_whitelist.adobe-flash-player", 1);
	    prefs.put("profile.content_settings.exceptions.plugins.*,*.per_resource.adobe-flash-player", 1);
	    // Enable Flash for this site
	    prefs.put("PluginsAllowedForUrls", "https://arlo.netgear.com");
	    options.setExperimentalOption("prefs", prefs); 
	    
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		String url = "http://demo.guru99.com/test/flash-testing.html";
		flashApp = new FlashObjectWebDriver(driver, "myFlashMovie");
		driver.get(url);
		
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
