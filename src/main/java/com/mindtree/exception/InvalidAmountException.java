package com.mindtree.exception;

public class InvalidAmountException extends BankingApplicationException{
	private static final long serialVersionUID = 1L;

	public InvalidAmountException(String s)
	{
		super(s);
	}
	public InvalidAmountException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidAmountException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public InvalidAmountException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public InvalidAmountException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
}
