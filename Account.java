package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity   //creates the table in the database.
public class Account {
	@Id        //responsible to create primary key
	@GeneratedValue(strategy=GenerationType.AUTO)   //responsible to create auto ids==>strategies==>GenerationType.Auto    /GenerationType.Identity
	private Long id;
	private String  accountNumber;
	private double balance;
	private String accountType;
	private long customerId;
	
	
	public Account(Long id, String accountNumber, double balance, String accountType, long customerId) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.accountType = accountType;
		this.customerId = customerId;
	}
	
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	
	

}