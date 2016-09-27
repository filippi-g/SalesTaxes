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
			double priceDouble = Double.parseDouble(productDetail.getPrice());
			Double salesTaxBasic = TaxesCalculation.calcolationSalesTaxExcept(priceDouble);
			Double salesTaxBasicRound = TaxesCalculation.roundNearestDoubleValue(salesTaxBasic);
			logger.debug("doSalesTaxesCalculation salesTaxBasic {} ", salesTaxBasic);
			logger.debug("doSalesTaxesCalculation salesTaxBasicRound {} ", salesTaxBasicRound);
			
			Double salesImportedTax = TaxesCalculation.calcolationSalesImportedTax(priceDouble,  productDetail.getImported());
			Double salesImportedTaxRound = TaxesCalculation.roundNearestDoubleValue(salesImportedTax);

			String salesTaxRoundFrmt = TaxesCalculation.fromDoubleToFormattedString( salesTaxBasicRound + salesImportedTaxRound );
			String finalCostRoundFrmt = TaxesCalculation.fromDoubleToFormattedString( salesTaxBasicRound + salesImportedTaxRound + priceDouble);
			logger.info("doSalesTaxesCalculation salesTaxRoundFrmt {} ", salesTaxRoundFrmt);
			logger.info("doSalesTaxesCalculation finalCostRoundFrmt {} ", finalCostRoundFrmt);
			setSalesTax( salesTaxRoundFrmt );
			setFinalCost( finalCostRoundFrmt );
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
