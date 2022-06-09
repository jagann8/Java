package com.hdfc.respository;

import com.hdfc.model.Account;

public class InMemoryAccountRepository implements AccountRepository{

	public InMemoryAccountRepository() {
		System.out.println("InMemoryAccountRepository instance created ....");
	}
	
	@Override
	public Account loadAccountNumber(String accountNumber) {
		System.out.println("load account number "+accountNumber);
		Account account= new Account(accountNumber,1000);
		return account;
	}
	@Override
	public void updateAccount(Account account) {
		System.out.println("updating account => "+account.getAccountNumber());
		System.out.println("current balance => "+account.getBalance());
	}
	
	
}
