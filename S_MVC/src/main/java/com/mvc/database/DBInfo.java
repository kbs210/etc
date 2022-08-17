package com.mvc.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBInfo {
	
	public static Connection getConnection() {
		System.out.println("DBInfo getConnection Run");
		Connection conn = null;
		
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "mvc";
			String pass = "mvc";
			conn = DriverManager.getConnection(url, id, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
