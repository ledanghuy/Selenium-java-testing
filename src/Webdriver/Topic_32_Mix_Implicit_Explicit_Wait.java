package Webdriver;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_32_Mix_Implicit_Explicit_Wait {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	WebDriverWait expicitWait;
	JavascriptExecutor jsExcutor;

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}
		driver = new FirefoxDriver();
		//expicitWait = new WebDriverWait (driver,15);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//jsExcutor = (JavascriptExecutor) driver;
	}

	//@Test
	public void TC_01_Element_Found() {
		///Element có xuất hiện và không cần chờ hết timeout
	
		/// Dù set cả 2 loại wait thì không ảnh hưởng 
		expicitWait = new WebDriverWait (driver,15);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Implicit Wait : Chỉ apply cho việc findElement/ findElements 
		
		
		// Explicit Wait: Cho các điều kiện của element 
		
		
		driver.get("https://www.facebook.com/");

        //Explicit
		System.out.println("Thời gian bắt đầu của explicit" +getTimeStamp());
		
		expicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email")));
		
		System.out.println("Thời gian kết thúc của explicit" +getTimeStamp());
		
		//Implicit
		
		System.out.println("Thời gian bắt đầu của Implicit" +getTimeStamp());
		
		driver.findElement(By.cssSelector("input#email"));
		
		System.out.println("Thời gian kết thúc của Implicit" +getTimeStamp());
		
	  
	}

	//@Test
	public void TC_02_Element_Not_Found_Implicit() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		
         System.out.println("Thời gian bắt đầu của Implicit" +getTimeStamp());
		
		try {
			driver.findElement(By.cssSelector("input#selenium"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Thời gian kết thúc của Implicit" +getTimeStamp());
		}
		
		
		
		
		//output
		/// không tìm thấy element -- nửa giây tìm 1 lần thì 10s tìm tổng là 20 lần
		/// Có cơ chế tìm lại sau mỗi nửa giây (0.5s)
		// Khi hết timeout sẽ đánh fail testcase này
		// Throw ra 1 exception: NoSuchElement
		
		
	}
	
	
//	@Test
	public void TC_03_Element_Not_Found_Implicit_Explicit() {
		
		/// Case 1 :  Set time out  2 thằng bằng nhau : Implicit = Explicit
		/// Case 2: Implicit < Explicit
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		expicitWait = new WebDriverWait (driver,5);
		driver.get("https://www.facebook.com/");
		
		
		
		/// Implicit 
		System.out.println("Thời gian bắt đầu  của Implicit" + getTimeStamp());
		try {
			driver.findElement(By.cssSelector("input#selenium"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Thời gian kết thúc của Implicit" + getTimeStamp());
		}
		
		///explicit
		
	   System.out.println("Thời gian bắt đầu của explicit" +getTimeStamp());
		
		try {
			expicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#selenium")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Thời gian kết thúc của explicit" +getTimeStamp());
		}
		
		
		
		
		
	}
	//@Test
	public void TC_04_Element_Not_Found_ExplicitBy() {
 
		
           ////Case 2: Implicit ( Mặc định =0 ) < Explicit 
		
		expicitWait = new WebDriverWait (driver,5);
		driver.get("https://www.facebook.com/");

		///Explicit - by là tham số nhận vào của hàm  explicit visibilityOfElementLocated (By)
		///Implicit=0;
		//Tồng time = Explicit
	   System.out.println("Thời gian bắt đầu của explicit" +getTimeStamp());
		
		try {
			expicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#selenium")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Thời gian kết thúc của explicit" +getTimeStamp());
		}

		
	}
	
	
	//@Test
	public void TC_05_Element_Not_Found_Explicit_Element() {
 
		
           ////Case 2: Implicit ( Mặc định =0 ) < Explicit 
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		expicitWait = new WebDriverWait (driver,5);
		driver.get("https://www.facebook.com/");

		
	   System.out.println("Thời gian bắt đầu của explicit" +getTimeStamp());
		
		try {
			expicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#selenium"))));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Thời gian kết thúc của explicit" +getTimeStamp());
		}

		
	}
	
	@Test
	public void TC_06_Real() {
 
		
		expicitWait = new WebDriverWait (driver,15);
		driver.get("https://www.facebook.com/");
		
		///Wait
	    expicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("email"))));
	    
	    
	    //Action
	    driver.findElement(By.cssSelector("input#email")).sendKeys("");
		
	}
	
	
	
	
	public String getTimeStamp()
	{
		Date date= new Date ();
		return date.toString();
	}
	//@AfterClass
	///public void afterClass() {
	   // driver.quit();
	//}
}
