package com.java.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListAction implements Command{

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) {
		String view = "/mvctest/mvc/list.jsp";
		return view;
	}

}
