package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Example_10_Session_Set")
public class Example_10_Session_Set extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Example_10_Session_Set() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");


		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		System.out.println(id + "\t" + pwd);

		HttpSession session = request.getSession();
		String msg ="";
		if(session.isNew()) {
			msg = "새로운 세션이 생성";
			session.setAttribute("id", id);
			session.setAttribute("pwd", pwd);

		} else {
			if(session.getAttribute("id") == null) {
				session.removeAttribute("id");
				session.removeAttribute("pwd");
				session.isNew();
				session.setAttribute("id", id);
				session.setAttribute("pwd", pwd);
				msg = "세션이 존재하지 않습니다";
			} else {
				msg = "기존 세션이 반환";
			}
		}

			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter(); 
			out.print("<html>");
			out.print("<body>");
			out.print("<script>");
			out.print("alert('" + msg + " : 로그인 성공');");
			out.print("location.href='http://localhost:8181/htmltest/servlet/10_example.html'");
			out.print("</script>");
			out.print("</body>");
			out.print("</html>");

		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
