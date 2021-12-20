package com.camflex.client.login.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import org.springframework.stereotype.Repository;

import com.camflex.client.login.vo.LoginVO;

@Repository
public class LoginDAOImpl implements LoginDAO {

	@Inject
	private SqlSession sqlSession;

	private static final String namespace = "com.camflex.client.login.dao.LoginDAO";

	// 회원가입 처리
	@Override
	public void insert(LoginVO vo) throws Exception {
		sqlSession.insert(namespace + ".insertMember", vo);
	}

	// 로그인 처리
	@Override
	public Integer loginAccess(LoginVO vo) throws Exception {
		System.out.println("6");
		boolean m_name = sqlSession.selectOne(namespace + ".loginAccess", vo);
		System.out.println("7");
		//return (Integer.parseInt(m_name) == 0) ? false : true;
		// return (m_name == null) ? false : true;

	}

}
