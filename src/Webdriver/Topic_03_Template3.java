package Webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_Template3 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01() {
		
		driver.get("http://live.techpanda.org/index.php/customer/account/login/");
		
		// Click vào my account bên dưới foooter 
		
		driver.findElement(By.xpath("//div[@class ='footer']//a[@title='My Account']")).click();
		
		//input[starts-with(@data-spm-anchor-i,'a2o4n.login_signup')]
		
		
		///div[@class='footer-contain']//a[contains (text(),'My Account']
		///div[@class='footer-contain']//a[contains (@title,'My Account']
		///div[@class='footer']//a[contains(@href,'account']
		
		//orange[contains@class, ]
	
	  
	}
	@Test
	public void TC_02() {
	}
	
	@Test
	public void TC_03() {
	
	}
	//@AfterClass
	///public void afterClass() {
	   // driver.quit();
	//}
}
