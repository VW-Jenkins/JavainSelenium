package automationFramework;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.*;

public class MultiSelectCommands {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\v-victw\\Desktop\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		String url = "http://toolsqa.wpengine.com/automation-practice-form";
		driver.get(url);
		
		Select oSelect = new Select(driver.findElement(By.name("selenium_commands")));
		oSelect.selectByIndex(0);
		Thread.sleep(2000);
		oSelect.deselectByIndex(0);
		
		oSelect.selectByVisibleText("Navigation Commands");
		Thread.sleep(2000);
		oSelect.deselectByVisibleText("Navigation Commands");
		
		List<WebElement> oSize = oSelect.getOptions();
		int iListSize = oSize.size();
		
		for(int i=0;i<iListSize;i++) {
			String sValue = oSelect.getOptions().get(i).getText();
			
			System.out.println(sValue);
			oSelect.selectByIndex(i);
			Thread.sleep(2000);
			
		}
		
		oSelect.deselectAll();
		driver.close();
	}

}
