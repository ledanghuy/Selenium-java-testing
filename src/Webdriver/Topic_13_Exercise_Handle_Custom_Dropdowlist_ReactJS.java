package Webdriver;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_13_Exercise_Handle_Custom_Dropdowlist_ReactJS {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	WebDriverWait Web_Driver_Wait;
	
	


	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
		}
			
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Web_Driver_Wait =new WebDriverWait(driver,30);
		driver.manage().window().maximize();
		
		
	}

	//@Test
	public void TC_01_ReactJS() {
		
	
		ReactJS ("//div [@role='listbox']","//span[@class='text']", "Matt" );
		SleepInSecond(5);
	    Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Matt" );
	    System.out.println("Xác nhận đúng thành phần lựa chọn");
		
		
	}
	
	//@Test
	public void TC_02_VueJS() {
		
	
		VueJS ("li.dropdown-toggle", "ul.dropdown-menu a", "Second Option");
	    SleepInSecond(3);
		                                                //ul.dropdown-menu>li>a
		
		Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "Second Option");
		
		System.out.println("Xác nhận đúng thành phần lựa chọn");
		
		

		
	}
	
	@Test
	public void TC_03_Enter_and_Selected_Item() {
		
		Enter_and_Selected_Item ("input.search", "span.text", "Belgium");
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Belgium");
		
		
		
		
	}
	//@Test
	public void TC_04() {
		
	
		
	}
	
	
	//@Test
	public void TC_05() {

		
	}


	
	public void SleepInSecond(long timeinSecond) {
		
		 try {
			 Thread.sleep(timeinSecond*1000);
			 //1000 ms =1s 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	}
	
	
	public void Enter_and_Selected_Item(String textbox_css, String All_item_css, String Text_item_css)
	{
		
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
		
		//driver.findElement(By.cssSelector("input.search")).click();
		
		driver.findElement(By.cssSelector(textbox_css)).sendKeys(Text_item_css);
		SleepInSecond(1);
		
		Web_Driver_Wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(All_item_css)));
		
		List<WebElement> list_Country= driver.findElements(By.cssSelector(All_item_css));
		
		for (WebElement web_Element : list_Country) {
			
			String a_b= web_Element.getText();
			System.out.println(a_b);
			
			if (a_b.equals(Text_item_css))
			{
				web_Element.click();
				System.out.println("Lua chon la " + a_b );
				break;
				
			}
			else
			{
				System.out.println("NOoooooooooooooooooooooooo");
			}
		}
		
		
	}
	
	public void VueJS(String parent_dropdown, String All_item_dropdown, String text_detal_item) 
	{
        driver.get("https://mikerodham.github.io/vue-dropdowns/");
		
		driver.findElement(By.cssSelector(parent_dropdown)).click();
		
		Web_Driver_Wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(All_item_dropdown)));
		
		List<WebElement> list_drop = driver.findElements(By.cssSelector(All_item_dropdown));
		
		for (WebElement item_vue : list_drop) {
			
			String detail_item=item_vue.getText();
			System.out.println(detail_item);
			
			if (detail_item.equals(text_detal_item))
			{
				
				
				item_vue.click();
				System.out.println("Lựa chon cái " + detail_item);
				break;
			}
			else
			{
				System.out.println("Không tìm thấy phần tử đó ");
			}
		}
		
	}
	
	public void ReactJS (String parent_dropdown, String All_item_Dropdown, String text_item  ) {
	
		
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
		
		driver.findElement(By.xpath(parent_dropdown)).click();
		
		//i.dropdown.icon
		
		
		Web_Driver_Wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(All_item_Dropdown)));

		
		List<WebElement> list_item_dropdown= driver.findElements(By.xpath(All_item_Dropdown));
		
		for (WebElement item_drop_down : list_item_dropdown) {
			
			String item_1= item_drop_down.getText();
			System.out.println(item_1);
			
			if (item_1.trim ().equals(text_item))
			{
				item_drop_down.click();
				System.out.println("Đã lựa chọn xong");
				break;
				
			}
			else
			{
				System.out.println("Không có lựa chọn phù hợp ");
				
			}
			
		}
	}
	
	public WebDriver getDriver() {
		return driver;
	}
}
