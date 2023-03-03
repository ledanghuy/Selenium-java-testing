package Webdriver;



import java.util.List;
import java.util.Random;
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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_11_Handle_Custom_Dropdown_Part_1 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	WebDriverWait exliciWait;
	

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
		}
			
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		exliciWait= new WebDriverWait(driver, 30);
		driver.manage().window().maximize();
		
		
		
	
	}

	@Test
	public void TC_01_JQurey() {
		
	    Select_item_in_DropDown("span#speed-button", "ul#speed-menu div[role='option']", "Slower"); 
	    SleepInSecond(3);
	    //driver.findElement(By.cssSelector("span#speed-button>span.ui-selectmenu-text")).getText();
	    Assert.assertEquals(driver.findElement(By.xpath("//span[@id='speed-button']/span[@class='ui-selectmenu-text']")).getText(), "Slower");
	   
	  
	    Select_item_in_DropDown("span#speed-button", "ul#speed-menu div[role='option']", "Medium");
	    Assert.assertEquals(driver.findElement(By.xpath("//span[@id='speed-button']/span[@class='ui-selectmenu-text']")).getText(), "Slower");

			
	
	}
 @Test
	public void TC_02() {
		
		
	
			
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

	
	public void Select_item_in_DropDown(String parentCss, String allitemCss, String expectedTextitem ) 
	{
		
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
		
		///*** CHỌn lần đầu tiên **///
		
		// 1- Click vào 1 thẻ bất kỳ để làm sao cho nó xổ hết tất cả các item của dropdown:
		driver.findElement(By.cssSelector(parentCss)).click();
		
		// 2 - Chờ cho tất cả item được load ra thành công :

		///locator phải lấy được tất cả các thành phần bên trong 
		exliciWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(allitemCss)));
		
		 
		/// Đưa hết tất cả các item trong dropdown vào 1 cái list 
		List <WebElement> speed_Drop_down_item= driver.findElements(By.cssSelector(allitemCss));
		
		/// forech dành cho array hoặc collecttion )
        /// Tìm item xem đúng cái đang cần hay không ( dùng vòng lặp duyệt qua để tìm )
	    for (WebElement temItem : speed_Drop_down_item) {
			
	    	String itemText= temItem.getText();
	    	System.out.println(itemText);
	    	
	    	///4 Kiểm tra text của item đúng với cái mình mong muốn 
	    	if (itemText.equals(expectedTextitem))
	    	{
	    		
	    		/// click vào item đó
	    		System.out.println("click vao item ");
	    		temItem.click();
	    		break ;
	    		// thoát khỏi vòng lặp ko xét cho các case còn lại nữa
	    	}
	    	else 
	    	{
	    		System.out.println("Không tìm thấy nên không click vào item ");
	    	}
	    	
	    	    	
	    	
		}
	    
	    
        
	    
		
		
		
	}
	public WebDriver getDriver() 
	{
		
		return driver;
	}
	
	//@AfterClass
//	public void afterClass() {
	///    driver.quit();
	//}
}
