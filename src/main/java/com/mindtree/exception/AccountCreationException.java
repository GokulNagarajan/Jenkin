package com.mindtree.exception;

public class AccountCreationException extends BankingApplicationException{

	private static final long serialVersionUID = 1L;

	public AccountCreationException(String s)
	{
		super(s);
	}
	public AccountCreationException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountCreationException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public AccountCreationException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public AccountCreationException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
}
