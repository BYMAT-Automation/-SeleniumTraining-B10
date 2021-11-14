package testCases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.PersonalInfoPage;
import testBase_B10.TestBase_B10;
import utility.CommonMethods;

public class EndToEndTestCase extends TestBase_B10{
	
	@BeforeClass
	public void getTestCaseName() {
		
		testCaseName = this.getClass().getSimpleName();	
		
		if(ht_RunMode.get(testCaseName).equalsIgnoreCase("Y")) 
			System.out.println("Running Test case: " +testCaseName);
		 else
			throw new SkipException("Run mode is set to No for Test case: " +testCaseName);
		
	}

	@Test(dataProvider = "data_Collection")
	public void endToEndTestCase(Hashtable<String, String> htData) throws InterruptedException, IOException {
		
		HomePage.createAnNewAccount(htData);
		PersonalInfoPage.enterPersonalInformation(htData);
		HomePage.LoginWithRegisteredUser(htData);
		
	}

}
