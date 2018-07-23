package com.capg.ewallet.EwalletJdbc;



import com.capg.ewallet.bean.AccountDetails;

import junit.framework.TestCase;

public class AccountDetailsTest extends TestCase {
AccountDetails account=new AccountDetails();
	public void testGetDetails() {
		
		assertNotSame(1, account.getDetails());
		
		assertEquals(null, account.getDetails());
		
		assertNull(account.getDetails());
		
	}

	public void testGetBalance() {
		
		assertNull( account.getBalance());
		
		assertNotSame(1, account.getBalance());
		
	}

	
	public void testGetAccountNumber() {
		
		assertNotSame(1, account.getAccountNumber());
		
		assertNull(account.getAccountNumber());
		
	}

	

	
}

