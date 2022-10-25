package com.bk.OnlineShoppingAPI.exceptionHandler;

public class ErrorInfo {
	
	private String url;
	private String message;
	
	public ErrorInfo(String url, String msg) {
		super();
		this.url = url;
		message = msg;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
