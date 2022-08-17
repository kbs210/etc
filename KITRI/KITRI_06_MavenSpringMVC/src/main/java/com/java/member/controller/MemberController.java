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

	@RequestMapping(value = "/member/login.do") // index.jsp���� �α����� Ŭ��������
	public ModelAndView memberLogin(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("member/login"); // ȭ������ �̵�������
	}

	@RequestMapping(value = "/member/loginOk.do") 
	public ModelAndView memberLoginOk(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView(); // �����͸� ��Ƽ� �ִ� ��ü�� ȭ����� �̵�����
		mav.addObject("request", request); //Ű���� value��
		memberService.memberloginOk(mav); //������ �������μ� ��Ʈ�ѷ��� ��û�� ���� �����͸� ���񽺷� ����, ������ ó���� ���񽺿���
		return mav;
	}
	
	@RequestMapping(value = "/member/main.do") // index.jsp���� �α����� Ŭ��������
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("member/main"); // ȭ������ �̵�������
	}
	
	@RequestMapping(value = "/member/logout.do") // index.jsp���� �α����� Ŭ��������
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("member/logout"); // ȭ������ �̵�������
	}
	
	@RequestMapping(value = "/member/delete.do") // index.jsp���� �α����� Ŭ��������
	public ModelAndView memberDelete(HttpServletRequest request, HttpServletResponse response, MemberDto memberDto) {
		return new ModelAndView("member/delete"); // ȭ������ �̵�������
	}
	
	@RequestMapping(value = "/member/deleteOk.do") 
	public ModelAndView memberDeleteOk(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView(); // �����͸� ��Ƽ� �ִ� ��ü�� ȭ����� �̵�����
		mav.addObject("request", request); //Ű���� value��
		memberService.memberDeleteOk(mav); //������ �������μ� ��Ʈ�ѷ��� ��û�� ���� �����͸� ���񽺷� ����, ������ ó���� ���񽺿���
		return mav;
	}

}