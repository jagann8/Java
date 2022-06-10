package com.hdfc.respository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

import com.hdfc.model.Account;

public class InMemoryAccountRepository implements AccountRepository{

	private static final Logger LOGGER=Logger.getLogger("mts");
	
	// common for SQL/ postgresql
	
	private Map<String,Account> inMemoryAccounts=new HashMap<>();
	
	public InMemoryAccountRepository() {
		inMemoryAccounts.put("1", new Account("1",1000.00));
		inMemoryAccounts.put("2", new Account("2",1000.00));
		
		LOGGER.info("Account inMemoryRepository instance created ....");
	}
	
	public Optional<Account> loadAccountNumber(String number){
		LOGGER.info("loading account -"+number);
		Account account=inMemoryAccounts.get(number);
		if(account==null) {
			return Optional.empty();
		}else {
			return Optional.of(account);
		}
	}
	
	public void updateAccount(Account account) {
		LOGGER.info("updating account -"+account.getAccountNumber());
		String accNumber=account.getAccountNumber();
		inMemoryAccounts.put(accNumber, account);
	}
}
