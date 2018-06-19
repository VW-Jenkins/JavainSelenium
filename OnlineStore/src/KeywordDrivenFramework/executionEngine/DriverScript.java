package KeywordDrivenFramework.executionEngine;

import java.lang.reflect.Method;

import org.apache.log4j.xml.DOMConfigurator;



/*
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
*/
import KeywordDrivenFramework.config.ActionKeywords;
import KeywordDrivenFramework.config.Constants;
import KeywordDrivenFramework.utility.ExcelUtils;
import KeywordDrivenFramework.utility.ORUtils;
import KeywordDrivenFramework.utility.Log;

public class DriverScript {

	public static ActionKeywords actionKeywords;
	public static String sActionKeyword;
	public static Method method[];
	public static String sPageObject;

	public static int iTestStep;
	public static int iTestLastStep;
	public static String sTestCaseID;
	public static String sRunMode;

	public static boolean bResult;
	
	public static String sData;
	
	
	public DriverScript() throws NoSuchMethodException, SecurityException {
		actionKeywords = new ActionKeywords();
		method = actionKeywords.getClass().getMethods();
	}

	private void execute_TestCase() throws Exception {
		int iTotalTestCases = ExcelUtils.getRowCount(Constants.Sheet_TestCases);
		for (int iTestCase = 1; iTestCase < iTotalTestCases; iTestCase++) {
			
			bResult = true;
			
			sTestCaseID = ExcelUtils.getCellData(iTestCase, Constants.Col_TestCaesId, Constants.Sheet_TestCases);
			sRunMode = ExcelUtils.getCellData(iTestCase, Constants.Col_RunMode, Constants.Sheet_TestCases);
			
			if (sRunMode.equals("Yes")) {
				iTestStep = ExcelUtils.getRowContains(sTestCaseID, Constants.Col_TestCaesId, Constants.Sheet_TestSteps);
				iTestLastStep = ExcelUtils.getTestStepsCount(Constants.Sheet_TestSteps, sTestCaseID, iTestStep);
				
				Log.startTestCase(sTestCaseID);
				
				bResult=true;
				
				for (; iTestStep < iTestLastStep; iTestStep++) {
					sActionKeyword = ExcelUtils.getCellData(iTestStep, Constants.Col_ActionKeyword,
							Constants.Sheet_TestSteps);
					sPageObject = ExcelUtils.getCellData(iTestStep, Constants.Col_PageObject,
							Constants.Sheet_TestSteps);
					
					sData = ExcelUtils.getCellData(iTestStep, Constants.Col_DataSet, Constants.Sheet_TestSteps);
					
					execute_Actions();
					
					if(bResult == false) {
						ExcelUtils.setCellData(Constants.KEYWORD_FAIL, iTestCase, Constants.Col_Result, Constants.Sheet_TestCases);
						Log.endTestCase(sTestCaseID);
						break;
					}
				}
				
				if(bResult==true) {
					ExcelUtils.setCellData(Constants.KEYWORD_PASS, iTestCase, Constants.Col_Result, Constants.Sheet_TestCases);
					Log.endTestCase(sTestCaseID);				
				}
			}
		}
	}

	private static void execute_Actions() throws Exception {
		for (int i = 0; i < method.length; i++) {
			if (method[i].getName().equals(sActionKeyword)) {
				method[i].invoke(actionKeywords, sPageObject,sData);
				if(bResult==true) {
					ExcelUtils.setCellData(Constants.KEYWORD_PASS, iTestStep, Constants.Col_TestStepsResult, Constants.Sheet_TestSteps);
					break;
				}else {
					ExcelUtils.setCellData(Constants.KEYWORD_FAIL, iTestStep, Constants.Col_TestStepsResult, Constants.Sheet_TestSteps);
					ActionKeywords.closeBrowser("","");
					break;
				}
			}
		}
	}

	// private static WebDriver driver = null;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * System.setProperty("webdriver.gecko.driver",
		 * "C:\\\\Users\\v-victw\\Desktop\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		 * 
		 * String sPath =
		 * "D:\\ToolsQA\\OnlineStore\\src\\KeywordDrivenFramework\\dataEngine\\DataEngine.xlsx";
		 */
		DOMConfigurator.configure("log4j.xml");
		ExcelUtils.setExcelFile(Constants.Path_TestData);
		ORUtils.ORLoadFs();
		DriverScript StartEngine = new DriverScript();
		/*
		 * driver = new FirefoxDriver(); driver.manage().timeouts().implicitlyWait(10,
		 * TimeUnit.SECONDS); String url="http://www.store.demoqa.com"; driver.get(url);
		 * 
		 * driver.findElement(By.xpath(".//*[@id='account']/a")).click();
		 * driver.findElement(By.id("log")).sendKeys("TestingLA4v@outlook.com");
		 * driver.findElement(By.id("pwd")).sendKeys("9Esu%YxUmZuP1lBA");
		 * driver.findElement(By.id("login")).click();
		 * driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();
		 * driver.quit();
		 */

		// for (int iRow = 0; iRow <= 9; iRow++) {
		/*
		 * String sActionKeyword = ExcelUtils.getCellData(iRow, 3);
		 * if(sActionKeyword.equals("openBrowser")) { ActionKeywords.openBrowser();
		 * }else if(sActionKeyword.equals("navigate")) { ActionKeywords.navigate();
		 * }else if(sActionKeyword.equals("click_MyAccount")) {
		 * ActionKeywords.click_MyAccount(); }else
		 * if(sActionKeyword.equals("input_Username")) {
		 * ActionKeywords.input_Username(); }else
		 * if(sActionKeyword.equals("input_Password")) {
		 * ActionKeywords.input_Password(); }else
		 * if(sActionKeyword.equals("click_Login")) { ActionKeywords.click_Login();
		 * }else if (sActionKeyword.equals("waitFor")) { ActionKeywords.waitFor(); }else
		 * if(sActionKeyword.equals("click_Logout")) { ActionKeywords.click_LogOut();
		 * }else if(sActionKeyword.equals("closeBrowser")) {
		 * ActionKeywords.closeBrowser(); }
		 */
		// sActionKeyword = ExcelUtils.getCellData(iRow, Constants.Col_ActionKeyword,
		// Constants.Sheet_TestSteps);
		// sPageObject = ExcelUtils.getCellData(iRow,
		// Constants.Col_PageObject,Constants.Sheet_TestCases);
		// execute_Actions();
		// }
		StartEngine.execute_TestCase();
	}

}
