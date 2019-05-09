package br.com.guilherme;

public class Account {

	private double balance = 0;

	public double getBalance() {
		// TODO Auto-generated method stub
		return balance;
	}

	public void deposit(double amount) {
		this.balance += amount;
	}

	public void withDraw(double amount) {
	
		if (balance < amount) {
			throw new IllegalArgumentException("잔액 부족");
		}
		
		
		this.balance -= amount;
	}



}
