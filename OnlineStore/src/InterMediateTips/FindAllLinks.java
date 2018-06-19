package InterMediateTips;


import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
public class FindAllLinks {

	public static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\v-victw\\Desktop\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		String url = "http://toolsqa.wpengine.com/";
		driver.get(url);
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		for(int i=0;i<=links.size();i++) {
			System.out.println(links.get(i).getText());
		}
		
		// all Checkbox
		//List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"))
		
		// all Dropdown
		//List<WebElement> dropdown = driver.findElements(By.tagName("select")); 
		
		// all TextBoxes
		//List<WebElement> textboxes = driver.findElements(By.xpath("//input[@type='text'[@class='inputtext']"));
		
		driver.close();
	}

}
