package com.java.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {

	public static Connection getConnection() {

		Connection conn = null;

		try {

			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe"; // 오라클 버전에 따라 마지막이 다름 :xe, :orcl 등
			String id = "mvc";
			String pass = "mvc";

			conn = DriverManager.getConnection(url, id, pass);

		} catch (Exception e) {

		}

		return conn;
	}
}
