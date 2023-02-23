package Webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

public class Topic_07_Web_Browser {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
		}
			
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}

	@Test
	public void TC_01() {
		
		
		/// ** là dùng nhiều
		
		/// * sao là dùng it 
		
		
		
		///đóng cái tab hoặc cửa sổ nó đang đứng 
		driver.close();
		
		/// Không quan tâm bao tab/window---Brower
		driver.quit();///**
		
		
		///Có thể lưu nó vào 1 biến để sử dụng cho các step sau >> dùng lại nhiều lần
		
	    /// Tìm 1 element
		WebElement emailTextBox=driver.findElement(By.xpath("//input[@id='email']"));//**
		emailTextBox.clear();
		emailTextBox.sendKeys("");
		
		// Tìm nhiều element
	    List<WebElement> CheckBoxes= driver.findElements(By.xpath("")); //*
		
		//// Mở ra 1 cái URL bất kỳ
	    
	    driver.get("https://www.facebook.com/");/// **
	    
	    //Clcik vào link tiếng việt
	   
	    /// Trả về url của page hiện tại  
	    
	    
	  
	    String VietnamesPageURl=  driver.getCurrentUrl();
	    Assert.assertEquals( VietnamesPageURl, "https://en-gb.facebook.com/");
		
	    
	    Assert.assertEquals( driver.getCurrentUrl(), "https://en-gb.facebook.com/");
		
	   
	    
	    ///Trả về Soure Code HTML của page hiện tại
	    ///Verify tương đối
	    driver.getPageSource();
	    
	    Assert.assertTrue(driver.getPageSource().contains("Facebook giúp bạn kết nối và chia sẻ với mọi người trong cuộc sống của ban"));
	    
	    
	    
	    /// trả về title của page hiển tại
	    
	    Assert.assertEquals(driver.getTitle(),"Facebook - Đăng Nhập hoặc đăng ký");
	    
	    
	    /// Lấy ra được ID của window hoặc tab mà driver đang đứng 
	    
	    String LoginWindowID= driver.getWindowHandle();  //*
	    
	    
	    
	    /// Lấy ra ID của tất cả window lẫn tab
	    
	 //   Set <String> allID= driver.getWindowHandles();  //*
	    
	    
	    ///Cookie // Cache
	   
	     Options opt= driver.manage();	    
	
	     //Login THành công >> Lưu Lại
	     
	     opt.getCookies(); //*
	     
	     ///Test Case khác >> Set cookie vào lại>> không cần phải login nữa.
	     
	    Timeouts timeout= opt.timeouts();
	    //khoảng thời gian chờ  element xuất hiện
	    timeout.implicitlyWait(15, TimeUnit.SECONDS); ///5 ///**
	    timeout.implicitlyWait(500, TimeUnit.MILLISECONDS);
 
	    
	    ///Khoảng thời gian chờ page load xong trong vòng x giây
	    timeout.pageLoadTimeout(5, TimeUnit.SECONDS);
	    
	    ////Khoảng thời gian chờ script được thực thi trogn vòng x giây
	    timeout.setScriptTimeout(5, TimeUnit.SECONDS);
	    
	    
	    Window win= opt.window();
	    win.fullscreen();
	    win.maximize();//**
	    
	    
	   
	    
	    /// Test GUI : Font /Size/ Color/Position
	    
	    win.getPosition();
	    win.getSize();
	    
	    /// đại diện cho 3 nút back ,next and refesh
	   Navigation nav= driver.navigate();
	    nav.back();
	    nav.refresh();
	    nav.forward();
	    nav.to("https://www.facebook.com/");
	    
	    
	      TargetLocator tar=driver.switchTo();
	      tar.alert(); //*
	      tar.frame("");//*
	      tar.window("");//*
	    
		
		
	}
	@Test
	public void TC_02() {
	}
	
	@Test
	public void TC_03() {
	
	}
	//@AfterClass
//	public void afterClass() {
	///    driver.quit();
	//}
}
