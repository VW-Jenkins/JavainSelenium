package TestCase_TestNGFrame;

import org.testng.Assert;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


//@Listeners(TestCase_TestNGFrame.AnnotationTransformer.class)
/*
 * Cannot use the @listeners() add the event, 
 * Need to use the <listeners name=""></listeners> in XML file, Everything work well. 
 * 
 */
public class RetryTest001 {

	//@Test(retryAnalyzer = TestCase_TestNGFrame.RetryAnalyzer.class)
	@Test
	public  void Test1() {
		// TODO Auto-generated method stub
		Assert.assertEquals(false, true);	
	}
	
	@Test
	public void Test2() {
		Assert.assertEquals(false, true);
	}
	

}
