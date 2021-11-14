package testPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import co.in.bymat.seleniumTraining.DataCollection;
import co.in.bymat.seleniumTraining.ExcelReader;

public class LoginToInstagramWithTestNG {

	static WebDriver driver;
	static ExcelReader excel;
	static Properties config;
	static Properties or;
	//public static String browser = "CHROME";
	
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
	}
	

	@BeforeMethod
	public void launchBrowser() throws IOException {

		if (config.getProperty("Browser").equalsIgnoreCase("CHROME")) {
			System.setProperty("webdriver.chrome.driver","D:\\BYMAT-Learn_Automation\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver(); // Responsible to launch the browser
		} else if (config.getProperty("Browser").equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.gecko.driver","D:\\BYMAT-Learn_Automation\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (config.getProperty("Browser").equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver","D:\\BYMAT-Learn_Automation\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else {
			System.setProperty("webdriver.edge.driver","D:\\BYMAT-Learn_Automation\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
		//driver.get("https://www.instagram.com/");
		
		driver.get(config.getProperty("App_URL_Prod"));
		System.out.println("User navigated to application URL:-" +config.getProperty("App_URL_Prod"));
		
		String ptile = driver.getTitle();
		
		Assert.assertEquals(ptile, excel.getCellData("Test_Data", "Page_Title", 2));
		//Assert.assertEquals(ptile, "Instagram");
		System.out.println("I validated the Page Tile and is:-" +ptile);

	}

	@Test
	public void loginToInstagramWithTestNG() throws InterruptedException, IOException {

		Thread.sleep(3000);
		driver.findElement(By.xpath(or.getProperty("UserName"))).sendKeys(excel.getCellData("Test_Data", "Email_ID", 3)); 
		System.out.println("User entered userName");
		takeaScreenShot();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(or.getProperty("Paswd"))).sendKeys(excel.getCellData("Test_Data", "Password", 3));
		System.out.println("User entered Password");
		takeaScreenShot();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(or.getProperty("Login_btn"))).click();
		System.out.println("User clicked on Login button");
		takeaScreenShot();

	}
	
	//@Test(priority = 1)
	public void loginToInstagramWithTestNG1() throws InterruptedException, IOException {

		Thread.sleep(3000);
		driver.findElement(By.xpath(or.getProperty("UserName"))).sendKeys(excel.getCellData("Test_Data", "Email_ID", 5)); 
		takeaScreenShot();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(or.getProperty("Paswd"))).sendKeys(excel.getCellData("Test_Data", "Password", 5));
		// driver.findElement(By.xpath("//*[@name=\"password\"]")).sendKeys("MyPassword");
		takeaScreenShot();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(or.getProperty("Login_btn"))).click();
		// driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();
		takeaScreenShot();

	}

	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
		System.out.println("Driver has been closed");
	}
	
	public void takeaScreenShot() throws IOException {
		
		String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String screenShotPath = System.getProperty("user.dir") +"\\src\\test\\resources\\screenShots\\screenshot_"+timeStamp+".png";
		// Now you can do whatever you need to do with it, for example copy somewhere
		File destfile = new File(screenShotPath);
	
		FileHandler.copy(scrFile, destfile);
		
	}
	

}
