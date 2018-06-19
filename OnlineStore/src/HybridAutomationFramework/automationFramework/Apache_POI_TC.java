package HybridAutomationFramework.automationFramework;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import HybridAutomationFramework.PageObject.PageObject_Home;
import HybridAutomationFramework.appModule.SignIn_Action;
import HybridAutomationFramework.utility.Constant;
import HybridAutomationFramework.utility.ExcelUtils;
import HybridAutomationFramework.utility.Log;

public class Apache_POI_TC {

	private static WebDriver driver = null;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DOMConfigurator.configure("log4j.xml");
		
		Log.startTestCase("Selenium_Test_001");
		System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\v-victw\\Desktop\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		
		ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData, "Sheet1");
		Log.info(" Excel sheet opened");
		driver = new FirefoxDriver();
		Log.info("New driver instantiated");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Log.info("Implicit wait applied on the driver for 10 seconds");
		String url="http://www.store.demoqa.com";
		driver.get(url);
		Log.info("Web application launched");
		SignIn_Action.Execute(driver);
		System.out.println("Login Successfully, now it is the time to Log Off buddy.");
		
		PageObject_Home.lnk_LogOut(driver).click();
		Log.info("Click action is perfomred on Log Out link");
		driver.quit();
		Log.info("Browser closed");
		ExcelUtils.setCellData("Pass", 1, 3);
		Log.endTestCase("Selenium_Test_001");
	}

}
