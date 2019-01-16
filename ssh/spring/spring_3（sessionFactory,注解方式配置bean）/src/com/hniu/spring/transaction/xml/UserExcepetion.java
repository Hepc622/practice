package com.hniu.spring.transaction.xml;

public class UserExcepetion extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public UserExcepetion() {
		System.out.println("账户余额不足！");
	}

	public UserExcepetion(String message, Throwable cause) {
		super(message, cause);
	}

	public UserExcepetion(String message) {
		super(message);
	}

	public UserExcepetion(Throwable cause) {
		super(cause);
	}
	
	
}
