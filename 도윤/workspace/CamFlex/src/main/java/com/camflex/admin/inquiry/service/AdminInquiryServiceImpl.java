package com.camflex.admin.inquiry.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.camflex.admin.inquiry.dao.AdminInquiryDAO;
import com.camflex.client.inquiry.vo.InquiryVO;

@Service
@Transactional
public class AdminInquiryServiceImpl implements AdminInquiryService {

	@Autowired
	private AdminInquiryDAO adminInquiryDAO;

	// 리스트 조회
	@Override
	public List<InquiryVO> inquiryList(InquiryVO ivo) {
		List<InquiryVO> list = new ArrayList<InquiryVO>();
		list = adminInquiryDAO.inquiryList(ivo);
		return list;
	}
	// 상세 페이지
	@Override
	public InquiryVO inquiryDetail(InquiryVO ivo) {
		InquiryVO detail = null;
		
		detail = adminInquiryDAO.inquiryDetail(ivo);
		
		return detail;
	}
	
}
