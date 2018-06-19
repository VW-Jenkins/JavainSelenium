package practiceTestCases;


import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PracticeSwitchWindow {

	public static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\v-victw\\Desktop\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		// TODO Auto-generated method stub
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		String url = "http://toolsqa.wpengine.com/automation-practice-switch-windows/";
		driver.get(url);
		
		String handle = driver.getWindowHandle();
		System.out.println(handle);
		
		driver.findElement(By.xpath("//div[@id='content']/p[3]/button")).click();
		Set<String> handles = driver.getWindowHandles();
		
		System.out.println(handles);
		
		for(String handle1:driver.getWindowHandles()) {
			System.out.println(handle1);
			driver.switchTo().window(handle1);
		}
		
		driver.close();
		driver.quit();
	}

}
