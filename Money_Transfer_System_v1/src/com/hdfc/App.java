package com.hdfc;


import java.util.logging.Logger;

import com.hdfc.exception.*;
import com.hdfc.respository.AccountRepository;
import com.hdfc.respository.InMemoryAccountRepository;
import com.hdfc.respository.JdbcAccountRepository;
import com.hdfc.service.TransferService;
import com.hdfc.service.TransferServiceImpl;

public class App {
	
	private static final Logger LOGGER=Logger.getLogger("mts"); // singleton object
	public static void main(String[] args) {
		
	//---------------------------------------------------------------	
	// init	
	//---------------------------------------------------------------
		
	AccountRepository inMemoryAccountRepository=new InMemoryAccountRepository();
	AccountRepository jdbcAccountRepository=new JdbcAccountRepository();
	
	TransferService transferService=new TransferServiceImpl(jdbcAccountRepository);
	System.out.println("-".repeat(50));
	
	
	//------------------------------------------------------------------
	// use
	//------------------------------------------------------------------
	
	try {
		transferService.amountTransfer(2500, "1", "2");
	}catch(AccountNotFoundException e) {
		LOGGER.info("Transfer Failed "+e.getMessage());
	}
	
	
	System.out.println("-".repeat(50));
	
	}
	
}