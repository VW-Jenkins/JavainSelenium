package TestCase_TestNGFrame;

import org.testng.annotations.Test;

public class Dependent {
  @Test(dependsOnMethods = {"OpenBrowser"})
  public void SingIn() {
	  System.out.println("This will execute second (SignIn)");
  }
  @Test
  public void OpenBrowser() {
	  System.out.println("This will execute first (Open Browser)");
  }
  @Test (dependsOnMethods= {"SingIn"})
  public void LogOut() {
	  System.out.println("Thie will execute third (LogOut)");
  }
}
