package Webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Template2_Axes {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01() {
		
		
		driver.get("http://live.techpanda.org/index.php/mobile.html");

		////a[text()='Sony Xperia']
		
		
	     /// Dù thay đổi vị trí của sản phẩm thì vẫn có thể lấy ra được :
		
		//a[text()='Sony Xperia']/parent::h2/following-sibling::div[@class='actions']/child::button
		//driver.findElement(By.xpath("//a[text()='Sony Xperia']/parent::h2/following-sibling::div[@class='actions']/button")).getText();
		
		// System.out.println (driver.findElement(By.xpath("//a[text()='Sony Xperia']/parent::h2/following-sibling::div[@class='actions']/button")).getText());
		
		////a[text()='Sony Xperia']/parent::h2/following-sibling::div[@class='ratings']/ancestor::*[@class='product-info']/preceding-sibling::*
		System.out.println (driver.findElement(By.xpath
				("//a[text()='Sony Xperia']/parent::*/following-sibling::div[@class='ratings']/ancestor::*[@class='product-info']/preceding-sibling::*[@class='product-image']")).getText());
	
		
		
		//a[text()='Sony Xperia']/parent::*/following-sibling::div//*[@class='ratings']/ancestor::*[@class='product-info']/preceding-sibling::*
		
		///>>giống thầy nhưng báo lỗi đoạn : div//*
		
		
		
		//driver.get("https://fptshop.com.vn/may-tinh-xach-tay/apple-macbook");
		
	
		
		//a[@title='MacBook Air 13" 2020 M1 16GB/256GB']/parent::h3/following-sibling::div[@class='cdt-product__btn']/a[text()='MUA NGAY']
		
		
		//ancestor : tổ tiên
		///parent : từ node con lên node cha
		/// preceding : bác
		/// following: chú
		///preceding-sibling : từ node em đi lên node anh
		///following-sibling : từ node anh đi xuống node em
		/// child ( con)
		/// descendant ( con/cháu/chắt)
		
		
	    
		
	}
	@Test
	public void TC_02() {
	}
	
	@Test
	public void TC_03() {
	
	}
	//@AfterClass
	//public void afterClass() {
	  ///  driver.quit();
	///}
}
