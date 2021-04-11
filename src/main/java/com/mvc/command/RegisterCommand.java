package com.mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterCommand implements Command{

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println();
		System.out.println("RegisterCommand Run");
		return "/WEB-INF/view/register.jsp";
	}

}
