package org.tdd.currency;

public abstract class Money {

	protected int amount;

	//비교대싱이 되는 두 객체의 amount값이 같은가를 확인
	public boolean equals(Object object) {
		
		Money money = (Money) object;
		
		//System.out.println(getClass().getName());
		//System.out.println(getClass().equals(money.getClass()));
		//System.out.println();
		
		return amount == money.amount
				&& getClass().equals(money.getClass())
				;
		/*
		 * 현재 객체(new Franc(5))의 클래스와
		 * 비교대상 객체(new Dollar(5))의 클래스가 서로 동일한지 체크함.
		 * geClass().getName()을 찍어보면 Money가 아닌
		 * 각각 Franc, Dollar클래스로 나옴
		 * ==> false
		 */
	}

	public static Money dollar(int amount) {
		return new Dollar(amount);
	}

	public static Money franc(int amount) {
		return new Franc(amount);
	}
	
	public abstract Money times(int multiplication);
}
