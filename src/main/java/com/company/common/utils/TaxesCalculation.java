package com.company.common.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import org.slf4j.LoggerFactory;

/**
 * 
 * @author Candidate GFILIPPI
 *
 */
public class TaxesCalculation {
	
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(TaxesCalculation.class);

	public static final double NO_TAX = 0.0;
	public static final double BASIC_SALES = 0.10;
	public static final double IMPORT_SALES = 0.05;
	public static final String IMPORTED = "YES";
	public static final DecimalFormat formatter = new DecimalFormat(FormatValue.DECIMAL_FORMAT, DecimalFormatSymbols.getInstance( Locale.ENGLISH ));
	
	public static synchronized Double calcolationSalesTaxBasic(Double price){
 		return price * BASIC_SALES ;
	}
	
	public static synchronized Double calcolationSalesTaxExcept(Double price){
 		return NO_TAX;
	}
	
	public static synchronized Double calcolationSalesImportedTax(Double price, String imported){
		double importedTax = NO_TAX;
		if ( imported.equalsIgnoreCase(IMPORTED) ){
			importedTax = price * IMPORT_SALES;
		}
 		return importedTax;
	}
	
	public static synchronized Double roundNearestDoubleValue(Double doubleValue){
 		return getRoundingRules( doubleValue );
	}
	
	public static synchronized String fromDoubleToFormattedString(Double doubleValue){
		String s = formatter.format(doubleValue);
		logger.debug("fromDoubleToFormattedString s {} ", s);
		return s;
	}
	
	private final static synchronized Double getRoundingRules(Double val) {
		return Math.ceil(val * 20.0) / 20.0;
	}

}
