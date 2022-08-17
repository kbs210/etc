package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Example_05")
public class Example_05 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	

	
	protected void  getPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int first_no = Integer.parseInt(request.getParameter("first_no")); 
		String sign = request.getParameter("sign");
		int second_no = Integer.parseInt(request.getParameter("second_no")); 
		
		String result = "";
		
		if(sign.equals("+")) {
			result = String.valueOf(first_no + second_no);
		} else if (sign.equals("-")) {
			result = String.valueOf(first_no - second_no);
		} else if (sign.equals("/")) {
			result = String.valueOf(first_no / second_no);
		} else if (sign.equals("%")) {
			result = String.valueOf(first_no * second_no);
		}
		
		System.out.println(result);
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		
		out.print("<head><title>사칙연산</title></head>");
		out.print("<body>");
		
		out.print("<h3>결과 : " + result + "</h3>");
		
		out.print("</body>");
		out.print("</html>");
	}

}













