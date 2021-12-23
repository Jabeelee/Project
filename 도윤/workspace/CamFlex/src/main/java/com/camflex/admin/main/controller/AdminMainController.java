package com.camflex.admin.main.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.camflex.admin.main.service.AdminMainService;
import com.camflex.client.member.vo.MemberVO;
import com.camflex.client.reservation.vo.ReservationVO;

@Controller
@RequestMapping("/admin")
public class AdminMainController {
	
	private Logger log = LoggerFactory.getLogger(AdminMainController.class);
	
	@Autowired
	private AdminMainService adminMainService;
	
	// 메인 페이지
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String mainList(@ModelAttribute MemberVO mvo, ReservationVO rvo, Model model) {
		log.info("메인 페이지 호출 성공");
		
		
		// 오늘 날짜 기준 가입한 회원 수 출력
		List<MemberVO> todayMember = adminMainService.mainList(mvo);
		
		model.addAttribute("todayMember", todayMember);
		model.addAttribute("data", mvo);
		
		List<ReservationVO> newRsv = adminMainService.rsvList(rvo);
		model.addAttribute("newRsv", newRsv);
		
		List<ReservationVO> visit = adminMainService.visit(rvo);
		model.addAttribute("visit", visit);
		
		List<ReservationVO> yesterday = adminMainService.yesterday(rvo);
		model.addAttribute("yesterday", yesterday);
		
		return "admin/main";
	}
	
}
