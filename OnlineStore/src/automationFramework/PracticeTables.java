package automationFramework;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

public class PracticeTables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\v-victw\\Desktop\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		String url = "http://toolsqa.wpengine.com/automation-practice-table";
		driver.get(url);
		
		String sCellValue  = driver.findElement(By.xpath("//div[@id='content']/table[@class='tsc_table_s13']/tbody/tr[1]/td[2]")).getText();
		System.out.println(sCellValue);
		
		driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody/tr[1]/td[6]/a")).click();
		System.out.println("Link has been clicked otherwise an exception would have thrown");
		driver.close();
	}

}
