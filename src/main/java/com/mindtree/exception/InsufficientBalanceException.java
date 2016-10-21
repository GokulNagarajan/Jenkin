package com.mindtree.exception;

public class InsufficientBalanceException extends BankingApplicationException{
	private static final long serialVersionUID = 1L;

	public InsufficientBalanceException(String s)
	{
		super(s);
	}

	public InsufficientBalanceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InsufficientBalanceException(String arg0, Throwable arg1,
			boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public InsufficientBalanceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public InsufficientBalanceException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
}
