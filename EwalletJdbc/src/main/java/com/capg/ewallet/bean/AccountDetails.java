package com.capg.ewallet.bean;

public class AccountDetails {
	private int  balance;
	private int accountNumber;
	private CustomerDetails details;
	
	public CustomerDetails getDetails() {
		return details;
	}
	public void setDetails(CustomerDetails details) {
		this.details = details;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	@Override
	public String toString() {
		return "AccountDetails [balance=" + balance + ", accountNumber=" + accountNumber + ", details=" + details + "]";
	}


}
