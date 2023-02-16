package Webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_Form_Register {
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
	public void TC_01_Empty_Data() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		//Action
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		
		
		//driver.findElement(By.id("txtFirstname-error")).getText()  >>>lấy text theo Id ra
		
		
		///
		 ///Assert.assertTrue: Kiểm tra 1 điều kiện trả về là đúng
		////Assert.assertFalse: Kiểm tra 1 điều kiện trả về là sai 
		////Assert.assertEquals  : kiểm tra thực tế với mong đợi như nhau
		
		/// Verify
		
	    Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(),"Vui lòng nhập họ tên" );
	    Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email" );
	    Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Vui lòng nhập lại địa chỉ email" );
	    Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(),"Vui lòng nhập mật khẩu" );
	    Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Vui lòng nhập lại mật khẩu" );
	    Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Vui lòng nhập số điện thoại." );
	    
		
		
	}
	@Test
	public void TC_02_Invalid_Email() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		///Action 
		
		driver.findElement(By.id("txtFirstname")).sendKeys("HuyLeDang");
		driver.findElement(By.id("txtEmail")).sendKeys("abc@da@");
		driver.findElement(By.id("txtCEmail")).sendKeys("abc@da@");
		driver.findElement(By.id("txtPassword")).sendKeys("123456789");
		driver.findElement(By.id("txtCPassword")).sendKeys("123456789");
		driver.findElement(By.id("txtPhone")).sendKeys("0936300491");
		
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		
		
		/// Verify
		
		 Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email" );
		 Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Vui lòng nhập lại địa chỉ email" );
		
		
	}
	
	
	@Test
	public void TC_03_Incorrect_Email() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		

		driver.findElement(By.id("txtFirstname")).sendKeys("HuyLeDang");
		driver.findElement(By.id("txtEmail")).sendKeys("ledanghuy@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("abc@da@");
		driver.findElement(By.id("txtPassword")).sendKeys("123456789");
		driver.findElement(By.id("txtCPassword")).sendKeys("123456789");
		driver.findElement(By.id("txtPhone")).sendKeys("0936300491");
		
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		
		
		/// Verify
		
		 Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Email nhập lại không đúng" );
	
	}
	@Test
	public void TC_04_Invalid_Password() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		driver.findElement(By.id("txtFirstname")).sendKeys("HuyLeDang");
		driver.findElement(By.id("txtEmail")).sendKeys("ledanghuy91@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("ledanghuy91@gmail.com");
		driver.findElement(By.id("txtPassword")).sendKeys("123");
		driver.findElement(By.id("txtCPassword")).sendKeys("123");
		driver.findElement(By.id("txtPhone")).sendKeys("0936300491");
		
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
	
		
		
		///Mật khẩu phải có ít nhất 6 ký tự
		
	    Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(),"Mật khẩu phải có ít nhất 6 ký tự" );
	    Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Mật khẩu phải có ít nhất 6 ký tự" );
	}
	
	
	
	@Test
	public void TC_05_Incorrect_Password() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		

		///Action
		driver.findElement(By.id("txtFirstname")).sendKeys("HuyLeDang");
		driver.findElement(By.id("txtEmail")).sendKeys("ledanghuy91@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("ledanghuy91@gmail.com");
		driver.findElement(By.id("txtPassword")).sendKeys("123455");
		driver.findElement(By.id("txtCPassword")).sendKeys("123456789");
		driver.findElement(By.id("txtPhone")).sendKeys("0936300491");
		
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		
		//Verify 
	
		
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Mật khẩu bạn nhập không khớp" );
		
	
	}
	
	
	@Test
	public void TC_06_Invalid_Phone() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		///Action
				driver.findElement(By.id("txtFirstname")).sendKeys("HuyLeDang");
				driver.findElement(By.id("txtEmail")).sendKeys("ledanghuy91@gmail.com");
				driver.findElement(By.id("txtCEmail")).sendKeys("ledanghuy91@gmail.com");
				driver.findElement(By.id("txtPassword")).sendKeys("123456789");
				driver.findElement(By.id("txtCPassword")).sendKeys("123456789");
				driver.findElement(By.id("txtPhone")).sendKeys("093630049");
				
				driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		
			
				
				
				 //Verify 1 (nhập số điện thoại dưới 10 số )
				Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại phải từ 10-11 số.");
				
				
				///Action 2:
				// nhập số điện thoại trên 11 số 
				driver.findElement(By.id("txtPhone")).clear();
				driver.findElement(By.id("txtPhone")).sendKeys("0936300491566");
				driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		        //Verify 2 (nhập số điện thoại trên 11 số )
				Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại phải từ 10-11 số.");
				
				
				///Action 3:
				/// nhập số điện thoại không đúng nhà mạng 
				driver.findElement(By.id("txtPhone")).clear();  
				driver.findElement(By.id("txtPhone")).sendKeys("936300491");
				driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
				
		        //Verify 3: 
				
				Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");
				
				
				
				// Nhập đúng số điện thoại 
				//driver.findElement(By.id("txtPhone")).clear();  
				//driver.findElement(By.id("txtPhone")).sendKeys("0936300491");
				//driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
				
				
	
	}
	
	
	@Test
	public void TC_07_Incorrect_Email() {
		///driver.get("https://alada.vn/tai-khoan/dang-ky.html");

	}
	
	@Test
	public void TC_08_() {
	
	}
	
	@Test
	public void TC_09_() {
	
	}
	
	@Test
	public void TC_10_() {
	
	}
	@Test
	public void TC_11_() {
	
	}
	
	@Test
	public void TC_12_() {
	
	}
	
	@Test
	public void TC_13_l() {
	
	}
	
	
	@Test
	public void TC_14_() {
	
	}
	
	
	public void TC_15_() {
	
	}
	
	//@AfterClass
	//public void afterClass() {
	///    driver.quit();
	//}
}
