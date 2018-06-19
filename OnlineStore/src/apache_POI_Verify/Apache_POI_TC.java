package apache_POI_Verify;

import org.openqa.selenium.firefox.FirefoxDriver;

import utility.Constant;
import utility.ExcelUtils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Apache_POI_TC {
	
	public static WebDriver driver = null; 
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\v-victw\\Desktop\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		ExcelUtils.SetExcelFile(Constant.Path_TestData+Constant.File_TestData,"sheet1");
		String sUserName = ExcelUtils.getCellData(1, 1);
		String sPassword = ExcelUtils.getCellData(1, 2);
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get(Constant.URL);
		
		driver.findElement(By.xpath("//*[@id=\"account\"]/a")).click();
		driver.findElement(By.id("log")).sendKeys(sUserName);
		driver.findElement(By.id("pwd")).sendKeys(sPassword);
		driver.findElement(By.id("login")).click();
		
		System.out.println("Login Successfully, now it is the time to Log Off buddy.");
		driver.close();
		
		ExcelUtils.setCellData("Pass", 1, 3);
	}

}
