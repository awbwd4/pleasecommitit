package br.com.guilherme;

import org.junit.Test;
import org.junit.Assert.*;
import static org.junit.Assert.assertEquals;


public class Account_Test {

	//계좌가 0인지 확인
	@Test
	public void shouldHaveZeroBalanceAfterOpeninigANewAcount() {
		Account account = new Account();
		double current = account.getBalance();
		
		
	}
	
	
	//계좌에 입금하기
	@Test
	public void shouldAddMoneyAfterDeposit() {
		Account account = new Account();

		account.deposit(123.45);
		assertEquals(123.45, account.getBalance(), 0.000001);//마지막 파라미터는 허용가능한 오차범위
		
		account.deposit(200.00);
		assertEquals(323.45, account.getBalance(), 0.000001);//마지막 파라미터는 허용가능한 오차범위

	}

	
	//인출하기
	@Test
	public void shouldSubtractAmountAfterWithDraw() {
	
		Account account = new Account();
		account.deposit(100);
		account.withDraw(40);
		
		assertEquals(60, account.getBalance(), 0.00001);
		
		
	}
	
	
	//출금하려는데 돈이 없을 경우
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionWhenThereIsNotEnoughMoney() {
		
		Account account = new Account();
		account.deposit(40);
		account.withDraw(100);
		
	}
	
	
}
