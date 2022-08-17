package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//웹 2.5 vs 3.0 이상 버전의 차이
//웹 3.0 이상의 버전에서는 web.xml 설정 대신에
//클래스에 어노테이션 방식으로 url-pattern을 설정 할 수 있다
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	int cnt;
	
	public void init() {
		cnt = 0;
	}
	//override 메소드에서 같은 매계 변수를 받는 메소드를 재정의
	//overload 메소드에서 다른 매계 변수를 받는 메소드를 새로정의
	public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cnt++;
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();		

		out.print("<html>");
		out.print("<head><title>사칙연산</title></head>");
		out.print("<body>");
		out.print("당신은" + cnt + "번째 방문자입니다");
		out.print("<h3>HelloServlet</h3>");
		out.print("</body>");
		out.print("</html>");
		
	}
			
}
