package com.camflex.admin.product.dao;

import java.util.List;

import com.camflex.admin.product.vo.AdminProductVO;

public interface AdminProductDAO {

	public int regProduct(AdminProductVO pvo);

	public List<AdminProductVO> productList(AdminProductVO pvo);

	public AdminProductVO productDetail(AdminProductVO pvo);

	public int updateProduct(AdminProductVO pvo);

}
