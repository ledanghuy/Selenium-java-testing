package Webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_08_Web_Element {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	
	/// định nghĩa biến by ra ngoài ( xem ở test case số 2 và 3)
	
	By emailtextBox = By.id("Email");
	By password = By.id("Password");

	
	
	
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
		} 
			
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01() {
		
		driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
		WebElement element= driver.findElement(By.className(""));
		
	
		
		///driver.findElement(By.cssSelector("div.header-links a.ico-login"));
		
	  String SearchAttribute = element.getAttribute("placeholder");  //// lấy ra chữ Search Store
	  
	  String FirstNameAttribute= element.getAttribute("value");
	  
	  
	  
	  ///
	  
	  /// Test UI : font/size/color/location
	  element.getCssValue("#4ab2f1");
	  element.getLocation();
	  element.getRect();
	  
	  
	  //// Vị trí element so với web( bên ngoài _)
	  
	  Point point= element.getLocation();
	  point.x=324; /// set tọa đọ 
	  
	  
	///  Kích thước elemetn (bên trong)
	  Dimension di = element.getSize();
	  di.getHeight();
	  di.getWidth();
	  
	  
	  System.out.print(di.height);
	  
	  
	  
	  /// chụp hình khi testcase fail
	  element.getScreenshotAs(OutputType.FILE);
	  element.getScreenshotAs(OutputType.BYTES);
	  element.getScreenshotAs(OutputType.BASE64);
	  
	  
	  /////cần lấy ra tên thẻ HTML của elemnt đó>> truyền vào cho 1 lacator khác 
	  driver.findElement(By.xpath("//input[@id='Email]")).getTagName();
	  
	  String emailTextboxTagname= driver.findElement(By.cssSelector("Email")).getTagName();
	  driver.findElement(By.xpath("//" + emailTextboxTagname + "[@id ='email']"));
	  
	  /// Lấy text Error message/success message/label/ header/...
	  element.getText();
	 
	  
	  //// Dùng gex Text >>> Khi value mình cần lấy nó nằm ngoài 
	  /// Dùng get Attribute >> khi value mình cần lấy nó nằm bên trong
	  
	  
	  /// Dùng để verify xem 1 elemnt heiern thị hoặc không
	  /// Phạm vi tất cả các element
	    element.isDisplayed();
	 
	 Assert.assertTrue(element.isDisplayed());
	 Assert.assertFalse(element.isDisplayed());
	 
	 
	 /// dùng để verify xem 1 element  có thao tác được hay không
	 
	 Assert.assertTrue(element.isEnabled());
	 Assert.assertFalse(element.isEnabled());
	 
	 
	 // Dùng để verify xem 1 element được chọn hay chưa
	 /// Phạm vi : Check box / Raido button
	 Assert.assertTrue(element.isSelected());
	 Assert.assertFalse(element.isSelected());
	 
	 /// Dùng cho các textbox/ textarea/ dropdown 
	 element.sendKeys("");
	 
	 
	 /// Các elemetn nằm trong thẻ form 
	 /// Tương ứng với hành vi của User ( Enter )
	 element.submit();
	 
	 
	 /// Dùng nhiều
	 element.clear();
	 element.sendKeys();
	// String SearchAttribute = element.getAttribute("placeholder"); 
	 element.getText();
	 element.click();
	 Assert.assertTrue(element.isDisplayed());
	  
	  
	 /// Dùng ít
	 
	 element.getCssValue("");
	 element.getScreenshotAs(OutputType.FILE);
	 Assert.assertFalse(element.isSelected());
		
		
		
	    
		
		
	}
	@Test
	public void TC_02() {
		driver.findElement(emailtextBox).sendKeys("");
		driver.findElement(password).sendKeys("");
	}
	
	@Test
	public void TC_03() {
	
	}
	//@AfterClass
//	public void afterClass() {
	///    driver.quit();
	//}
}
