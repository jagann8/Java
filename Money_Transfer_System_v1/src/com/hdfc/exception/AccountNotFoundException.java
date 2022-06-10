package com.hdfc.exception;

public class AccountNotFoundException extends RuntimeException{
	
	public AccountNotFoundException(String sms) {
		super(sms);
	}
	
}