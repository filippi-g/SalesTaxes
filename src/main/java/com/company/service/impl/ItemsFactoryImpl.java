package com.company.service.impl;

import com.company.common.enumeration.GoodCategory;
import com.company.domain.model.ProductDetail;
import com.company.service.ItemsFactory;
import com.company.service.bean.Item;
import com.company.service.bean.ItemAllBean;
import com.company.service.bean.ItemExceptBean;
import com.company.service.exception.InvalidItemsTypeException;

/**
 * 
 * @author Candidate GFILIPPI
 *
 */
public class ItemsFactoryImpl implements ItemsFactory {

	public Item transferIntoItems(ProductDetail p) throws InvalidItemsTypeException {
		GoodCategory type = GoodCategory.valueOf(p.getCategory().toUpperCase());
		switch (type) {
		case ALL:
			return new ItemAllBean(p) ;
		case FOOD:
		case MED:
		case BOOK:
			return new ItemExceptBean(p);
		default:
			throw new InvalidItemsTypeException(p.getCategory());
		}
	}



}