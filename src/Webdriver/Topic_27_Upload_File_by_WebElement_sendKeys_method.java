package Webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_27_Upload_File_by_WebElement_sendKeys_method {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	JavascriptExecutor jsExecutor;
	
	String Fish_1_File_Name= "Fish_1.jpg";
	String Fish_2_File_Name="Fish_2.jpg";
	String Fish_3_File_Name="Fish_3.jpg";
	
	// Đường dẫn tương đối :
	String Fish_1_File_Path= projectPath + "\\Upload_File\\" + Fish_1_File_Name;
	String Fish_2_File_Path= projectPath + "\\Upload_File\\" + Fish_2_File_Name;
	String Fish_3_File_Path= projectPath + "\\Upload_File\\" + Fish_3_File_Name;
	
	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		jsExecutor = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
	}

	///@Test
	public void TC_01_One_File_Per_Time() {
		
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		//input [@type='file']
		
		///Load file lên:
		driver.findElement(By.cssSelector("input[type='file']")).sendKeys(Fish_1_File_Path);
		SleepInSecond(2);
		driver.findElement(By.cssSelector("input[type='file']")).sendKeys(Fish_2_File_Path);
		SleepInSecond(2);
		

		
		//Verify file up lên thành công 
		
		//p [@class='name' and text()='Fish_1.jpg']
		
		Assert.assertTrue(driver.findElement(By.xpath("//p [@class='name' and text()='"+ Fish_1_File_Name +"']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p [@class='name' and text()='"+ Fish_2_File_Name +"']")).isDisplayed());
		
		/// Clip upload ( từng nút upload của từng ảnh )
		
	   List<WebElement>  button_upload=driver.findElements(By.cssSelector("table button.start"));
	  for (WebElement button : button_upload) {
		button.click();
		SleepInSecond(3);
	}
	  
	  // Verify hình ảnh upload thành công (link)
	
	  Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ Fish_1_File_Name  +"']")).isDisplayed());
	  Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ Fish_2_File_Name  +"']")).isDisplayed());
		
	  
	  //Verify uploa thành công ( Image)
	  Assert.assertTrue(isImageLoaded("//img[contains(@src,'"+ Fish_1_File_Name +"')]"));
	  
	  Assert.assertTrue(isImageLoaded("//img[contains(@src,'"+ Fish_2_File_Name +"')]"));
		
		
		
		
	  
	}
	@Test
	public void TC_02_Multiple_File_Per_Time() {
		
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		//input [@type='file']
		
		///Load file lên:
		driver.findElement(By.cssSelector("input[type='file']")).sendKeys(Fish_1_File_Path + "\n" + Fish_2_File_Path + "\n" + Fish_3_File_Path );
		SleepInSecond(2);

		
		//Verify file up lên thành công 
		
		//p [@class='name' and text()='Fish_1.jpg']
		
		Assert.assertTrue(driver.findElement(By.xpath("//p [@class='name' and text()='"+ Fish_1_File_Name +"']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p [@class='name' and text()='"+ Fish_2_File_Name +"']")).isDisplayed());
		
		/// Clip upload ( từng nút upload của từng ảnh )
		
	   List<WebElement>  button_upload=driver.findElements(By.cssSelector("table button.start"));
	  for (WebElement button : button_upload) {
		button.click();
		SleepInSecond(3);
	}
	  
	  // Verify hình ảnh upload thành công (link)
	
	  Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ Fish_1_File_Name  +"']")).isDisplayed());
	  Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ Fish_2_File_Name  +"']")).isDisplayed());
		
	  
	  //Verify uploa thành công ( Image)
	  Assert.assertTrue(isImageLoaded("//img[contains(@src,'"+ Fish_1_File_Name +"')]"));
	  
	  Assert.assertTrue(isImageLoaded("//img[contains(@src,'"+ Fish_2_File_Name +"')]"));
		
	}
	
	@Test
	public void TC_03() {
	
	}
	
	public void SleepInSecond(long timeinSecond) {
		
		 try {
			 Thread.sleep(timeinSecond*1000);
			 //1000 ms =1s 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	}
	
	public boolean isImageLoaded(String locator) {
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
				getElement(locator));
		return status;
	}

	public WebElement getElement(String locator) {
		return driver.findElement(By.xpath(locator));
	}
	//@AfterClass
	///public void afterClass() {
	   // driver.quit();
	//}
}
