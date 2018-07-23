package com.capg.ewallet.service;

import com.capg.ewallet.bean.AccountDetails;
import com.capg.ewallet.dao.EwalletDao;

public class EwalletService implements IEwalletService {
	EwalletDao dao =new EwalletDao();
	public boolean createDetails(AccountDetails account) {
		// TODO Auto-generated method stub
		
		return dao.createDetails(account);
	}


	public boolean withdrawAmount(int amount) {
		// TODO Auto-generated method stub
		return dao.withdrawAmount(amount);
	}


	public boolean depositAmount(int amount) {
		// TODO Auto-generated method stub
		
		return dao.depositAmount(amount);
	}



	public boolean loginAccount(String name, String password) {
		// TODO Auto-generated method stub
		return dao.loginAccount(name, password);
	}


	public int showBalance() {
		// TODO Auto-generated method stub
		return dao.showBalance();
	}


	public void printTransaction() {
		// TODO Auto-generated method stub
		dao.printTransaction();
	}


	public boolean fundTransfer(int accountNumber, int amount) {
		// TODO Auto-generated method stub
		return dao.fundTransfer(accountNumber, amount);
	}


}
