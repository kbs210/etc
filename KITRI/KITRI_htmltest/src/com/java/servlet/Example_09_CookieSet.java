package com.java.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Example_09_CookieSet")
public class Example_09_CookieSet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Example_09_CookieSet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String[] food = request.getParameterValues("food");
		System.out.println(food.length);

		// request : 쿠키 읽기, response : 쿠키 설정(저장)
		if (food.length != 0) {
			for (int i = 0; i < food.length; i++) {
				// key와 value를 food배열에서 나눠 저장해야한다
				String key = "food" + (i + 1);
				String value = food[i];

				System.out.println(key + "\t" + value);

				Cookie cookie = new Cookie(key, value);
				// 쿠키의 유효 시간 설정
				cookie.setMaxAge(60 * 60 * 24 * 365);// 초*분*시*일
				response.addCookie(cookie);

			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
