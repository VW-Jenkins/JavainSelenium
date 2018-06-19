package FrameworkDesignPrinciples.automationFramework;


import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import FrameworkDesignPrinciples.Browser_Factory.*;
import FrameworkDesignPrinciples.ObjectRepository.RespositoryParser;

public class TestObjectRepositoryProperties {

	private static WebDriver driver = null;
	private RespositoryParser parser;

	@BeforeTest
	public void setUp() throws IOException {
		driver = BrowserFactory.getBrowser("Firefox");
		driver.get("http://toolsqa.wpengine.com/automation-practice-form/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		parser = new RespositoryParser("D:\\ToolsQA\\OnlineStore\\src\\FrameworkDesignPrinciples\\ObjectRepository\\ObjectRepo.properties");
		
	}
	
	@Test
	public void EnterValue() {
		// TODO Auto-generated method stub
		driver.findElement(parser.getObjectLocator("FirstName")).sendKeys("Victor");
		driver.findElement(parser.getObjectLocator("LastName")).sendKeys("Wang");			
	}
	
	@Test
	public void FindPartialLink() {
		driver.findElement(parser.getObjectLocator("PartialLink")).click();
	}

	@AfterTest
	public void tearDown() {
		BrowserFactory.closeAllDriver();
	}

}
