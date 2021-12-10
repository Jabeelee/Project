package com.camflex.admin.product.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.camflex.admin.product.service.ProductService;
import com.camflex.admin.product.vo.ProductVO;

@Controller
@RequestMapping(value = "/admin/product")
public class ProductController {

	private Logger log = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	/************************************
	 * 상품 목록 구현
	 ************************************/
	/*
	 * @RequestMapping(value = "/productList") public ModelAndView
	 * productList(@ModelAttribute ProductVO pvo) { List<ProductVO> list =
	 * productService.productList(pvo); System.out.println("controller 1");
	 * ModelAndView mav = new ModelAndView(); System.out.println("controller 2");
	 * mav.addObject("productList", list); System.out.println("controller 3");
	 * mav.setViewName("admin/product" + "/productList");
	 * System.out.println("controller 4"); return mav; }
	 */

	@RequestMapping(value = "/productList", method = RequestMethod.GET)
	public String productList(@ModelAttribute ProductVO pvo, Model model) {
		log.info("상품 목록 호출 성공");

		List<ProductVO> productList = productService.productList(pvo);

		System.out.println("1번 진행");
		model.addAttribute("productList", productList);
		System.out.println("2번 진행");
		model.addAttribute("data", pvo);
		System.out.println("3번 진행");

		return "admin/product/productList";
	}

	/*************************************
	 * 상품 등록 폼 출력
	 ************************************/
	@RequestMapping(value = "/regForm", method = RequestMethod.GET)
	public String regForm() {
		log.info("상품 등록 폼 호출 성공");
		return "admin/product/regProduct";
	}

	/*************************************
	 * 상품 등록 구현
	 *************************************/
	@RequestMapping(value = "/regProduct", method = RequestMethod.GET)
	public String regProduct(@ModelAttribute ProductVO pvo, Model model) {
		log.info("상품 등록 호출");

		int result = 0;
		String url = "";

		result = productService.regProduct(pvo);
		if (result == 1) {
			url = "/admin/product/productList";
		} else {
			model.addAttribute("code", 1);
			url = "/admin/product/regForm";
		}
		return "redirect:" + url;
	}
	
	@RequestMapping(value = "/productDetail", method = RequestMethod.GET)
	public String productDetail(@ModelAttribute ProductVO pvo, Model model) {
		log.info("상품 상세 페이지 호출 성공");
		log.info("p_number = " + pvo.getP_number());
		
		ProductVO detail = new ProductVO();
		detail = productService.productDetail(pvo);
		
		if(detail != null) {
			detail.setP_information(detail.getP_information().toString().replaceAll("\n", "<br>"));
		}
		
		model.addAttribute("detail", detail);
		
		return "admin/product/productDetail";
	}

}
