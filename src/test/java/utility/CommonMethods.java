package utility;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import testBase_B10.TestBase_B10;

public class CommonMethods extends TestBase_B10 {

	public static void clickOnWebElement(String WebElementKey, String WebElementName) throws IOException {
		driver.findElement(By.xpath(or.getProperty(WebElementKey))).click();
		System.out.println("User clicked on " + WebElementName);
		test.log(LogStatus.PASS, "User clicked on " + WebElementName);
		takeaScreenShot();
	}

	public static void clickOnButton(String WebElementKey, String ButtonName) throws IOException {
		driver.findElement(By.xpath(or.getProperty(WebElementKey))).click();
		System.out.println("User clicked on " + ButtonName + " button");
		test.log(LogStatus.PASS, "User clicked on " + ButtonName + " button");
		takeaScreenShot();
	}

	public static void selectRadioButton() {

	}

	public static void selectCheckBox() {

	}

	public static void enterTextIntoTextBox(String WebElementKey, String input_value, String WebElementName)
			throws IOException {
		driver.findElement(By.xpath(or.getProperty(WebElementKey))).sendKeys(input_value);
		System.out.println("User entered " + WebElementName);
		test.log(LogStatus.PASS, "User entered " + WebElementName);
		takeaScreenShot();
	}

	public static void selectByText() {

	}

	public static void selectByIndex() {

	}

	public static void selectByValue() {

	}

	public static void verifyPageTitle(String expected_Title) {

		String Actual_Ptile = driver.getTitle();

		Assert.assertEquals(Actual_Ptile, expected_Title);

		test.log(LogStatus.PASS, "I validated the Page Tile and is:-" + expected_Title);

	}

}
