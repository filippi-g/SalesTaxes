package com.company.common.utils;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.LoggerFactory;

public class TaxesCalculationTest {

	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(TaxesCalculationTest.class);

	@SuppressWarnings("static-access")
	@Test
	public void testFromDoubleToString() {
		Double d = new Double("54.625");
		TaxesCalculation taxesCalculation = new TaxesCalculation();
		Double rounded = taxesCalculation.roundNearestDoubleValue(d);
		String value = taxesCalculation.fromDoubleToFormattedString(rounded);
		logger.debug("testFromDoubleToString 0 : {} ", value);
		assertTrue(value.equalsIgnoreCase("54.65"));

	}

	@Test
	public void testCalcolationTaxExceptItem() {

		//ALL EXCEPT - box of imported chocolates
		String price = "11.25";
		String imported = "YES";
		String outputTotal = "11.85";

		double priceDouble = Double.parseDouble(price);
		Double salesTaxBasic = TaxesCalculation.calcolationSalesTaxExcept(priceDouble);
		Double salesTaxBasicRound = TaxesCalculation.roundNearestDoubleValue(salesTaxBasic);

		Double salesImportedTax = TaxesCalculation.calcolationSalesImportedTax(priceDouble, imported);
		Double salesImportedTaxRound = TaxesCalculation.roundNearestDoubleValue(salesImportedTax);

		String salesTaxRoundFrmt = TaxesCalculation.fromDoubleToFormattedString( salesTaxBasicRound + salesImportedTaxRound );
		String finalCostRoundFrmt = TaxesCalculation.fromDoubleToFormattedString( salesTaxBasicRound + salesImportedTaxRound + priceDouble);

		logger.debug("testCalcolationTaxAllItem 1: salesTaxRoundFrmt {} ", salesTaxRoundFrmt);
		logger.debug("testCalcolationTaxAllItem 1: finalCostRoundFrmt {} ", finalCostRoundFrmt);
		assertTrue(finalCostRoundFrmt.equalsIgnoreCase(outputTotal));

	}

	@Test
	public void testCalcolationTaxAllItem() {
		//ALL Item - music cd
		String price = "14.99";
		String imported = "NO";
		String outputTotal = "16.49";

		double priceDouble = Double.parseDouble(price);
		Double salesTaxBasic = TaxesCalculation.calcolationSalesTaxBasic(priceDouble);
		Double salesTaxBasicRound = TaxesCalculation.roundNearestDoubleValue(salesTaxBasic);

		Double salesImportedTax = TaxesCalculation.calcolationSalesImportedTax(priceDouble, imported);
		Double salesImportedTaxRound = TaxesCalculation.roundNearestDoubleValue(salesImportedTax);

		String salesTaxRoundFrmt = TaxesCalculation.fromDoubleToFormattedString( salesTaxBasicRound + salesImportedTaxRound );
		String finalCostRoundFrmt = TaxesCalculation.fromDoubleToFormattedString( salesTaxBasicRound + salesImportedTaxRound + priceDouble);

		logger.debug("testCalcolationTaxAllItem 2a: salesTaxRoundFrmt {} ", salesTaxRoundFrmt);
		logger.debug("testCalcolationTaxAllItem 2a: finalCostRoundFrmt {} ", finalCostRoundFrmt);
		assertTrue(finalCostRoundFrmt.equalsIgnoreCase(outputTotal));

	}

	@Test
	public void testCalcolationTaxAllItem2() {
		//ALL Item - imported bottle of perfume
		String price = "47.50";
		String imported = "YES";
		String outputTotal = "54.65";

		double priceDouble = Double.parseDouble(price);
		Double salesTaxBasic = TaxesCalculation.calcolationSalesTaxBasic(priceDouble);
		Double salesTaxBasicRound = TaxesCalculation.roundNearestDoubleValue(salesTaxBasic);

		Double salesImportedTax = TaxesCalculation.calcolationSalesImportedTax(priceDouble, imported);
		Double salesImportedTaxRound = TaxesCalculation.roundNearestDoubleValue(salesImportedTax);

		String salesTaxRoundFrmt = TaxesCalculation.fromDoubleToFormattedString( salesTaxBasicRound + salesImportedTaxRound );
		String finalCostRoundFrmt = TaxesCalculation.fromDoubleToFormattedString( salesTaxBasicRound + salesImportedTaxRound + priceDouble);

		logger.debug("testCalcolationTaxAllItem 2b: salesTaxRoundFrmt {} ", salesTaxRoundFrmt);
		logger.debug("testCalcolationTaxAllItem 2b: finalCostRoundFrmt {} ", finalCostRoundFrmt);
		assertTrue(finalCostRoundFrmt.equalsIgnoreCase(outputTotal));

	}

	@Test
	public void testCalcolationTaxDouble() {
		Double d = new Double("7.125");
		Double out =round1(d);
		logger.debug("testCalcolationTaxDouble 3: {} ", out);
		assertTrue(new Double("7.15").equals(out));

		d = new Double("4.1985");
		out =round1(d);
		logger.debug("testCalcolationTaxDouble 3: {} ", out);
		assertTrue(new Double("4.2").equals(out));

		d = new Double("0.5625");//
		out =round1(d);
		logger.debug("testCalcolationTaxDouble 3: {} ", out);
		assertTrue(new Double("0.6").equals(out));

		d = new Double("0.1775");
		out =round1(d);
		logger.debug("testCalcolationTaxDouble 3: {} ", out);
		assertTrue(new Double("0.2").equals(out));

	}

	@Test
	public void testCalcolationTotalDouble() {
		Double tax = Double.parseDouble("14.99") * TaxesCalculation.BASIC_SALES;
		Double res = Double.parseDouble("14.99") + tax;
		String s = TaxesCalculation.fromDoubleToFormattedString(res);
		logger.debug("testCalcolationTotalDouble 4: {} ", s);
		assertTrue("16.49".equalsIgnoreCase(s));
	}

	private  Double round1(Double doubleValue){
		return TaxesCalculation.roundNearestDoubleValue(doubleValue);
	}

}
