package com.java.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Example_06
 */
@WebServlet("/Example_06")
public class Example_06 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Example_06() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
			request 객체의 역할 - 사용자의 요청
			한글 Encoding 기능
			파라미터 읽기 기능
			서버와 관련된 정보 읽기 기능
			웹브라우저 관련 정보 읽기 기능
			헤더 읽기 기능
			쿠키 읽기 기능
			속성 처리 기능
		 */
		
		//한글 인코딩 설정
		request.setCharacterEncoding("utf-8");
		//파라미터 읽기
		int su = Integer.parseInt(request.getParameter("su"));
		System.out.println(su);
		//서버와 관련된 정보 읽기 기능
		String serverName = request.getServerName();
		int serverPort = request.getServerPort();
		System.out.println("서버이름 : " + serverName);
		System.out.println("서버포트 : " + serverPort);
		
		//웹브라우저 관련 정보 읽기 기능
		//URL (Uniform Resource Location)
		//프로토콜(http, https)부터 servlet파일까지의 경로를 나타낸다
		//	http://localhost:8181/htmltest/com/java/servlet/Example_06
		StringBuffer URL = request.getRequestURL();
		System.out.println("서버URL : " + URL);
		
		//URI (Uniform Resource Identifier)
		//context(프로젝트명)부터 시갖해서 servelt파일까지의 경로를 나타낸다
		//	/htmltest/com/java/servlet/Example_06
		String URI = request.getRequestURI();
		System.out.println("서버URI : " + URI);
		
		// /htmltest
		String contextPath = request.getContextPath();
		System.out.println("context(프로젝트명) 경로 : " + contextPath);
		String servletPath = request.getServletPath();
		System.out.println("servlet 경로 : " + servletPath);
		
		//클라이언트 정보
		System.out.println("요청프로토콜 : " + request.getProtocol());
		//ip주소 ipv6에 대한 정보를 받아옴, ipv4를 사용중이기 때문에 정보가 이상함
		System.out.println("클라이언트 주소 : " + request.getRemoteAddr());
		System.out.println("클라이언트 포트 : " + request.getRemotePort());
		//헤더 읽기 기능
		Enumeration<String> header = request.getHeaderNames();
		while(header.hasMoreElements()) {
			String key = header.nextElement();
			String value = request.getHeader(key);
			System.out.println(key + " : \t" + value);
		}
		
		//request 객체
		// 쿠키 읽기 기능
		// 속성 처리 기능
		/*
		 	response 객체
		 	문서 타입, 한글 설정 -> setContentType
		 	출력 : getWriter()
		 	쿠키 저장(설정) 기능, 헤더설정(파일업로일때) 기능
		 		*** 페이지이동 : sendRedirect
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
