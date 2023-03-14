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

public class Topic_19_User_Interaction_Part_2 {
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

	
 //  @Test
	public void TC_01_Click_and_Hold() {
		
		driver.get("https://automationfc.github.io/jquery-selectable/");
		
		//ol[@id='selectable']/li
		List <WebElement> list_number = driver.findElements(By.cssSelector("ol#selectable>li"));
		
		action.clickAndHold(list_number.get(0)).moveToElement(list_number.get(7)).release().perform();
		//action.clickAndHold(list_number.get(0)).moveToElement(list_number.get(4)).moveToElement(list_number.get(8)).release().perform();
		
		SleepInSecond(10);
		

		
		//ol[@id='selectable']/li[@class='ui-state-default ui-selectee ui-selected']
		List <WebElement> Selected_list_number = driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
		
		Assert.assertEquals(Selected_list_number.size(), 8);
		
	

	}
	//@Test
	public void TC_02_Click_and_Hold_random() {
		
		driver.get("https://automationfc.github.io/jquery-selectable/");
		
		Keys key=null;
		
		if (osName.contains("Windows"))
		{
			key=Keys.CONTROL;
			
		}else
		{
			key=Keys.COMMAND;
		}
		
		List <WebElement> list_number = driver.findElements(By.cssSelector("ol#selectable>li"));
		
		
		///Nhấn ctrl xuống
		
		action.keyDown(key).perform();
		
		
		
		// Chọn các số random 
		
		action.click(list_number.get(0)).click(list_number.get(4)).click(list_number.get(6)).click(list_number.get(11)).perform();
		
		// nhả phím ctrl ra
		
		action.keyUp(key).perform();
		
		
		SleepInSecond(5);
		
      List <WebElement> Selected_list_number = driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
		
		Assert.assertEquals(Selected_list_number.size(), 4);
		
		
	
	}
	
	//@Test
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
	public void TC_04_Drag_and_Drop_HTML4() {

	
		driver.get("https://automationfc.github.io/kendo-drag-drop/");
		
		WebElement smallcrile = driver.findElement(By.cssSelector("div#draggable"));
		
		WebElement bigcrile= driver.findElement(By.cssSelector("div#droptarget"));
		
		action.dragAndDrop(smallcrile, bigcrile).perform();
		SleepInSecond(3);
		
		///verify text
		Assert.assertEquals(bigcrile.getText(),"You did great!");
		  
		/// Verify color
		
		String bigcrile_backgroundcolor= bigcrile.getCssValue("background-color");
		
		System.out.println(bigcrile_backgroundcolor);
		
		Assert.assertEquals(Color.fromString(bigcrile_backgroundcolor).asHex().toUpperCase(), "03a9F4");
		
  
	}
	
	
	@Test
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





