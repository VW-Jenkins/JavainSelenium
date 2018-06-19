package TestCase_TestNGFrame;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	int counter = 0;
	int retryLimit = 4;
	
	@Override
	public boolean retry(ITestResult arg0) {
		// TODO Auto-generated method stub
		
		if(counter < retryLimit) {
			counter++;
			return true;
		}
		return false;
	}

}
