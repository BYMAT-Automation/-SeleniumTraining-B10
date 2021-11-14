package testCases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.HomePage;
import pages.PersonalInfoPage;
import testBase_B10.TestBase_B10;
import utility.CommonMethods;

public class LoginToMyStore extends TestBase_B10 {
	
	@BeforeClass
	public void getTestCaseName() {
		
		testCaseName = this.getClass().getSimpleName();	
		
		if(ht_RunMode.get(testCaseName).equalsIgnoreCase("Y")) 
			System.out.println("Running Test case: " +testCaseName);
		 else
			throw new SkipException("Run mode is set to No for Test case: " +testCaseName);
		
	}

	@Test(dataProvider = "data_Collection")
	public void loginToMyStore(Hashtable<String, String> htData) throws InterruptedException, IOException {
		
//		CommonMethods.verifyPageTitle(htData.get("Page_Title"));
//
//		CommonMethods.clickOnWebElement("SignIn_btn", "Sign In");
//		
//		CommonMethods.enterTextIntoTextBox("Email_Add", htData.get("Email_ID"), "Email Address");
//		
//		CommonMethods.clickOnButton("CreatAnAccnt_btn", "Create An Account"); 
		
		
//		CommonMethods.clickOnButton("radio_btn", "Mr.");	
//		
//		CommonMethods.enterTextIntoTextBox("first_Name", htData.get("First_Name"), "First Name");
//		
//		CommonMethods.enterTextIntoTextBox("last_Name", htData.get("Last_Name"), "Last Name");
//		
//		CommonMethods.enterTextIntoTextBox("password", htData.get("Password"), "Password");
//		
	HomePage.createAnNewAccount(htData);
	PersonalInfoPage.enterPersonalInformation(htData);
	
	}


}
