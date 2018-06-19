package HybridAutomationFramework.automationFramework;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import HybridAutomationFramework.PageObject.PageObject_Home;
import HybridAutomationFramework.appModule.SignIn_Action;
import HybridAutomationFramework.utility.*;

public class TestNG_Framework {
	
	private static WebDriver driver = null;
	@BeforeMethod
	public void BeforeMethod() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Selenium_Test_001");
		System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\v-victw\\Desktop\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		
		ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData, "Sheet1");
		Log.info("New driver instantiated");
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Implicit wait applied on the driver for 10 seconds");
		driver.get(Constant.url);
	}
	
	@Test
	public void f() throws Exception {
		// TODO Auto-generated method stubSignIn_Action.Execute(driver);
		SignIn_Action.Execute(driver);
		System.out.println("Login Successfully, now it is the time to Log Off buddy.");
 
		PageObject_Home.lnk_LogOut(driver).click(); 
 
		Log.info("Click action is perfomred on Log Out link");
		
	}
	@AfterMethod
	public void afterMethod() {
		driver.quit();
		Log.endTestCase("Selenium_Test_001");
	}
	
}
