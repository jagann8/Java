package com.hdfc.service;
import com.hdfc.model.*;
import com.hdfc.respository.AccountRepository;

public class NEFTTransferServiceAccount implements TransferService{
	AccountRepository accountRepository;
	
	public NEFTTransferServiceAccount(AccountRepository accountRepository) {
		this.accountRepository=accountRepository;
	}
	
	@Override
	public boolean amountTransfer(double amount, String fromAccountNumber, String toAccountNumber) {
		
		Account fromAccount=accountRepository.loadAccountNumber(fromAccountNumber);
		
		Account toAccount = accountRepository.loadAccountNumber(toAccountNumber);
		
		fromAccount.setBalance(fromAccount.getBalance()-amount);
		
		toAccount.setBalance(toAccount.getBalance()+amount);
		
		accountRepository.updateAccount(fromAccount);
		
		accountRepository.updateAccount(toAccount);
		
		
		return true;
	}
	
}
