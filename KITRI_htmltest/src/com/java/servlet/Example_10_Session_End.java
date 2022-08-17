package com.java.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Example_10_Session_End")
public class Example_10_Session_End extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public Example_10_Session_End() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//세션 생성 시간
		long createTime = session.getCreationTime();
		
		//세션 마지막 접근 시간
		long lastTime = session.getLastAccessedTime();
		
		//사이트 머문시간 = 마지막 접근시간 - 생성시간
		long userTime = (lastTime - createTime);
		
		System.out.println("createTime : " + createTime);
		System.out.println("lastTime : " + lastTime);
		System.out.println("userTime : " + userTime);
		
		Date date = new Date(createTime);
		System.out.println("생성시간 : " + createTime + "\t" + date);
		System.out.println("마지막 접근 시간 : " + lastTime + "\t" + new Date(lastTime));
		System.out.println("머문시간 : " + userTime + "\t" + userTime/60000);
		
		// 시간 초과시 세션 종료
		/*
		 * if (userTime/60000 > 11) { session.invalidate(); }
		 */
		
		int max = session.getMaxInactiveInterval();
		System.out.println(max + "\t" + max/60);
		
		//액션이 없을 경우 세션 시간 설정으로 자동 종료
		if(request.isRequestedSessionIdValid()) {
			System.out.println("세션 아이디가 유효합니다");
		} else {
			System.out.println("세션 아이디가 유효하지 않습니다");
		}
		
		//세션 종료 시간 설정, 초 단위
		session.setMaxInactiveInterval(60);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
