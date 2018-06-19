package AdvanceTips;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PracticeFormPageObject {
	
	@FindBy(how=How.NAME, using="firstname")@CacheLookup
	public WebElement firstName;
	
	@FindBy(how=How.NAME,using="lastname")@CacheLookup
	public WebElement lastName;
}
