package Webdriver;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_17_Handle_Alert_Authentication_Alert {
	WebDriver driver;
	JavascriptExecutor jsExcutor;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	Alert alert;
	WebDriverWait epliciwait;
	

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}
		driver = new FirefoxDriver();
		jsExcutor= (JavascriptExecutor) driver;
		epliciwait=new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}


	
	//@Test
	public void TC_01_Accept_Alert() {
		
		driver.get("https://automationfc.github.io/basic-form/index.html");
		//input [value='Spring']
		SleepInSecond(3);
		
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		SleepInSecond(1);
		
		
		/// Cacsh1 : Có thể switch qua và tương tác luôn
		
		alert= driver.switchTo().alert();
		
		
		
		
		/// Cách 2: Cần wait trước khi nó xuất hiện thì mới switch qua và tương tác >>> Nên dùng 
	  alert=epliciwait.until(ExpectedConditions.alertIsPresent());
	  //Verify alert 

	  
	  alert.getText();
	  
	 
        Assert.assertEquals(alert.getText(),"I am a JS Alert");
	
        
        alert.accept();
		
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id ='result']")).getText(), "You clicked an alert successfully");

	}
	//@Test
	public void TC_02_Confirm_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		SleepInSecond(3);
		
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		SleepInSecond(1);
	    alert=epliciwait.until(ExpectedConditions.alertIsPresent());
	    alert.dismiss();
	    //You clicked: Cancel
	    
	    Assert.assertEquals(driver.findElement(By.xpath("//p[@id ='result']")).getText(), "You clicked: Cancel");
		
	}
	
//	@Test
	public void TC_03_Prompt_Alert() {
       driver.get("https://automationfc.github.io/basic-form/index.html");
       driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		SleepInSecond(1);
		

	    alert=epliciwait.until(ExpectedConditions.alertIsPresent());
	    
	    Assert.assertEquals(alert.getText(), "I am a JS prompt");
	    
	    String s_name= "Lê Đăng Huy";
	    
	    alert.sendKeys(s_name);
	    SleepInSecond(2);
	    alert.accept();
	    SleepInSecond(1);
	   
	    
	    Assert.assertEquals(driver.findElement(By.xpath("//p[@id ='result']")).getText(), "You entered: " + s_name);
	
		
    }
	
	@Test
	public void TC_04_Authentication_Alert() {

		driver.get(UsernameandPassword("http://the-internet.herokuapp.com/basic_auth", "admin", "admin"));
		
	
		
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.']")).isDisplayed());
		
		
		
		  
		
	}
	
	public String UsernameandPassword (String url, String username, String password)
	{
		
		String [] arrayurl = url.split("//");
		
		return arrayurl[0] + "//" + username +":"+ password + "@" + arrayurl[1];
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





