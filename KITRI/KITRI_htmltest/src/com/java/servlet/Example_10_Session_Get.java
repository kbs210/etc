package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Example_10_Session_Get")
public class Example_10_Session_Get extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Example_10_Session_Get() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(!session.isNew() && session.getAttribute("id") != null) {
			
			String id = (String)session.getAttribute("id"); //object값을 반환함으로 문자열로 id에 입력
			String pwd = (String)session.getAttribute("pwd");
			
			System.out.println(id + "\t" + pwd + "\t" + session.getId());
		
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter(); 
			out.print("<html>");
			out.print("<body>");
			out.print("<h3>아이디 : " + id + "</h3>");
			out.print("<h3>비밀번호 : " + pwd + "</h3>");
			out.print("</body>");
			out.print("</html>");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
