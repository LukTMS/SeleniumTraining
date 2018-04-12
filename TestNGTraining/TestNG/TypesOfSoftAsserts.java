package TestNG;


import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;
import TestNG.SomeClassToTest;

public class TypesOfSoftAsserts {
	
	//je�li mamy kilka asercji SoftAssert w te�cie i pierwsza asercja b�dzie negatywna, to wykonanie testu nadal b�dzie kontynuowane
	
	@Test
	public void testSum() {
		
		SoftAssert sa = new SoftAssert();
		
		
		System.out.println("\nRunning Test -> testSum");
		
		SomeClassToTest obj = new SomeClassToTest();
		int result = obj.sumNumbers(1, 2);
		
		sa.assertEquals(result, 2);
		System.out.println("\nLine after assert 1");
		
		sa.assertEquals(result, 3);
		System.out.println("\nLine after assert 2");
		
		//assertAll sprawdza, czy jakakolwiek asercja w te�cie jest negatywna
		sa.assertAll();
	}
}