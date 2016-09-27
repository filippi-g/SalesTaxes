package com.company.service.exception;

/**
 * 
 * @author Candidate GFILIPPI
 *
 */
public class CalculationErrorException extends Exception {


	/**
	 * 
	 */
	private static final long serialVersionUID = -902590537814872424L;

	public CalculationErrorException(String type){
		super("Calculation Error type : " + type);
	}
}
