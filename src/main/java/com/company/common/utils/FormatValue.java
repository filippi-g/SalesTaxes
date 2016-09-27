package com.company.common.utils;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * 
 * @author Candidate GFILIPPI
 *
 */
public class FormatValue {

	public static final String DECIMAL_FORMAT = "#0.00";
	public static final DecimalFormat formatter = new DecimalFormat(DECIMAL_FORMAT, DecimalFormatSymbols.getInstance( Locale.ENGLISH ));

	public static String fromDoubleToString(Double d){
		formatter.setRoundingMode( RoundingMode.UP );
		String s = formatter.format(d);
		return s;
	}
	
	public static DecimalFormat getDecimalFormat(){
		return formatter;
	}


}
