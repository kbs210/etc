package com.java.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.command.Command;
import com.java.member.model.MemberDao;
import com.java.member.model.MemberDto;

public class UpdateCommand implements Command {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession(); // 세션 받아오기

		String id = (String)session.getAttribute("id"); //object값을 반환함으로 문자열로 id에 입력
		
		MemberDto memberDto = MemberDao.getInstance().load(id);

		request.setAttribute("memberDto", memberDto);

		return "/WEB-INF/member/update.jsp";
	}

}
