package Webdriver;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_16_Handle_Button_Custom_Checkbox_and_Radio {
	WebDriver driver;
	JavascriptExecutor jsExcutor;
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
		jsExcutor= (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}


	
	//@Test
	public void TC_01_Default() {
		
		driver.get("https://tiemchungcovid19.gov.vn/portal/register-person");
		//input [value='Spring']
		SleepInSecond(5);
		
		
		///Case 1: Thẻ input bị che nên ko thao tác được nhưng thẻ input lại dùng để verify được >> vì thẻ isSleledted chỉ làm việc với thẻ input
		driver.findElement(By.xpath("//div [text()='Đăng ký cho người thân']/preceding-sibling::div/input")).click();
		
		//verify
		
		Assert.assertTrue(driver.findElement(By.xpath("//div [text()='Đăng ký cho người thân']/preceding-sibling::div/input")).isSelected());
		

	}
	//@Test
	public void TC_02_Default_Checkbox_Radio() {
		driver.get("https://tiemchungcovid19.gov.vn/portal/register-person");
		//input [value='Spring']
		SleepInSecond(5);
		
		
		///Case 2: Thẻ khác với input để click ( span/ div/ label) >>> đang hiển thị là được
		// Thẻ này lại không verify được >> vì hàm isSelected chỉ work với thẻ input
		
		
		//driver.findElement(By.xpath("//div [text()='Đăng ký cho người thân']/preceding-sibling::div/div[@class='mat-radio-outer-circle']")).click();
		driver.findElement(By.xpath("//div [text()='Đăng ký cho người thân']/parent::label")).click();
		SleepInSecond(3);
		//verify
		
		Assert.assertTrue(driver.findElement(By.xpath("//div [text()='Đăng ký cho người thân']/preceding-sibling::div/div[@class='mat-radio-outer-circle']")).isSelected());
		/// các thẻ ( span/ div/ label) >> luôn luôn trả về fale 
	}
	
	//@Test
	public void TC_03_Default_Checkbox_Radio_Work() {
	
		driver.get("https://tiemchungcovid19.gov.vn/portal/register-person");
		
		SleepInSecond(5);
		

		driver.findElement(By.xpath("//div [text()='Đăng ký cho người thân']/parent::label")).click();
		SleepInSecond(3);
	
		
		Assert.assertTrue(driver.findElement(By.xpath("//div [text()='Đăng ký cho người thân']/preceding-sibling::div/input")).isSelected());
	
		
    }
	
	//@Test
	public void TC_04_TC_Default_Checkbox_Radio_Multiple_Select_1_Request() {

		driver.get("https://tiemchungcovid19.gov.vn/portal/register-person");
		SleepInSecond(5);
		
		//Case 4: Thẻ input bị ẩn nhưng vẫn dùng để click	
		//Hàm click () của webelemtn nó sẽ không thao tác vào elemtn bị ẩn được
		/// 
		/// Nên sẽ dùng 1 hàm click của javascrip để click  ( click vào element bị ẩn được )
		/// Thẻ input lại dùng để verify được >> vì hàm isSeleleted () nó chỉ work với thẻ input
		
		
		/// selenium có thư viện để nhúng đoạn code JS vào kcihj bản test >>> JavascriptExcutor
		
		By radiobutton= By.xpath("//div [text()='Đăng ký cho người thân']/preceding-sibling::div/input");
		
		
		jsExcutor.executeScript("arguments[0].click();", driver.findElement(radiobutton));
		SleepInSecond(3);
		
		Assert.assertTrue(driver.findElement(By.xpath("//div [text()='Đăng ký cho người thân']/preceding-sibling::div/input")).isSelected());
		
		
	}
	
	@Test
	public void TC_05_() {
		
		
		driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");
		SleepInSecond(3);
		
		
       By radiobutton= By.cssSelector("div[aria-label='Hà Nội']");
       By checkbox_button= By.cssSelector("div[aria-label='Quảng Ngãi']");
		
		
		jsExcutor.executeScript("arguments[0].click();", driver.findElement(radiobutton));
		SleepInSecond(3);
		jsExcutor.executeScript("arguments[0].click();", driver.findElement(checkbox_button));
		SleepInSecond(3);
		
		/// Cách 1 :
		Assert.assertTrue(driver.findElement(By.cssSelector("div[aria-label='Quảng Ngãi'][aria-checked=\"true\"]")).isDisplayed());
		
		Assert.assertTrue(driver.findElement(By.cssSelector("div[aria-label='Hà Nội'][aria-checked=\"true\"]")).isDisplayed());
		
		//Cách 2: 
		
		Assert.assertEquals(driver.findElement(radiobutton).getAttribute("aria-checked"),"true" );
		Assert.assertEquals(driver.findElement(checkbox_button).getAttribute("aria-checked"),"true" );
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





