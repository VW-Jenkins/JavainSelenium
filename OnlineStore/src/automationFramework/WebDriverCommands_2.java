package automationFramework;

import org.openqa.selenium.firefox.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebDriverCommands_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\v-victw\\Desktop\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		
		
		WebDriver driver = new FirefoxDriver();
		String url = "http://demoqa.com/frames-and-windows/";
		
		driver.get(url);
		driver.findElement(By.xpath("//div[@id='tabs-1']/div[@class='inside_contain']/p/a"));
		driver.close();
	}

}
