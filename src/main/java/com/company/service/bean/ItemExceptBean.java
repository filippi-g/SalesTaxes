package com.company.service.bean;

import org.slf4j.LoggerFactory;

import com.company.common.utils.TaxesCalculation;
import com.company.domain.model.ProductDetail;
import com.company.service.exception.CalculationErrorException;

/**
 * 
 * @author Candidate GFILIPPI
 *
 */
public class ItemExceptBean extends Item{
	
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(ItemExceptBean.class);
	
	ProductDetail productDetail = null;
	String finalCost = null;
	String salesTax = null;

	public ItemExceptBean(ProductDetail p){
		this.productDetail = p;
	}

	@Override
	public boolean doSalesTaxesCalculation() throws CalculationErrorException {
		logger.info("doSalesTaxesCalculation");
		try{
			Double salesTax = TaxesCalculation.calcolationTax(productDetail.getPrice(), productDetail.getImported(), TaxesCalculation.EXCEPT_SALES);
			boolean rounding = TaxesCalculation.EXCEPT_SALES != salesTax;
			String salesTaxString = TaxesCalculation.fromDoubleToString(salesTax, rounding);
			setSalesTax( salesTaxString );
			setFinalCost( TaxesCalculation.fromDoubleToString(Double.parseDouble(salesTaxString)  + Double.parseDouble(productDetail.getPrice()), false));
		}catch (Exception e) {
			logger.error("doSalesTaxesCalculation ", e);
			throw new CalculationErrorException("calcolationTax");
		}
		return true;
	}

	@Override
	public String getFinalCost() {
		return this.finalCost;
	}

	@Override
	public String getSalesTax() {
		return this.salesTax;
	}

	@Override
	public ProductDetail getProductDetail() {
		return productDetail;
	}

	private void setFinalCost(String finalCost) {
		this.finalCost = finalCost;
	}

	private void setSalesTax(String salesTax) {
		this.salesTax = salesTax;
	}
	
}
