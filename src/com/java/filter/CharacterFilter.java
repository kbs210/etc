package com.java.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);
		//요청이 들어오는 작업은 전부 필터를 거쳐서 넘어가게 된다
		//web.xml에 /* 선언을 해놓았기에 모든 주소에 적용
		//우선순위 CharFilter - Controller
	}

}
