package HybridAutomationFramework.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;;

public class Utils {
	public static WebDriver driver = null;

	public static WebDriver openBrowser(int iTestCaseRow) throws Exception {
		String sBrowserName = "";
		try {
			sBrowserName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Browser);
			if (sBrowserName.equals("Mozilla")) {
				System.setProperty("webdriver.gecko.driver",
						"C:\\\\Users\\v-victw\\Desktop\\geckodriver-v0.20.1-win64\\geckodriver.exe");
				driver = new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Log.info("Implicit wait applied on the driver for 10 seconds");

				driver.get(Constant.url);
				Log.info("Web application launched successfully");
			}

		} catch (Exception e) {
			// TODO: handle exception
			Log.error("Class Utils | Method OpenBrowser | Exception desc : " + e.getMessage());
		}
		return driver;
	}

	public static String getTestCaseName(String sTestCase)throws Exception{
		String value=sTestCase;
		try {
			int posi = value.indexOf("@");
			value = value.substring(0,posi);
			posi = value.lastIndexOf(".");
			value=value.substring(posi+1);
			return value;
		}catch(Exception e){
			Log.error("Class Utils | Method getTestCaseName | Exception desc : "+e.getMessage());
			throw(e);
		}
	}
	
}
