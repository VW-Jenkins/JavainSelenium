package AdvanceTips;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EventThrowing {

	private static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\v-victw\\Desktop\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
		
		EventHandler handler = new EventHandler();
		eventDriver.register(handler);
		
		eventDriver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");
		
		
		WebElement element = eventDriver.findElement(By.id("timingAlert"));
		element.click();
		
		eventDriver.unregister(handler);
		
		eventDriver.close();
		//driver.quit();
	}

}
