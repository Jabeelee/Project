package com.camflex.admin.notice.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.camflex.admin.notice.vo.NoticeVO;

@Repository
public class NoticeDAOImpl implements NoticeDAO {
	
	@Autowired
	private SqlSession sqlSession;

	private static final String namespace = "com.camflex.admin.notice.dao.NoticeDAO";
	
	// 전체 리스트 조회
	@Override
	public List<NoticeVO> noticeList(NoticeVO nvo) {
		
		return sqlSession.selectList(namespace + ".noticeList", nvo);
	}
}
