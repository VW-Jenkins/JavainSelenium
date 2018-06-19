package automationFramework;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;


public class PracticeTable_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\v-victw\\Desktop\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		String url = "http://toolsqa.wpengine.com/automation-practice-table";
		driver.get(url);
		
		String sRow = "1";
		String sCol = "2";
		String sCellValue  = driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody/tr["+ sRow +"]/td["+ sCol+"]")).getText();
		System.out.println(sCellValue);
		
		String sRowValue = "Clock Tower Hotel";
		for(int i=1;i<5;i++) {
			String sValue = null;
			sValue = driver.findElement(By.xpath("//tbody/tr["+i+"]/th")).getText();
			if(sValue.equalsIgnoreCase(sRowValue)) {
				for(int j=1;j<=5;j++) {
					
					String sCloumnValue = driver.findElement(By.xpath("//tbody/tr["+i+"]/td["+j+"]")).getText();
					System.out.println("\n");
					System.out.println(sCloumnValue);
				}
				break;
				
			}
			
		}
		driver.close();
	}

}
