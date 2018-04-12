package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import TestNG.SomeClassToTest;

public class TypesOfAsserts {
	
	
	//je�li mamy kilka asercji w te�cie i pierwsza asercja b�dzie negatywna, to wykonanie testu zostanie przerwane
	
	@Test
	public void testSum() {
		System.out.println("\nRunning Test -> testSum");
		
		SomeClassToTest obj = new SomeClassToTest();
		int result = obj.sumNumbers(1, 2);
		
		//asercja czy warto�ci s� r�wne
		Assert.assertEquals(result, 3);
	
	}
	
	@Test
	public void testStrings() {
		System.out.println("\nRunning Test -> testStrings");
		String expectedString = "Hello World";
		
		SomeClassToTest obj = new SomeClassToTest();
		String result = obj.addStrings("Hello", "World");
		
		//asercja czy Stringi s� r�wne
		Assert.assertEquals(result, expectedString);
	}
	
	@Test
	public void testArrays() {
		System.out.println("\nRunning Test -> testArrays");
		int[] expectedArray = {1, 2, 3, 4};
		
		SomeClassToTest obj = new SomeClassToTest();
		int[] result = obj.getArray();
		
		//asercja czy tablice s� r�wne
		Assert.assertEquals(result, expectedArray);
		System.out.println("\nEnd Test -> testArrays");
	}
}