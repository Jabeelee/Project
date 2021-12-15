package com.camflex.admin.product.service;

import java.util.List;

import com.camflex.admin.product.vo.AdminProductVO;

public interface AdminProductService {

	public List<AdminProductVO> productList(AdminProductVO pvo);

	public int regProduct(AdminProductVO pvo);

	public AdminProductVO productDetail(AdminProductVO pvo);

	public int updateProduct(AdminProductVO pvo);

}
