package testPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertions {
	
	@Test
	public void testNGAssertions() {
		
		Assert.assertEquals(true, true);
		System.out.println("I am in TestNG Assertion method- validating boolean values");
		
		Assert.assertEquals("SeleniumTraining", "SeleniumTraining");
		
		System.out.println("I am in TestNG Assertion method- validating text values");
		
		//Assert.fail("i am failing this test case");
		//System.out.println("I am in TestNG Assertion method- validating Assert.fail statement");
		
		Assert.assertTrue(false, "i am in assertTrue validation");
		
	}

}
