package TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TimeoutTestMethods {
	
	@BeforeClass
	public void setUp() {
		System.out.println("before class");
	}
	
	@AfterClass
	public void cleanUp() {
		System.out.println("after class");
	}
	
	@Test(enabled=false)
	public void testMethod1() {
		System.out.println("testMethod1");
	}
	
	//okre�lamy maksymalny dopuszczalny czas wykonania testu. 
	//je�li rzeczywisty czas wykonania b�dzie wi�kszy, test zostanie sfailowany
	@Test(timeOut=300)
	public void testMethod2() throws InterruptedException {
		System.out.println("testMethod2");
		Thread.sleep(400);
	}
}