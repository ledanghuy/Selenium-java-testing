package Webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Web_Element_Exce {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	
	
	
	By emailTextbox=By.id("mail");
	By ageUnder18Radio=By.cssSelector("#under_18");
	By educationTextArea= By.cssSelector("#edu");
	By nameUser5= By.xpath("//h5[text()='Name: User5']");
	By PasswordTextbox= By.cssSelector("#disable_password");
	By biographyTextArea = By.cssSelector("#bio");
	By jobRol01= By.cssSelector("#job1");
	By jobRol02= By.cssSelector("#job2");
	By developcheckbox= By.cssSelector("#development");
	By slider01bar = By.cssSelector("#slider-1");
	By radiodisablecheckbox = By.cssSelector ("#radio-disabled");
	By jobRol03 =By.cssSelector("#job3");
	By Checkboxdisable = By.cssSelector("#check-disbaled");
	By slider02bar=  By.cssSelector("#slider-2");
	By javacheckbox = By.cssSelector("#java");
	
	
	
	By email =By.id("email");
	By mail_chimp_password= By.id("new_password");
	By signup_button =By.id("create-account-enabled");
	
	
	

	@BeforeClass
	public void beforeClass() {
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
		}
			
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		
	}

	//@Test
	public void TC_01() {
		
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		/// texbox // texarea neu co hien thi thi` nhap text vao va in ra 
		
		if (driver.findElement(emailTextbox).isDisplayed())
		{
			driver.findElement(emailTextbox).sendKeys("Selenium WebDriver");
			System.out.println("Email textbox is displayed");
		}else 
		{
			System.out.println("Email textbox is not displayed");
			
		}
		
		///text area
		if (driver.findElement(educationTextArea).isDisplayed())
		{
			driver.findElement(educationTextArea).sendKeys("Selenium GRID");
			System.out.println("Text area  is displayed");
		}
		else
		{
			System.out.println("Text area is not displayed");
		}
		
		
		/// Raido button
		if (driver.findElement(ageUnder18Radio).isDisplayed())
		{
			driver.findElement(ageUnder18Radio).click();
			System.out.println("Age Under 18  is displayed");
		}
		else
		{
			System.out.println("Age Under 18 is not displayed");
		}
	
		
		
		if (driver.findElement(nameUser5).isDisplayed())
		{
			
			System.out.println("Name User 5 is displayed");
		}
		else
		{
			System.out.println("Name User 5 is not displayed");
		}
	  
	}
	//@Test
	public void TC_02_Enable() {
		
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		///Step 02 :
		
		//email:
		if (driver.findElement(emailTextbox).isEnabled())
		{
			System.out.println("Email is Enable");
			
		}
		else
		{
			System.out.println("Email is Disable");
		}
		
		////Age under 18
		if(driver.findElement(ageUnder18Radio).isEnabled())
		{
			System.out.println("Under 18 is Enable");
		}
		else
		{
			System.out.println("Under 18 is Disable");
		}
		
		///Education
		if (driver.findElement(educationTextArea).isEnabled())
		{
			System.out.println("Education is Enable");
		}
		else
		{
			System.out.println("Education is Disable");
		}
		
		
		//Jobrole 01
		if (driver.findElement(jobRol01).isEnabled())
		{
			System.out.println("jobRol01 is  Enable");
		}
		else
		{
			System.out.println("jobRol01 is Disable");
		}
		
		//Jobrole 02
		if (driver.findElement(jobRol02).isEnabled())
		{
			System.out.println("jobRol02 is  Enable");
		}
		else
		{
			System.out.println("jobRol02 is Disable");
		}
		
		//Development checkbox
		
		if (driver.findElement(developcheckbox).isEnabled())
		{
			System.out.println("developcheckbox is Enable");
		}
		else
		{
			System.out.println("developcheckbox is Disable");
		}
		
		//Slider01
		
		if (driver.findElement(slider01bar).isEnabled())
		{
			System.out.println("slider01bar is  Enable");
		}
		else
		{
			System.out.println("slider01bar is Disable");
		}
			
		
		
		
		
		
		
		
		///Step 03 
		
		//password
	    if(driver.findElement(PasswordTextbox).isEnabled())
		{
			System.out.println("Password Textbox is Enable");
			
		}
		else
	    {
		System.out.println("Password Textbox is disable");
		}
		
	
	    //biography
		if (driver.findElement(biographyTextArea).isEnabled()) 
		{
			System.out.println("Biography is Enable ");
						
		}
		else
		{
			System.out.println("Biography is Disable");
			
		}
		//Age (Radiobutton is disable)
		if (driver.findElement(radiodisablecheckbox).isEnabled())
		{
			System.out.println("Radion is Enable ");
		}
		else 
		{
			System.out.println("Radion is disable ");
		}
		
		///Job Role 03
		if (driver.findElement(jobRol03).isEnabled())
		{
			System.out.println("jobRol03  is Enable ");
		}
		else 
		{
			System.out.println("jobRol03 is disable ");
		}
		
		///Interest ( Checkbox is disable)
		if (driver.findElement(Checkboxdisable).isEnabled())
		{
			System.out.println("Checkboxdisable  is Enable ");
		}
		else 
		{
			System.out.println("Checkboxdisable is disable ");
		}
		
		///silder02 (disable)
		
		if (driver.findElement(slider02bar).isEnabled())
		{
			System.out.println("slider02bar  is Enable ");
		}
		else 
		{
			System.out.println("slider02bar is disable ");
		}
		
		
		
		
		
		
}	
	
	@Test
	public void TC_03() {
		
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		
		/// Kiểm tra xem raido và check box đã được chọn chưa
		
		Assert.assertFalse(driver.findElement(ageUnder18Radio).isSelected());
		Assert.assertFalse(driver.findElement(javacheckbox).isSelected());
		
		driver.findElement(ageUnder18Radio).click();
		driver.findElement(javacheckbox).click();
		
		SleepInSecond(3);
		
		
		/// Kiểm tra raido và checkbox đã được chọn rồi
		Assert.assertTrue(driver.findElement(ageUnder18Radio).isSelected());
		Assert.assertTrue(driver.findElement(javacheckbox).isSelected());
		
		
		
	    //Step 03 : kiem tra step 02 da duoc chon
		
		driver.findElement(ageUnder18Radio).click();
		driver.findElement(javacheckbox).click();
		
		
		
	
		
	
		
	
	}
	//@Test
	public void TC_04_Register_Function_at_MailChimp() {
		
		driver.get("https://login.mailchimp.com/signup/");
		
		driver.findElement(email).sendKeys("ledanghuy91@gmail.com");
		
		
		//nhập chữ cái abc 
		
		driver.findElement(mail_chimp_password).sendKeys("abc");
		driver.findElement(signup_button).click();
		
		SleepInSecond(3);
		
		//Verify that One lowercase character
		
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		
		/// Verify that One uppercase character
		driver.findElement(mail_chimp_password).clear();
		driver.findElement(mail_chimp_password).sendKeys("ABC");
		driver.findElement(signup_button).click();
		SleepInSecond(3);
		
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		
		/// Verify that One number
		driver.findElement(mail_chimp_password).clear();
		driver.findElement(mail_chimp_password).sendKeys("123");
		driver.findElement(signup_button).click();
		SleepInSecond(3);
				
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
	    Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		
		
		/// Verify that One special character
		driver.findElement(mail_chimp_password).clear();
		driver.findElement(mail_chimp_password).sendKeys("#$@");
		driver.findElement(signup_button).click();
		SleepInSecond(3);
				
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
	    Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
		
		
		
		
		/// Verify that 8 characters minimum
		driver.findElement(mail_chimp_password).clear();
		driver.findElement(mail_chimp_password).sendKeys("ABCXYZHG");
		driver.findElement(signup_button).click();
		SleepInSecond(3);
						
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='lowercase-char not-completed']")).isDisplayed());
	    Assert.assertTrue(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='number-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='special-char not-completed']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
		
		
		/// Verify that nhap dung het yeu cau
		driver.findElement(mail_chimp_password).clear();
		driver.findElement(mail_chimp_password).sendKeys("123abcABC@!#");
		driver.findElement(signup_button).click();
		SleepInSecond(3);
								
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='lowercase-char completed']")).isDisplayed());
	    Assert.assertFalse(driver.findElement(By.xpath("//li[@class='uppercase-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='number-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='special-char completed']")).isDisplayed());
		Assert.assertFalse(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
		
		
		
		
		
		
		
		
		
		
	
		
	
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
