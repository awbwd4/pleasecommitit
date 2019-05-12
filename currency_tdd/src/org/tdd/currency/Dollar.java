package org.tdd.currency;

public class Dollar extends Money {

	//private int amount;

	public Dollar(int amount) {
		this.amount = amount;
	}

	public Money times(int multiplier) {
	
		return new Dollar(amount * multiplier);

	}

	
	//뭐에쓰는 메서드?
	
	
	
}
