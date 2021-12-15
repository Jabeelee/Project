package com.camflex.client.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camflex.admin.product.vo.AdminProductVO;
import com.camflex.client.product.dao.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	// 캠핑장 리스트
	@Override
	public List<AdminProductVO> list() throws Exception {
		return productDAO.productList();
	} 
}
