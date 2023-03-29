package Webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_31_ExplicitWait {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	WebDriverWait explicitWait;

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}
		driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
	}

	//@Test
	public void TC_01_Not_En_Time() {
	driver.get("https://automationfc.github.io/dynamic-loading/");
		
	
	explicitWait = new WebDriverWait(driver,3);
	driver.findElement(By.cssSelector("div#start>button")).click();
		   
		 		   
	explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div#finish>h4")));
		   
	Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
	

	  
	}
	//@Test
	public void TC_02_En_Time() {
		driver.get("https://automationfc.github.io/dynamic-loading/");
		   
		explicitWait = new WebDriverWait(driver,5);
		driver.findElement(By.cssSelector("div#start>button")).click();

		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div#finish>h4")));

		Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
	}
	
	@Test
	public void TC_03_More_Time() {
   driver.get("https://automationfc.github.io/dynamic-loading/");
		   
   
   explicitWait = new WebDriverWait(driver,5);
    driver.findElement(By.cssSelector("div#start>button")).click();
   ///wait cho loading icon biến mất 
    
    explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div #loading")));

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
