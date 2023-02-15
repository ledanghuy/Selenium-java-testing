package Webdriver;

public class Topic_05_And_Or {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean statusA;
		boolean statusB;
		

		
		statusA=true;
		statusB= false;
		System.out.println ("Ket qua = " + (statusA && statusB));
		
		
		
		statusA=false;
		statusB=true;
		System.out.println ("Ket qua = " + (statusA && statusB));
		
		
		
		statusA=true;
		statusB=true;
		System.out.println ("Ket qua = " + (statusA && statusB));
		
		
		statusA=false;
		statusB=false;
		System.out.println ("Ket qua = " + (statusA && statusB));
		

	}

}
