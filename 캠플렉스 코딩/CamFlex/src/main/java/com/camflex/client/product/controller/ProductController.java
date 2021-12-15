package com.camflex.client.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.camflex.client.product.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	// 캠핑장 리스트
	@RequestMapping(value = "/productList", method = RequestMethod.GET)
	public void list(Model model) throws Exception {
		model.addAttribute("list", productService.list());
	}
	
}
