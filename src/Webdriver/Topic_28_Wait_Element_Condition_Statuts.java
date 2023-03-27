package Webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_28_Wait_Element_Condition_Statuts {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	WebDriverWait expliciWait;

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		expliciWait =new WebDriverWait(driver, 10);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	//@Test
	public void TC_01_Visible_Displayed_Visibility() {
		/// Trường hợp  : Có điều kiện là : 
		///// Có trên UI ( Bắt buộc )
		///// Có trong HTML ( Bắt buộc )
		
		driver.get("https://www.facebook.com/");
		
		/// Wait cho email addreess textbox thiển thị
		//// Chờ cho email textbox hiển thị trong vòng 10s 
		expliciWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		driver.findElement(By.id("email")).sendKeys("ledanghuy91");
		
	  
	}
	//@Test
	public void TC_02_Invisible_Undisplayed_Invisibility_I() {
	     // Trường hợp :
		 /// 1. Không Có trên UI ( bắt buộc)
		//// 2. Có trong HTML
		
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//a [@data-testid='open-registration-form-button']")).click();
		
		//Chờ chờ Re-enter Email textbox không hiển thị trong vòng 10s
		expliciWait.until(ExpectedConditions.invisibilityOfElementLocated(By.name("reg_email_confirmation__")));
		
	}
	
	//@Test
	public void TC_02_Invisible_Undisplayed_Invisibility_II() {
		
		// Trường hợp :
		/// 1. Không có trên UI ( bắt buộc )
		////2. Không có trong HTML
		driver.get("https://www.facebook.com/");
		expliciWait.until(ExpectedConditions.invisibilityOfElementLocated(By.name("reg_email_confirmation__")));

	
	}
//	@Test
	public void TC_03_Presence_I() {
		
		// Trường hợp :
		/// 1. Có ở trên UI
		////2. Có ở trên cây HTML ( bắt buộc )
		driver.get("https://www.facebook.com/");
		
		/// Chờ cho email address textbo presence trong HTML trong vòng 10s
		expliciWait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
		
		
		
	
	}
	
	//@Test
	public void TC_03_Presence_II() {
		
		// Trường hợp :
		/// 1. Không có trên UI 
		////2. Có trong HTML ( bắt buộc )
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//a [@data-testid='open-registration-form-button']")).click();
		expliciWait.until(ExpectedConditions.presenceOfElementLocated(By.name("reg_email_confirmation__")));
		
		
		
	
	}
	@Test
	public void TC_04_Staleness() {
	     
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//a [@data-testid='open-registration-form-button']")).click();
		
		/// Phase 1  Element có trong cây HTML
		
		WebElement reEnterEmailAddressTextbox = driver.findElement(By.name("reg_email_confirmation__"));
		
		
		/// Thao tác với element khác làm cho element re-etner email không còn trong DOM nữa
		
		
		
		// Close popup di 
		driver.findElement(By.cssSelector("img._8idr")).click();
		
		
		/// Chờ cho Re-enter email textbox không còn trong DOM trong vòng 10s
		expliciWait.until(ExpectedConditions.stalenessOf(reEnterEmailAddressTextbox));
		
		
		
	}
	
	//@AfterClass
	///public void afterClass() {
	   // driver.quit();
	//}
}
