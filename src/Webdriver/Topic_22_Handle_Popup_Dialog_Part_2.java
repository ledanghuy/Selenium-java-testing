package Webdriver;

import static org.testng.Assert.assertEquals;
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
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_22_Handle_Popup_Dialog_Part_2 {
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
		
		FirefoxOptions optionns= new FirefoxOptions();
		optionns.setProfile(new FirefoxProfile());
		optionns.addPreference("dom.webnotifications.enabled", false);
		
		
		driver= new FirefoxDriver(optionns);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		action= new Actions(driver);
		jsExcutor= (JavascriptExecutor) driver;
		epliciwait=new WebDriverWait(driver, 5);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	
  // @Test
	public void TC_01_Login_popup_Not_In_DOM() {
		
		driver.get("https://tiki.vn/");
		
		By loginpopup= By.cssSelector("div.ReactModal_Content");
		//Verify không có popuplogin hiển thị
		Assert.assertEquals(driver.findElements(loginpopup).size(), 0);
		
		
		// Click để bật popup lên 
		// div[data-view-id*='header_account']
		driver.findElement(By.xpath("//span[text()='Tài khoản']")).click();
		SleepInSecond(2);
		
		
		///verify hiển thị sau khi button click 
		   // 
		  // Assert.assertEquals(driver.findElements(loginpopup).size(), 1);
		  ///Assert.assertTrue(driver.findElement(loginpopup).isDisplayed());
		
		
	
	
		
		
		
		
		//div#modal-login-v1 div.modal-content
		By LOginpopup= By.xpath("//div [@class='styles__Root-sc-2hr4xa-0 jyAQAr']");
		
		Assert.assertTrue(driver.findElement(LOginpopup).isDisplayed());
		
		driver.findElement(By.cssSelector("p.login-with-email")).click();
		
		SleepInSecond(3);
		
		Assert.assertTrue(driver.findElement(LOginpopup).isDisplayed());
		
	
		//button[text()='Đăng nhập']
		
		driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
		//Cách 1 : 
		//Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Email không được để trống']")).getText(), "Email không được để trống");
		
		//Assert.assertEquals(driver.findElement(By.xpath("//span[text()='Mật khẩu không được để trống']")).getText(), "Mật khẩu không được để trống");
		
		
		// Cách 2: 
		Assert.assertTrue(driver.findElement(By.xpath("//span[@class='error-mess' and text()= 'Email không được để trống']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//span[@class='error-mess' and text()= 'Mật khẩu không được để trống']")).isDisplayed());
		
		
		driver.findElement(By.cssSelector("button.btn-close")).click();
		SleepInSecond(3);
		
		
		//Assert.assertFalse(driver.findElement(LOginpopup).isDisplayed());
		


	}
	@Test
	public void TC_02_TC_01_Login_popup_Not_In_DOM_Facebook() {
		
		driver.get("https://www.facebook.com/");
		
		
		By createAccountPOpup= By.xpath("//div[text()='Sign Up']/parent::div/parent::div");
		
		//Verify popup không hiển thị:
		
		Assert.assertEquals(driver.findElements(createAccountPOpup).size(), 0);
		
		
		driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();
		//driver.findElement(By.xpath("//a [text()='Create new account']")).click();
		SleepInSecond(2);
		
		
		///Verify sau khi click hiển thị lên :
		Assert.assertEquals(driver.findElements(createAccountPOpup).size(),1);
		
		
		driver.findElement(By.name("lastname")) .sendKeys("ABC");
		driver.findElement(By.name("firstname")) .sendKeys("DDHDHD");
		driver.findElement(By.name("reg_email__")).sendKeys("34343232");
		driver.findElement(By.name("reg_passwd__")).sendKeys("43243254353");
		
		new Select(driver.findElement(By.id("day"))).selectByVisibleText("10");
		new Select(driver.findElement(By.id("month"))).selectByVisibleText("Aug");
		new Select(driver.findElement(By.id("year"))).selectByVisibleText("1999");
		
		driver.findElement(By.xpath("//label[text()='Custom']/following-sibling::input")).click();

		
		if (driver.findElement(By.xpath("//label[text()='Custom']/following-sibling::input")).isSelected())
		{
			Assert.assertTrue(driver.findElement(By.xpath("//select[@name='preferred_pronoun']")).isDisplayed() );
			
			new Select(driver.findElement(By.xpath("//select[@name='preferred_pronoun']"))).selectByVisibleText("They: \"Wish them a happy birthday!\"");
			
		}
		SleepInSecond(2);
	
		
		driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/preceding-sibling::img")).click();
		SleepInSecond(2);
		
		
		Assert.assertEquals(driver.findElements(createAccountPOpup).size(), 0);
		
		
		
		
		
		
		
		

		
		

		
	}
	
	//@Test
	public void TC_03_Hover_to_Element_menu_2() {
     


    }
	
	//@Test
	public void TC_04_Drag_and_Drop_HTML4() {
	
  
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





