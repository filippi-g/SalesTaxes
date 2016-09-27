package com.company.domain.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.company.common.csv.ParseCSV2Bean;
import com.company.domain.model.ProductDetail;

/**
 * 
 * @author Candidate GFILIPPI
 *
 */
public class ProductDAO {

	private static final String FILENAME = "./input/ProductDetail.csv";
	
	public List<ProductDetail> getProductDetailList(String basketId) {
		ParseCSV2Bean parseCSVFile = new ParseCSV2Bean();
		List<ProductDetail> list = parseCSVFile.parseCSVtoBean(FILENAME);
		List<ProductDetail> listOut = new ArrayList<ProductDetail>(); 
		for(ProductDetail p:list){
			if ( p.getBasketId().equalsIgnoreCase(basketId) ) listOut.add(p);
		}
		return listOut;
	}
	
	public Set<Integer> getAllBasketIds() {
		ParseCSV2Bean parseCSVFile = new ParseCSV2Bean();
		Set<Integer> set = parseCSVFile.parseCSVtoInteger(FILENAME);
		return set;
	}
}
