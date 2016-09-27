package com.company.service.bean;

import com.company.domain.model.ProductDetail;
import com.company.service.exception.CalculationErrorException;

/**
 * 
 * @author Candidate GFILIPPI
 *
 */
public abstract class Item {
	
	public abstract boolean doSalesTaxesCalculation() throws CalculationErrorException;
	public abstract String getFinalCost();
	public abstract String getSalesTax();
	public abstract ProductDetail getProductDetail();
	
}