package com.camflex.admin.product.dao;

import java.util.List;

import com.camflex.admin.product.vo.ProductVO;

public interface ProductDAO {


	public int regProduct(ProductVO pvo);

	public List<ProductVO> productList(ProductVO pvo);

	public ProductVO productDetail(ProductVO pvo);
	
}