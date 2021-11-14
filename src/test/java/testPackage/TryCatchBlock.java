package testPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.Test;

public class TryCatchBlock {

	@Test
	//public static void tryCatchBlock() throws FileNotFoundException, InterruptedException {
		
		public static void tryCatchBlock() {	
		///throw new FileNotFoundException("Config is not present");
		

		FileInputStream fis;
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		//fis = new FileInputStream(System.getProperty("user.dir") +"\\src\\test\\resources\\files\\Config11.properties");
		
		try {
			fis = new FileInputStream(System.getProperty("user.dir") +"\\src\\test\\resources\\files\\Config.properties");
			Properties config = new Properties();
			
			//config.load(fis);
			
			try {
				config.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
			} finally {
				System.out.println("I am inside of Try Catch & finally block.");
			}
			System.out.println("Config file has been loaded");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Issue while loading the Config file:-" + e.getMessage());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
		//	e1.printStackTrace();
			System.out.println("Issue while loading the Config file:-" + e1.getMessage());
		} 
		
		catch (NullPointerException e) { // mandatory 
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Issue while loading the Config file:-" + e.getMessage());
		}

		finally { // optional
			System.out.println("I am executing every time.");
		}

}

}
