package com.capg.ewallet.bean;

public class CustomerDetails {
	private String name;
	private String phoneNumber;
	private String password;
	


	private int amount;
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	private int age;
	
	private String email;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "CustomerDetails [name=" + name + ", phoneNumber=" + phoneNumber + ", password=" + password + ", amount="
				+ amount + ", age=" + age + ", email=" + email + "]";
	}
	

}



