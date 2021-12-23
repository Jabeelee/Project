package com.camflex.client.member.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;


import com.camflex.client.member.service.MemberService;
import com.camflex.client.member.vo.MemberVO;

@Controller
public class MemberController {
	// 로깅을 위한 변수
	private Logger log = LoggerFactory.getLogger(MemberController.class);

	@Inject
	MemberService memberService;

	/* 회원가입 폼 */
	@RequestMapping(value = "/joinForm", method = RequestMethod.GET)
	public String joinForm() {
		log.info("joinForm.do get 성공");
		return "/member/joinForm";
	}

	/* 회원가입 처리 */
	@RequestMapping(value = "/login/insert", method = RequestMethod.POST)
	public String insertMember(@ModelAttribute MemberVO vo) throws Exception {
		log.info("회원가입 처리 완료");
		memberService.insertMember(vo);
		return "/member/insert";

	}

}
