package testCases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import testBase_B10.TestBase_B10;
import utility.CommonMethods;

public class LoginToMyStoreWithRegisteredUser2 extends TestBase_B10 { 
	
	@BeforeClass
	public void getTestCaseName() {
		
		testCaseName = this.getClass().getSimpleName();	
		
		if(ht_RunMode.get(testCaseName).equalsIgnoreCase("Y")) 
			System.out.println("Running Test case: " +testCaseName);
		 else
			 throw new SkipException("Run mode is set to No for Test case: " +testCaseName);
		
	}

	@Test(dataProvider = "data_Collection") 
	public void loginToMyStoreWithRegisteredUser2(Hashtable<String, String> htData) throws InterruptedException, IOException {
		
		CommonMethods.verifyPageTitle(htData.get("Page_Title"));
		
		CommonMethods.clickOnWebElement("SignIn_btn", "Sign In");
		
		CommonMethods.enterTextIntoTextBox("Email_Add_RegUser", htData.get("Email_ID"), "Email Address");
		
		CommonMethods.enterTextIntoTextBox("Pass_RegUser", htData.get("Password"), "Password");
		
		CommonMethods.clickOnButton("Sign_In_btn_regUser", "Sign In");
		
	}


}
