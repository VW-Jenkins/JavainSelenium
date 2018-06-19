package InterMediateTips;


import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PracticeAutoItUploadFile {

	public static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		//1. Download the AutoIt and AutoIt Script
		//2. Write the AutoIt script
		//3. Convert AutoIt file to exe
		//4. Use the Selenium call it
		System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\v-victw\\Desktop\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		String url = "http://toolsqa.com/automation-practice-form/";
		driver.get(url);
		
		//driver.findElement(By.id("photo")).click();
		WebElement uploadBtn = driver.findElement(By.id("photo"));
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		exe.executeScript("arguments[0].click()", uploadBtn);
		Runtime.getRuntime().exec("C:\\Users\\v-victw\\Desktop\\upload.exe");
		Thread.sleep(2000);
		driver.close();
	}

}
