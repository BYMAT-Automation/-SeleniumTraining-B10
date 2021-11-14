package testPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import co.in.bymat.seleniumTraining.ExcelReader;

public class LoginToInstagram {

	static WebDriver driver;
	public static String browser = "CHROME";
	
	public static void main(String[] args) throws InterruptedException {	
		
		if (browser.equalsIgnoreCase("CHROME")) {
			System.setProperty("webdriver.chrome.driver","D:\\BYMAT-Learn_Automation\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver(); // Responsible to launch the browser
		} else if (browser.equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.gecko.driver","D:\\BYMAT-Learn_Automation\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver","D:\\BYMAT-Learn_Automation\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else {
			System.setProperty("webdriver.edge.driver","D:\\BYMAT-Learn_Automation\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\Master_Sheet.xlsx");
		
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.instagram.com/");
		
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[1]/div/label/input")).sendKeys(excel.getCellData("Test_Data", "Email_ID", 3)); // Absolute Xpath
		//driver.findElement(By.xpath("//*[@name=\"username\"]")).sendKeys("response@bymat.co.in");  // Relative Xpath
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[2]/div/label/input")).sendKeys("MyPassword");
		//driver.findElement(By.xpath("//*[@name=\"password\"]")).sendKeys("MyPassword");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[3]/button/div")).click();
		//driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();
		
		Thread.sleep(5000);
		driver.close();
		
		// Syntax of Xpath -- //TagName[@Attribute Name = "Attribute Value"]
		
	}
}
