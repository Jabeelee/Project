package com.camflex.client.login.dao;

import org.springframework.stereotype.Repository;

import com.camflex.client.login.vo.LoginVO;

//DB 연결
@Repository
public interface LoginDAO {

	// 회원가입 처리
	public void insert(LoginVO vo) throws Exception;

	//로그인 처리
	public Integer loginAccess(LoginVO vo) throws Exception;



}
