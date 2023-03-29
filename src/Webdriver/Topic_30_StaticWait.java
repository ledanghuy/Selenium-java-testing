package Webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_30_StaticWait {
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
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_Not_En_Time() {
		 driver.get("https://automationfc.github.io/dynamic-loading/");
		   
		   driver.findElement(By.cssSelector("div#start>button")).click();
		   
		 // Thiếu thời gian
		   SleepInSecond(3);
		   
		   Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
	
		
		
	  
	}
	@Test
	public void TC_02_En_Time() {
		 driver.get("https://automationfc.github.io/dynamic-loading/");
		   
		   driver.findElement(By.cssSelector("div#start>button")).click();
		   
		   
		   
		   //get text and verify
		   
		   // Đủ thời gian
		   SleepInSecond(5);
		   Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
	}
	
	@Test
	public void TC_03_More_Time() {
   driver.get("https://automationfc.github.io/dynamic-loading/");
		   
		   driver.findElement(By.cssSelector("div#start>button")).click();
		   
		   //get text and verify
		   //Dư thời gian
		   SleepInSecond(10);
		   Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
	
	}
	public void SleepInSecond(long timeinSecond) {
		
		 try {
			 Thread.sleep(timeinSecond*1000);
			 //1000 ms =1s 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	}
	//@AfterClass
	///public void afterClass() {
	   // driver.quit();
	//}
}
