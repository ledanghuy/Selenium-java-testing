package Java_Basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Topic_02_Data_Type {

	
	WebDriver driver;
	////
	List<WebElement>  homepagelink= driver.findElements(By.tagName("a")); /// lưu trùng
	
	Set<String> allWindows = driver.getWindowHandles();/// khoonng lưu trùng 	
	
	
	List<String > productName= new ArrayList<String>();
	
	public void ClickToElement()
	{
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int number =10;
		number +=5;
		System.out.println(number);
		
		System.out.println(number/5);
		System.out.println(number % 6 );
		
		
		for (int i = 0; i < 3; ++i) {
			
			System.out.println(i);
		}
		
	}

}
