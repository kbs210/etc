package com.java.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.java.aop.HAspect;
import com.java.member.dao.MemberDao;
import com.java.member.dto.MemberDto;


@Component
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDao memberDao;
	@Override
	public void memberRegisterOk(ModelAndView mav) {
		
		Map<String, Object> map = mav.getModelMap();
		MemberDto memberDto = (MemberDto) map.get("memberDto");
		
		memberDto.setMemberLevel("BA");
		
		int check = memberDao.memberinsert(memberDto);
		
		mav.addObject("check", check);
		mav.setViewName("member/registerOk");
		
		
	}

	@Override
	public void memberidCheck(ModelAndView mav) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void memberlogin(ModelAndView mav) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void memberloginOk(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		Map<String, String> hmap = new HashMap<String, String>();
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		String memberLevel = memberDao.loginOk(id, password);
		
		mav.addObject("memberLevel", memberLevel);
		mav.addObject("id", id);
		mav.setViewName("member/loginOk"); //화면으로 이동
		
//		hmap.put("id", request.getParameter("id"));
//		hmap.put("pw", request.getParameter("password")); //화면(index.jsp)에서 name값으로 찾음
		
	}

	@Override
	public void main(ModelAndView mav) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void memberloginOut(ModelAndView mav) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void memberUpdateOk(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		MemberDto memberDto = (MemberDto) map.get("memberDto");
		
		int check = memberDao.memberUpdateOk(memberDto);
		
		mav.addObject("check", check);
		mav.setViewName("member/updateOk");
	}

	@Override
	public void memberUpdate(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("id"); // jstl을 이용하여 세션 범위의 id 변수 생성했음<c:set var = "id" value="${id}" scope="session"/>
		MemberDto memberDto = memberDao.memberUpdate(id);
		
		mav.addObject("memberDto", memberDto);
		mav.setViewName("member/update");
	}

	@Override
	public void memberDeleteOk(ModelAndView mav) {
		Map<String, Object> map = mav.getModelMap();
		MemberDto memberDto = (MemberDto) map.get("memberDto");
		
		int check = memberDao.memberDeleteOk(memberDto);
		
		mav.addObject("check", check);
		mav.setViewName("member/deleteOk");
	}
		
	
}
