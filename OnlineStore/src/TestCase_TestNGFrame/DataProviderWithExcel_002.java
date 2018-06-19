package TestCase_TestNGFrame;

import org.testng.annotations.Test;

import utility.ExcelUtils_TestNG;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class DataProviderWithExcel_002 {
	private String sTestCaseName;

	private int iTestCaseRow;

	WebDriver driver;

	@Test(dataProvider = "dp")
	public void f(String n, String s) {
		driver.findElement(By.xpath(".//*[@id='account']/a")).click();

		driver.findElement(By.id("log")).sendKeys(n);

		System.out.println(n);

		driver.findElement(By.id("pwd")).sendKeys(s);

		System.out.println(s);

		driver.findElement(By.id("login")).click();

		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");

		driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();
	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\\\Users\\v-victw\\Desktop\\geckodriver-v0.20.1-win64\\geckodriver.exe");

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://www.store.demoqa.com");
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

	@DataProvider
	public Object[][] dp() throws Exception {
		/*
		 * return new Object[][] { new Object[] { 1, "a" }, new Object[] { 2, "b" }, };
		 */

		// Setting up the Test Data Excel file

		ExcelUtils_TestNG.setExcelFile("D:\\ToolsQA\\OnlineStore\\src\\testData\\TestData_TestNG_Excel.xlsx", "Sheet1");

		sTestCaseName = this.toString();

		// From above method we get long test case name including package and class name
		// etc.

		// The below method will refine your test case name, exactly the name use have
		// used

		sTestCaseName = ExcelUtils_TestNG.getTestCaseName(this.toString());

		// Fetching the Test Case row number from the Test Data Sheet

		// Getting the Test Case name to get the TestCase row from the Test Data Excel
		// sheet

		iTestCaseRow = ExcelUtils_TestNG.getRowContains(sTestCaseName, 0);

		Object[][] testObjArray = ExcelUtils_TestNG.getTableArray(
				"D:\\ToolsQA\\OnlineStore\\src\\testData\\TestData_TestNG_Excel.xlsx", "Sheet1", iTestCaseRow);

		return (testObjArray);

	}
}
