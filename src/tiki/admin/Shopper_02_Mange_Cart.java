package tiki.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Shopper_02_Mange_Cart {
	
	   WebDriver driver;
	   String projectPath = System.getProperty("user.dir");
	   
	  @BeforeTest (alwaysRun = true)
	  public void initBrowser()
	  {
		  System.out.println ("----------Open Brower and driver------------------------------");
		  System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		  driver = new FirefoxDriver();
		  
	  }
	  @Test (groups={"admin", "Cart"})
	  public void Cart_01_01_Create_Visa() {
		  
	  }
	  
	  @Test (groups={"admin", "Cart"})
	  public void Cart_02_View_Visa() {
		  
	  }
	  
	  @Test (groups={"admin", "Cart"})
	  public void Cart_03_Update_Visa() {
		  
	  }
	   
	  @Test (groups={"admin", "Cart"})
	  public void Cart_04_Delete_Visa() {
		  
	  }
	  
	  @AfterTest
	  public void CleanBrowser()
	  {
		  System.out.println ("----------Clean Brower and driver------------------------------");
		  driver.quit();
	  }
}
