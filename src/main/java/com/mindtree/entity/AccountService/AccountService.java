package com.mindtree.entity.AccountService;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.Exception;

import org.apache.log4j.Logger;

import com.mindtree.entity.Account.Account;
import com.mindtree.exception.*;

public class AccountService {
	public static int count=0;
	private static Scanner scan=new Scanner(System.in);
	public Account [] accounts=new Account[5];
	String regex = "^([a-zA-Z]+([ ][a-zA-z]*)*)+$";
	Pattern pattern = Pattern.compile(regex);
	public static final Logger LOGGER = Logger.getLogger(AccountService.class);
	
	public void createAccount(Account a) throws AccountCreationException
	{
		while(true)
		{
		try
		{
			System.out.println("Enter the Account Number");
			a.accountNo=scan.nextInt();
			if(a.accountNo>0)
			{
				for(int i=0;i<count;i++)
				{	if(accounts[i].accountNo==a.accountNo)
					{
					throw new AccountCreationException();
					}
					}
				count++;
				break;
			}
			else
			{
				LOGGER.debug("Account Number Invalid");
				System.out.println("Enter valid Account Number");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			scan.next();
		}
		}
		scan.nextLine();
		while(true)
		{
			System.out.println("Enter the Account Holder Name");
			a.customerName=scan.nextLine();
			Matcher matcher = pattern.matcher(a.customerName);
			if(matcher.matches())
			{	
				break;
			}
			else
			{
				LOGGER.debug("Customer Name Invalid");
				System.out.println("Enter the valid name");
			}
		}		
		while(true)
		{
		try
		{
			System.out.println("Enter the Balance Amount");
			a.balance=scan.nextDouble();
			if(a.balance>0)
				break;
			else
			{
				LOGGER.debug("Balance Amount Invalid");
				System.out.println("Enter Balance Amount greater than 0");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			scan.next();
		}
		}
	}
	public Account[] getAccounts() 
	{
		return accounts;
	}
	public void transferFunds(Account fromAccount,Account toAccount,double amount) throws AccountTransactionException, InsufficientBalanceException
	{
		if(amount>fromAccount.balance)
		{
			if(fromAccount.accountNo==toAccount.accountNo)
			{	
				LOGGER.debug("Account Numbers are Same");
				throw new AccountTransactionException("Account Transaction Failed");
			}
			else
			{
				LOGGER.debug("Insufficient Balance in Account");
				throw new InsufficientBalanceException("Insufficient Balance Amount");
			}
		}
		fromAccount.balance=fromAccount.balance-amount;
		toAccount.balance=toAccount.balance+amount;
	}
}
