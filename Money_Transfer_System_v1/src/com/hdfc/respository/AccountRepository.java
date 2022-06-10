package com.hdfc.respository;

import java.util.Optional;

import com.hdfc.model.Account;

public interface AccountRepository {
	
	public	Optional<Account> loadAccountNumber(String accountNumber);
	public void updateAccount(Account account);
	
}
