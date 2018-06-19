package automationFramework;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class FindElementCommands1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\v-victw\\Desktop\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		String url = "http://toolsqa.wpengine.com/Automation-practice-form/";
		driver.get(url);
		
		driver.findElement(By.name("firstname")).sendKeys("victor");
		driver.findElement(By.name("lastname")).sendKeys("wang");
		
		driver.findElement(By.id("submit")).submit();
		
		driver.close();
	}

}
