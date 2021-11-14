package pages;

import java.io.IOException;
import java.util.Hashtable;

import testBase_B10.TestBase_B10;
import utility.CommonMethods;

public class HomePage extends TestBase_B10 {

	public static  void createAnNewAccount(Hashtable<String, String> htData) throws IOException {
		
		CommonMethods.verifyPageTitle(htData.get("Page_Title"));

		CommonMethods.clickOnWebElement("SignIn_btn", "Sign In");
		
		CommonMethods.enterTextIntoTextBox("Email_Add", htData.get("Email_ID"), "Email Address");
		
		CommonMethods.clickOnButton("CreatAnAccnt_btn", "Create An Account");

	}

	public static void LoginWithRegisteredUser(Hashtable<String, String> htData) throws IOException {
		
		CommonMethods.verifyPageTitle(htData.get("Page_Title"));
		
		CommonMethods.clickOnWebElement("SignIn_btn", "Sign In");
		
		CommonMethods.enterTextIntoTextBox("Email_Add_RegUser", htData.get("Email_ID"), "Email Address");
		
		CommonMethods.enterTextIntoTextBox("Pass_RegUser", htData.get("Password"), "Password");
		
		CommonMethods.clickOnButton("Sign_In_btn_regUser", "Sign In");

	}

	public static void contactUs() {
//		
//		CommonMethods.verifyPageTitle(htData.get("Page_Title"));
//		
//		CommonMethods.selectByValue();
//		
//		CommonMethods.enterTextIntoTextBox(WebElementKey, input_value, "Email address");
//		
//		CommonMethods.enterTextIntoTextBox(WebElementKey, input_value, "Order reference");
//		
//		CommonMethods.clickOnButton("Sign_In_btn_regUser", "Send_Btn");

	}

}
