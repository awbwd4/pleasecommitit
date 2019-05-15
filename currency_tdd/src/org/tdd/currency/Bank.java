package org.tdd.currency;

import java.util.Hashtable;

public class Bank {//환율에 관한일은 모두 bank가 처리한다. 

	//환율을 저장하기 위한 해쉬테이블
	private Hashtable rates = new Hashtable();
	
	
	
	public Money reduce(Expression source, String to) {
		//if(source instanceof Money) return (Money) source;
		
		//Sum sum = (Sum) source;
		//int amount = sum.augend.amount+sum.addend.amount;
		//return new Money(amount, to);
		return source.reduce(this, to);
	}

	//환율을 해쉬테이블에 저장
	public void addRate(String from, String to, int rate) {
		rates.put(new Pair(from, to), new Integer(rate));
		//두개의 통화 짝이 해쉬테이블의 키가 됨.
		//두 통화간 환율이 값
	}

	int rate(String from, String to) {
		
		if(from.equals(to)) return 1;
		
		Integer rate = (Integer) rates.get(new Pair(from, to));
		//해쉬테이블에 저장돼있는 각 통화간 환율을 가져옴.
		return rate.intValue();
		
		//return (from.equals("CHF") && to.equals("USD"))? 2 : 1;
	}
	
	
}
