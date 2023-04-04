package Webdriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.NewSessionPayload;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class Topic_33_FluentWait {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	
	WebDriverWait expicitWait;
	JavascriptExecutor jsExcutor;
	
	long AllTime=15; // second
	
	long pollingTime=100; // mili second
	
	
	FluentWait<WebDriver> fluentDriver;
	

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}
		driver = new FirefoxDriver();

	}

	@Test
	public void TC_01() {
		
		driver.get("https://automationfc.github.io/dynamic-loading/");
	
		FindElement("//div[@id='start']/button").click();
		
		Assert.assertEquals(FindElement ("//div[@id='finish']/h4").getText(), "Hello World!");

	}
	public WebElement FindElement (String xpathLocator)
	{
       fluentDriver = new FluentWait<WebDriver>(driver);
		
		
		//Set toongr thowfi gian và tần số 
		fluentDriver.withTimeout(Duration.ofSeconds(AllTime))
		
		// 1/3 giay check 1 lần
		.pollingEvery(Duration.ofMillis(pollingTime))
		.ignoring(NoSuchElementException.class);
		//div button
		
		///apply điều kiện
		
		return	fluentDriver.until(new Function<WebDriver, WebElement>() {
			 
			
			public WebElement apply (WebDriver driver)
			{ 
				return driver.findElement(By.xpath(xpathLocator));
				
			}
			
		});
		
	}
	
	
	@Test
	public void TC_02_Fluent() {
		driver.get("https://automationfc.github.io/fluent-wait/");
		
	}
	
	@Test
	public void TC_03() {
	
	}
	//@AfterClass
	///public void afterClass() {
	   // driver.quit();
	//}
}
