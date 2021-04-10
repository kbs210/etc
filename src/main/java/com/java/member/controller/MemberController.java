package com.java.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.view.InternalResourceView;

import com.java.aop.HAspect;
import com.java.member.dto.MemberDto;
import com.java.member.service.MemberService;

@Controller
public class MemberController { // Command

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/member/register.do", method = RequestMethod.GET)
	public ModelAndView memberRegister(HttpServletRequest request, HttpServletResponse response) {

		return new ModelAndView("member/register");

	}

	@RequestMapping(value = "/member/registerOk.do", method = RequestMethod.POST)
	public ModelAndView memberRegisterOk(HttpServletRequest request, HttpServletResponse response,
			MemberDto memberDto) {

		ModelAndView mav = new ModelAndView();
		mav.addObject("memberDto", memberDto);
		memberService.memberRegisterOk(mav);

		return mav;

	}

	@RequestMapping(value = "/member/update.do", method = RequestMethod.GET)
	public ModelAndView memberUpdate(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView();
		mav.addObject("request", request);
		memberService.memberUpdate(mav);

		return mav;
	}
	
	@RequestMapping(value = "/member/updateOk.do", method = RequestMethod.POST)
	public ModelAndView memberUpdateOk(HttpServletRequest request, HttpServletResponse response, MemberDto memberDto) {

		ModelAndView mav = new ModelAndView();
		mav.addObject("memberDto", memberDto);
		memberService.memberUpdateOk(mav);

		return mav;
	}

	@RequestMapping(value = "/member/login.do") // index.jsp에서 로그인을 클릭했을때
	public ModelAndView memberLogin(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("member/login"); // 화면으로 이동시켜줌
	}

	@RequestMapping(value = "/member/loginOk.do") 
	public ModelAndView memberLoginOk(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView(); // 데이터를 담아서 주는 객체로 화면까지 이동가능
		mav.addObject("request", request); //키값과 value값
		memberService.memberloginOk(mav); //디자인 패턴으로서 컨트롤러는 요청에 대해 데이터를 서비스로 전달, 데이터 처리는 서비스에서
		return mav;
	}
	
	@RequestMapping(value = "/member/main.do") // index.jsp에서 로그인을 클릭했을때
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("member/main"); // 화면으로 이동시켜줌
	}
	
	@RequestMapping(value = "/member/logout.do") // index.jsp에서 로그인을 클릭했을때
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("member/logout"); // 화면으로 이동시켜줌
	}
	
	@RequestMapping(value = "/member/delete.do") // index.jsp에서 로그인을 클릭했을때
	public ModelAndView memberDelete(HttpServletRequest request, HttpServletResponse response, MemberDto memberDto) {
		return new ModelAndView("member/delete"); // 화면으로 이동시켜줌
	}
	
	@RequestMapping(value = "/member/deleteOk.do") 
	public ModelAndView memberDeleteOk(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView(); // 데이터를 담아서 주는 객체로 화면까지 이동가능
		mav.addObject("request", request); //키값과 value값
		memberService.memberDeleteOk(mav); //디자인 패턴으로서 컨트롤러는 요청에 대해 데이터를 서비스로 전달, 데이터 처리는 서비스에서
		return mav;
	}

}