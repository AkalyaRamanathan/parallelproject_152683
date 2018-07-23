package com.capg.ewallet.EwalletJdbc;



import com.capg.ewallet.bean.CustomerDetails;

import junit.framework.TestCase;

public class CustomerDetailsTest extends TestCase {
	CustomerDetails customer = new CustomerDetails();
	public void testGetAmount() {
		assertNotSame(100,500 );
		assertNull(null, customer.getAmount());
		
	}

	

	public void testGetName() {
		
		assertEquals("abc", customer.getName());
		assertNotSame("b9ht", customer.getName());
		
		
}


	public void testGetPhoneNumber() {
		assertNotSame(0, customer.getPhoneNumber());
		assertEquals("9876543210", "9876543210");
		
	}

	

	public void testGetPassword() {
		
		
		assertNotSame("k@m", customer.getPassword());
		assertNull(null);
	}

	

	public void testGetAge() {
		assertEquals(22, customer.getAge());
		assertNotSame("ten", customer.getAge());
		
		
	}

	

	public void testGetEmail() {
		
		assertNotSame("k@m", customer.getEmail());
		assertNull(customer.getEmail());
	}

	

	
}
