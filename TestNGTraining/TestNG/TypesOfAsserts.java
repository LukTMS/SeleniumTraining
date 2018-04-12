package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import TestNG.SomeClassToTest;

public class TypesOfAsserts {
	
	
	//jeœli mamy kilka asercji w teœcie i pierwsza asercja bêdzie negatywna, to wykonanie testu zostanie przerwane
	
	@Test
	public void testSum() {
		System.out.println("\nRunning Test -> testSum");
		
		SomeClassToTest obj = new SomeClassToTest();
		int result = obj.sumNumbers(1, 2);
		
		//asercja czy wartoœci s¹ równe
		Assert.assertEquals(result, 3);
	
	}
	
	@Test
	public void testStrings() {
		System.out.println("\nRunning Test -> testStrings");
		String expectedString = "Hello World";
		
		SomeClassToTest obj = new SomeClassToTest();
		String result = obj.addStrings("Hello", "World");
		
		//asercja czy Stringi s¹ równe
		Assert.assertEquals(result, expectedString);
	}
	
	@Test
	public void testArrays() {
		System.out.println("\nRunning Test -> testArrays");
		int[] expectedArray = {1, 2, 3, 4};
		
		SomeClassToTest obj = new SomeClassToTest();
		int[] result = obj.getArray();
		
		//asercja czy tablice s¹ równe
		Assert.assertEquals(result, expectedArray);
		System.out.println("\nEnd Test -> testArrays");
	}
}