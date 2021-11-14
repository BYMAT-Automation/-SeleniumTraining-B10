package testPackage;

import org.testng.annotations.Test;

public class GetClassName {

	public static String testCaseName ;
	
	@Test
	public void getTestCaseName() {
		
		testCaseName = this.getClass().getSimpleName();	
		
		System.out.println("testCaseName:- " +testCaseName);
		
	}
	
}
