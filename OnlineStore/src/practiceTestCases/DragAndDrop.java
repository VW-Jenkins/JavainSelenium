package practiceTestCases;


import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DragAndDrop {
	
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\v-victw\\Desktop\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		String url = "https://todoist.com/";
		//login to your site
		driver.get(url);
		
		driver.findElement(By.xpath("//a[@class='td-header__action-link sel_login']")).click();
		
		//switch window and frame
		String currentHandle = driver.getWindowHandle();			
		driver.switchTo().frame("GB_frame").switchTo().frame("GB_frame");
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/a")).click();
		
		for(String handle1:driver.getWindowHandles()) {
			if(handle1!=currentHandle) {
				driver.switchTo().window(handle1);
			}
		}
		
		driver.manage().window().maximize();
		
		//inout the account and sign in 	
		driver.findElement(By.id("identifierId")).sendKeys("Aaptvictorwang@gmail.com");
		driver.findElement(By.id("identifierNext")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("password")).sendKeys("password~1");
		driver.findElement(By.id("passwordNext")).click();	
		
		//println current window make sure driver in which frame and window	
		System.out.println(driver.getTitle());
		
		// switch back to default frame and window
		driver.switchTo().defaultContent();	
		driver.switchTo().window(currentHandle);
		
		Thread.sleep(3000);
	
		//println current window make sure driver in which frame and window	
		System.out.println(driver.getTitle());
		driver.switchTo().defaultContent();	//when u go to the nested frame u need to use the defaultContent() twice? 
		
		// Focus on the element
		WebElement From = driver.findElement(By.xpath("//*[@id=\"projects_list\"]/li[3]"));
		Actions actionFrom = new Actions(driver);
		actionFrom.moveToElement(From).build().perform();
		
		Thread.sleep(2000);
		//find the drag hander
		WebElement fdragHand = driver.findElement(By.xpath("//li[@class='clickable menu_clickable indent_1'][3]/div[@class='drag_and_drop_handler']"));
		
		
		WebElement To = driver.findElement(By.xpath("//*[@id=\"projects_list\"]/li[6]"));
		//Actions actionTo = new Actions(driver);
		//actionTo.moveToElement(To).build().perform();
		
		//Thread.sleep(2000);
		// find the to hander
		//WebElement tdragHand = driver.findElement(By.xpath("//li[@class='clickable menu_clickable indent_1'][6]/div[@class='drag_and_drop_handler']"));
		
		Actions builder = new Actions(driver);
		
		//drag the element
		Action dragAndDrop = builder.clickAndHold(fdragHand).moveToElement(To).release(To).build();

		dragAndDrop.perform();
		
		driver.close();
	}

}
