package com.company.domain.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.company.common.csv.ParseCSV2BeanSingleton;
import com.company.domain.model.ProductDetail;

/**
 * 
 * @author Candidate GFILIPPI
 *
 */
public class ProductDAO {

	public List<ProductDetail> getProductDetailList(String basketId) {
		List<ProductDetail> list = ParseCSV2BeanSingleton.getInstance().getProductList();
		List<ProductDetail> listOut = new ArrayList<ProductDetail>(); 
		for(ProductDetail p:list){
			if ( p.getBasketId().equalsIgnoreCase(basketId) ) listOut.add(p);
		}
		return listOut;
	}
	
	public Set<Integer> getAllBasketIds() {
		return ParseCSV2BeanSingleton.getInstance().getBasketIds();
	}
}
