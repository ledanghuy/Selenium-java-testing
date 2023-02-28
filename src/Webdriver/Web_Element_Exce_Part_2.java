package Webdriver;

import java.util.Random;
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
	
	Random rand_1;
	
	String email_Address, firstname, middlename, lastname,password, fullname ;
	


	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
		}
			
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		rand_1=new Random();
		
		email_Address= "huyld" +rand_1.nextInt(9999)+ "@gmail.com";
		firstname = "Le Dang";
		lastname= "Huy";
		fullname= firstname + " " + lastname;
		password="12345678";
		
		
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
	//@Test
	public void TC_04_Login_with_incorrect_Email_Password() {
		
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		
		SleepInSecond(3);
		
		
		driver.findElement(By.id("email")).sendKeys(email_Address);
		driver.findElement(By.id("pass")).sendKeys("123123");
		driver.findElement(By.id("send2")).click();
		
		SleepInSecond(3);
		///driver.findElement(By.xpath("//div[@class='col-2 registered-users']//button[@title='Login']")).click();
		
		//Verify 
		///Assert.assertEquals(driver.findElement(By.cssSelector("li.error-msg span")).getText(), "Invalid login or password.");
		
		Assert.assertEquals(driver.findElement(By.className("error-msg")).getText(), 
				"Invalid login or password.");
		
	}
	
	
	@Test
	public void TC_05_Register_A_New_Account() {
		
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		SleepInSecond(3);
		driver.findElement(By.xpath("//div [@class='buttons-set']/a[@title='Create an Account']")).click();
		//driver.findElement(By.cssSelector("a[title='Create an Account'")).click();
		SleepInSecond(3);
		
		
		//driver.findElement(By.xpath("//div[@class='input-box']/input[@id='firstname']")).sendKeys("");
		driver.findElement(By.id("firstname")).sendKeys(firstname);
		driver.findElement(By.id("lastname")).sendKeys(lastname);
		driver.findElement(By.id("email_address")).sendKeys(email_Address);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("confirmation")).sendKeys(password);
		
		
		driver.findElement(By.xpath("//div[@class='buttons-set']//button[@title='Register']")).click();
		//driver.findElement(By.cssSelector("button[title='Register'")).click();
		
		
		/// Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), false);
	Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(), "Thank you for registering with Main Website Store.");
	
	
	String contacinformationText = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();
	
	System.out.println(contacinformationText);
	
	
	
	Assert.assertTrue(contacinformationText.contains(fullname));
	Assert.assertTrue(contacinformationText.contains(email_Address));
	
	//div[@class ='account-cart-wrapper']//span[text()='Account']
	
	driver.findElement(By.xpath("//div[@class ='account-cart-wrapper']//span[text()='Account']")).click();
	
	driver.findElement(By.xpath("//a[@title='Log Out']")).click();
	

     Assert.assertTrue(driver.findElement(By.xpath("//img[contains(@src, 'logo.png')]")).isDisplayed());

		
	}
	
	@Test
	public void TC_06_Login_Validation() {
		
		
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		SleepInSecond(3);
		
		
		

		driver.findElement(By.id("email")).sendKeys(email_Address);
		driver.findElement(By.id("pass")).sendKeys(password);
		
		driver.findElement(By.id("send2")).click();
		
		SleepInSecond(3);
		
		String contacinformationText = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();
		
		System.out.println(contacinformationText);
		
		
		
		Assert.assertTrue(contacinformationText.contains(fullname));
		Assert.assertTrue(contacinformationText.contains(email_Address));
	
		
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
