package testPackage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotations {
	
	@BeforeSuite
	public static void beforeSuite() { 
		System.out.println("I am in beforeSuite of TestNG");
	}
	
	@BeforeTest
	public static void beforeTest() { 
		System.out.println("I am in beforeTest of TestNG");
	}
	
	@BeforeClass
	public static void beforeClass() { 
		System.out.println("I am in beforeClass of TestNG");
	}
	
	@BeforeMethod
	public static void beforeMethod() { // Prerequisite, PreConditions
		System.out.println("I am in beforeMethod of TestNG");
	}
	
//	@BeforeMethod
//	public static void beforeMethod1() { // Prerequisite, PreConditions
//		System.out.println("I am in beforeMethod1 of TestNG");
//	}
	
	
	@Test
	public static void testCase1() {
		
		System.out.println("I am in testCase1 of TestNG");
	}
	
	@Test
	public static void testCase2() {
		
		System.out.println("I am in testCase2 of TestNG");
	}
	
	@Test
	public static void testCase3() {
		
		System.out.println("I am in testCase3 of TestNG");
	}
	
	@AfterMethod
	public static void afterMethod() { // post conditions
		System.out.println("I am in afterMethod of TestNG");
		System.out.println("******************************");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("I am in afterClass of TestNG");
		System.out.println("******************************");
	}
	
	@AfterTest
	public static void afterTest() { 
		System.out.println("I am in afterTest of TestNG");
		System.out.println("******************************");
	}
	
	@AfterSuite
	public static void afterSuite() { 
		System.out.println("I am in afterSuite of TestNG");
		System.out.println("******************************");
	}

}
