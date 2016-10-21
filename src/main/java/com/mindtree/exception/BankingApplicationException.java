package com.mindtree.exception;

public class BankingApplicationException extends Exception{
	public BankingApplicationException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankingApplicationException(String arg0, Throwable arg1,
			boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public BankingApplicationException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public BankingApplicationException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	public BankingApplicationException(String s) {
		super(s);
	}

}
