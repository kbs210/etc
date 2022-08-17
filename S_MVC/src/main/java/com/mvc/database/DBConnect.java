package com.mvc.database;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DBConnect")
public class DBConnect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DBConnect() {
        super();
    }
    
    public void init(ServletConfig config) {
    	System.out.println();
    	System.out.println("DBConnection init Run");
    	String j = config.getInitParameter("j");
    	System.out.println("String j : " + j);
    	try {
			Class.forName(j);
			System.out.println("Class.forName(jdbcDriver) : " + Class.forName(j));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
