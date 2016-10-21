package com.mindtree.entity.Account;
import org.apache.log4j.Logger;

import com.mindtree.exception.*;

public class Account {
	public int accountNo;
	public String customerName;
	public double balance;
	public static final Logger LOGGER = Logger.getLogger(Account.class);
	
	public Account()
	{
		accountNo=0;
		customerName="";
		balance=0;
	}
	public Account(int accno,String custname,double bal)
	{
		accountNo=accno;
		customerName=custname;
		balance=bal;
	}
	
	public void deposit(double amount) throws InvalidAmountException
	{
		if(amount<1)
		{
			LOGGER.debug("Balance Amount Invalid");
			throw new InvalidAmountException("Invalid Amount");
		}
		this.balance+=amount;
	}
	public void withdraw(double amount) throws InvalidAmountException,InsufficientBalanceException
	{
		if(amount<1)
		{
			LOGGER.debug("Balance Amount Invalid");
			throw new InvalidAmountException("Invalid Amount");
		}
		else if(amount>this.balance)
		{
			LOGGER.debug("Insufficient Balance in Account");
			throw new InsufficientBalanceException("Insufficient Balance amount");
		}
		this.balance-=amount;
	}
	public double getBalance()
	{
		return this.balance;
	}
}
