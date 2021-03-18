package com.java.database;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;

public class DBCPInit extends HttpServlet{

	private static final long serialVersionUID = -1518387793656085229L;

	public void init(ServletConfig config) {
		try {
			String jdbcDriver = config.getInitParameter("jdbcDriver");
			Class.forName(jdbcDriver);
		} catch (Exception e) {

		}
		
	}
	
}
