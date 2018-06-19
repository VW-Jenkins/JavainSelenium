package automationFramework;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

public class CheckBxRadioBtn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\v-victw\\Desktop\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String url = "http://toolsqa.wpengine.com/automation-practice-form";
		
		driver.get(url);
		
		List<WebElement> rdBtn_Sex = driver.findElements(By.name("sex"));
		boolean bValue = false;
		bValue = rdBtn_Sex.get(0).isSelected();
		if(bValue == true) {
			
			rdBtn_Sex.get(1).click();
		}else {
			rdBtn_Sex.get(0).click();
		}
		
		WebElement rdBtn_Exp = driver.findElement(By.id("exp-2"));
		rdBtn_Exp.click();
		
		List<WebElement> chkBx_Profession = driver.findElements(By.name("profession"));
		int iSize = chkBx_Profession.size();
		
		for(int i=0; i<iSize;i++) {
			String sValue = chkBx_Profession.get(i).getAttribute("value");
			if(sValue.equalsIgnoreCase("Automation Tester")) {
				chkBx_Profession.get(i).click();
				break;
			}
		}
		
		WebElement oCheck_Box = driver.findElement(By.cssSelector("input[value='Selenium IDE']"));
		oCheck_Box.click();
		driver.quit();
		
	}

}
