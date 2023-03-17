package Webdriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_23_Handle_Popup_Dialog_Part_3 {
	WebDriver driver;
	JavascriptExecutor jsExcutor;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	Alert alert;
	WebDriverWait epliciwait;
	
	Actions action;
	
	String EmailAddreess= "testdemo" +getRandomNumerb()+ "@gmail.com";
	

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}
			
		
		
		FirefoxOptions optionns= new FirefoxOptions();
		optionns.setProfile(new FirefoxProfile());
		optionns.addPreference("dom.webnotifications.enabled", false);
		
		
		driver= new FirefoxDriver(optionns);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		action= new Actions(driver);
		jsExcutor= (JavascriptExecutor) driver;
		epliciwait=new WebDriverWait(driver, 5);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	
   //@Test
	public void TC_01_Random_in_Dom() {
		
		driver.get("https://www.javacodegeeks.com/");
		SleepInSecond(30);
		
		//By Lepopup= By.cssSelector("div.lepopup-popup-container>div:not([style^='display:none'])");
		
		
		By Lepopup= By.xpath("//div[@data-page='1']");

		if (driver.findElement(Lepopup).isDisplayed())
		{
			// div.lepopup-input>input
			driver.findElement(By.xpath("//div[@class='lepopup-input']/input [@class='lepopup-ta-left ']")).sendKeys(EmailAddreess);
			SleepInSecond(5);
			driver.findElement(By.cssSelector("a[data-label='Get the Books'],[data-label='OK']>span")).click();
			SleepInSecond(5);
			
			////div [@class='lepopup-element-html-content']/h4
			//div.lepopup-element-html-content>h4
			Assert.assertEquals(driver.findElement(By.xpath("//div [@class='lepopup-element-html-content']/h4")).getText(), "Thank you!");
			
			
			///
			///div.lepopup-element-html-content>p
			Assert.assertTrue(driver.findElement(By.xpath("//div[@class='lepopup-element-html-content']/p")).getText().contains("Your sign-up request was successful. We will contact you shortly. Please"));
			SleepInSecond(15);
			///
		}
		
		String articleName= "Agile Testing Explained";
		//input#search-input 
	    ///button#search-submit
		
		driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys(articleName);
		driver.findElement(By.xpath("//button [@id='search-submit']")).click();
		
        
        Assert.assertEquals(driver.findElement(By.xpath("//a[text()='Agile Testing Explained']")).getText(), articleName);
		
		
		
		

	}
	//@Test
	public void TC_02_Random_Popup_In_DOm() {

		driver.get("https://vnk.edu.vn/");
		SleepInSecond(30);
		By popup = By.cssSelector("div#tve-p-scroller");
		
		if (driver.findElement(popup).isDisplayed())
		{
			//div.thrv_icon
			driver.findElement(By.cssSelector("div#tve-p-scroller div.thrv_icon")).click();
			SleepInSecond(3);
			
		}
		else
		{
			driver.findElement(By.cssSelector("button.btn-danger")).click();
			SleepInSecond(5);
			
			//span[text()='Lịch khai giảng tháng 3 năm 2023']
			Assert.assertEquals(driver.getTitle(), "Lịch khai giảng các khóa học tại VNK EDU | VNK EDU" );
			
			
		}
		

		
	}
	
	@Test
	public void TC_03_RANDOM_NOT_IN_DOM() {
     
		driver.get("https://dehieu.vn/");
		SleepInSecond(30);
		
		By Popup_Register = By.cssSelector("div.popup-content");
		
		if (driver.findElement(Popup_Register).isDisplayed())
		{
			
			driver.findElement(By.cssSelector("button#close-popup")).click();
			SleepInSecond(3);
			
			driver.findElement(By.xpath("//a [text()='Tất cả khóa học']")).click();
			SleepInSecond(5);
			Assert.assertTrue(driver.findElement(By.cssSelector("input.search")).isDisplayed());
			
			
		}
		

    }
	
	//@Test
	public void TC_04_Drag_and_Drop_HTML4() {
	
  
	}
	
	
	//@Test
	public void TC_05_() {
		
		
		
		
	
		
	}
	
	//@Test
	public void TC_06_PartiaLinktext() {
	
	}
	
	//@Test
	public void TC_07_Css() {
		
	}
	
	//@Test
	public void TC_08_Xpath() {
	
	}
	
	
	public  int  getRandomNumerb() 
	
	{
	        	return new Random().nextInt(99999);
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
	//public void afterClass() {
	//    driver.quit();
	//}


	
}





