package Webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Web_Browser_Exce {
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
		driver.manage().window().maximize();
		
	}

	@Test
	public void TC_01_URL() {
		driver.get("http://live.techpanda.org/");
		// xpath
	    driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
	    
	    // css
	   //driver.findElement(By.cssSelector("div[class='footer'] a[title='My Account']")).click();
	    
	    SleepInSecond(3);
	    ///driver.getCurrentUrl();
	    
	    Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");
	    
	    ///click vào Create an account
	    
	    //xpath
	    
	    driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
	    // css
	   // driver.findElement(By.cssSelector("a[title='Create an Account']")).click();
	    
	    SleepInSecond(3);
	    Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/create/");
	  
		

	}

	@Test
	public void TC_02_Title() {
		
		driver.get("http://live.techpanda.org/");
		
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();	
		SleepInSecond(3);
        Assert.assertEquals(driver.getTitle(), "Customer Login");	
        
        
        //Click vao Create An Account
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        SleepInSecond(3);
        Assert.assertEquals(driver.getTitle(), "Create New Customer Account");

		
	}

	@Test
	public void TC_03_Navigate() {
		driver.get("http://live.techpanda.org/");
		
		//Click vao My Account 
		
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();	
		SleepInSecond(3);
		
		// Click vao Create an Account 
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		SleepInSecond(3);
		 Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/create/");
		 
		
		 // Back Lai
		 
		 driver.navigate().back();
		 SleepInSecond(2);
		 Assert.assertEquals(driver.getTitle(), "Customer Login");	
		 
		 
		 //forward
		 driver.navigate().forward();
		 SleepInSecond(2);
		 Assert.assertEquals(driver.getTitle(), "Create New Customer Account");

	}
	
	@Test
	public void TC_04_Page_Source_HTML() {
		driver.get("http://live.techpanda.org/");
		
		
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();	
		SleepInSecond(3);
		
		//Verify page HMTL co chua chuoi~ mong muon
		Assert.assertTrue(driver.getPageSource().contains(" Login or Create an Account"));

		///Click vao Create an Account
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		 SleepInSecond(3);
		 
		 
		 // Verify  page HTML chua 1 chiuoi mong muon
		 Assert.assertTrue(driver.getPageSource().contains("Create an Account"));
		 
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
	  //  driver.quit();
	//}
}
