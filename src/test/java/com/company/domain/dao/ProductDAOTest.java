package com.company.domain.dao;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.company.domain.model.ProductDetail;

public class ProductDAOTest {

	@Test
	public void testGetProductDetailList() {
		ProductDAO ProductDAO = new ProductDAO();
		List<ProductDetail> productDetailList = ProductDAO.getProductDetailList("1");
		assertNotNull(productDetailList);
		assertTrue(productDetailList.size()>=0);
	}

	@Test
	public void testGetAllBasketIds() {
		ProductDAO ProductDAO = new ProductDAO();
		Set<Integer> set = ProductDAO.getAllBasketIds();
		assertNotNull(set);
		assertTrue(set.size()>=0);
	}

}
