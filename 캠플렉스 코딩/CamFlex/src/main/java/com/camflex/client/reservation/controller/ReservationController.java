package com.camflex.client.reservation.controller;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.camflex.client.reservation.service.ReservationService;
import com.camflex.client.reservation.vo.ReservationVO;

import oracle.jdbc.logging.annotations.Log;

@Controller
@RequestMapping(value = "/reservation")
public class ReservationController {

	private Logger log = LoggerFactory.getLogger(ReservationController.class);

	/*
	 * @Autowired private ReservationService reservationService;
	 */

	/* 실시간 예약 폼 */
	@RequestMapping(value = "/reservationDetail")
	public String reservationDetail(Model model) {
		log.info("reservationDetail 호출 성공");

		return "reservation/reservationDetail";
	}

	/* 실시간 예약 생성 */
	@RequestMapping(value = "/reservationAgreePage", method = RequestMethod.POST)
	public String reservationAgreePage() {
		log.info("reservationAgreePage 호출 성공");
		
		return "reservation/reservationAgreePage";
	}

}
