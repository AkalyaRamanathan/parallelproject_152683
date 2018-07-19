package com.capg.ewallet.service;

public class EwalletValidation {
	public boolean ValidateWithdraw(int amount, int balance) {
		// TODO Auto-generated method stub
		if(amount<balance)
		{
			
			return true;
		}
		return false ;
	}


	public boolean Validatename(String name) {
		// TODO Auto-generated method stub
		if(name.matches("[a-zA-Z][a-zA-Z]*")) {
		return true;
		}
		return false;
	}

	public boolean ValidatePhoneNumber(String phoneNumber) {
		// TODO Auto-generated method stub
		if(phoneNumber.length()==10) {
		return true;
		}
		return false;
	}

	public boolean Validateage(int age) {
		// TODO Auto-generated method stub
		if(age>18){
			return true;
		}
		
		return false;
	}

	public boolean Validateemail(String email) {
		// TODO Auto-generated method stub
		if(email.contains("@") && email.contains(".") && email.contains("com")) {
			return true;
		}
		return false;
	}

	public boolean ValidatePassword(String password) {
		// TODO Auto-generated method stub
		if(password.length()>5) {
			return true;
		}
		return false;
	}


	
	

}
