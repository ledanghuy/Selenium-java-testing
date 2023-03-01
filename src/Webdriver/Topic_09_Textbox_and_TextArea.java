package Webdriver;



import java.awt.Desktop.Action;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle.Control;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
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
	
	String passport_Number ="40517-402-96-7202";
	String comment_input= "This is generated data \n of real people";
	Actions control__action;
	
	
	

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		rand_1= new Random();
		Employee_ID=String.valueOf(rand_1.nextInt(999999));
		control__action = new Actions (driver);
		
		
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
		
		driver.findElement(By.name("firstName")).sendKeys("Le Dang");
		driver.findElement(By.name("lastName")).sendKeys("Huy");
		
		
		
		
		driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).sendKeys(Keys.chord(Keys.CONTROL,"a"));
		SleepInSecond(1);
		driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).sendKeys(Keys.chord(Keys.DELETE));
		driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).sendKeys(Employee_ID);
		SleepInSecond(3);
		
		driver.findElement(By.xpath("//p[text()='Create Login Details']/parent::div//span")).click();
		SleepInSecond(3);
		
		driver.findElement(By.xpath("//label[text()='Username']/parent::div/following-sibling::div/input")).sendKeys("afc"  + Employee_ID);
		driver.findElement(By.xpath("//label[text()='Password']/parent::div/following-sibling::div/input")).sendKeys("Password123!!!");	
		driver.findElement(By.xpath("//label[text()='Confirm Password']/parent::div/following-sibling::div/input")).sendKeys("Password123!!!");
		driver.findElement(By.xpath("//button[contains(string(),'Save')]")).click();
		//driver.findElement(By.xpath("//button[contains(.,'Save')]")).click();
		
		SleepInSecond(10);
		
		//a[text()='Immigration']
		
		//a[contains(.,'Immigration')]
		
		Assert.assertEquals(driver.findElement(By.name("firstName")).getAttribute("value"), "Le Dang");
		Assert.assertEquals(driver.findElement(By.name("lastName")).getAttribute("value"), "Huy");
		
		
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getAttribute("value"),Employee_ID);
		
		
		driver.findElement(By.xpath("//a[text()='Immigration']")) .click();
		SleepInSecond(6);
		
		
		driver.findElement(By.xpath("//h6[text()='Assigned Immigration Records']/ following-sibling::button")) .click();
		driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).sendKeys(passport_Number);
		driver.findElement(By.xpath("//label[text()='Comments']/parent::div/following-sibling::div/textarea")).sendKeys(comment_input);
		driver.findElement(By.xpath("//button[text()=' Save ']")).click();
		
		SleepInSecond(6);
		
		driver.findElement(By.cssSelector("i.bi-pencil-fill")).click();
		SleepInSecond(3);
		
		
		
		
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).getAttribute("value"), passport_Number);
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Comments']/parent::div/following-sibling::div/textarea")).getAttribute("value"), comment_input);
		
		driver.findElement(By.cssSelector("p.oxd-userdropdown-name")).click();
	
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
		SleepInSecond(3);
		
		driver.findElement(By.name("username")).sendKeys("afc" +Employee_ID);
		driver.findElement(By.name("password")).sendKeys("Password123!!!");

		//csss 
		driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();	


		SleepInSecond(2);
		
	
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
