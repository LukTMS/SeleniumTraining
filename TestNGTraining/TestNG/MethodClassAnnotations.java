package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class MethodClassAnnotations {
	
	@BeforeClass
	public void setUp() {
		System.out.println("\n@BeforeClass runs once before class");
	}
	
	@AfterClass
	public void cleanUp() {
		System.out.println("\n@AfterClass runs once after class\n");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("\n	@BeforeMethod runs before every method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("\n	@AfterMethod runs after every method");
	}
	
	@Test
	public void testMethod1() {
		System.out.println("\n		@Test = Running Test -> testMethod1");
	}
	
	@Test
	public void testMethod2() {
		System.out.println("\n		@Test = Running Test -> testMethod2");
	}
}