package InterMediateTips;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;

public class PracticeHeadlessBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HtmlUnitDriver unitDriver = new HtmlUnitDriver(BrowserVersion.CHROME);
		
		//HtmlUnitDriver support the JavaScript
		
		unitDriver.get("http://google.com");
		System.out.println("Title of the page is -> " + unitDriver.getTitle());
		
		WebElement searchBox = unitDriver.findElement(By.name("q"));
		searchBox.sendKeys("selenium");
		
		unitDriver.findElement(By.name("btnK")).click();
		System.out.println("Title of the page is -> " + unitDriver.getTitle());
		
		unitDriver.setJavascriptEnabled(true);
		String domainName = (String)unitDriver.executeScript("return document.domain");
		
		System.out.println("Domain name is " + domainName);
				
		unitDriver.close();
	}

}
