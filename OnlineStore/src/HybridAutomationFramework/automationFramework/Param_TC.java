package HybridAutomationFramework.automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import HybridAutomationFramework.appModule.*;
import HybridAutomationFramework.PageObject.*;

public class Param_TC {

	private static WebDriver driver = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\v-victw\\Desktop\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		String url="http://www.store.demoqa.com";
		driver.get(url);
		
		SignIn_Action.Execute(driver, "TestingLA4v@outlook.com", "9Esu%YxUmZuP1lBA");
		System.out.println("Login Successfully, now it is the time to Log Off buddy.");
		
		PageObject_Home.lnk_LogOut(driver).click();
		
		driver.quit();
	}

}
