package com.camflex.admin.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.camflex.admin.member.service.AdminMemberService;
import com.camflex.client.login.vo.LoginVO;
import com.camflex.common.page.Paging;
import com.camflex.common.util.Util;

@Controller
@RequestMapping(value = "/admin/member")
public class AdminMemberController {

	private Logger log = LoggerFactory.getLogger(AdminMemberController.class);

	@Autowired
	private AdminMemberService adminMemberService;

	/*******************************
	 * 회원 리스트 구현하기
	 *******************************/
	@RequestMapping(value = "/memberList", method = RequestMethod.GET)
	public String memberList(@ModelAttribute LoginVO lvo, Model model, HttpServletRequest request) {
		log.info("회원 리스트 호출 성공");
		
		
		  // 페이징 세팅
		  Paging.setPage(lvo);
		  
		  // 전체 레코드 수 구현 
		  int total = adminMemberService.memberListCnt(lvo);
		  log.info("total = " + total);
		  
		  // 글번호 재설정 
		  int count = total -
		  (Util.nvl(lvo.getPage())-1)*Util.nvl(lvo.getPageSize());
		  log.info("count = " + count);
		 
		
		List<LoginVO> memberList = adminMemberService.memberList(lvo);
		
		model.addAttribute("memberList", memberList);
		model.addAttribute("total", total);
		model.addAttribute("data", lvo);
		
		return "admin/member/memberList";
	}

}
