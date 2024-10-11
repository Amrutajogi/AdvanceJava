package com.sunbeam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbutil {
	//create connection
	public static final String DB_DRIVER ="com.mysql.cj.jdbc.Driver";
	public static final String DB_URL="jdbc:mysql://localhost:3306/classworkdb";
	public static final String DB_USER="W3_87380_Amruta";
	public static final String DB_PASSWD="manager";
	
	
	
	//load and register driver
	
	static {
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws Exception {
	Connection con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWD);
	return con;
	}
}
