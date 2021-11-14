package testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import co.in.bymat.seleniumTraining.DataCollection;
import co.in.bymat.seleniumTraining.ExcelReader;
import utility.CommonMethods;

public class LoginToMyStoreWithRegisteredUserDataDriven {  // Data Driven Framework

	public static WebDriver driver;
	public static ExcelReader excel;
	public static Properties config;
	public static Properties or;
	public static ExtentTest test;
	public static ExtentReports report;
	
		
	@BeforeClass
	public void initialization() throws IOException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +"\\src\\test\\resources\\files\\Config.properties");
	    config = new Properties(); // Local Variable
	    config.load(fis);
	    System.out.println("Config file has been loaded");
		
	    FileInputStream fis1 = new FileInputStream(System.getProperty("user.dir") +"\\src\\test\\resources\\files\\OR.properties");
	    or = new Properties();
	    or.load(fis1);
	    System.out.println("OR file has been loaded");
		
		excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\Master_Sheet.xlsx");
		System.out.println("Excel file has been initialized");
		
		report = new ExtentReports(System.getProperty("user.dir")+"\\src\\test\\resources\\executionReports\\ExtentReportResults.html");
		
		test = report.startTest("LoginToMyStore");
	}
	

	@BeforeMethod
	public void launchBrowser() throws IOException {

		if (config.getProperty("Browser").equalsIgnoreCase("CHROME")) {
			System.setProperty("webdriver.chrome.driver","D:\\BYMAT-Learn_Automation\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver(); // Responsible to launch the browser
			test.log(LogStatus.PASS  , "CHROME Browser is launched");
		} else if (config.getProperty("Browser").equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.gecko.driver","D:\\BYMAT-Learn_Automation\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			test.log(LogStatus.PASS , "CHROME Browser is launched");
		} else if (config.getProperty("Browser").equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver","D:\\BYMAT-Learn_Automation\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			test.log(LogStatus.PASS , "CHROME Browser is launched");
		} else {
			System.setProperty("webdriver.edge.driver","D:\\BYMAT-Learn_Automation\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			test.log(LogStatus.PASS , "CHROME Browser is launched");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
		//driver.get("https://www.instagram.com/");
		
		driver.get(config.getProperty("App_URL_Prod"));
		System.out.println("User navigated to application URL:-" +config.getProperty("App_URL_Prod"));
		
		test.log(LogStatus.PASS , "User navigated to application URL:-" +config.getProperty("App_URL_Prod"));
		
	}

	@Test(dataProvider = "data_Collection") // Data Driven Framework
	public void loginToMyStore(Hashtable<String, String> htData) throws InterruptedException, IOException {
		
		String ptile = driver.getTitle();

		//CommonMethods cm = new CommonMethods();
		
		
		Assert.assertEquals(ptile, htData.get("Page_Title"));
		System.out.println("I validated the Page Tile and is:-" +ptile);
		test.log(LogStatus.PASS, "I validated the Page Tile and is:-" +ptile);  
		
		Thread.sleep(2000);

	//	cm.clickOnWebElement();
//		driver.findElement(By.xpath(or.getProperty("SignIn_btn"))).click();
//		System.out.println("User clicked on Sign In button");
//		test.log(LogStatus.PASS, "User clicked on Login button");
//		takeaScreenShot();	
			
		//cm.enterTextInTextBox();
		Thread.sleep(3000);
		driver.findElement(By.xpath(or.getProperty("Email_Add"))).sendKeys(htData.get("Email_ID"));
		System.out.println("User entered email addrress");
		test.log(LogStatus.PASS, "User entered  email addrress");
		takeaScreenShot();
		
	//	cm.clickOnWebElement();
		Thread.sleep(2000);
		driver.findElement(By.xpath(or.getProperty("CreatAnAccnt_btn"))).click();
		System.out.println("User clicked on Creat An Account button");
		test.log(LogStatus.PASS, "User clicked on Create An Account button");
		takeaScreenShot();	
		
//		Thread.sleep(2000);
//		String Email_errormsg = "";
//		Email_errormsg = driver.findElement(By.xpath(or.getProperty("EmailErrorMsg"))).getText();
//		System.out.println("\n User clicked on Creat An Account button" + Email_errormsg);
//		Assert.assertTrue(Email_errormsg == "");
//		
//		System.out.println("User got error message");
//		test.log(LogStatus.PASS, "User got error message");
//		takeaScreenShot();	
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(or.getProperty("radio_btn"))).click();
		System.out.println("User selected a radio button");
		test.log(LogStatus.PASS, "User selected a radio button");
		takeaScreenShot();		
		
		Thread.sleep(3000);
		driver.findElement(By.xpath(or.getProperty("first_Name"))).sendKeys(htData.get("First_Name"));
		System.out.println("User entered first_Name");
		test.log(LogStatus.PASS, "User entered  first_Name");
		takeaScreenShot();
		
	}

	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
		System.out.println("Driver has been closed");
		test.log(LogStatus.PASS, "Driver has been closed");
	}
	
	@AfterClass
	public static void endTest()
	{
	report.endTest(test);
	report.flush();
	}
	
	public void takeaScreenShot() throws IOException {
		
		String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());	
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		String screenShotPath = System.getProperty("user.dir") +"\\src\\test\\resources\\screenShots\\screenshot_"+timeStamp+".png";
		// Now you can do whatever you need to do with it, for example copy somewhere
		File destfile = new File(screenShotPath);
		FileHandler.copy(scrFile, destfile);
		test.log(LogStatus.PASS, test.addScreenCapture(screenShotPath));
	}
	
	@DataProvider
	public Object[][] data_Collection() {
		
		  DataCollection dc = new DataCollection(excel, "Test_Data", "LoginToMyStore");
				
		  return dc.dataArray();
				
		//DataCollection dc = new DataCollection(excel, "Test_Data", testCaseName);
		
	}

}
