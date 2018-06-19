package TestCase_TestNGFrame;

import org.testng.Assert;
import org.testng.annotations.Test;
import customAnnotations.RetryCountIfFailed;

public class RetryTest002 {
	
	/*
	 * 
	 * Define the @RetryCountIfFailed just want to set the retry number
	 * 1. define interface  - RetryCountIfFailed
	 * 2. Create RetryAnalyzer002 to implements IRetryAnalyzerinterface
	 * 3. Set the retry number in code - @RetryCountIfFailed(10)
	 * 4. Bind the RetryAnalyzer002 to @Test annotation 
	 * @Test(retryAnalyzer=TestCase_TestNGFrame.RetryAnalyzer002.class)
	 * 
	 * Victor Wang 2018/06/06
	 * */
	
	
	
  @Test(retryAnalyzer=TestCase_TestNGFrame.RetryAnalyzer002.class)
  @RetryCountIfFailed(10)

  public void Test1() {
	  Assert.assertEquals(false, true);
  }
  @Test
  public void Test2() {
	  Assert.assertEquals(false, true);
  }
}
