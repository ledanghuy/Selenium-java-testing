package Java_Basic;

import java.util.Iterator;
import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_While_Do_While {
	
  static	Scanner scanner =new Scanner(System.in);

	public static void main(String[] args) {
		
		//int i=0;
		//int j=0;
		
		
		//while (i<5)
		//{
		//	System.out.println(i);
	//		i++;
	//		break;
			
	//	}
		
		
		///do 89
		///{
		///	System.out.println(j);
	//		j++;
	///	}
	///	while (j<10);
		
		//TC_01_For();
		//TC_02_While();
		TC_03_Do_While();
		

	}
	@Test
	public static void TC_01_For() {
		
		int number= scanner.nextInt();
		
		
 
		
		for (int i = number; i < 100; i ++) {
			
			if (i % 2==0)
			{
			    System.out.println(i);
			    
			}
		}
		
		
		
	}
	@Test
	public static void TC_02_While() {
		int number= scanner.nextInt();
		
		while (number <100) {
			if ( number % 2 ==0)
			{
				System.out.println(number);
				number++;
			}
			
		}
		
	}
	@Test
	public static void TC_03_Do_While()
	{
		int number= scanner.nextInt();
		
		do
		{
			if (number % 2 ==0)
			{
				System.out.println(number);
				number ++;
			}
		
		}
		while (number <100);
		
	}
	
	
}
