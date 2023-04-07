package TestNG;

import org.testng.annotations.Test;

public class Topic_03_Priority {
	
  
	@Test (enabled  = false, description = "JIRA_0787-Create a new Employee and verify the employee create ")
    public void EndUser_Register_New_Employee() {
	  
     }
	@Test 
	public void EndUser_View_Employee() {
		  
	 }
	 @Test (priority = 3)
	 public void EndUser_Edit_Employee() {
		  
	 }
	 @Test (priority = 4)
	 public void EndUser_Move_Employee() {
		  
	 }
	
}
