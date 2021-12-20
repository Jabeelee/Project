package com.camflex.client.login.service;

import javax.servlet.http.HttpSession;

import com.camflex.client.login.vo.LoginVO;

public interface LoginService {

	// 로그인 처리
	public boolean loginAccess(LoginVO vo, HttpSession session) throws Exception ;

	// 회원가입 처리
	public void insertMember(LoginVO vo) throws Exception;
	
}
