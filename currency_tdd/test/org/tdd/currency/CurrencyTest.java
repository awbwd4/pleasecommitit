package org.tdd.currency;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CurrencyTest {

	
	@Test
	public void testMutiplication() {
		
		Dollar five = new Dollar(5);
		
	//	Dollar product = five.times(2);
		
		//five.times(2);
	
		//assertEquals(10, five.amount);
		
		assertEquals(new Dollar(10), five.times(2));

		//product = five.times(3);
		assertEquals(new Dollar(15), five.times(3));
		
		//assertEquals(15, product.amount);
		
	}
	
	@Test
	public void testEquality() {
		
		assertTrue(new Dollar(5).equals(new Dollar(5)));
		assertFalse(new Dollar(5).equals(new Dollar(6)));

		assertTrue(new Franc(5).equals(new Franc(5)));
		assertFalse(new Franc(5).equals(new Franc(6)));
	
	}
	
	
	@Test
	public void testFrancMutiplication() {
		
		Franc five = new Franc(5);
		assertEquals(new Franc(10), five.times(2));
		assertEquals(new Franc(15), five.times(3));
		
	}
	
	
	
	
}