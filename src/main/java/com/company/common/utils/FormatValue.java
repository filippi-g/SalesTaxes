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
	public static DecimalFormat formatter = null;
	
	
	public FormatValue() {
	}
	
	public static String fromDoubleToString(Double d){
		if (formatter==null){
			formatter = new DecimalFormat(DECIMAL_FORMAT, DecimalFormatSymbols.getInstance( Locale.ENGLISH ));
			formatter.setRoundingMode( RoundingMode.UP );
		}
		return formatter.format(d);
	}

}
