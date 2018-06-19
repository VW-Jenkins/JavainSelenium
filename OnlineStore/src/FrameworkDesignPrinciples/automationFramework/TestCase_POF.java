package FrameworkDesignPrinciples.automationFramework;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import FrameworkDesignPrinciples.Page_Factory.*;
import FrameworkDesignPrinciples.Browser_Factory.*;

public class TestCase_POF {
	private static final WebDriver driver = BrowserFactory.getBrowser("Firefox");
	@BeforeMethod
	public void beforeMethod() {
		String url="http://www.store.demoqa.com";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);	
	}
	@Test
	public void main() {
		// TODO Auto-generated method stub
		HomePage home= PageFactory.initElements(driver, HomePage.class);
		LogInPage login = PageFactory.initElements(driver, LogInPage.class);
		
		home.lnk_MyAccount.click();
		login.txtbx_UserName.sendKeys("TestingLA4v@outlook.com");
		login.txtbx_Password.sendKeys("9Esu%YxUmZuP1lBA");
		login.btn_Login.click();
		System.out.println("Login Successfully, now it is the time to Log Off buddy.");
		home.lnk_LogOut.click();
	}
	@AfterMethod
	public void tearDown() {
		BrowserFactory.closeAllDriver();
	}

}
