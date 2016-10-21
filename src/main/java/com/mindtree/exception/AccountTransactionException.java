package com.mindtree.exception;

public class AccountTransactionException extends BankingApplicationException{
	private static final long serialVersionUID = 1L;

	public AccountTransactionException(String s)
	{
		super(s);
	}

	public AccountTransactionException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountTransactionException(String arg0, Throwable arg1,
			boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public AccountTransactionException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public AccountTransactionException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
}
