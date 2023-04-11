package TestNG;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Topic_07_Loop {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	By emailTextbox = By.xpath("//*[@id='email']");
	By passwordTextbox = By.xpath("//*[@id='pass']");
	By loginButton = By.xpath("//*[@id='send2']");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test(invocationCount = 5)
	public void Register()  {
		driver.get("http://live.techpanda.org/index.php/customer/account/create/");
		
		driver.findElement(By.cssSelector("input#firstname")).sendKeys("Automation");
		driver.findElement(By.cssSelector("input#middlename")).sendKeys("FC");
		driver.findElement(By.cssSelector("input#lastname")).sendKeys("ABC");
		
		String Email_Address= "HUYLD" +getRandomNumerb() +"@gmail.com";
		System.out.println("Email la :" + Email_Address);
		
		driver.findElement(By.cssSelector("input#email_address")).sendKeys(Email_Address);
		driver.findElement(By.cssSelector("input#password")).sendKeys("12345678");
		driver.findElement(By.cssSelector("input#confirmation")).sendKeys("12345678");
		driver.findElement(By.cssSelector("input#is_subscribed")).isSelected();
		
		driver.findElement(By.cssSelector("button[title='Register']")).click();
		
		
		
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='success-msg']//span[text()='Thank you for registering with Main Website Store.']")).isDisplayed());
		
		
		
		
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='col-1']//p")).getText().contains("Automation FC"));

		driver.findElement(By.xpath("//header[@id='header']//span[text()='Account']")).click();
		driver.findElement(By.xpath("//a[text()='Log Out']")).click();
	}

	
	public  int  getRandomNumerb() 
	
	{
	        	return new Random().nextInt(99999);
	}
	
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
