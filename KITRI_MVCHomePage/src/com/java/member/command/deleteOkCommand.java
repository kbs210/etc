package com.java.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.Command;
import com.java.member.model.MemberDao;
import com.java.member.model.MemberDto;

public class deleteOkCommand implements Command{

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		//파라미터를 통해 넘어온 데이터를 MemberDto에 저장
		MemberDto memberDto = new MemberDto();
		
		memberDto.setId(request.getParameter("id"));
		memberDto.setPassword(request.getParameter("password"));
		
		logger.info(logMsg + memberDto.toString());
		
		//DAO			Member.Dao.insert
		int check = MemberDao.getInstance().delete(memberDto);
		
		request.setAttribute("check", check);
		
		return "/WEB-INF/member/deleteOk.jsp";
	}

}
