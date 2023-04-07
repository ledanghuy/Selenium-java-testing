package tiki.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	 WebDriver driver;
	   String projectPath = System.getProperty("user.dir");
	
	  @BeforeTest (alwaysRun = true)
	  public void initBrowser()
	  {
		  System.out.println ("----------Open Brower and driver------------------------------");
		  System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		  driver = new FirefoxDriver();
		  
	  }
	  
	  @AfterTest
	  public void CleanBrowser()
	  {
		  System.out.println ("----------Clean Brower and driver------------------------------");
		  driver.quit();
	  }
	  
	  public WebDriver getBrowserDriver() {
		  
		  return driver;
	  }

}
