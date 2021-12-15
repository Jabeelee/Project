package com.camflex.admin.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.camflex.admin.notice.vo.NoticeVO;
import com.camflex.admin.notice.service.NoticeService;


@Controller
@RequestMapping(value = "/admin/notice")
public class NoticeController {

	private Logger log = LoggerFactory.getLogger(NoticeController.class);
	
	@Autowired
	private NoticeService noticeService;
	
	/*****************************************
	 * 공지사항 기본 조회
	 *****************************************/
	@RequestMapping(value = "/noticeList", method = RequestMethod.GET)
	public String noticeList(@ModelAttribute NoticeVO nvo, Model model) {
		log.info("공지사항 목록 호출 성공");
		
		List<NoticeVO> noticeList = noticeService.noticeList(nvo);
		
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("data", nvo);
		
		return "admin/notice/noticeList";
	}

	/****************************************
	 * 공지사항 등록 폼 출력
	 ****************************************/
	@RequestMapping(value = "/regNotice", method = RequestMethod.GET)
	public String regForm(HttpSession session) {
		log.info("글 등록 폼 호출 성공");
		return "admin/notice/regNotice";
	}
	
	/****************************************
	 * 글 등록 구현
	 ****************************************/
	
	public String regNotice(@ModelAttribute NoticeVO nvo, Model model, HttpServletRequest request)throws IllegalStateException, IOException{
		log.info("글 등록 호출");
		
		int result = 0;
		String url = "";
		if(nvo.getFile() != null) {
			String n_photo = File
		}
	}
	
}