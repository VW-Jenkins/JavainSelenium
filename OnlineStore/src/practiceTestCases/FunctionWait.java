package practiceTestCases;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.FluentWait;
import com.google.common.base.Function;

public class FunctionWait {
	
	public static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\v-victw\\Desktop\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		String url = "http://toolsqa.wpengine.com/automation-practice-switch-windows/";
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get(url);
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(Duration.ofMillis(250));
		wait.withTimeout(Duration.ofMinutes(2));		
		wait.ignoring(NoSuchElementException.class);
		
		Function<WebDriver,WebElement> function = new Function<WebDriver,WebElement>(){
			public WebElement apply(WebDriver arg0) {
				System.out.println("Checking for the element!!");
				WebElement element = arg0.findElement(By.id("target"));
				if(element != null) {
					System.out.println("Target element found");
				}
				return element;
			}
		};
		wait.until(function);
		driver.close();
	}

}
