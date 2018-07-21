package com.capg.ewallet.dao;

import com.capg.ewallet.bean.AccountDetails;

public interface IEwalletDao {
	public boolean loginAccount(String userName,String password);

	boolean createDetails(AccountDetails account);
	public int showBalance();
	public boolean depositAmount(int amount);
	public boolean withdrawAmount(int amount);
	public boolean fundTransfer(int accountNumber,int amount);
	public void printTransaction();



}
