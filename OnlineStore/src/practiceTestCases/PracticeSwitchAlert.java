package practiceTestCases;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PracticeSwitchAlert {

	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\v-victw\\Desktop\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		/*
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		String url = "http://toolsqa.wpengine.com/automation-practice-switch-windows/";
		driver.get(url);
		
		driver.findElement(By.id("alert")).click();
		Alert myAlert = driver.switchTo().alert();
		
		myAlert.accept();
		driver.close();
		*/
		//-----------------Simple alert-----------------
		/*
		driver  = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		String url="http://toolsqa.wpengine.com/handling-alerts-using-selenium-webdriver/";
		driver.get(url);
		
		driver.findElement(By.xpath("//p[4]/button")).click();
		Alert simpleAlert = driver.switchTo().alert();
		String alertText = simpleAlert.getText();
		System.out.println("Alert text is " + alertText);
		simpleAlert.accept();
		*/
		//------------ConfirmationAlert-----------------------------
		
		/*
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		String url="http://toolsqa.wpengine.com/handling-alerts-using-selenium-webdriver/";
		driver.get(url);
		WebElement element = driver.findElement(By.xpath("//div[@id='content']/p[8]/button"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click()", element);
		Alert confirmationAlert = driver.switchTo().alert();
		String alertText = confirmationAlert.getText();
		System.out.println("Alert text is " + alertText);
		confirmationAlert.dismiss();
		*/
		//-------------------------PromptAlert-----------------------
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		String url="http://toolsqa.wpengine.com/handling-alerts-using-selenium-webdriver/";
		driver.get(url);
		
		WebElement element = driver.findElement(By.xpath("//div[@id='content']/p[11]/button"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click()", element);
		
		Alert promptAlert = driver.switchTo().alert();
		String alertText = promptAlert.getText();
		System.out.println("Alert text is " + alertText);
		promptAlert.sendKeys("Accept the alert");
		Thread.sleep(1000);
		promptAlert.accept();
		driver.close();
		
	}

}
