package com.bk.OnlineShoppingAPI.order;

@SuppressWarnings("serial")
public class InvalidOrderException extends Exception{

	public InvalidOrderException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidOrderException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public InvalidOrderException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidOrderException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidOrderException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
