package Webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_Locator {
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
		
		/// Mở trang  Register ra:
		driver.get("https://demo.nopcommerce.com/register");
		
	}

	///<input type="text" data-val="true" data-val-required="First name is required." id="FirstName" 
	//name="FirstName" class="input-validation-error" aria-describedby="FirstName-error" aria-invalid="true">
	
	
	@Test
	public void TC_01_ID() {
		driver.findElement(By.id("FirstName")).sendKeys("Automation");
	}
	@Test
	public void TC_02_Class() {
		//<input class="search-text" type="text" id="q" name="q">
		driver.get("https://demo.nopcommerce.com/search");
		driver.findElement(By.className("search-text")).sendKeys("Macbook");
	}
	
	@Test
	public void TC_03_Name() {
	
		//Click vao Advaned Search checkbox
		///<input type="checkbox" data-val="true" data-val-required="The Advanced search field is required." id="advs" name="advs" value="true">
		///<label for="advs">Advanced search</label>
		driver.findElement(By.name("advs")).click();
	}
	
	@Test
	public void TC_04_TagName() {
		
		/// tim ra bao nhieu the input tren man hinh hien tai
		
		System.out.print(driver.findElements(By.tagName("input")).size());
	
	}
	
	@Test
	public void TC_05_LinkText() {
		
		///Click vao duong link Addresses ( truyen text tuyet doi)
	
		driver.findElement(By.linkText("Addresses")).click();
	}
	
	@Test
	public void TC_06_PartiaLinktext() {
	
	   //// Click vao duong link addree ( tuong doi  Apply for vendor account ) 
		driver.findElement(By.partialLinkText("vendor account")).click();
	}
	
	@Test
	public void TC_07_Css() {
		
		
		// Mo lai trang register
		driver.get("https://demo.nopcommerce.com/register");
		
		// 1 :
		
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("selenium");
		
		//2 : 
		driver.findElement(By.cssSelector("input[id='LastName']")).sendKeys("Locator");
		
		//3:
		driver.findElement(By.cssSelector("input[name='Email']")).sendKeys("automation@gmail.com");
		
		
	
	}
	
	@Test
	public void TC_08_Xpath() {
		
		
	
	}
	
	
	//@AfterClass
	//public void afterClass() {
	   // driver.quit();
	//}
}

/// comment


