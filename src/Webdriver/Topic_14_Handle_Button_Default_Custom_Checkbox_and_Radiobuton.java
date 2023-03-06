package Webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
	@Test
	public void TC_02_Default_Checkbox_Radio() {
		driver.get("https://automationfc.github.io/multiple-fields/");
	}
	
	
	//@Test
	public void TC_03_Name() {

	}
	
	//@Test
	public void TC_04_TagName() {
		
	}
	
	//@Test
	public void TC_05_LinkText() {

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





