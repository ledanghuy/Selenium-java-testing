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

public class Topic_24_Handle_Iframe_and_Frame_1 {
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

	
  // @Test
	public void TC_01_kynaenglish() {
		
	   driver.get("https://skills.kynaenglish.vn/");
	  
	  /// jsExcutor.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("")));
	   
	   Assert.assertTrue(driver.findElement(By.xpath("//iframe[contains(@src,'kyna.vn')]")).isDisplayed());
	   
	   
	   ///swith vaò đúng thẻ iframe chứ elemnt đó
	   
	   //cách 1:
	  // driver.switchTo().frame(1);
	   
	   //cách 2:
	  // driver.switchTo().frame("");
	   
	   
	   //cách 3:
	   
	   driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'kyna.vn')]")));
	   
	   String facebookLike= driver.findElement(By.xpath("//a[text()='Kyna.vn']/parent::div/following-sibling::div")).getText();
	   
	   System.out.println(facebookLike);
	   
	   Assert.assertEquals(facebookLike, "165K likes");
	   
	  
	   
	   //swith lai ve mainpage
	   driver.switchTo().defaultContent();
	   
	   /// switch sang ifram chat
	   
	   
	   driver.switchTo().frame ("cs_chat_iframe");
	   //driver.switchTo().frame(driver.findElement(By.xpath("//iframe [@id='cs_chat_iframe']")));
	   
	   
	   
	   
	  driver.findElement(By.cssSelector("div.button_bar")).click();
	  
	  driver.findElement(By.cssSelector(".input_name")).sendKeys("ABC");
	  driver.findElement(By.cssSelector(".input_phone")).sendKeys("0166796223");
	 new Select(driver.findElement(By.id("serviceSelect"))) .selectByVisibleText("HỖ TRỢ KỸ THUẬT");
	 
	 driver.findElement(By.name("message")).sendKeys("Hà Nội Mùa thu");
	 
    SleepInSecond(3);
    
    
    driver.switchTo().defaultContent();
    
	driver.findElement(By.id("live-search-bar")).sendKeys("Excel");
	driver.findElement(By.cssSelector("button.search-button")).click();
	SleepInSecond(3);
	
	

	List<WebElement> list_element = driver.findElements(By.cssSelector("div.content>h4"));
	
	for (WebElement list_item : list_element) {
		
		
		Assert.assertTrue(list_item.getText().contains("Excel"));
	}
	
	  
		

	}
	@Test
	public void TC_02_hdfcbank() {
		
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		
		driver.switchTo().frame("login_page");
		SleepInSecond(3);

		driver.findElement(By.name("fldLoginUserId")).sendKeys("john2022");
		
		driver.findElement(By.cssSelector("a.login-btn")).click();
		SleepInSecond(5);
		
		
		//Assert.assertTrue(driver.findElement(By.xpath("//div [text()='Login to Netbanking']")).isDisplayed());
		
		Assert.assertTrue(driver.findElement(By.cssSelector("input#fldPasswordDispId")).isDisplayed());
		driver.findElement(By.cssSelector("input#fldPasswordDispId")) .sendKeys("joyhn20022000");	  
		
		

		
	}
	
	//@Test
	public void TC_03_RANDOM_NOT_IN_DOM() {
     
		

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





