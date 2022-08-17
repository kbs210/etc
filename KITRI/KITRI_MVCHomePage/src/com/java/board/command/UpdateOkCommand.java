package com.java.board.command;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.board.model.BoardDao;
import com.java.board.model.BoardDto;
import com.java.command.Command;

public class UpdateOkCommand implements Command{

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		BoardDto boardDto = new BoardDto();
		
		if(request.getParameter("pageNumber")!=null) {
			int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
			request.setAttribute("pageNumber", pageNumber);
		}
		
		boardDto.setWriter(request.getParameter("name"));
		boardDto.setSubject(request.getParameter("subject"));
		boardDto.setEmail(request.getParameter("email"));
		boardDto.setContent(request.getParameter("content"));
		boardDto.setPassword(request.getParameter("password"));
		boardDto.setBoardNumber(Integer.parseInt(request.getParameter("boardNumber")));
		boardDto.setWriteDate(new Date());
		
		logger.info(logMsg + boardDto.toString());
		
		int check = BoardDao.getInstance().update(boardDto);
		
		request.setAttribute("check", check);
		
		return "/WEB-INF/board/updateOk.jsp";
	}

}
