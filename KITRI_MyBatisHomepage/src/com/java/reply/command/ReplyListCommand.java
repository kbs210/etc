package com.java.reply.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.command.Command;
import com.java.reply.model.ReplyDao;
import com.java.reply.model.ReplyDto;

public class ReplyListCommand implements Command{

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//댓글의 List 조회
		
		List<ReplyDto> replyList = ReplyDao.getInstance().getList();
	
		request.setAttribute("replyList", replyList);
		
		return "/WEB-INF/views/ajax/reply/list.jsp";
	}

}
