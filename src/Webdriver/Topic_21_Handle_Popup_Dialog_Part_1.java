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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_21_Handle_Popup_Dialog_Part_1 {
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		action= new Actions(driver);
		jsExcutor= (JavascriptExecutor) driver;
		epliciwait=new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	
  // @Test
	public void TC_01_Login_popup() {
		
		driver.get("https://ngoaingu24h.vn/");
		By LoginPOpup= By.cssSelector("div#modal-login-v1 div.modal-content");
		
		///Verify popup is undisplay
		
		
		Assert.assertFalse(driver.findElement(LoginPOpup).isDisplayed());
		
		
		///Click vao button login
		
		///driver.findElement(By.xpath("//button[@class='login_ icon-before']")).click();
		
		   driver.findElement(By.cssSelector("button.login_")).click();
		   
		   Assert.assertTrue(driver.findElement(LoginPOpup).isDisplayed());
		   
		   
		   
		 ///driver.findElement(By.cssSelector("input#account-input"));
		 ///input#password-input
		driver.findElement(By.xpath("//input[@id='account-input']")) .sendKeys("automationfc");
		driver.findElement(By.xpath("//input[@id='password-input']")) .sendKeys("automationfc");
		
		
		driver.findElement(By.cssSelector("button.btn-login-v1")).click();
		//div#modal-login-v1 div.error-login-panel
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div#modal-login-v1 div.error-login-panel")).getText(), "Tài khoản không tồn tại!");
		
		driver.findElement(By.cssSelector("div#modal-login-v1 button.close")).click();


	}
	@Test
	public void TC_02_Fixed_In_DOM() {
		

		driver.get("https://skills.kynaenglish.vn/");
		
	
				
		//div#k-popup-account-login-mb div.modal-content
		
		////div[@id='k-popup-account-login-mb']//div [@class='modal-content']
		By LOgin_popup= By.cssSelector("div#k-popup-account-login");
		
		
		Assert.assertFalse(driver.findElement(LOgin_popup).isDisplayed());
		
		
		driver.findElement(By.cssSelector("a.login-btn")).click();
		SleepInSecond(2);
		
		Assert.assertTrue(driver.findElement(LOgin_popup).isDisplayed());
		
		
		driver.findElement(By.cssSelector("input#user-login")).sendKeys("automation@gmail.com");
		driver.findElement(By.cssSelector("input#user-password")).sendKeys("123456");
		driver.findElement(By.cssSelector("button#btn-submit-login")).click();
		SleepInSecond(1);
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div#password-form-login-message")).getText(), "Sai tên đăng nhập hoặc mật khẩu");
		
		
		
		driver.findElement(By.cssSelector("button.k-popup-account-close")).click();
		SleepInSecond(1);
		
		
		Assert.assertFalse(driver.findElement(LOgin_popup).isDisplayed());
		

		
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





