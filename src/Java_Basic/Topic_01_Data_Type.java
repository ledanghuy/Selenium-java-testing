package Java_Basic;

public class Topic_01_Data_Type {
	
	static int StudentNumber;
	static boolean statusvalues;
	static final String BrowserNam="Chrome";
	
	String StudentName="Automation FC";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(StudentNumber);
		System.out.println(statusvalues);
		

	}

	
	public String  getStudenNumber()
	{
		return this.StudentName;
		
	}
	
	public void setStudenName(String stdName)
	{
		this.StudentName=stdName;
	}

}
