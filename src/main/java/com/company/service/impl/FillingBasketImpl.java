package com.company.service.impl;

import java.util.List;
import java.util.Set;

import com.company.domain.dao.ProductDAO;
import com.company.domain.model.ProductDetail;
import com.company.service.FillingBasket;

public class FillingBasketImpl implements FillingBasket{

	@Override
	public List<ProductDetail> getBasketById(String basketId) {
		ProductDAO ProductDAO = new ProductDAO();
		List<ProductDetail> productDetailList = ProductDAO.getProductDetailList(basketId);
		return productDetailList;
	}
	
	@Override
	public Set<Integer> getAllBasketIds() {
		ProductDAO ProductDAO = new ProductDAO();
		Set<Integer> set = ProductDAO.getAllBasketIds();
		return set;
	}

}
