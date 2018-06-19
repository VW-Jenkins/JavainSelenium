package HybridAutomationFramework.automationFramework;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import HybridAutomationFramework.PageObject.PageObject_Home;
import HybridAutomationFramework.appModule.SignIn_Action;
import HybridAutomationFramework.utility.*;

public class UDF_TC {
	public static WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;

	@BeforeMethod
	public void beforeMethod() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		sTestCaseName = this.toString();
		sTestCaseName = Utils.getTestCaseName(this.toString());
		Log.startTestCase(sTestCaseName);
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData_UDF, "Sheet1");
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
		driver = Utils.openBrowser(iTestCaseRow);
	}

	@Test
	public void f() throws Exception {
		// TODO Auto-generated method stub
		SignIn_Action.Execute(driver);
		System.out.println("Login Successfully, now it is the time to Log Off buddy.");
		PageObject_Home.lnk_LogOut(driver).click();
		Log.info("Click action is performed on Log Out link");
	}
	
	@AfterMethod
	public void afterNethod() {
		driver.quit();
		Log.endTestCase(this.toString());
	}

}
