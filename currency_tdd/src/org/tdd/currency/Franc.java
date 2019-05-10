package org.tdd.currency;

public class Franc extends Money {

	//private int amount = 0;
	
	
	public Franc(int amount) {
		this.amount = amount;
	}

	public Franc times(int multiplier) {
		return new Franc(amount*multiplier);
	}

	/*
	public boolean equals(Object object) {

		Franc franc = (Franc) object;
		return amount == franc.amount;
		
	}
	*/
	
	
}
