package automationFramework;

import org.openqa.selenium.firefox.*;
import org.openqa.selenium.WebDriver;

public class WebDriverCommands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\v-victw\\Desktop\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		String url = "http://www.store.demoqa.com";
		driver.get(url);
		
		String title = driver.getTitle();
		int titleLength = driver.getTitle().length();
		
		System.out.println("Title of the page is : " + title);
		System.out.println("Length of the title is : " + titleLength);
		
		String actualUrl = driver.getCurrentUrl();
		
		if(actualUrl.equals(url)) {
			
			System.out.println("Verification Successful - The correct Url is opened.");
		}else {
			System.out.println("Verification Failed - An incorrect Url is opened.");
			//In case of Fail, you like to print the actual and expected URL for the record purpose
			System.out.println("Actual URL is : " + actualUrl);
			System.out.println("Expected URL is : " + url);	
		}
		
		String pageSource = driver.getPageSource();
		int pageSourceLength = pageSource.length();
		
		System.out.println("Total length of the page source is : " + pageSourceLength);
		
		driver.quit();
	}

}
