package com.company.common.utils;

import org.junit.Test;
import org.slf4j.LoggerFactory;

import junit.framework.Assert;

public class TaxesCalculationTest {

	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(TaxesCalculationTest.class);

	@SuppressWarnings("static-access")
	@Test
	public void testFromDoubleToString() {
		Double d = new Double("54.625");
		TaxesCalculation taxesCalculation = new TaxesCalculation();
		String value = taxesCalculation.fromDoubleToString(d, true);
		logger.debug("testFromDoubleToString : {} ", value);

	}

	@SuppressWarnings("static-access")
	@Test
	public void testCalcolationTax() {
		TaxesCalculation taxesCalculation = new TaxesCalculation();

		//ALL Item
		String price = "47.50";
		Double salesTax = taxesCalculation.calcolationTax(price, "YES", TaxesCalculation.BASIC_SALES);
		logger.debug("testCalcolationTax : salesTax {} ", salesTax);
		boolean rounding = TaxesCalculation.EXCEPT_SALES != salesTax;
		String salesTaxString = TaxesCalculation.fromDoubleToString(salesTax, rounding) ;
		logger.debug("testCalcolationTax : salesTaxString {} ", salesTaxString);
		String finalString =  TaxesCalculation.fromDoubleToString(Double.parseDouble(salesTaxString) + Double.parseDouble(price), false);
		logger.debug("testCalcolationTax : finalString {} ", finalString);
		Assert.assertEquals(finalString, "54.65");

		//ALL EXCEPT
		String priceE = "11.25";
		Double salesTaxE = taxesCalculation.calcolationTax(priceE, "YES", TaxesCalculation.EXCEPT_SALES);
		logger.debug("testCalcolationTax : salesTax E {} ", salesTaxE);
		boolean roundingE = TaxesCalculation.EXCEPT_SALES != salesTaxE;
		String salesTaxStringE = TaxesCalculation.fromDoubleToString(salesTaxE, true) ;
		logger.debug("testCalcolationTax : salesTaxString E {} ", salesTaxStringE);
		String finalStringE =  TaxesCalculation.fromDoubleToString(Double.parseDouble(salesTaxStringE) + Double.parseDouble(priceE), false);
		logger.debug("testCalcolationTax : finalString E {} ", finalStringE);
		Assert.assertEquals(finalStringE, "11.85");

	}

	@SuppressWarnings("deprecation")
	@Test
	public void testCalcolationTaxDouble() {
		Double d = new Double("7.125");
		Double out =round1(d);
		logger.debug("testCalcolationTaxDouble 1: {} ", out);
		Assert.assertEquals(new Double("7.15"), out, 0);

		d = new Double("4.1985");
		out =round1(d);
		logger.debug("testCalcolationTaxDouble 2: {} ", out);
		Assert.assertEquals(new Double("4.2"), out, 0);

		d = new Double("0.5625");//
		out =round1(d);
		logger.debug("testCalcolationTaxDouble 3: {} ", out);
		Assert.assertEquals(new Double("0.6"), out, 0);
		
		d = new Double("0.1775");
		out =round1(d);
		logger.debug("testCalcolationTaxDouble 4: {} ", out);
		Assert.assertEquals(new Double("0.2"), out, 0);
		
	}

	private  Double round1(Double d){
		return TaxesCalculation.getRoundingRules(d);
	}

}
