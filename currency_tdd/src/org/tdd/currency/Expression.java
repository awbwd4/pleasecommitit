package org.tdd.currency;

public interface Expression {

	public Money reduce(Bank bank, String to);

	public Expression plus(Expression tenFrancs);

	public Expression times(int multiplier);

	//public Expression plus(Expression tenFrancs);

	//public Expression plus(Expression Addend);
	
}
