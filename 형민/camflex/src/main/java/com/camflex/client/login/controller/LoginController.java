package com.camflex.client.login.controller;

import javax.inject.Inject;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import com.camflex.client.login.dao.LoginDAO;
import com.camflex.client.login.service.LoginService;

import com.camflex.client.login.vo.LoginVO;

@Controller
public class LoginController {
	// 로깅을 위한 변수
	private Logger log = LoggerFactory.getLogger(LoginController.class);

	@Inject
	LoginService loginService;

	@Inject
	LoginDAO loginDAO;

	/* 로그인 화면 */
	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public String LoginForm() {
		log.info("loginForm.do get 성공");
		return "/login/loginForm"; // views/login/loginForm.jsp로 포워드
	}

	/* 로그인 처리 */
	@RequestMapping(value = "/login/loginAccess", method = RequestMethod.POST)
	public ModelAndView loginAccess(@ModelAttribute LoginVO vo, HttpSession session) throws Exception {
		log.info("loginAccess.do POST 성공");
		boolean result = loginService.loginAccess(vo, session);
		ModelAndView mav = new ModelAndView();
		if (result == true) {
			log.info("로그인 성공");
			mav.setViewName("/login/listMember");
		} else {
			log.info("로그인 실패");
			mav.setViewName("/login/loginForm");
		}
		return mav;
	}

	/* 회원가입 폼 */
	@RequestMapping(value = "/joinForm", method = RequestMethod.GET)
	public String joinForm() {
		log.info("joinForm.do get 성공");
		return "/login/joinForm";
	}

	/* 회원가입 처리 */
	@RequestMapping(value = "/login/insert", method = RequestMethod.POST)
	public String insertMember(@ModelAttribute LoginVO vo) throws Exception {
		log.info("회원가입 처리 완료");
		loginService.insertMember(vo);
		return "/login/insert";

	}

}
