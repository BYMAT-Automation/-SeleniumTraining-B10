package testPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import co.in.bymat.seleniumTraining.DataCollection;
import co.in.bymat.seleniumTraining.ExcelReader;

public class LoginMyStore {
	WebDriver driver;
	public static ExcelReader excel;
	static ExtentTest test;
	static ExtentReports report;
	String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	File destFile;

	

	@BeforeMethod
	public void before(){
		
		System.setProperty("webdriver.chrome.driver", "D:\\Automation Training Vinay Sir\\Drivers\\Chrome94\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		excel=new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\testdata.xlsx");
		report = new ExtentReports(System.getProperty("user.dir")+"\\src\\test\\resources\\reports\\ExtentReportResults"+timeStamp+".html");
		test = report.startTest("ExtentDemo");
	}
	
	
	@Test(dataProvider="getData")
	//@Test
	public void login() throws IOException, InterruptedException {
		
		
		
		Properties prop = new Properties();          
		File configFile = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\configuration\\conf.properties");
		InputStream stream = new FileInputStream(configFile);
		prop.load(stream);
		driver.get(prop.getProperty("appUrl"));
	
		if(driver.getTitle().equals("My Store"))
		{
		test.log(LogStatus.PASS, "Navigated to the specified URL");
		}
		else
		{
		test.log(LogStatus.FAIL, "Test Failed");
		}
		
		Properties prop1 = new Properties();          
		File configFile1 = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\xpaths\\OR.properties");
		InputStream stream1 = new FileInputStream(configFile1);
		prop1.load(stream1);
	
		driver.findElement(By.xpath(prop1.getProperty("signIn"))).click();
		test.log(LogStatus.PASS, "Clicked to the Sign In button");
		Thread.sleep(5000);
		driver.findElement(By.xpath(prop1.getProperty("emailAddr"))).sendKeys(excel.getCellData("TestLogin", "EmailID", 2));
		test.log(LogStatus.PASS, "Passed the correct  email id from file");
		Thread.sleep(5000);
		takeScreenshot();
		driver.findElement(By.xpath(prop1.getProperty("createAccntBtn"))).click();
		test.log(LogStatus.PASS, "Create account button got clicked");
		
	}
	
	public void takeScreenshot() throws IOException {
		
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		File destFile=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\screenshots\\screenshots"+timeStamp+".png");
		FileHandler.copy(screenshot, destFile);
		
	}
	
	@DataProvider
	public Object[][] getData(){
		
		DataCollection dc=new DataCollection(excel,"TestLogin","LoginMyStore");
		return dc.dataArray();
		
		
	}
	
	@AfterMethod
	public void after(){
		report.endTest(test);
		report.flush();
		driver.quit();
	}
}