package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
	@Autowired
	private Accountdao accountdao;
	
	public Account createAc(Account account) {
		return accountdao.save(account);
	}
	
	public Account  AccountByAcNo(String AccountNo) {
		return accountdao.findByAccountNumber(AccountNo);
	}
	public double deposit(String AccountNo,double amount) {
		
		Account account=accountdao.findByAccountNumber(AccountNo);
	    account.setBalance(account.getBalance()+amount);
	    accountdao.save(account);
	    return account.getBalance();
		
	}
	
	public double withdraw(String AccountNo,double amount) 
	{
		
		Account account=accountdao.findByAccountNumber(AccountNo);
		account.setBalance(account.getBalance()-amount);
		accountdao.save(account);
		return account.getBalance();
	}
	public List<String> getAllAccountNumbers() {
	    List<String> accountNumbers = new ArrayList<>();
	    Iterable<Account> accounts = accountdao.findAll();
	    for (Account account : accounts) {
	        accountNumbers.add(account.getAccountNumber());
	    }
	    return accountNumbers;
	}
	public Iterable<Account> getAllAccountsDetails() {
	    return  accountdao.findAll(); 
	}

}