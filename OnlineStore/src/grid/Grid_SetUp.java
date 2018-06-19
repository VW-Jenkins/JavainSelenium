package grid;


import java.net.MalformedURLException;
import java.net.URL;

/*
 * 1. download the Selenium Server and Set up Selenium GRID Hub in Hub machine
 *    http://docs.seleniumhq.org/download/
 * 	  use the below command to start selenium service:
 *    java -jar selenium-server-standalone-3.3.1.jar -role hub
 *    
 * 2. download selenium server jar in Node machine and install
 * 	  java -jar selenium-server-standalone-3.3.1.jar -role node -hub http://10.138.68.80:4444/grid/register -port 5555
 * 
 * 3. Start to write your script
 * 
 * 
 * *Note: when you register the Node machine, u need attend the driver path or other info
 * otherwise, cannot create the service instance
 * 
 * java -jar -Dwebdriver.gecko.driver=C:\Users\v-victw\Desktop\geckodriver-v0.20.1-win64\geckodriver.exe 
 * 			selenium-server-standalone-3.12.1.jar -role node -hub http://10.138.68.80:4444/grid/register -port 5555 

 * */


/*
 * 
 * java -jar -Dwebdriver.gecko.driver=C:\Users\v-victw\Desktop\geckodriver-v0.20.1-win64\geckodriver.exe 
 * 		selenium-server-standalone-3.4.0.jar -role node 
 * 		-hub http://<hub name or IP>:4444/grid/register -port 5555 
 * 		-browser browserName=firefox,
 * 		version=58.0.3029.110,maxInstances=2,platform=WINDOWS
 * 
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Grid_SetUp {
	
	private static WebDriver driver = null;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		String URL = "http://www.DemoQA.com";
		String Node = "http://10.138.68.80:4444/wd/hub";
		
		DesiredCapabilities cap = DesiredCapabilities.firefox();
	
		driver = new RemoteWebDriver(new URL(Node), cap);
		driver.get(URL);
		Thread.sleep(5000);
		
		driver.quit();
		
	}

}
