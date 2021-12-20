package com.camflex.client.login.service;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.camflex.client.login.dao.LoginDAO;
import com.camflex.client.login.vo.LoginVO;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

	@Inject
	private LoginDAO loginDAO;

	@Inject
	private static Hashtable<String, String> loginUsers = new Hashtable<String, String>();

	// 회원가입 처리
	@Override
	public void insertMember(LoginVO vo) throws Exception {

		loginDAO.insert(vo);
	}

	// 로그인 처리
	@Override
	public boolean loginAccess(LoginVO vo, HttpSession session) throws Exception {
		System.out.println("1");
		boolean isLogin = isLogin(vo.getM_id());
		if (!isLogin) {
			System.out.println("2");
			Integer result = loginDAO.loginAccess(vo);
			if (result != null) {
				System.out.println("3");
				setSession(session, vo);
			}
			System.out.println("4");
			return result != null;

		}
		System.out.println("5");
		return !isLogin;
	}

	public boolean isLogin(String m_id) {
		boolean isLogin = false;

		Enumeration<String> e = loginUsers.keys();
		String key = "";

		while (e.hasMoreElements()) {
			key = (String) e.nextElement();
			if (m_id.equals(loginUsers.get(key)))
				isLogin = true;
		}
		return isLogin;
	}

	private void setSession(HttpSession session, LoginVO vo) {
		loginUsers.put(session.getId(), vo.getM_id());
		session.setAttribute("id", vo.getM_id());

	}

}
