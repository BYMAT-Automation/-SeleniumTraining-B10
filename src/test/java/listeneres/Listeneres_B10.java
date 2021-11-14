package listeneres;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

import testBase_B10.TestBase_B10;

public class Listeneres_B10 extends TestBase_B10 implements ITestListener {

	public void onTestStart(ITestResult result) {
		
		try {
			launchBrowser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSuccess(ITestResult result) {
		
		try {
			closeBrowser();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(LogStatus.PASS, "Execution of test case "+ testCaseName+" is Passed");
		
	}

	public void onTestFailure(ITestResult result) {
		
		test.log(LogStatus.FAIL, result.getThrowable().getMessage());
		try {
			takeaScreenShot_fail();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			closeBrowser();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		test.log(LogStatus.FAIL , "Execution of test case "+ testCaseName+" is Failed");
	}

	public void onTestSkipped(ITestResult result) {
		
		//test.log(LogStatus. , "Execution of test case "+ testCaseName+" is Failed");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
