package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Gugudan")
public class Gugudan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	int cnt;
	
	public void init() {
		cnt = 0;
	}
	public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cnt++;
		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();		

		out.print("<html>");
		out.print("<body>");

		out.print("<table border='2px solid black'>");
		for(int i = 1; i<=9; i++) {
			out.print("<tr border='2px solid black'>");
			for(int j = 2; j<=9; j++) {
				if(j%2 == 0) {
					out.print("<td style='background:pink'; align='center'>" + j + "*" + i + " = " + j*i + "</td>");
				} else {
					out.print("<td style='background:skyblue'; align='center'>" + j + "*" + i + " = " + j*i + "</td>");
				}
			}
			out.print("</tr>");
		}
		out.print("</table>");
		out.print("</div>");
		out.print("</body>");
		out.print("</html>");
		
		
		
	}

}
