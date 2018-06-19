package practiceTestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;

public class PracticeWaitCommands {
	
	public static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\v-victw\\Desktop\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String url = "http://toolsqa.wpengine.com/automation-practice-switch-windows/";
		driver.get(url);
		
		driver.findElement(By.id("timingAlert")).click();
		
		System.out.println("Timer JavaScript Alert is triggered but it is not yet opened");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());
		
		System.out.println("Either Pop Up is displayed or it is Timed Out");
		myAlert.accept();
		System.out.println("Alert Accepted");
		driver.close();
	}

}
