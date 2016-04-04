package mytests;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculateTest {
	Calculate calculation = new Calculate();
	int sum = calculation.sum(25, 56);
	int testSum = 84;
	
	@Test
	public void testSum(){
		System.out.println("@Test sum(): " + sum + " = " + testSum);
		assertEquals(sum, testSum);
	}

}
