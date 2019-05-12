package org.tdd.currency;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CurrencyTest {

	
	//assertEquals(a,b) : 객체 a와 b의 값이 같은지 확인

	//assertSame(new Dollar(10), product);
	//객체 a와 b가 같은 객체인지 확인
	@Test
	public void testMultiplication() {
		Money five = Money.dollar(5);
		
		assertEquals(Money.dollar(10), five.times(2));
		assertEquals(Money.dollar(15), five.times(3));
		
	}
	
	//무슨테스트일까.
	//비교대싱이 되는 두 객체의 amount값이 같은가를 확인
	@Test
	public void testEquality() {
		
		
		
		assertTrue(Money.dollar(5).equals(new Dollar(5)));
		assertFalse(Money.dollar(5).equals(new Dollar(6)));

		assertTrue(new Franc(5).equals(new Franc(5)));
		assertFalse(new Franc(5).equals(new Franc(6)));

		assertFalse(new Franc(5).equals(Money.dollar(5)));
	}
	//but, null값이나 다른객체들과의 비교문제는 해결안됨.
	
	
	
	@Test
	public void testFrancMultiplication() {
		Money five = Money.franc(5);
		
		assertEquals(Money.franc(10), five.times(2));
		assertEquals(Money.franc(15), five.times(3));
		
	}
	
}
