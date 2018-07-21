package com.capg.ewallet.ui;

import java.util.Scanner;

import com.capg.ewallet.bean.AccountDetails;
import com.capg.ewallet.bean.CustomerDetails;
import com.capg.ewallet.service.EwalletService;
import com.capg.ewallet.service.EwalletValidation;

public class Ewallet {
	static boolean a;
	static boolean b;

	public static void main(String[] args) {
		int choice = 0;
		int amount =0;
		

		do {
			int choice1;
			Scanner scan = new Scanner(System.in);
			System.out.println("              WELCOME                     ");
			System.out.println("*****************************************");
			System.out.println("        1.CREATE ACCOUNT              ");
			System.out.println("        2.already have an account then LOGIN  ");
			System.out.println("*****************************************");

			
			choice= scan.nextInt();
			switch(choice)
			{
			case 1:
				//createAccount();
				EwalletService service = new EwalletService();
				EwalletValidation validate = new EwalletValidation();
				AccountDetails account = new AccountDetails();

				CustomerDetails customer = new CustomerDetails();
				
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter UserName");
				String name = sc.nextLine();
				System.out.println("enter Password that should contain minimum 6 letters");
				String password = sc.nextLine();
				System.out.println("Enter PhoneNumber");
				String phoneNumber= sc.nextLine();
				System.out.println("Enter Age");
				int age=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Email");
				String email=sc.nextLine();
				System.out.println("enter initial Balance");
				int balance=sc.nextInt();
				sc.nextLine();
				
				int accountNumber = (int)(Math.random() * 123456+123456);
				
				boolean validname=validate.Validatename(name);
				boolean validepassword=validate.ValidatePassword(password);
				boolean validnum=validate.ValidatePhoneNumber(phoneNumber);
				boolean validage=validate.Validateage(age);
				boolean validemail=validate.Validateemail(email);
				
				customer.setName(name);
				customer.setPassword(password);
				customer.setPhoneNumber(phoneNumber);
				customer.setAge(age);
				customer.setEmail(email);
				account.setAccountNumber(accountNumber);
				customer.setAmount(amount);
				account.setBalance(balance);
				account.setDetails(customer);
				if(validname && validepassword && validnum && validage && validemail) {
					
					a=service.createDetails(account);
					System.out.println("Created Successfully");
					System.out.println("Your AccountNumber is"+accountNumber);
					System.out.println("Your UserName is: "+name);
					System.out.println("Your Password is :"+password);
					
				}
				else
				{
					System.out.println("Invalid");
				
					System.err.println("account not created");
			}
		
				break;
				
			case 2:
				EwalletService service1 = new EwalletService();
				Scanner s = new Scanner(System.in);
				System.out.println("Enter Your Username");
				name = s.nextLine();
				System.out.println("Enter Your Password");
				password = s.nextLine();
				
				b= service1.loginAccount(name, password);
				System.out.println(b);
				if(b)
				{
					System.out.println("LOGINED SUCCESSFULLY");
				} 
				
				if(b)
			
				{
					do {
						
						System.out.println("*****************************************");
						System.out.println("           1)Deposit Amount              ");
						System.out.println("           2)Withdraw Amount             ");
						System.out.println("           3)Show Balance                ");
						System.out.println("           4)Transfer Money              ");
						System.out.println("           5)Print Transactions          ");
						System.out.println("           6)Exit                        ");
						System.out.println("*****************************************");

						
						System.out.println("Enter Your Choice");
						
						choice1 = scan.nextInt(); 
						
						switch(choice1)
						{
						
						
							
						case 1:
							EwalletService service3 = new EwalletService();
							System.out.println(" DEPOSIT");
							Scanner scan1 = new Scanner(System.in);
							
							System.out.println("Enter amount to deposit");
							amount = scan1.nextInt();
							boolean isDeposit = service3.depositAmount(amount);
							
							if(isDeposit)
							{
								System.out.println("Amount Deposited in your account");
							}
							else {
								System.out.println("not deposited");
							}
							//account.setBalance(balance);
							break;
							
						case 2 : 
							EwalletService service4 = new EwalletService();
							System.out.println("WITHDRAW");
							Scanner scan2 = new Scanner(System.in);

							System.out.println("Enter amount to withdraw");
							amount = scan2.nextInt();
							boolean isWithdraw = service4.withdrawAmount(amount);
							
							if(isWithdraw)
							{
								System.out.println("Amount Withdrawed from your account");
							}
							break;
							
						case 3 : 
							EwalletService service5 = new EwalletService();
							System.out.println("BALANCE DETAILS");
							balance = service5.showBalance();
							
							break;
							
						case 4:
							System.out.println("FUND TRANSFER");
							Scanner scn = new Scanner(System.in);
							System.out.println(" Enter Account Number to transfer amount");
							accountNumber = scn.nextInt();
							System.out.println("Enter Amount to Transfer");
							amount = scn.nextInt();
							scn.nextLine();
							EwalletService service6 = new EwalletService();
							System.out.println("fund");
							boolean b1= service6.fundTransfer(accountNumber,amount);
							if(b1)
							{
								System.out.println("Fund Successfully Transfer");
							}
							else
							{
								System.out.println("Enter Correct Input");
							}
							break;
							
						case 5:
							EwalletService service7 = new EwalletService();
							System.out.println("PRINT TRANSACTION");
							service7.printTransaction();
							break;
							
						case 6 :
							
							break;
						
						
						}
					
					}while(choice1!=6);
					
					
				}
				
				else
				{
					System.out.println("Invalid  Details..Try Again..");
				}
			break;
			
			
			}
		}while(choice!=3);
	}
}
