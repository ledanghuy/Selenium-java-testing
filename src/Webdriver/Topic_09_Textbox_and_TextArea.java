package Webdriver;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_09_Textbox_and_TextArea {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	Random rand_1;
	
	String Employee_ID;
	

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
		}
			
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		rand_1= new Random();
		Employee_ID=String.valueOf(rand_1.nextInt(999999));
		
		
	}

	@Test
	public void TC_01_Create_New_Employee() {
		
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");

		//csss 
		driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();	


		SleepInSecond(2);
		
		//driver.findElement(By.xpath("//span[contains(.,'PIM')]")).click();
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		SleepInSecond(3);
		
		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
		SleepInSecond(3);
		
		driver.findElement(By.name("firstname")).sendKeys("Le Dang");
		driver.findElement(By.name("lastname")).sendKeys("Huy");
		
		driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).sendKeys(Employee_ID);
		
		
		driver.findElement(By.xpath("//p[text()='Create Login Details']/parent::div//input")).click();
		
		
		driver.findElement(By.xpath("//label[text()='Username']/parent::div/following-sibling::div/input")).sendKeys("afc"  + Employee_ID);
		driver.findElement(By.xpath("//label[text()='Password']/parent::div/following-sibling::div/input")).sendKeys("Password123!!!");
		
		driver.findElement(By.xpath("//label[text()='Confirm Password']/parent::div/following-sibling::div/input")).sendKeys("Password123!!!");
		
		
		//driver.findElement(By.xpath(Employee_ID))
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	 
		
		
		
		
		
		
		
		

		
	}
	@Test
	public void TC_02() {
	}
	
	@Test
	public void TC_03() {
	
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
//	public void afterClass() {
	///    driver.quit();
	//}
}
