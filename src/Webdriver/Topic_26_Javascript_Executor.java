package Webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_26_Javascript_Executor {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	JavascriptExecutor jsExecutor;
	
	String EmailAddreess= "testdemo" +getRandomNumerb()+ "@gmail.com";
	Alert alert;
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
	}

	//@Test
	public void TC_01_Tech_Panda() {
		
		navigateToUrlByJS("http://live.techpanda.org/");
		SleepInSecond(5);
		Assert.assertEquals(executeForBrowser("return document.domain;"), "live.techpanda.org");
		
		Assert.assertEquals(executeForBrowser("return document.URL;"), "http://live.techpanda.org/");
		hightlightElement("//a[text()='Mobile']");
		clickToElementByJS("//a[text()='Mobile']");
		SleepInSecond(5);
		
		hightlightElement("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']/button");
		clickToElementByJS("//a[text()='Samsung Galaxy']/parent::h2/following-sibling::div[@class='actions']/button");
		SleepInSecond(3);
		
		//li [@class='success-msg']//span
		
		//Assert.assertTrue(getInnerText().contains("Samsung Galaxy was added to your shopping cart."));
		
		
		//a[text()='Customer Service']
		hightlightElement("//a[text()='Customer Service']");
		clickToElementByJS("//a[text()='Customer Service']");
		SleepInSecond(3);
		
		
	  hightlightElement("//input [@id='newsletter']");
	   scrollToElementOnDown("//input [@id='newsletter']");
	   SleepInSecond(4);
	
	   
	   sendkeyToElementByJS("//input [@id='newsletter']", EmailAddreess);
	   
	   hightlightElement(" //button[@title='Subscribe']");
	   clickToElementByJS("//button[@title='Subscribe']");
	   SleepInSecond(5);
	   
		Assert.assertTrue(getInnerText().contains("Thank you for your subscription."));
	   
		navigateToUrlByJS("https://demo.guru99.com/v4/");
		SleepInSecond(5);
		
       Assert.assertEquals(executeForBrowser("return document.domain;"), "demo.guru99.com");
		
		Assert.assertEquals(executeForBrowser("return document.URL;"), "https://demo.guru99.com/v4/");
		
	}
	
    public  int  getRandomNumerb() 
	
	{
	        	return new Random().nextInt(99999);
	}
	
	public String getDomainName()
	{
		return (String) jsExecutor.executeScript("return document.domain");
	}
	@Test
	public void TC_02_Register_HMTL_5_Validation_Message() {
		
		
			
		navigateToUrlByJS("https://warranty.rode.com/");
		SleepInSecond(5);
		String registerbutton="//button[contains(text(),'Register')]";
		String firstname="//input [@id='firstname']";
		String Surname= "//input [@id='surname']";
		String Email ="//div[contains(text(),'Register')]/following-sibling::div//input[@id='email']";
		String Password="//div[contains(text(),'Register')]/following-sibling::div//input[@id='password']";
		String Confirm_Password="//div[contains(text(),'Register')]/following-sibling::div//input[@id='password-confirm']";
		By  text_error_8_character=By.xpath("//div[contains(text(),'Register')]/following-sibling::div//span[@class='invalid-feedback']");
		
		// Lệnh lấy tin nhắn validation cho html 5: 
		/// var element=$x("//input[@id='firstname']")[0];  
		///element.validationMessage; 
		
		clickToElementByJS(registerbutton);
		SleepInSecond(3);
		Assert.assertEquals(getElementValidationMessage(firstname), "Please fill out this field.");
		sendkeyToElementByJS(firstname, "ABC");
		
		clickToElementByJS(registerbutton);
		SleepInSecond(3);
		Assert.assertEquals(getElementValidationMessage(Surname), "Please fill out this field.");
		sendkeyToElementByJS(Surname, "XaoRau");
		
		
		clickToElementByJS(registerbutton);
		SleepInSecond(3);
		Assert.assertEquals(getElementValidationMessage(Email), "Please fill out this field.");
		sendkeyToElementByJS(Email, "abcdsdsad");
		Assert.assertEquals(getElementValidationMessage(Email), "Please enter an email address.");
		sendkeyToElementByJS(Email, EmailAddreess);	
		
		
		clickToElementByJS(registerbutton);
		SleepInSecond(3);
		Assert.assertEquals(getElementValidationMessage(Password), "Please fill out this field.");
		sendkeyToElementByJS(Password, "1234546");
		
		clickToElementByJS(registerbutton);
		SleepInSecond(3);
		Assert.assertEquals(getElementValidationMessage(Confirm_Password), "Please fill out this field.");
		sendkeyToElementByJS(Confirm_Password, "455661");
		
		clickToElementByJS(registerbutton);
		SleepInSecond(3);
		Assert.assertEquals(driver.findElement(text_error_8_character).getText(),"Password must be 8 characters or more");
		
		sendkeyToElementByJS(Password, "123454678");
		Assert.assertEquals(getElementValidationMessage(Confirm_Password), "Please fill out this field.");
		sendkeyToElementByJS(Confirm_Password, "455661");
		
		clickToElementByJS(registerbutton);
		SleepInSecond(3);
		Assert.assertEquals(driver.findElement(text_error_8_character).getText(),"The password confirmation does not match.");
		
		sendkeyToElementByJS(Password, "123454678");
		Assert.assertEquals(getElementValidationMessage(Confirm_Password), "Please fill out this field.");
		sendkeyToElementByJS(Confirm_Password, "123454678");
		
		clickToElementByJS(registerbutton);
 

		navigateToUrlByJS("https://warranty.rode.com/registration");
		
	   Assert.assertEquals(driver.findElement(By.xpath("//div[@class='container']/h2[text()='Register your warranty']")).getText(),"Register your warranty");
			
		
		
		
	}

//	@Test
	public void TC_03() {
		
	
		

		
	
	}
	
	public Object executeForBrowser(String javaScript) {
		return jsExecutor.executeScript(javaScript);
	}

	public String getInnerText() {
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(String textExpected) {
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage() {
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(String url) {
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void hightlightElement(String locator) {
		WebElement element = getElement(locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
		SleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	public void clickToElementByJS(String locator) {
		jsExecutor.executeScript("arguments[0].click();", getElement(locator));
	}

	public void scrollToElementOnTop(String locator) {
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
	}

	public void scrollToElementOnDown(String locator) {
		jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getElement(locator));
	}

	public void sendkeyToElementByJS(String locator, String value) {
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(locator));
	}

	public void removeAttributeInDOM(String locator, String attributeRemove) {
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(locator));
	}

	public String getElementValidationMessage(String locator) {
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(locator));
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
	
	public void SleepInSecond(long timeinSecond) {
		
		 try {
			 Thread.sleep(timeinSecond*1000);
			 //1000 ms =1s 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	}
	
	//@AfterClass
	///public void afterClass() {
	   // driver.quit();
	//}
}
