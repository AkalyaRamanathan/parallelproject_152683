package com.capg.ewallet.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class jdbcUtil {
	static	Connection con ;
	public static Connection getConnection() {
		

		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ewalletjdbc","root","Capgemini@123");
					
		}
		catch (Exception e) {
			// TODO: handle exception
			
		}
		return con;
		
	}
}
