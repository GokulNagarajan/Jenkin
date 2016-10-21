package com.mindtree.entity.Account;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mindtree.exception.InsufficientBalanceException;
import com.mindtree.exception.InvalidAmountException;

public class AccountTest {
	Account a=new Account(10901,"gokul",5000);
	@Test
	public void testDeposit() throws InvalidAmountException {
		a.deposit(2500);
		assertEquals(7500, a.balance, 0);
	}

	@Test
	public void testWithdraw() throws InvalidAmountException, InsufficientBalanceException {
		a.withdraw(2000);
		assertEquals(3000, a.balance, 0);
	}

}
