package Webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_31_ExplicitWait_Bai_Tap {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	WebDriverWait explicitWait;
	
	String Fish_1_File_Name= "Fish_1.jpg";
	String Fish_2_File_Name="A_1.jpg";
	String Fish_3_File_Name="A_2.jpg";
	
	// Đường dẫn tương đối :
	String Fish_1_File_Path= projectPath + "\\Upload_File\\" + Fish_1_File_Name;
	String Fish_2_File_Path= projectPath + "\\Upload_File\\" + Fish_2_File_Name;
	String Fish_3_File_Path= projectPath + "\\Upload_File\\" + Fish_3_File_Name;

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver_1.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver_1");
		}
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
	}

	//@Test
	public void TC_01_Select_Date_Ajax_Loading() {
	 
		
		 driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
		 
		 explicitWait = new WebDriverWait (driver, 30);
		 //wait cho cái date picker hiển thị

		 explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.RadCalendar'")));
		 
		 /// Verify cho Selected Date là No Selected Dates to display	 
		 Assert.assertEquals(driver.findElement(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1")).getText(), "No Selected Dates to display.");
		 
		 //wait cho ngày 20 được phép click
		 explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a [text()='20']")));
		 
		 /// Click vào ngày 20
		 driver.findElement(By.xpath("//a [text()='20']")).click();
		 
		 /// Wait cho Ajax icon loading biến mất ( invisible)
		 
		 explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[id*='RadCalendar1']>div.raDiv")));
		 
		 /// Wait cho ngày vừa được chọn  là được phép click 
		 
		 explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td [@class='rcSelected']/a[text()='20']")));
		 
		 
		 // Verify ngày được lựa chọn được hiển thị ra
		 
		 Assert.assertEquals(driver.findElement(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1")).getText(), "Monday, March 20, 2023");
	
	  
	}
	@Test
	public void TC_02_Select_Date_Ajax_Loading() {
		 
		
		 driver.get("https://gofile.io/welcome");
		explicitWait = new WebDriverWait (driver, 30);
		 
		 /// Verify cho trang hiển thị :
		 
		 explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-secondary btn-lg']")));
		 
		//wait cho nut được phép click
		 explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-secondary btn-lg']")));
		 
		 /// Click vao button
		 driver.findElement(By.xpath("//button[@class='btn btn-secondary btn-lg']")).click();
		 
		//div [@role='alert']
		 
		 /// wait cho trang tiep theo hien thi len
		 
		 explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']"))).isDisplayed();
		 
		/// Verrify trang upload file hien thi len
		 Assert.assertTrue(driver.findElement(By.xpath("//div[@role='alert']")).isDisplayed());
		 
		 
		 /// Wait cho den khi button duoc hien thi ra:
		// explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#filesUpload button.filesUploadButton")));
		 
		 
		 /// upload 1 file 
		 
		// driver.findElement(By.cssSelector("input[type='file']")).sendKeys(Fish_1_File_Path);
		 
		 /// upload nhieu file 
		 driver.findElement(By.cssSelector("input[type='file']")).sendKeys(Fish_1_File_Path + "\n" + Fish_2_File_Path + "\n" + Fish_3_File_Path );
		 
		 /// wait cho cac cai loading icon cua tung file bien mat
		 explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy
				 (By.xpath("//div[@class='col mainUploadFilesListDetails']//div [@class='progress position-relative mt-1']")));
		 
		 
		///wait cho message upload thanh cong duoc hien thi ra
		 
		//div[@class='col-auto text-center']//div[text()='Your files have been successfully uploaded']
		 
		 explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='col-auto text-center']//div[text()='Your files have been successfully uploaded']")));
		 
		 ///Verify message hien thi
		 
		 
		 Assert.assertTrue(driver.findElement(By.xpath("//div[@class='col-auto text-center']//div[text()='Your files have been successfully uploaded']")).isDisplayed());

		 
		 driver.findElement(By.xpath("//div[@class='col-6 text-center']/a[@class='ajaxLink']")).click();
		 
		 
		 //wait loading icon chuyển trang 
		 
		 //div#filesLoading>div.col-auto div.spinner-border
		 
		 explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#filesLoading>div.col-auto div.spinner-border")));
		 
		
		
		 
		 //Wait cho file name voi button download/hiển thị

		 Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='A_1.jpg']/parent::a/parent::div/following-sibling::div//button[@class='btn btn-outline-secondary btn-sm p-1 text-white']"))).isDisplayed());
		 Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='A_2.jpg']/parent::a/parent::div/following-sibling::div//button[@class='btn btn-outline-secondary btn-sm p-1 text-white']"))).isDisplayed());
		 Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Fish_1.jpg']/parent::a/parent::div/following-sibling::div//button[@class='btn btn-outline-secondary btn-sm p-1 text-white']"))).isDisplayed());
		 
		//span[text()='A_1.jpg']/parent::a/parent::div/following-sibling::div//button[contains(@class, 'filesContentOptionPlay')]
		 
		 Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='A_1.jpg']/parent::a/parent::div/following-sibling::div//button[contains(@class, 'filesContentOptionPlay')]"))).isDisplayed());
		 Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='A_2.jpg']/parent::a/parent::div/following-sibling::div//button[contains(@class, 'filesContentOptionPlay')]"))).isDisplayed());
		 Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Fish_1.jpg']/parent::a/parent::div/following-sibling::div//button[contains(@class, 'filesContentOptionPlay')]"))).isDisplayed());
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 

	
	  
	}
	

		 
	//}
	//@AfterClass
	///public void afterClass() {
	   // driver.quit();
	//}
}
