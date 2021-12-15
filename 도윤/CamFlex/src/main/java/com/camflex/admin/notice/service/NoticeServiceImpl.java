package com.camflex.admin.notice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.camflex.admin.notice.vo.NoticeVO;
import com.camflex.admin.notice.dao.NoticeDAO;

@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {
	
	
	@Autowired
	private NoticeDAO noticeDAO;

	// 전체 리스트 조회
	@Override
	public List<NoticeVO> noticeList(NoticeVO nvo) {
		
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		list = noticeDAO.noticeList(nvo);
		
		return list;
	}
}
