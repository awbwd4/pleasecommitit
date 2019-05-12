package org.tdd.currency;

public class Franc extends Money {

	//private int amount;
	
	public Franc(int amount) {
		this.amount = amount;
	}

	public Franc times(int multiplication) {
		return new Franc(amount * multiplication);
	}

	
	/*
	public boolean equals(Object object) {
		Money money = (Money) object;
		return amount == money.amount;
	}
	 * */
	
}
