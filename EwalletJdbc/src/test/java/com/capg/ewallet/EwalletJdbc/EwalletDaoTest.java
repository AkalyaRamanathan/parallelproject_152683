package com.capg.ewallet.EwalletJdbc;



import com.capg.ewallet.bean.AccountDetails;
import com.capg.ewallet.dao.EwalletDao;

import junit.framework.TestCase;

public class EwalletDaoTest extends TestCase {


	AccountDetails account =new AccountDetails();
	EwalletDao dao = new EwalletDao();
		public void testLoginAccount() {
			assertEquals("result", 0, 0);
		}

		public void testCreateDetails() {
			assertEquals("result", 0, 0);
			assertEquals("username","username" );
		}

		public void testShowBalance() {
			assertEquals("result", 0, 0);
			assertNotSame("13000","14500" );
			assertNotSame("101",account.getDetails().getAmount());
		}

		public void testDepositAmount() {
			assertEquals("result", 0, 0);
			assertNotSame("13000","14500" );
			assertNotSame("101",account.getDetails().getAmount());
		}

		public void testWithdrawAmount() {
			assertEquals("result", 0, 0);
			assertNotSame("13000","14500" );
			assertNotSame("101",account.getDetails().getAmount());
		}

		public void testFundTransfer() {
	         assertEquals("result", 0, 0);
			
			assertNotSame("21000","12500" );
			assertNotSame("101",account.getAccountNumber());
			
		}

		public void testPrintTransaction() {
			 assertEquals("result", 0, 0);
				
				assertNotSame("21000","12500" );
				assertNotSame("101",account.getAccountNumber());
		}

	}

