package com.company.service;

import com.company.domain.model.ProductDetail;
import com.company.service.bean.Item;
import com.company.service.exception.InvalidItemsTypeException;

/**
 * 
 * @author Candidate GFILIPPI
 *
 */
public interface ItemsFactory {
	
	public Item transferIntoItems(ProductDetail p) throws InvalidItemsTypeException;
}
