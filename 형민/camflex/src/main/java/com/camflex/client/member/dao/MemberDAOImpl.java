package com.camflex.client.member.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import org.springframework.stereotype.Repository;

import com.camflex.client.member.vo.MemberVO;

//DB 연결 구현
@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	private SqlSession sqlSession;

	private static final String namespace = "com.camflex.client.member.dao.MemberDAO";

	// 회원가입 처리
	@Override
	public void insert(MemberVO vo) throws Exception {
		sqlSession.insert(namespace + ".insertMember", vo);
	}

}
