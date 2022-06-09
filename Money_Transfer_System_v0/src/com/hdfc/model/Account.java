package com.hdfc.model;

public class Account {
	private String accountNumber;
	private double balance;
	
	
	
	public Account(double balance) {
		super();
		this.balance = balance;
	}

	public Account(String accountNumber, double balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccount(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
