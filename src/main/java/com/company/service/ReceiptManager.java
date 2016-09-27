package com.company.service;

import com.company.domain.model.Basket;
import com.company.domain.model.Receipt;

/**
 * 
 * @author Candidate GFILIPPI
 *
 */
public interface ReceiptManager {
	
	Receipt getReceipt(Basket basket);

}
