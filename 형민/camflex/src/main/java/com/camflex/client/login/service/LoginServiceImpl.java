package com.camflex.client.login.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.camflex.client.login.dao.LoginDAO;
import com.camflex.client.login.vo.LoginVO;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

	@Inject
	private LoginDAO loginDAO;

	@Override
	public LoginVO userIdSelect(String m_id) {
		return loginDAO.userIdSelect(m_id);
	}

	@Override
	public LoginVO loginSelect(LoginVO vo) {
		LoginVO loginVO = null;
		try {
			System.out.println("1");
			LoginVO lvo = new LoginVO();
			lvo.setM_id("m_id");
			lvo.setM_pw("m_pw");

			loginVO = loginDAO.loginSelect(lvo);
			System.out.println("2");
		} catch (Exception e) {
			System.out.println("3");
			e.printStackTrace();
			loginVO = null;
			System.out.println("4");
		}
		System.out.println("5");
		return loginVO;
	}

	// 로그인 처리
	/*
	 * @Override public String loginCheck(LoginVO vo, HttpSession session) throws
	 * Exception { String m_name = loginDAO.loginCheck(vo);
	 * 
	 * if (m_name != null) { session.setAttribute("m_id", vo.getM_id());
	 * session.setAttribute("m_name", m_name); } return m_name; }
	 */

	// 로그인 처리2

}
