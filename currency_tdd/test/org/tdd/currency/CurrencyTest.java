package org.tdd.currency;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
		
		
		assertTrue(Money.dollar(5).equals(Money.dollar(5)));
		assertFalse(Money.dollar(5).equals(Money.dollar(6)));
		
		//assertTrue(Money.franc(5).equals(Money.franc(5)));
		//assertFalse(Money.franc(5).equals(Money.franc(6)));

		assertFalse(Money.franc(5).equals(Money.dollar(5)));
		/*
		 * */
	}
	//but, null값이나 다른객체들과의 비교문제는 해결안됨.

	@Test
	public void testCurrencty() {
		assertEquals("USD", Money.dollar(1).currency());
		assertEquals("CHF", Money.franc(1).currency());
	}
	

	@Test
	public void testSimpleAddition() {

		Money five = Money.dollar(5);
		Bank bank = new Bank();
		
		//Money sum = Money.dollar(5).plus(Money.dollar(5));
		
		Expression sum = five.plus(five);
		
		Money reduced = bank.reduce(sum, "USD");//계산 결과에 환율을 적용함. 
		
		assertEquals(Money.dollar(10), reduced);
	}
	
	
	//두 Money의 합은 sum(Sum 타입)이어야 한다.
	@Test
	public void testPlusReturnsSum() {
		Money five = Money.dollar(5);
		Expression result = five.plus(five);
		Sum sum = (Sum) result;
		assertEquals(five, sum.augend);
		assertEquals(five, sum.addend);
		
	}
	
	@Test
	public void testReduceSum() {
		Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
	
		Bank bank = new Bank();
		Money result = bank.reduce(sum, "USD");
	
		assertEquals(Money.dollar(7), result);
	
	}
	
	
	@Test
	public void testReduceMoney() {
		Bank bank = new Bank();
		Money result = bank.reduce(Money.dollar(1), "USD");
		assertEquals(Money.dollar(1), result);
	}
	
	
	@Test
	public void testReduceMoneyDifferentCurrency() {
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		Money result = bank.reduce(Money.franc(2), "USD");
		assertEquals(Money.dollar(1), result);
	}
	
	@Test
	public void testArrayEquals() {
		//assertEquals(new Object[] {"abc"}, new Object[] {"abc"});
		assertEquals(new Object[] {"abc"}, new Object[] {"abc"});
	}
	
	@Test
	public void testIdentifyRate() {
		assertEquals(1, new Bank().rate("USD", "USD"));
	}
	
	
	@Test
	public void testMixedAddition() {
		
		Expression fiveBucks = Money.dollar(5);
		Expression tenFrancs = Money.franc(10);
		
		//bank 객체 : 두 통화간 환율을 저장하거나 가져오는 역할
		Bank bank = new Bank();

		bank.addRate("CHF","USD", 2);
		//두 통화간 환율 : 2
		
		
		Money result = bank.reduce(
				fiveBucks.plus(tenFrancs), "USD");
		//plus는 구현객체에만 있는 메서드
		//fiveBucks는 Dollar객체를 참조하지만
		//타입은 Expression이므로, 부모객체에 없는 메서드는 실행x
		//인터페이스에도 만들어주어야 한다. 
		//아니면 캐스팅을 하든가
		
		
		assertEquals(Money.dollar(10), result);
	}
	
	
	public void testSumPlusMoney() {
		Expression fiveBucks = Money.dollar(5);
		Expression tenFrnacs = Money.franc(10);
		
		Bank bank = new Bank();
		
		bank.addRate("CHF", "USD", 2);
	
		Expression sum 
			= new Sum(fiveBucks, tenFrnacs).plus(fiveBucks);
	
		Money result = bank.reduce(sum, "USD");
		
		assertEquals(Money.dollar(15), result);
	}
	
	
	public void testSumTimes() {
	
		Expression fiveBucks = Money.dollar(5);
		Expression tenFrancs = Money.franc(10);
		
		Bank bank = new Bank();
		bank.addRate("CHF", "USD", 2);
		
		Expression sum = new Sum(fiveBucks, tenFrancs).times(2);
		Money result = bank.reduce(sum, "USD");
		assertEquals(Money.dollar(20), result);
		
	}
	
	public void testPlusSameCurrencyReturnsMoney() {
		Expression sum = Money.dollar(1).plus(Money.dollar(1));
		assertTrue(sum instanceof Money);
	}
	
	
	
	
	
	/*
	@Test
	public void testFrancMultiplication() {
		Money five = Money.franc(5);
		
		assertEquals(Money.franc(10), five.times(2));
		assertEquals(Money.franc(15), five.times(3));
		
	}

	
	@Test
	public void testDifferentClassEquality() {
		assertTrue(new Money(10, "CHF").equals(
				new Franc(10, "CHF")));
	}
	
	 * */
	
	
}