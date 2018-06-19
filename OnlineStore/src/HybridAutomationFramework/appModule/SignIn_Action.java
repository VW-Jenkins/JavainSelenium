package HybridAutomationFramework.appModule;



import org.openqa.selenium.*;
import HybridAutomationFramework.PageObject.*;
import HybridAutomationFramework.utility.*;

public class SignIn_Action {
	
	public static void Execute(WebDriver driver, String sUserName, String sPassword) {
		PageObject_Home.lnk_MyAccount(driver).click();
		//PageObject_Login.txtbx_UserName(driver).sendKeys("TestingLA4v@outlook.com");
		//PageObject_Login.txtbx_Password(driver).sendKeys("9Esu%YxUmZuP1lBA");
		
		PageObject_Login.txtbx_UserName(driver).sendKeys(sUserName);
		PageObject_Login.txtbx_Password(driver).sendKeys(sPassword);
		
		PageObject_Login.btn_LogIn(driver).click();
	}
	
	/*
	public static void Execute(WebDriver driver) {
		PageObject_Home.lnk_MyAccount(driver).click();
		PageObject_Login.txtbx_UserName(driver).sendKeys("TestingLA4v@outlook.com");
		PageObject_Login.txtbx_Password(driver).sendKeys("9Esu%YxUmZuP1lBA");				
		PageObject_Login.btn_LogIn(driver).click();
	}
	*/
	public static void Execute(WebDriver driver) throws Exception {
		
		String sUserName = ExcelUtils.getCellData(1, 1);
		Log.info("Username picked from Excel is "+ sUserName );
		String sPassword = ExcelUtils.getCellData(1, 2);
		Log.info("Password picked from Excel is "+ sPassword );
		PageObject_Home.lnk_MyAccount(driver).click();
		Log.info("Click action performed on My Account link");
		PageObject_Login.txtbx_UserName(driver).sendKeys(sUserName);
		Log.info("Username entered in the Username text box");
		PageObject_Login.txtbx_Password(driver).sendKeys(sPassword);
		Log.info("Password entered in the Password text box");
		PageObject_Login.btn_LogIn(driver).click();
		Log.info("Click action performed on Submit button");
	}
};
