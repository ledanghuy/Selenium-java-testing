package Webdriver;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_18_User_Interaction_Part_1 {
	WebDriver driver;
	JavascriptExecutor jsExcutor;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	Alert alert;
	WebDriverWait epliciwait;
	
	Actions action;
	

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		action= new Actions(driver);
		
		jsExcutor= (JavascriptExecutor) driver;
		epliciwait=new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
		
		
		
		
	}
	


	
  // @Test
	public void TC_01_ToolTips() {
		
		driver.get("https://automationfc.github.io/jquery-tooltip/");
		
		
		
		//action.
		//action.moveToElement(driver.findElement(By.cssSelector("input#age"))).perform();
		//SleepInSecond(3);
		
		///Verrify
		
		//Assert.assertEquals(driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText(), "We ask for your age only for statistical purposes.");
		
		
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Tooltips']"))).perform();
		
				
		Assert.assertEquals(driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText(), "That's what this widget is");
		//SleepInSecond(4);
		
		
		
		
	

	}
//	@Test
	public void TC_02_Hover_to_Element_menu() {
		
		
		driver.get("https://www.myntra.com/");
		
	
		action.moveToElement(driver.findElement(By.xpath("//div [@class= 'desktop-navLink']/a[text()='Kids']"))).perform();
		
		driver.findElement(By.xpath("//a[text()='Home & Bath']")).click();
		
		Assert.assertEquals (driver.findElement(By.xpath("//span[@class='breadcrumbs-crumb']")).getText(), "Kids Home Bath");
		
		
	
	}
	
	@Test
	public void TC_03_Hover_to_Element_menu_2() {
     
      driver.get("https://www.fahasa.com/");
      
      SleepInSecond(20); 
      
      
      action.moveToElement(driver.findElement(By.cssSelector("span.icon_menu"))).perform();
      SleepInSecond(5);
      
      
      action.moveToElement(driver.findElement(By.cssSelector("span.menu-title"))).perform();
      SleepInSecond(5);
      
      driver.findElement(By.xpath("//div[contains(@class,'fhs_menu_content)']//a[text()='Quản Trị - Lãnh Đạo']")).click();
      
      
    //  ol.breadcrumb li.category6028
    //ol[@class='breadcrumb']//strong[text()='Quản Trị - Lãnh Đạo']
      
    //  Assert.assertEquals(driver.findElement(By.cssSelector("ol.breadcrumb li.category6028")).getText(), " QUẢN TRỊ - LÃNH ĐẠO");
      
      Assert.assertTrue(driver.findElement(By.xpath("//ol[@class='breadcrumb']//strong[text()='Quản Trị - Lãnh Đạo']")).isDisplayed());
      
      
      
      
		
    }
	
	//@Test
	public void TC_04_Authentication_Alert() {

	
		
		
		
		  
		
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





