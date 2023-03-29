package Webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_31_ExplicitWait_Bai_Tap {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	WebDriverWait explicitWait;

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver_1.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver_1");
		}
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
	}

	//@Test
	public void TC_01_Select_Date_Ajax_Loading() {
	 
		
		 driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
		 
		 explicitWait = new WebDriverWait (driver, 30);
		 //wait cho cái date picker hiển thị

		 explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.RadCalendar'")));
		 
		 /// Verify cho Selected Date là No Selected Dates to display	 
		 Assert.assertEquals(driver.findElement(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1")).getText(), "No Selected Dates to display.");
		 
		 //wait cho ngày 20 được phép click
		 explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a [text()='20']")));
		 
		 /// Click vào ngày 20
		 driver.findElement(By.xpath("//a [text()='20']")).click();
		 
		 /// Wait cho Ajax icon loading biến mất ( invisible)
		 
		 explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[id*='RadCalendar1']>div.raDiv")));
		 
		 /// Wait cho ngày vừa được chọn  là được phép click 
		 
		 explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td [@class='rcSelected']/a[text()='20']")));
		 
		 
		 // Verify ngày được lựa chọn được hiển thị ra
		 
		 Assert.assertEquals(driver.findElement(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1")).getText(), "Monday, March 20, 2023");
	
	  
	}
	@Test
	public void TC_02_Select_Date_Ajax_Loading() {
		 
		
		 driver.get("https://gofile.io/welcome");
		 explicitWait = new WebDriverWait (driver, 30);
		 
		 /// Verify cho trang hiển thị :
		 
		 explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-secondary btn-lg']")));

	
	  
	}
	

		 
	//}
	//@AfterClass
	///public void afterClass() {
	   // driver.quit();
	//}
}
