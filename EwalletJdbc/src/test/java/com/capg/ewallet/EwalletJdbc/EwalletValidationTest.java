package com.capg.ewallet.EwalletJdbc;



import com.capg.ewallet.bean.CustomerDetails;
import com.capg.ewallet.service.EwalletValidation;

import junit.framework.TestCase;

public class EwalletValidationTest extends TestCase {

	EwalletValidation validate = new EwalletValidation();
	CustomerDetails customer = new CustomerDetails();
	public void testValidateWithdraw() {
		
	}

	public void testValidatename() {
		
	}

	public void testValidatePhoneNumber() {
		assertEquals(true,validate.ValidatePhoneNumber("9876543210"));
		assertFalse(validate.ValidatePhoneNumber("9333"));
		assertTrue(validate.ValidatePhoneNumber("9876543210"));
		assertNotNull(validate.ValidatePhoneNumber("9876543210"));
	}

	public void testValidateage() {
		assertEquals(true, validate.Validateage(21));
		assertNotSame(false, validate.Validateage(10));
	}

	public void testValidateemail() {
		assertEquals(true,validate.Validateemail("google@gmail.com") );
		assertNotSame(false,validate.Validateemail("googlegmail.com") );
		assertNull(null, validate.Validateemail(null));
		
	}

	public void testValidatePassword() {
		assertEquals(true,validate.ValidatePassword(customer.getPassword()));
		assertNotSame(false,validate.Validateemail("pass") );
	}

}
