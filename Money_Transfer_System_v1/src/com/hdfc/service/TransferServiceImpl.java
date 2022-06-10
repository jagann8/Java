package com.hdfc.service;

import java.util.logging.Logger;

import com.hdfc.exception.AccountNotFoundException;
import com.hdfc.model.Account;
import com.hdfc.respository.AccountRepository;

public class TransferServiceImpl implements TransferService {

	private static final Logger LOGGER=Logger.getLogger("mts");
	
	// dependency
	private AccountRepository accountRepository;
	
	//dependency injection
	public TransferServiceImpl(AccountRepository accountRepository) {
		this.accountRepository=accountRepository;
		LOGGER.info("TransferService instance created ...");
	}
	
	@Override
	public void amountTransfer(double amount, String sourceAccountNumber, String tagetAccountNumber) {
		LOGGER.info("transfer initiated ...");
		
		// load accounts
			Account sourceAccount = accountRepository.loadAccountNumber(sourceAccountNumber)
					.orElseThrow(()-> new AccountNotFoundException("account not found "+sourceAccountNumber));
		
			Account targetAccount=accountRepository.loadAccountNumber(tagetAccountNumber)
					.orElseThrow(()->new AccountNotFoundException("account not found "+tagetAccountNumber));
		// debit & credit
				
				sourceAccount.setBalance(sourceAccount.getBalance()-amount);		
				targetAccount.setBalance(targetAccount.getBalance()+amount);		
				
				// updating the transaction details.
				
				accountRepository.updateAccount(sourceAccount);
				
				accountRepository.updateAccount(targetAccount);
				
				LOGGER.info("Transaction Completed Successfully...");
	}
	
	
}
