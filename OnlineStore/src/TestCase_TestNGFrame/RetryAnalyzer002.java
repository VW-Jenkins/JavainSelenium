package TestCase_TestNGFrame;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import customAnnotations.RetryCountIfFailed;

public class RetryAnalyzer002 implements IRetryAnalyzer{
	
	int counter = 0;
	@Override
	public boolean retry(ITestResult arg0) {
		// TODO Auto-generated method stub
		RetryCountIfFailed annotation = arg0.getMethod().getMethod()
				.getAnnotation(RetryCountIfFailed.class);
		if((annotation!=null)&&(counter<annotation.value())) {
			counter++;
			return true;
		}
		return false;
	}

}
