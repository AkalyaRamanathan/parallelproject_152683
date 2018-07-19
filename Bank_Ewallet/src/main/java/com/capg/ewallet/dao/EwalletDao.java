package com.capg.ewallet.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.capg.ewallet.bean.AccountDetails;
import com.capg.ewallet.bean.CustomerDetails;

public class EwalletDao implements IEwalletDao{
	//static HashMap<String, CustomerDetails> map = new HashMap<String, CustomerDetails>();
	static HashMap<String, AccountDetails> map1 = new HashMap<String, AccountDetails>();
	// public static  List<String> transactions= new ArrayList<String>();
static List<String> trans =new ArrayList<String>();
	//CustomerDetails customer = new CustomerDetails();
	//static CustomerDetails acc;
	static  AccountDetails acc1 ;

	public boolean loginAccount(String name, String password) {
		// TODO Auto-generated method stub
		for(String key : map1.keySet())
		{
			acc1=map1.get(key);
			
			if(acc1.getDetails().getName().equals(name) && acc1.getDetails().getPassword().equals(password))
			{
				return true;
			}
		}
		return false;
		
	}


	public boolean createDetails(AccountDetails account) {
		// TODO Auto-generated method stub
		map1.put(account.getDetails().getName(), account);
		//map1.put(account.getDetails().getPassword(), account);
		


		return true;
	}

	public int showBalance() {
		// TODO Auto-generated method stub
		return acc1.getBalance();
	}

	public boolean depositAmount(int amount) {
		// TODO Auto-generated method stub

	    acc1.setBalance(acc1.getBalance()+amount);
		System.out.println(acc1.getBalance());
		System.out.println(map1);
		String dep="THE AMOUNT "+amount+"IS DEPOSITED TO UR ACCOUNT";
		trans.add(dep);
		
	
		return true;
	}

	public boolean withdrawAmount(int amount) {
		// TODO Auto-generated method stub
		
		if(acc1.getBalance() >= (amount))
		{
			acc1.setBalance(acc1.getBalance()-amount);
			String with="THE AMOUNT "+amount +"IS WITHDRAWN";
			trans.add(with);
			return true;
		}
		else
		{
			System.out.println("Minimum balance should be maintained");
		}
		return false;
	}

	public boolean fundTransfer(int accountNumber, int amount) {
		// TODO Auto-generated method stub
		for(String key : map1.keySet())
		{    
			System.out.println("for loop");
			//AccountDetails ac = map1.get(key);
			AccountDetails ac1 = map1.get(key);
			//System.out.println(map);
			System.out.println(map1);
			//if(ac.getAccountNum()==accountNumber)
			if(ac1.getAccountNumber()==accountNumber)
			{
				System.out.println("if");
				ac1.setBalance(ac1.getBalance()+amount);
				System.out.println(acc1);
				
				acc1.setBalance(acc1.getBalance()-amount);
				System.out.println(acc1);
				String fd="THE AMOUNT "+amount+"IS TRANSFERED TO ACCOUNT NUMBER"+accountNumber;
				trans.add(fd);
				return true;
			}
			else {
				System.out.println("no id");
			}
		}
		return false;
	}

	public void printTransaction() {
		// TODO Auto-generated method stub
		System.out.println(trans);


		
	}
	}	


