package Webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Web_Element_Exce_Part_2 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	


	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
		}
			
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		
	}

	//@Test
	public void TC_01_Login_with_Empty_Email_Password() {
		
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		
		SleepInSecond(2);
		
		
		driver.findElement(By.id("send2")).click();
		
		SleepInSecond(3);
		///driver.findElement(By.xpath("//div[@class='col-2 registered-users']//button[@title='Login']")).click();
		
		
		//Verify 
		
		Assert.assertEquals(driver.findElement(By.id("advice-required-entry-email")).getText(), "This is a required field.");
		Assert.assertEquals(driver.findElement(By.id("advice-required-entry-pass")).getText(), "This is a required field.");
		
		
		
		
	}
	
	//@Test
	public void TC_02_Login_with_Invalid_Email() {
		
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		
		SleepInSecond(3);
		
		
		driver.findElement(By.id("email")).sendKeys("12343234@12312123123");
		driver.findElement(By.id("pass")).sendKeys("123456");
		driver.findElement(By.id("send2")).click();
		
		SleepInSecond(3);
		///driver.findElement(By.xpath("//div[@class='col-2 registered-users']//button[@title='Login']")).click();
		
		
		//Verify 
		
		Assert.assertEquals(driver.findElement(By.id("advice-validate-email-email")).getText(), 
				"Please enter a valid email address. For example johndoe@domain.com.");
		
	}
	
	//@Test
	public void TC_03_Login_with_Password_under_6_character() {
		
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		
		SleepInSecond(3);
		
		
		driver.findElement(By.id("email")).sendKeys("ledanghuy91@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("123");
		driver.findElement(By.id("send2")).click();
		
		SleepInSecond(3);
		///driver.findElement(By.xpath("//div[@class='col-2 registered-users']//button[@title='Login']")).click();
		
		
		//Verify 
		
		Assert.assertEquals(driver.findElement(By.id("advice-validate-password-pass")).getText(), 
				"Please enter 6 or more characters without leading or trailing spaces.");
		
	}
	@Test
	public void TC_04_Login_with_incorrect_Email_Password() {
		
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		
		SleepInSecond(3);
		
		
		driver.findElement(By.id("email")).sendKeys("ledanghuy92@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("123123");
		driver.findElement(By.id("send2")).click();
		
		SleepInSecond(3);
		///driver.findElement(By.xpath("//div[@class='col-2 registered-users']//button[@title='Login']")).click();
		
		//Verify 
		
		Assert.assertEquals(driver.findElement(By.className("error-msg")).getText(), 
				"Invalid login or password.");
		
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
