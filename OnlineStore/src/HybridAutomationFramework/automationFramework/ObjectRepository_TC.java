package HybridAutomationFramework.automationFramework;

import org.openqa.selenium.WebDriver;

import HybridAutomationFramework.PageObject.*;
public class ObjectRepository_TC {

	private static WebDriver driver = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductListing_Page.Product_1.btn_AddToCart(driver);
	}

}
