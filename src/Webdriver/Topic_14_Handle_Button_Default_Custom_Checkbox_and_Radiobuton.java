package Webdriver;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_14_Handle_Button_Default_Custom_Checkbox_and_Radiobuton {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	By Login_button=By.cssSelector("button.fhs-btn-login");

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
	}


	
	//@Test
	public void TC_01_Default() {
		
		driver.get("https://www.fahasa.com/customer/account/create");
		driver.findElement(By.cssSelector("li.popup-login-tab-item")).click();
		
		
		// Verify login button is disabled
		Assert.assertFalse(driver.findElement(Login_button).isEnabled());
		

		
	String color_loginbutton= driver.findElement(Login_button).getCssValue("background-image");
	Assert.assertTrue(color_loginbutton.contains("rgb(224, 224, 224)"));
		
	//Color Loginbutton= Color.fromString(color_loginbutton);
	//Assert.assertEquals(Loginbutton.asHex().toUpperCase(), "#C92127");
	
	driver.findElement(By.id("login_username")).sendKeys("0936300491");
	driver.findElement(By.id("login_password")).sendKeys("0936300491");
	SleepInSecond(2);
		
	}
	///@Test
	public void TC_02_Default_Checkbox_Radio() {
		driver.get("https://automationfc.github.io/multiple-fields/");
		
		//click Chọn 1 checkbox 
		
		
		driver.findElement(By.xpath("//label[contains(text(),'Digestive Problems')]/preceding-sibling::input")).click();
		
		
		///click chonj 1 radio
		
		driver.findElement(By.xpath("//label[contains(text(),\"I don't drink\")]/preceding-sibling::input")).click();
		
		
		///verify cac checkbox va raido da chon
		
		
		assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Digestive Problems')]/preceding-sibling::input")).isSelected());
		assertTrue(driver.findElement(By.xpath("//label[contains(text(),\"I don't drink\")]/preceding-sibling::input")).isSelected());
		
		// Check box co the bo cho nhung radio thi khong the tu bo chon duoc 
		
		driver.findElement(By.xpath("//label[contains(text(),'Digestive Problems')]/preceding-sibling::input")).click();
		
		//Verify bỏ chọn checkbox
		
		assertFalse(driver.findElement(By.xpath("//label[contains(text(),'Digestive Problems')]/preceding-sibling::input")).isSelected());
		
	}
	
	//@Test
	public void TC_03_Default_Checkbox_Radio_Multiple() {
		
		driver.get("https://automationfc.github.io/multiple-fields/");
	List<WebElement> list_checkbox =driver.findElements(By.cssSelector("input.form-checkbox"));
	
	///dùng vòng lặp để duyệt qua và click vào check box
	
	for (WebElement item_checkbox : list_checkbox) {
		
		item_checkbox.click();
		//SleepInSecond(1);
		System.out.println("Đã lựa chọn");
	
	}
	
	/// Verify tatass cả các checkbox được chọn thành công
	for (WebElement check_box : list_checkbox) {
		
		Assert.assertTrue(check_box.isSelected());
		
	}
		
}
	
	//@Test
	public void TC_04_TC_Default_Checkbox_Radio_Multiple_Select_1_Request() {
		// Chạy hết cả list checkbox nhưng chỉ select 1 cái theo yêu cầu 
		driver.get("https://automationfc.github.io/multiple-fields/");
		List<WebElement> list_checkbox =driver.findElements(By.cssSelector("input.form-checkbox"));
		
		for (WebElement item_checkbox : list_checkbox) {
			
			if (item_checkbox.getAttribute("value").equals("Sleep Apnea"))
				
				item_checkbox.click();
			//SleepInSecond(1);
			System.out.println(item_checkbox.isSelected());
			//System.out.println( "Đã chọn");
		}
		
		
	//	for (WebElement check_box : list_checkbox) {
		
			//Assert.assertTrue(check_box.isSelected());
			
		//}
		
		
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





