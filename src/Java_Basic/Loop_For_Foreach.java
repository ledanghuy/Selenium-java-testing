package Java_Basic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Loop_For_Foreach {

	
	WebDriver driver;
	
	@Test
	public void TC_01_For() {
		//for (int i = 1; i <= 10; i++) {
			
			//System.out.println(i);
	//	}
		
		
		
		//List<WebElement>  links =  driver.findElements(By.id(""));
		
		
		
		// Array
		String [] CityName= {"Hà Nội", "Hồ CHí Minh", "Đà Nẵng", "Huế", "Hồ CHí Minh","Hải Phòng"};
		
		
		///Array / List/ Set/Queue(index);
		
		
		
		for (int i = 0; i < CityName.length; i++) {
			
		///	System.out.println(CityName[i]);
			
			if (CityName[i].equals("Hồ CHí Minh"))
			{
				System.out.println(CityName[i]);
				break;
			}

		}
		
		String [] name_= {"AAAAAAAA", "BBBBBB", "CCCCCCCC", "DSDDDDD", "FGFFFFFF","UUUUUUUUg"};
		
		int y=0;
		for (String name_item : name_) {
			
			if (name_[y].equals("CCCCCCCC"))
			{
				System.out.println(name_[y]);
				
			}
			y++;
			
			
		}
		
	}
	
	
	
}
