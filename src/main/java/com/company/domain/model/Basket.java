package com.company.domain.model;

import java.util.List;

/**
 * 
 * @author Candidate GFILIPPI
 *
 */
public class Basket {

	String id;
	List<ProductDetail> productDetailList = null;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<ProductDetail> getProductDetailList() {
		return productDetailList;
	}
	public void setProductDetailList(List<ProductDetail> productDetailList) {
		this.productDetailList = productDetailList;
	}
	
	
	
}
