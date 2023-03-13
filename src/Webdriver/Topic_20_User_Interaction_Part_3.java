package Webdriver;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class Topic_20_User_Interaction_Part_3 {
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
	public void TC_01_Doulbe_Click() {
		
		driver.get("https://automationfc.github.io/basic-form/index.html");
		SleepInSecond(10);
		
		
		///scroll đến element đó
		jsExcutor.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//button [text()='Double click me']")));
		
		action.doubleClick(driver.findElement(By.xpath("//button [text()='Double click me']"))).perform();
		
		SleepInSecond(5);
		
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='demo']")).getText(), "Hello Automation Guys!");
		
		
		
		
	
		
		
	

	}
	//@Test
	public void TC_02_Right_Click_Menu_Context_Menu() {
		
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		
		//
		
		//li.context-menu-visible
		action.contextClick(driver.findElement(By.xpath("//span [text()='right click me']"))).perform();
		
		////span[text()='Quit']
		Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-quit")).isDisplayed());
		
		action.moveToElement(driver.findElement(By.cssSelector("li.context-menu-icon-quit"))).perform();
		SleepInSecond(3);
		
		
		Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon.context-menu-visible.context-menu-icon-quit.context-menu-hover")).isDisplayed());
		
		action.click(driver.findElement(By.xpath("//span[text()='Quit']"))).perform();
		SleepInSecond(3);
		
		driver.switchTo().alert().accept();
		SleepInSecond(3);
		
		
		Assert.assertFalse(driver.findElement(By.xpath("//span[text()='Quit']")).isDisplayed());
		
	}
	
	@Test
	public void TC_03_Drap_and_Drop() {
    
		driver.get("https://automationfc.github.io/kendo-drag-drop/");
		
		action.clickAndHold(driver.findElement(By.id("draggable"))).perform();
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





