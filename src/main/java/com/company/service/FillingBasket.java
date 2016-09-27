package com.company.service;

import java.util.List;
import java.util.Set;

import com.company.domain.model.ProductDetail;

/**
 * 
 * @author Candidate GFILIPPI
 *
 */
public interface FillingBasket {
	
	List<ProductDetail> getBasketById(String basketId);
	
	Set<Integer> getAllBasketIds();

}
