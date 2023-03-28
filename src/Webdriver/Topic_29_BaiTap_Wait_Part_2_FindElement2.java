package Webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_29_BaiTap_Wait_Part_2_FindElement2 {
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
		
		
		
		
		// 1 ảnh hưởng trực tiếp tới 2 hàm : FindElement /FindElements 
		// 2 ngoại lệ 
	   /// implicitlyWait set ở đâu thì sẽ apply từ đó trở xuống
		// Nếu bị gán lại giá thì sẽ dùng cái giá trị mới / không dùng giá trị cũ 
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_Not_Enough() {
		 driver.get("https://automationfc.github.io/dynamic-loading/");
	   
	   driver.findElement(By.cssSelector("div#start>button")).click();
	   
	   //Loading icon mất 5s mới biến mất 
	   
	   //get text and verify
	   
	   Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
;	   
	   
		
		
	
	  
	}
	@Test
	public void TC_02_Enough() {
		
		   driver.get("https://automationfc.github.io/dynamic-loading/");
		   
		   driver.findElement(By.cssSelector("div#start>button")).click();
		   
		   //get text and verify
		   
		   Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
		
	}
	
	
	@Test
	public void TC_03_More_Time() {
		
		
		   driver.get("https://automationfc.github.io/dynamic-loading/");
		   
		   driver.findElement(By.cssSelector("div#start>button")).click();
		   
		   //get text and verify
		   
		   Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
		

		
	}
	//@AfterClass
	///public void afterClass() {
	   // driver.quit();
	//}
}
