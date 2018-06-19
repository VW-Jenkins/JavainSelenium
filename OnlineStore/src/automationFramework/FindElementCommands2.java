package automationFramework;

import org.openqa.selenium.firefox.*;
import org.openqa.selenium.*;

public class FindElementCommands2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\v-victw\\Desktop\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		String url = "http://toolsqa.wpengine.com/Automation-practice-form/";
		driver.get(url);
		
		driver.findElement(By.partialLinkText("Partial")).click();
		System.out.println("Partial Link Test Pass");
		
		String sClass = driver.findElements(By.tagName("button")).toString();
		System.out.println(sClass);
		
		driver.findElement(By.linkText("Link Test")).click();
		System.out.println("Link Test Pass");
		
		driver.close();
	}

}
