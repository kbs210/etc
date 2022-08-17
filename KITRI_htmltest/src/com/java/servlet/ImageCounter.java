package com.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageCounter
 */
@WebServlet("/ImageCounter")
public class ImageCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	int cnt;
	int totalLen;
	
	public void init() {
		cnt = 0;
		totalLen = 8;
	}
	
	/*
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cnt++;
		tmp = cnt;
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();		

		out.print("<html>");
		out.print("<head><title>Image Counter</title></head>");
		out.print("<body>");
		out.print("<h1>Welcome</h1>");
		out.print("당신은" + cnt + "번째 방문자입니다");
		out.print("<br>");
		
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		int e = 0;
		int f = 0;
		int g = 0;
		int h = 0;
		
		a = ((cnt%10)/1);
		b = ((cnt-a)%100)/10;
		c = ((cnt-a-b*10)%1000)/100;
		d = ((cnt-a-b*10-c*100)%10000)/1000;
		e = ((cnt-a-b*10-c*100-d*1000)%100000)/10000;
		f = ((cnt-a-b*10-c*100-d*1000-e*10000)%1000000)/100000;
		g = ((cnt-a-b*10-c*100-d*1000-e*10000-f*100000)%10000000)/100000;
		h = ((cnt-a-b*10-c*100-d*1000-e*10000-f*100000-g*10000000)%100000000)/10000000;
		
		out.print(a);
		out.print(b);
		out.print(c);
		out.print(d);
		out.print(e);
		out.print(f);
		out.print(g);
		out.print(h);
		out.print("<br>");
		
		
		out.print("<img alt='h' src=\"/htmltest/servlet/img/" + h + ".jpg\" width = \"150\" height=\"200\">");
		out.print("<img alt='g' src=\"/htmltest/servlet/img/" + g + ".jpg\" width = \"150\" height=\"200\">");
		out.print("<img alt='f' src=\"/htmltest/servlet/img/" + f + ".jpg\" width = \"150\" height=\"200\">");
		out.print("<img alt='e' src=\"/htmltest/servlet/img/" + e + ".jpg\" width = \"150\" height=\"200\">");
		out.print("<img alt='d' src=\"/htmltest/servlet/img/" + d + ".jpg\" width = \"150\" height=\"200\">");
		out.print("<img alt='c' src=\"/htmltest/servlet/img/" + c + ".jpg\" width = \"150\" height=\"200\">");
		out.print("<img alt='b' src=\"/htmltest/servlet/img/" + b + ".jpg\" width = \"150\" height=\"200\">");
		out.print("<img alt='a' src=\"/htmltest/servlet/img/" + a + ".jpg\" width = \"150\" height=\"200\"> ");
		out.print("</body>");
		out.print("</html>");
		
	}
	*/
	
	

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cnt++;
		//cnt 자리수 판단을 위해 int cnt를 String cntstr로
		String cntStr = cnt + ""; // "125"
		int numLen = cntStr.length(); // 3
		int zeroLen = totalLen - numLen; // 8 - 3
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<h3>Welcome</h3>");
		
		for (int i = 0; i<zeroLen; i++) {
			out.print("<img alt='h' src='/htmltest/servlet/img/0.jpg' width = '150' height='200'>");
		}
		for (int i = 0; i<numLen; i++) {
			out.print("<img alt='h' src='/htmltest/servlet/img/" +cntStr.charAt(i) + ".jpg' width = '150' height='200'>");
		}
		out.print("</body>");
		out.print("</html>");
	}
	
}
