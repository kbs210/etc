package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Example_08_sub
 */
@WebServlet("/Example_08_sub")
public class Example_08_sub extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = request.getParameter("message");
		String name = (String) request.getAttribute("name");
		String phone = (String) request.getAttribute("phone");
		
		System.out.println("Example_08_sub" + message);
		System.out.println("Example_08_sub" + name);
		System.out.println("Example_08_sub" + phone);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<body>");
		out.print("<h3 style='color:pink'>" + message +"</h3>");
		out.print("<h3 style='color:pink'>" + name +"</h3>");
		out.print("<h3 style='color:pink'>" + phone +"</h3>");
		out.print("</body>");
		out.print("</html>");
		//close를 사용하면 페이지로 다시 돌아갈 수 없기 때문에 사용 여부를 판단 후 사용
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
