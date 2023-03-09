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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_10_Handle_Default_Dropdown {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	

	String firtName, lastName, emailAdreess, companyName, password, day, month, year, country, 
	state_provide, City, Address_1, Address_2, Zip_code, Phone_number, Fax;
	
	Select select;
	
	
	///String generatedString = RandomStringUtils.randomAlphabetic(10);



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
		
		firtName="Le Dang";
		lastName="Huy";
		emailAdreess="ledanghuy" + getRandomNumber() +"@gmail.com";
		companyName="AdOne";
		password="huy123@!!";
		day="30";
		month="April";
		year="1991";
		
		country="United States";
		state_provide="Alaska";
		City="ABC";
		Address_1="dsadsad132132342";
		Address_2="dsadsad132132342dfs543fds43543";
		Zip_code="1000";
		Phone_number="0936300491";
		Fax="+988888888";
		
	
	}

	//@Test
	public void TC_01_Register() {
		
		
		driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
		
		
		
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		/// css : a.ico-register
		SleepInSecond(4);
		
		driver.findElement(By.xpath("//label[text()='Male']")).click();	
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys(firtName);
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys(lastName);
		
		 new Select (driver.findElement(By.name("DateOfBirthDay"))).selectByVisibleText(day);
		 new Select (driver.findElement(By.name("DateOfBirthMonth"))).selectByVisibleText(month);
		 new Select (driver.findElement(By.name("DateOfBirthYear"))).selectByVisibleText(year);
		 
		
	
		 
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailAdreess);
		driver.findElement(By.xpath("//input[@id='Company']")).sendKeys(companyName);	 
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.id("ConfirmPassword")).sendKeys(password);
		
		driver.findElement(By.id("register-button")).click();
		
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");
		
		driver.findElement(By.cssSelector("a.ico-account")).click();
		
		//driver.findElement(By.xpath("//a[text()='Log in']")).click();
		
		
		
		//Assert.assertEquals(driver.findElement(By.cssSelector("//h1[text()='Welcome, Please Sign In!']")).getText(),"Welcome, Please Sign In!");
		
		
		
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='FirstName']")).getAttribute("value"), firtName);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='LastName']")).getAttribute("value"), lastName);
		
		Assert.assertEquals(new Select (driver.findElement(By.name("DateOfBirthDay"))).getFirstSelectedOption().getText(), day );
		Assert.assertEquals(new Select (driver.findElement(By.name("DateOfBirthMonth"))).getFirstSelectedOption().getText(), month );
		Assert.assertEquals(new Select (driver.findElement(By.name("DateOfBirthYear"))).getFirstSelectedOption().getText(), year );
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='Company']")).getAttribute("value"), companyName);
	
	}
 @Test
	public void TC_02() {
		
		
			driver.get("https://demo.nopcommerce.com/");
			driver.findElement(By.xpath("//a[text()='Log in']")).click();
			
			driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("ledanghuy91@gmail.com");
			driver.findElement(By.id("Password")).sendKeys("huy123@!!");
			
	
		
			driver.findElement(By.xpath("//button[text()='Log in']")).click();
			SleepInSecond(2);
			
			
			driver.findElement(By.xpath("//div[@class= 'header' ]//a[text()='My account']")).click();
			
			driver.findElement(By.xpath("//li[@class='customer-addresses inactive']/a")).click();
			
			driver.findElement(By.xpath("//div[@class='add-button']/button")).click();
			
			
			driver.findElement(By.id("Address_FirstName")).sendKeys(firtName);
			driver.findElement(By.id("Address_LastName")).sendKeys(lastName);
			driver.findElement(By.id("Address_Email")).sendKeys(emailAdreess);
			driver.findElement(By.id("Address_Company")).sendKeys(companyName);
			
			
		   new Select(driver.findElement(By.id("Address_CountryId"))).selectByVisibleText(country);
		   new Select(driver.findElement(By.id("Address_StateProvinceId"))).selectByVisibleText(state_provide);
		   
		   driver.findElement(By.id("Address_City")).sendKeys(City);

		   driver.findElement(By.id("Address_Address1")).sendKeys(Address_1);
		   
		   driver.findElement(By.id("Address_Address2")).sendKeys(Address_2);
		   driver.findElement(By.id("Address_ZipPostalCode")).sendKeys(Zip_code);
		   driver.findElement(By.id("Address_PhoneNumber")).sendKeys(Phone_number);
		   driver.findElement(By.id("Address_FaxNumber")).sendKeys(Fax);
		   
		   
		   driver.findElement(By.xpath("//button[@class='button-1 save-address-button']")).click();
		   
		   Assert.assertEquals(driver.findElement(By.cssSelector("li.name")).getText(), firtName +" " + lastName);
		   Assert.assertTrue(driver.findElement(By.cssSelector("li.email")).getText().contains(emailAdreess));
		   Assert.assertTrue(driver.findElement(By.cssSelector("li.phone")).getText().contains(Phone_number));
		   Assert.assertEquals(driver.findElement(By.cssSelector("li.company")).getText(), companyName);
		   Assert.assertEquals(driver.findElement(By.cssSelector("li.address1")).getText(), Address_1);
		   Assert.assertEquals(driver.findElement(By.cssSelector("li.address2")).getText(), Address_2);
		   Assert.assertTrue(driver.findElement(By.cssSelector("li.city-state-zip")).getText().contains(City));
		   
		   
		   
			
	}
	@Test
	public void TC_03() {
	
	}
	
	public int getRandomNumber()
	{
		Random rand= new Random();
		return rand.nextInt(99999);
		
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
