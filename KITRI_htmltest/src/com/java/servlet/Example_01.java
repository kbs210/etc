package com.java.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Example_01")
public class Example_01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Example_01() {
        super();
    }

    //생명주기 - 생성 후 초기화 init() -> 서비 service() -> 소멸 destroy()
    public void init() {
    	System.out.println("서블릿 초기화 (처음 요청 시 단 한 번)");
    	System.out.println("또재초기화");
    }
    
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//서비스 - 요청방식에 의해서 get, post 함수를 호출
    	doGet(request, response);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("서비스가 호출한 doGet 함수 입니다");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void destory() {
		System.out.println("서블릿 소멸");
	}

}
