package FrameworkDesignPrinciples.Page_Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LogInPage {
	final WebDriver driver;

	public LogInPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "log")
	@CacheLookup
	public WebElement txtbx_UserName;
	
	@FindBy(how = How.ID, using = "pwd")
	@CacheLookup
	public WebElement txtbx_Password;

	@FindBy(how = How.NAME, using = "submit")

	public WebElement btn_Login;
}
