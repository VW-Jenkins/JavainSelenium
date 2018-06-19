package practiceTestCases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Predicate;


public class PredicateWait {
	public static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\v-victw\\Desktop\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		String url = "http://toolsqa.wpengine.com/automation-practice-switch-windows/";
		driver.get(url);
		
		
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(Duration.ofMillis(250));
		wait.withTimeout(Duration.ofSeconds(2));
		wait.ignoring(NoSuchElementException.class);
		
		Predicate<WebDriver> predicate = new Predicate<WebDriver>() {
			public boolean apply(WebDriver arg0) {
				WebElement element = arg0.findElement(By.id("colorVar"));
				String color = element.getAttribute("color");
				System.out.println("The color if the button is " + color);
				if(color.equals("red")) {
					return true;
				}
				return false;
			}
		}; 
		
		//until cannot accept the predicate as parameter, so here need convert predicate to function
		
		
		//wait.until(predicate);
		
		driver.close();
	}

}
