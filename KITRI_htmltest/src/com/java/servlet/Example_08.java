package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Example_08")
public class Example_08 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//include
		String message = request.getParameter("message");
		System.out.println(message);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		
		request.setAttribute("name", "가나다");
		request.setAttribute("phone", "112");
		RequestDispatcher rd = request.getRequestDispatcher("/Example_08_sub");
		rd.include(request, response);
		
		out.print("<h3>include는 다시 돌아온다, 제어권을 넘겨주지 않는다</h3>");
		out.print("<h3>서블릿에서 데잍터 생명주기 pageScope, requestScope, sessionScope, applicationScope</h3>");
		
		out.print("</body>");
		out.print("</html>");
		out.close();
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//forward
		String message = request.getParameter("message");
		System.out.println(message);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		
		request.setAttribute("name", "가나다");
		request.setAttribute("phone", "112");
		RequestDispatcher rd = request.getRequestDispatcher("/Example_08_sub");
		rd.forward(request, response);
		
		out.print("<h3>include는 다시 돌아온다, 제어권을 넘겨주지 않는다</h3>");
		out.print("<h3>서블릿에서 데이터 생명주기 pageScope, requestScope, sessionScope, applicationScope</h3>");
		
		out.print("</body>");
		out.print("</html>");
		out.close();
		
	}

}
