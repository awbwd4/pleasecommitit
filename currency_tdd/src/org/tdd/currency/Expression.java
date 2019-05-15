package org.tdd.currency;

public interface Expression {

	public Money reduce(Bank bank, String to);
	
}
