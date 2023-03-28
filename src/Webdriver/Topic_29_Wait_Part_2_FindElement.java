package Webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_29_Wait_Part_2_FindElement {
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
		/// đang apply 30s cho việc tìm element
		
		//driver.get("http://live.techpanda.org/index.php/customer/account/login/");
		
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
	}

	//@Test
	public void TC_01_FindElement() {
	   /// Tìm thấy duy nhất 1 element/node
		/// Tìm thấy và thao tác trực tiếp lên node đó
		/// Vì nó tìm thấy nên không cần phải chờ hết timeout 30s
		driver.findElement(By.cssSelector("input#email"));
		
		
		
		///Tìm thấy nhiều hơn 1 element/node
		// Nó sẽ thao tác với node đầu tiên
		//Không quan tâm các node còn lại
		// Trong trường hợp các bạn bắt cái locator sai thì nó tìm sai 
		driver.findElement(By.cssSelector("input[type='email']")).sendKeys("abc@gmail.com");
		
		
		
		/// Không tìm thấy element/node nào
		/// Có cơ chế tìm lại = nửa giây ( 0.5s) sẽ tìm lại 1 lần
		/// Nếu trong thời gian đang tìm lại mà thấy element thì thỏa mãn điều kiện- Pass
		/// Nếu hết thời gian 30s mà ko tìm thấy element thì sẽ có 2 cái :
		   ///1. đánh fail testcase này tại step này + khoog chạy step tiếp theo 
	       ///2  Throw  ra 1 ngoại lệ : No Such ElementException
		driver.findElement(By.cssSelector("input[type='check']"));
		
		
	
	  
	}
	//@Test
	public void TC_02FindElements() {
		 /// Tìm thấy duy nhất 1 element/node
		// Tìm  thấy và lưu nó vào list= 1 element
		/// Vì nó tìm thấy nên không cần phải chờ hết timeout 30s
		
		List<WebElement> elements= driver.findElements(By.cssSelector("input#email"));
		System.out.println("List eleemnt number = " + elements.size());
		
		
		
		///Tìm thấy nhiều hơn 1 element/node
		//Tìm  thấy và lưu nó vào list= element tương ứng
		elements=driver.findElements(By.cssSelector("input[type='email']"));
		System.out.println("List eleemnt number = " + elements.size());
		
		/// Không tìm thấy element/node nào
		/// Có cơ chế tìm lại = nửa giây ( 0.5s) sẽ tìm lại 1 lần
		/// Nếu trong thời gian đang tìm lại mà thấy element thì thỏa mãn điều kiện- Pass
		/// Nếu hết thời gian 30s mà ko tìm thấy element thì
		/// + Không đánh fail testcase + vẫn chạy step tiếp theo
		/// + Trả về 1 list rỗng ( empty)=0
		elements=driver.findElements(By.cssSelector("input[type='check']"));
		System.out.println("List eleemnt number = " + elements.size());
	}
	
	
	@Test
	public void TC_03() {
		
		
		

		
	}
	//@AfterClass
	///public void afterClass() {
	   // driver.quit();
	//}
}
