package com.company.service.exception;

/**
 * 
 * @author Candidate GFILIPPI
 *
 */
public class InvalidItemsTypeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3715633694973032090L;

	public InvalidItemsTypeException(String category){
		super("Invalid Item of category type " + category);
	};
	
}
