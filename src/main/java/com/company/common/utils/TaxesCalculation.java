package com.company.common.utils;

import java.text.DecimalFormat;

/**
 * 
 * @author Candidate GFILIPPI
 *
 */
public class TaxesCalculation {

	public static final double EXCEPT_SALES = 0;
	public static final double BASIC_SALES = 0.10;
	public static final double IMPORT_SALES = 0.05;
	public static final String IMPORTED = "YES";
	
	public static synchronized Double calcolationTax(String price, String imported, double rate){
		if ( imported.equalsIgnoreCase(TaxesCalculation.IMPORTED) ){
			rate = rate + TaxesCalculation.IMPORT_SALES;
		}
		if (rate == 0) return EXCEPT_SALES;
 		return Double.parseDouble(price) * rate ;
		
	}

	public static String fromDoubleToString(Double val, boolean rounding){
		Double d = rounding?getRoundingRules( val ):val;
		DecimalFormat formatter = FormatValue.getDecimalFormat();
		String s = formatter.format(d);
		return s;
	}
	
	public final static Double getRoundingRules(Double val) {
		return Math.ceil(val * 20.0) / 20.0;
	}

}
