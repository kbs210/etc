package com.kitri.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;

@Service
public class AccountService {
	
	@Autowired
	AccountDAO dao;
	
	@Autowired
	PlatformTransactionManager transactionManager;
	
	
	public void transfer(int money, String accountNum) throws Exception{
		
		dao.withdraw(money, "1234-5678");
		
		//System.out.println(dao.transferring());
		
		dao.deposit(money, accountNum);
		System.out.println(dao.transferOk());
		
		
	}
	
}
