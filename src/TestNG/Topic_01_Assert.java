package TestNG;

import org.testng.Assert;

public class Topic_01_Assert {

	public static void main(String[] args) {
		String fullname="Automation Testing";
		
		// TODO Auto-generated method stub
		
		// Mong chờ 1 điều kiện trả về là đúng (true)
		///Assert.assertTrue(fullname.contains("Automation"));
		
		
		
		// Mong chờ 1 điều kiện trả về là sai (false)
			//	Assert.assertFalse(fullname.contains("Testing"));
				
				
      /// Mong đợi 2 điều kiện bằng nhau 
				
	//// Actual resualt =  Expected Resutl
				
				Assert.assertEquals(fullname, "Automation Testing");
				
				
	
				

	}

}
