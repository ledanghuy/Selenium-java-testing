package Webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Run_On_Browser {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName=System.getProperty("os.name");
 
	

	@BeforeClass
	public void beforeClass() {
		
		///Chay tren Chrome
		//System.setProperty("webdriver.chrome.driver", projectPath +"\\browserDrivers\\chromedriver.exe");		
		
		
		//driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		
		//Chay tren Firefox
		
      //  System.setProperty("webdriver.gecko.driver", projectPath +"\\browserDrivers\\geckodriver.exe");		
	//	driver = new FirefoxDriver();
	//	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
       //Chay tren Edge
		
     //   System.setProperty("webdriver.edge.driver", projectPath +"\\browserDrivers\\geckodriver.exe");		
		//driver = new EdgeDriver();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
	}
	

	@Test
	public void TC_01_Chrome() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
		}
		
		//System.setProperty("webdriver.chrome.driver", projectPath +"\\browserDrivers\\chromedriver.exe");		
		driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		driver.quit();
		
	}
	@Test
	public void TC_02_FireFox() {
		
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath +"\\browserDrivers\\geckodriver.exe");		
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath +"/browserDrivers/geckodriver");		
		}
		
		 
	     driver = new FirefoxDriver();
	     driver.get("https://demo.nopcommerce.com/");
		 driver.quit();
	     
		
	}
	
	@Test
	public void TC_03_Edge() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.edge.driver", projectPath +"\\browserDrivers\\msedgedriver.exe");			
		} else {
			System.setProperty("webdriver.edge.driver", projectPath +"/browserDrivers/msedgedriver");		
		}
		
		driver = new EdgeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
	    driver.quit();
		
	
	}
	//@AfterClass
	///public void afterClass() {
	///    driver.quit();
	//}
}
