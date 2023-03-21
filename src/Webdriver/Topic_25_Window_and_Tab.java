package Webdriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
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

public class Topic_25_Window_and_Tab {
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
		//driver.manage().window().maximize();

	}

	
 //  @Test
	public void TC_01_WindowandTab() {
	   
	   // Parent Page
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		// jsExcutor.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//a [text()='GOOGLE']")));
		 
			//1 - Lay ra cai ID cua tab/ window ma no dang dung' (active)
		 String parentPagewindowID = driver.getWindowHandle();
		 System.out.println("Parent Page" + parentPagewindowID);
		 
		 
		 //Click vao link google de bat ra 1 tab moi
		 driver.findElement(By.xpath("//a [text()='GOOGLE']")).click();
		 SleepInSecond(5);

		//2  Lay ra tat ca ID
		 
		 SwichToWindowByID(parentPagewindowID);
		
        //  Set<String> allWindowIDs = driver.getWindowHandles();
          
          
          ///Sau do dùg vòng lặp duyệt qua và kiểm tra
          
          //for (String id : allWindowIDs) {
        	//  if (!id.equals(parentPagewindowID))
        	  //{
        		//  driver.switchTo().window(id);
        		 // SleepInSecond(3);
        //	  }
			
	//	}
          
          
          Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.com.vn/");
         
         driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Selenium");
         SleepInSecond(5);
         
         String googleWindowID= driver.getWindowHandle();
         
         SwichToWindowByID(googleWindowID);
         
        // allWindowIDs = driver.getWindowHandles();
         
         //for (String id : allWindowIDs) {
       //	  if (!id.equals(googleWindowID))
       	//  {
       	//	  driver.switchTo().window(id);
       	//	  SleepInSecond(3);
       //	  }
			
		//}
         Assert.assertEquals(driver.getCurrentUrl(), "https://automationfc.github.io/basic-form/index.html");
		
		/// Case 1: Chi co duy nhat 2 window hoac 2 tab
		
		
		/// Case 2 : Nhieu hon 2 window/ 2 tab
		
	  
		

	}
   //Dùng điwọc cho 2 ID ( window/tab)
   public void SwichToWindowByID(String otherID) 
   {
	   Set<String> allWindowIDs = driver.getWindowHandles();
       
       
       ///Sau do dùg vòng lặp duyệt qua và kiểm tra
       
       for (String id : allWindowIDs) {
     	  if (!id.equals(otherID))
     	  {
     		  driver.switchTo().window(id);
     		  SleepInSecond(3);
     	  }
			
		}
   
   }
   
   
   
   //Dùng được cho từ ID trở lên (Window/Tab)
   private void SwitchToWindowByPageTitle(String expectedPagetitle) {
		// TODO Auto-generated method stub
		   
		   Set<String> allWindowIDs = driver.getWindowHandles();
		   
		   
	       for (String id : allWindowIDs) {
	     	 
	     		  //duyet qua tung ID truoc
	     		  driver.switchTo().window(id);
	     		  
	     		  /// Lay ra title cua page nay 
	     		 String actualPagetitle = driver.getTitle();
	     		 
	     		 if (actualPagetitle.equals(expectedPagetitle))
	     		 {
	     			 SleepInSecond(3);
	     			 break;
	     			 
	     		 }
		
			}

	}
   
 
	//@Test
	public void TC_02_Title () {

	
				driver.get("https://automationfc.github.io/basic-form/index.html");
				
				 jsExcutor.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//a [text()='GOOGLE']")));
				 driver.findElement(By.xpath("//a [text()='GOOGLE']")).click();
				 SleepInSecond(5);
				
				 String parentPagewindowID = driver.getWindowHandle();
				 System.out.println("Parent Page" + parentPagewindowID);
	 
				SwitchToWindowByPageTitle("Google");
		        Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.com.vn/");
		        SleepInSecond(2);
		        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("24h.com.vn");
		        SleepInSecond(3);
		        
		         
		       SwitchToWindowByPageTitle("Selenium WebDriver");
		       Assert.assertEquals(driver.getCurrentUrl(), "https://automationfc.github.io/basic-form/index.html");
		      

		       
		       driver.findElement(By.xpath("//a [text()='FACEBOOK']")).click();
		       SleepInSecond(5);
		       
		       SwitchToWindowByPageTitle("Facebook – log in or sign up");
		      // Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/");
		       driver.findElement(By.id("email")).sendKeys("ledanghuy91");
		       driver.findElement(By.id("pass")).sendKeys("Ledangkhoi@234");
		       driver.findElement(By.xpath("//button [@name='login']")).click();
		       SleepInSecond(3);
		       
		       
		       SwitchToWindowByPageTitle("Selenium WebDriver");
		       Assert.assertEquals(driver.getCurrentUrl(), "https://automationfc.github.io/basic-form/index.html");
		       driver.findElement(By.xpath("//a [text()='TIKI']")).click();
		       SleepInSecond(3);
		       
		       SwitchToWindowByPageTitle("Tiki - Mua hàng online giá tốt, hàng chuẩn, ship nhanh");
		       Assert.assertEquals(driver.getCurrentUrl(), "https://tiki.vn/");
		       SleepInSecond(3);
		       driver.findElement(By.cssSelector("input[class^='FormSearch']")).sendKeys("iphone 14 pro max");
		       SleepInSecond(3);
		       

		
	}
	
	//@Test
	public void TC_03_Kya() {
		
		driver.get("https://skills.kynaenglish.vn/");
		
     
		

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





