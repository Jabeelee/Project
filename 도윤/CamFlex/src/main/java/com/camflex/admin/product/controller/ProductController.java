package com.camflex.admin.product.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.camflex.admin.product.service.ProductService;
import com.camflex.admin.product.vo.ProductVO;
import com.camflex.common.file.FileUploadUtil;

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
	@RequestMapping(value = "/regProduct", method = RequestMethod.GET)
	public String regForm(HttpSession session) {
		log.info("상품 등록 폼 호출 성공");
		return "admin/product/regProduct";
	}

	/*************************************
	 * 상품 등록 구현
	 *************************************/
	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	public String regProduct(@ModelAttribute ProductVO pvo, Model model, HttpServletRequest request)
			throws IllegalStateException, IOException {
		log.info("상품 등록 호출");
		log.info("fileName : " + pvo.getFile().getOriginalFilename());
		log.info("fileName : " + pvo.getFile1().getOriginalFilename());
		log.info("fileName : " + pvo.getFile2().getOriginalFilename());
		log.info("fileName : " + pvo.getFile3().getOriginalFilename());
		int result = 0;
		String url = "";

		if (pvo.getFile() != null) {
			String p_mainphoto = FileUploadUtil.fileUpload(pvo.getFile(), request, "product");
			pvo.setP_mainphoto(p_mainphoto);
		}
		if (pvo.getFile1() != null) {
			String p_photo1 = FileUploadUtil.fileUpload1(pvo.getFile1(), request, "product");
			pvo.setP_photo1(p_photo1);
		}
		if (pvo.getFile2() != null) {
			String p_photo2 = FileUploadUtil.fileUpload2(pvo.getFile2(), request, "product");
			pvo.setP_photo2(p_photo2);
		}
		if (pvo.getFile3() != null) {
			String p_photo3 = FileUploadUtil.fileUpload3(pvo.getFile3(), request, "product");
			pvo.setP_photo3(p_photo3);
		}
		result = productService.regProduct(pvo);
		if (result == 1) {
			url = "/admin/product/productList";
		} else {
			model.addAttribute("code", 1);
			url = "/admin/product/regProduct";
		}
		return "redirect:" + url;
	}

	/************************************
	 * 상품 상세 페이지
	 ***********************************/
	@RequestMapping(value = "/productDetail", method = RequestMethod.GET)
	public String productDetail(@ModelAttribute ProductVO pvo, Model model) {
		log.info("상품 상세 페이지 호출 성공");
		log.info("p_number = " + pvo.getP_number());

		ProductVO detail = new ProductVO();
		detail = productService.productDetail(pvo);

		if (detail != null) {
			detail.setP_information(detail.getP_information().toString().replaceAll("\n", "<br>"));
		}

		model.addAttribute("detail", detail);

		return "admin/product/productDetail";
	}

	/****************************************
	 * 상품 수정 폼
	 ****************************************/
	@RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
	public String updateForm(@ModelAttribute ProductVO pvo, Model model) {
		log.info("상품 수정 폼 호출 성공");

		log.info("p_number = " + pvo.getP_number());

		ProductVO update = new ProductVO();
		update = productService.productDetail(pvo);

		model.addAttribute("update", update);

		return "admin/product/updateProduct";
	}

	/*********************************
	 * 상품 수정 구현
	 *********************************/
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateProduct(@ModelAttribute ProductVO pvo, HttpServletRequest request)
			throws IllegalStateException, IOException {
		log.info("상품 수정 성공");

		int result = 0;
		String url = "";
		String p_mainphoto = "";
		String p_photo1 = "";
		String p_photo2 = "";
		String p_photo3 = "";

		if (!pvo.getFile().isEmpty()) {
			log.info("======== file = " + pvo.getFile().getOriginalFilename());
			if (!pvo.getP_mainphoto().isEmpty()) {
				System.out.println("error is here?");
				FileUploadUtil.fileDelete(pvo.getP_mainphoto(), request);
			}
			System.out.println("hello?");
			p_mainphoto = FileUploadUtil.fileUpload(pvo.getFile(), request, "product");
			pvo.setP_mainphoto(p_mainphoto);
		} else {
			log.info("첨부 파일 없음");
			pvo.setP_mainphoto("");
		}
		if (!pvo.getFile1().isEmpty()) {
			log.info("======== file1 = " + pvo.getFile1().getOriginalFilename());
			if (!pvo.getP_photo1().isEmpty()) {
				
				FileUploadUtil.fileDelete(pvo.getP_photo1(), request);
			}
			
			p_photo1 = FileUploadUtil.fileUpload(pvo.getFile1(), request, "product");
			pvo.setP_photo1(p_photo1);
		} else {
			log.info("첨부 파일 없음");
			pvo.setP_photo1("");
		}
		if (!pvo.getFile2().isEmpty()) {
			log.info("======== file2 = " + pvo.getFile2().getOriginalFilename());
			if (!pvo.getP_photo2().isEmpty()) {
				
				FileUploadUtil.fileDelete(pvo.getP_photo2(), request);
			}
			
			p_photo2 = FileUploadUtil.fileUpload(pvo.getFile2(), request, "product");
			pvo.setP_photo2(p_photo2);
		} else {
			log.info("첨부 파일 없음");
			pvo.setP_photo2("");
		}
		if (!pvo.getFile3().isEmpty()) {
			log.info("======== file3 = " + pvo.getFile3().getOriginalFilename());
			if (!pvo.getP_photo3().isEmpty()) {
				
				FileUploadUtil.fileDelete(pvo.getP_photo3(), request);
			}
			p_photo3 = FileUploadUtil.fileUpload(pvo.getFile3(), request, "product");
			pvo.setP_photo3(p_photo3);
		} else {
			log.info("첨부 파일 없음");
			pvo.setP_photo3("");
		}

		log.info("======== p_mainphoto = " + pvo.getP_mainphoto());
		log.info("======== p_photo1 = " + pvo.getP_photo1());
		log.info("======== p_photo2 = " + pvo.getP_photo2());
		log.info("======== p_photo3 = " + pvo.getP_photo3());
		result = productService.updateProduct(pvo);

		if (result == 1) {
			url = "/admin/product/productDetail?p_number=" + pvo.getP_number();
		}
		return "redirect:" + url;
	}
	
	/**************************************
	 * 상품 삭제 구현 (안 쓸 예정)
	 **************************************/
	/*
	 * @RequestMapping(value = "/productDelete") public String
	 * productDelete(@ModelAttribute ProductVO pvo, HttpServletRequest
	 * request)throws IOException{ log.info("상품삭제 호출 성공");
	 * 
	 * // 아래 변수에는 입력 성공에 대한 상태값을 담는다. (1 or 0) int result = 0; String url = "";
	 * 
	 * if(!pvo.getP_photo().isEmpty()) { FileUploadUtil.fileDelete(pvo.getP_photo(),
	 * request); }
	 * 
	 * result = productService.productDelete(pvo.getP_number()); if(result == 1) {
	 * System.out.println("success"); url = "/admin/product/productList"; }else {
	 * System.out.println("fail"); url = "/admin/product/productDetail?p_number=" +
	 * pvo.getP_number(); } return "redirect:" + url; }
	 */

}
