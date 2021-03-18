package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Example_10_Session_Del")
public class Example_10_Session_Del extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public Example_10_Session_Del() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.isRequestedSessionIdValid()) {
			System.out.println("세션 아이디가 유효합니다");
		} else {
			System.out.println("세션 아이디가 유효하지 않습니다");
		}
		
		HttpSession session = request.getSession();
		if(!session.isNew()) {
			session.invalidate(); // 세션 종료 메소드
		}
		
	response.setContentType("text/html; charset=utf-8");
	PrintWriter out = response.getWriter(); 
	out.print("<html>");
	out.print("<body>");
	out.print("<h3>로그아웃 되었습니다</h3>");
	out.print("</body>");
	out.print("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
