package com.java.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Example_03")
public class Example_03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = request.getParameter("msg");
		System.out.println("doGet : " + msg);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String msg = request.getParameter("msg");
		System.out.println("doPost : " + msg);
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service() 실행");
		doPost(request, response);
	}
	
	public void destroy() {
		System.out.println("destroy() 실행");
		System.out.println("destroy() 실행");
	}
	
	public void init() throws ServletException{
		System.out.println("init() 실행");
	}
}
