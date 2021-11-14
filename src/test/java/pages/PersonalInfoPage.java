package pages;

import java.io.IOException;
import java.util.Hashtable;

import testBase_B10.TestBase_B10;
import utility.CommonMethods;

public class PersonalInfoPage extends TestBase_B10 {

	public static void enterPersonalInformation(Hashtable<String, String> htData) throws IOException {

		CommonMethods.clickOnButton("radio_btn", "Mr.");

		CommonMethods.enterTextIntoTextBox("first_Name", htData.get("First_Name"), "First Name");

		CommonMethods.enterTextIntoTextBox("last_Name", htData.get("Last_Name"), "Last Name");

		CommonMethods.enterTextIntoTextBox("password", htData.get("Password"), "Password");
		
	}

}
