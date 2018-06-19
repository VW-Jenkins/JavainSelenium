package automationFramework;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.*;

public class DropDownCommands {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\v-victw\\Desktop\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String url = "http://toolsqa.wpengine.com/automation-practice-form";
		driver.get(url);
		Select oSelect = new Select(driver.findElement(By.id("continents")));
		
		oSelect.selectByVisibleText("Europe");
		Thread.sleep(2000);
		
		oSelect.selectByIndex(2);
		Thread.sleep(2000);
		
		List<WebElement> oSize = oSelect.getOptions();
		int iListSize = oSize.size();
		
		for(int i=0;i<iListSize;i++) {
			String sValue = oSelect.getOptions().get(i).getText();
			System.out.println(sValue);
			
			if(sValue.equals("Africa")) {
				oSelect.selectByIndex(i);
				break;
				
			}
			
		}
		driver.quit();
	}

}
