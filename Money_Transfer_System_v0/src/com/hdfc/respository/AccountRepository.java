package com.hdfc.respository;

import com.hdfc.model.Account;

public interface AccountRepository {
	
	Account loadAccountNumber(String accountNumber);
	public void updateAccount(Account account);
	
}
