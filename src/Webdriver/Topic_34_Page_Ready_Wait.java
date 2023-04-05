package Webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_34_Page_Ready_Wait {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	WebDriverWait explicitWait;
    
	JavascriptExecutor jsExecutor;
	
	Actions action;
	

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}
		driver = new FirefoxDriver();
		explicitWait= new WebDriverWait (driver, 30);
	}

	//@Test
	public void TC_01_Orange_API() {
		
		driver.get("https://api.orangehrm.com/");
	
		///Wait cho icon loading biến mất 
		// Vì khi cái icon loading biến mất thì trang sẽ load hết được dữ liệu
		
		
		
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='spinner']")));
		//explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#loader >div.spinner")));
		
		
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div#project h1")).getText(), "OrangeHRM REST API Documentation");
		

	  
	}
	//@Test
	public void TC_02_Admin_Nopcom() {
		driver.get("https://admin-demo.nopcommerce.com");
		
		//driver.findElement(By.cssSelector("input.email")).sendKeys("admin@yourstore.com");
	//	driver.findElement(By.cssSelector("input.password")).sendKeys("admin");
		
		driver.findElement(By.cssSelector("button.login-button")).click();
		
	    Assert.assertTrue(isPageLoadedSuccess());
		
		
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
		Assert.assertTrue(isPageLoadedSuccess());
		
		Assert.assertEquals(driver.getTitle(), "Your store. Login");
	
		
	}
	
	@Test
		public void TC_03_Auto_Blog_Test() {
		
		driver.get("https://blog.testproject.io/");
		
		
		
		///Hover chuột vào 1 element bất kỳ để page nó ready
		
		action = new Actions(driver);
		
		action.moveToElement(driver.findElement(By.cssSelector("h1.main-heading"))).perform();
		
		Assert.assertTrue(isPageLoadedSuccess());
		
		String keyword="Selenium";
		
		driver.findElement(By.cssSelector("section#search-2 input.search-field")).sendKeys(keyword);
		
		driver.findElement(By.cssSelector("section#search-2 span.glass")).click();
		
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='main-heading' and text()='Search Results']")));
		
		Assert.assertTrue(isPageLoadedSuccess());
		
		
		List<WebElement> postArticles= driver.findElements(By.cssSelector(".post-title>a"));
	 
		for (WebElement articles : postArticles) {
			Assert.assertTrue(articles.getText().contains(keyword));			
			
		}
		
 		
		
		
		
     }
	
	public boolean isPageLoadedSuccess() {
		 explicitWait = new WebDriverWait(driver, 30);
		 jsExecutor = (JavascriptExecutor) driver;
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};
		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}
	
	
	
	public boolean WaitforAjaxBusyLoadingInvisible()
	{
		return explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#ajaxBusy")));
		 
	}
	
	
	//@AfterClass
	///public void afterClass() {
	   // driver.quit();
	//}
}
