package com.hdfc;


import com.hdfc.respository.AccountRepository;
import com.hdfc.respository.InMemoryAccountRepository;
import com.hdfc.service.NEFTTransferServiceAccount;
import com.hdfc.service.TransferService;

public class App {
		
	public static void main(String[] args) {
		
		AccountRepository accountRepository=new InMemoryAccountRepository();
		
		TransferService service= new NEFTTransferServiceAccount(accountRepository);
		
		System.out.println("Transfer Initiated ....");
		service.amountTransfer(300, "1", "2");
		System.out.println("Transfer Completed ....");
		
		
	}
	
}
