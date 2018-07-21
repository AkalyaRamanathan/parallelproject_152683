package com.capg.ewallet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.capg.ewallet.bean.AccountDetails;


public class EwalletDao implements IEwalletDao{
AccountDetails account;
 static int accountNumber;

static int accno;
int balance;
Connection con=jdbcUtil.getConnection();
	public boolean createDetails(AccountDetails account) {
		
	Statement st;
	
		
		try {
			
			PreparedStatement 	preparedStatement1 = con.prepareStatement("insert into accountdetails values(?,?)");
			PreparedStatement 	 preparedStatement = con.prepareStatement("insert into customerdetails values(?,?,?,?,?,?)");
			st=con.createStatement();
			
			
			

			preparedStatement.setString(1,account.getDetails().getName() );
		
		
		preparedStatement.setString(2,account.getDetails().getPassword() );
		preparedStatement.setString(3,account.getDetails().getPhoneNumber() );
		
		preparedStatement.setInt(4,account.getDetails().getAge() );
		preparedStatement.setString(5,account.getDetails().getEmail() );
	    preparedStatement.setInt(6, account.getAccountNumber());	
		
		
		preparedStatement1.setInt(1,account.getBalance());
		preparedStatement1.setInt(2,account.getAccountNumber());
	
		preparedStatement.execute();
		preparedStatement1.execute();
		
		
		con.close();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
public boolean loginAccount(String name, String password) {
	Statement stmt;

	try {
		
		stmt=con.createStatement();
		
	 
		
		
		
	String query="select customerdetails.name,customerdetails.password,customerdetails.accountNumber from customerdetails,accountdetails where customerdetails.accountNumber=accountdetails.accountNumber";
	stmt.executeQuery(query);
	ResultSet rs=stmt.getResultSet();
		
		while(rs.next())
		{
		
		String name1=rs.getString("name");
			String password1=rs.getString("password");
			if(name1.equals(name) && password1.equals(password)) {
				
			accno=rs.getInt("accountNumber");
			
			con.close();
				return true;
			}
		}
		
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return false;
		
		
	}

	public int showBalance() {
		try {
		Statement stmt;
		accountNumber=accno;
		stmt = con.createStatement();
		String query="select* from accountdetails where accountNumber='"+accountNumber+"'";
		
		ResultSet rs;
		
			rs = stmt.executeQuery(query);
		
		while(rs.next()) {
			balance=rs.getInt("balance");
		}
		System.out.println("balance is"+balance);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return 0;
		
		
		
		
	}

	public boolean depositAmount(int amount) {
		
		 accountNumber=accno;

		try {
			
			
			String deposit= "The Amount" + amount + "is Deposited '"+accountNumber+"'\n";
		    String insertquery ="Insert into transactions values(?,?)";
			String query="update accountdetails set balance=balance+? where accountNumber=?";
			
			PreparedStatement ps=con.prepareStatement(query);
			
		    ps.setInt(1, amount);
	        ps.setInt(2,accountNumber);
	        
			System.out.println(accountNumber);
			ps.execute();
			
			
		 PreparedStatement ps4=con.prepareStatement(insertquery);
	
		 ps4.setString(1, deposit);
		 
		  ps4.setInt(2,accountNumber);
		System.out.println(accountNumber);
		
		  ps4.executeUpdate();
		  
		   
			
return true;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return false;
		
	}

	public boolean withdrawAmount(int amount) {
		Statement stmt;
		//Connection con=jdbcUtil.getConnection();
		
		accountNumber=accno;
		try {
			stmt=con.createStatement();
			String withdraw= "The Amount" + amount + "is withdraw '"+accountNumber+"'\n";
		   String insertquery ="Insert into transactions values(?,?)";
			String query="select * from accountdetails where accountNumber='"+accountNumber+"'";
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				balance = rs.getInt("balance");
			}
			if(balance > amount)
			{
				String Query="update accountdetails set balance=balance-? where accountNumber=?";
				
			
			PreparedStatement ps=con.prepareStatement(Query);
			ps.setInt(1, amount);
			ps.setInt(2,accountNumber);
			
			PreparedStatement ps1=con.prepareStatement(insertquery);
		
	       ps1.setString(1,withdraw);
	       ps1.setInt(2, accountNumber);
			//System.out.println(accountNumber);
		    ps.execute();
		    ps1.executeUpdate();
			con.close();
			return true;
			}	
			

		}catch (Exception e) {
			// TODO: handle exception
		}
		return false;
		
		
	}
	public boolean fundTransfer(int accountNumber2, int amount) {
		
		//Connection con=jdbcUtil.getConnection();
		 accountNumber=accno;
		 Statement stmt;
			try {
				
				String fdt= "The Amount" + amount + "is Transfered"+accountNumber2;
			String insertquery ="Insert into transactions values(?,?)";
				String query="update accountdetails set balance=balance+? where accountNumber=?";
				
				PreparedStatement ps=con.prepareStatement(query);
				
				ps.setInt(1, amount);
			
				ps.setInt(2,accountNumber2);
			
				ps.executeUpdate();
				 stmt=con.createStatement();
				String query2="select * from accountdetails where accountNumber='"+accountNumber+"'";
				ResultSet rs=stmt.executeQuery(query2);
				while(rs.next())
				{
					balance = rs.getInt("balance");
				}
				if(balance > amount)
				{
					String Query="update accountdetails set balance=balance-? where accountNumber=?";
					
				
				PreparedStatement ps2=con.prepareStatement(Query);
				ps2.setInt(1, amount);
				ps2.setInt(2,accountNumber);
				ps2.executeUpdate();
				
				PreparedStatement ps3=con.prepareStatement(insertquery);
				
				ps3.setString(1,fdt);
				ps3.setInt(2,accountNumber);
				ps3.executeUpdate();
			     con.close();
				return true;
				}	

				else {
					System.out.println("cant transfer");
				}
				
		
				con.close();
	
			}catch (Exception e) {
				// TODO: handle exception
			}
		
		
		return false;
	}
	public void printTransaction() {
		accountNumber=accno;
		try {
			 Statement stmt;
			 stmt=con.createStatement();
				String query="select * from transactions where accountNumber='"+accountNumber+"'";
				ResultSet rs=stmt.executeQuery(query);
				while(rs.next()) {
					System.out.println();
					String details=rs.getString("transaction_info");
					System.out.println("the transactions are"+details);
				}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
