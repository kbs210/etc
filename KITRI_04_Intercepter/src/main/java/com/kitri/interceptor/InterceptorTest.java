package com.kitri.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class InterceptorTest implements HandlerInterceptor{

	//url 요청 >> HandlerInterceptor		>>	 controller 	>>	 postHandle		>> 	afterCompletion
	//			controller가 실행 전							예외없이 실행 완료 후		View 전송 후
	//			> preHandle : true false
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//controller 실행 전
		System.out.println("Interceptor=1 preHandle");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//controller 실행 후
		System.out.println("Interceptor=1 postHandle()");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//view 전송 후 실행
		System.out.println("Interceptor=1 afterCompletion()");
	}
	
}
