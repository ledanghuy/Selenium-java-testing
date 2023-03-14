package Webdriver;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_15_Exercise_Handle_Button_Default_Custom_Checkbox_and_Radiobuton {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	By Login_button=By.cssSelector("button.fhs-btn-login");

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver_1.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver_1");
		}
			
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
	}


	
	//@Test
	public void TC_01_Default_Checkbox_or_Radio_button() {
		
		driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
		
		SleepInSecond(10);
		
		//Kieerm tra truoc khi chon

		if(!driver.findElement(By.xpath("//label[contains(text(),'Dual-zone air conditioning')]/preceding-sibling::input")).isDisplayed())
		{
			driver.findElement(By.xpath("//label[contains(text(),'Dual-zone air conditioning')]/preceding-sibling::input")).click();
			
		}
		
		
		
		
		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Dual-zone air conditioning')]/preceding-sibling::input")).isSelected());
		System.out.println ("Đã lựa chọn");
		
		
		if(driver.findElement(By.xpath("//label[contains(text(),'Dual-zone air conditioning')]/preceding-sibling::input")).isDisplayed())
		{
			driver.findElement(By.xpath("//label[contains(text(),'Dual-zone air conditioning')]/preceding-sibling::input")).click();
			
		}
		
		
		
		Assert.assertFalse(driver.findElement(By.xpath("//label[contains(text(),'Dual-zone air conditioning')]/preceding-sibling::input")).isSelected());
	 
		System.out.println ("Đã bỏ chọn ");
		

		
	   
		
		
	}
	@Test
	public void TC_02_Default_Checkbox_Radio() {
		
		driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
		SleepInSecond(10);
		
		
		
		
		
		
		if (!driver.findElement(By.xpath("//label[contains(text(),'2.0 Petrol, 147kW')]/preceding-sibling::input")).isSelected())
		{
			driver.findElement(By.xpath("//label[contains(text(),'2.0 Petrol, 147kW')]/preceding-sibling::input")).click();
		}
		
		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'2.0 Petrol, 147kW')]/preceding-sibling::input")).isSelected());
		
	//	if (driver.findElement(By.xpath("//label[contains(text(),'2.0 Petrol, 147kW')]/preceding-sibling::input")).isSelected())
		//{
		///	driver.findElement(By.xpath("//label[contains(text(),'2.0 Petrol, 147kW')]/preceding-sibling::input")).click();
	///	}
		
		//Assert.assertFalse(driver.findElement(By.xpath("//label[contains(text(),'2.0 Petrol, 147kW')]/preceding-sibling::input")).isSelected());
		
		
	}
	
	public void CheckToCheckbox()
	{
		
	}
	//@Test
	public void TC_03_Default_Checkbox_Radio_Multiple() {
		
		
		
}
	
	//@Test
	public void TC_04_TC_Default_Checkbox_Radio_Multiple_Select_1_Request() {
	
		
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





