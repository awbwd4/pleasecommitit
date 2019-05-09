package org.tdd.currency;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CurrencyTest {

	@Test
	public void testMutiplication() {
		
		Dollar five = new Dollar(5);
		
		five.times(2);
	
		assertEquals(10, five.amount);
		
	}
	
	
}
