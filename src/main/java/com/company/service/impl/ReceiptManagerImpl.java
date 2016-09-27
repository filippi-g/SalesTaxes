/**
 * 
 */
package com.company.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

import com.company.common.utils.FormatValue;
import com.company.domain.model.Basket;
import com.company.domain.model.ProductDetail;
import com.company.domain.model.Receipt;
import com.company.service.ReceiptManager;
import com.company.service.bean.Item;
import com.company.service.exception.CalculationErrorException;
import com.company.service.exception.InvalidItemsTypeException;

/**
 * @author Candidate GFILIPPI
 *
 */
public class ReceiptManagerImpl implements ReceiptManager {

	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(ReceiptManagerImpl.class);

	@Override
	public Receipt getReceipt(Basket basket) {
		try{
			return fillingReceipt(basket);
		}catch (InvalidItemsTypeException e) {
			logger.error("getReceipt ", e);
		}catch (CalculationErrorException e) {
			logger.error("getReceipt ", e);
		}catch (Exception e) {
			logger.error("getReceipt ", e);
		}
		return null;
	}

	private Receipt fillingReceipt(Basket basket) throws CalculationErrorException, InvalidItemsTypeException{
		Receipt receipt = new Receipt();
		receipt.setId(basket.getId());
		List<Item> itemsList = getItemsList(basket.getProductDetailList());
		receipt.setItemsList(itemsList);
		receipt.setSalesTaxes(getSalesTaxes(itemsList, basket.getId()));
		receipt.setTotal(getTotal(itemsList, basket.getId()));
		return receipt;

	}

	private List<Item> getItemsList(List<ProductDetail> productDetailList) throws CalculationErrorException, InvalidItemsTypeException{
		List<Item> itemsList = new ArrayList<Item>();
		ItemsFactoryImpl itemsFactoryImpl = new ItemsFactoryImpl();
		for(ProductDetail p:productDetailList){
			Item item = itemsFactoryImpl.transferIntoItems(p);
			if ( item.doSalesTaxesCalculation() ){
				itemsList.add( item );
			}else{
				throw new CalculationErrorException("doSalesTaxesCalculation error on product " +p.getProductNumber());
			}
		}
		return itemsList;

	}

	private String getSalesTaxes(List<Item> itemsList, String id)  throws CalculationErrorException{
		Double salesTaxes = new Double(0);
		try{
			for(Item item:itemsList){
				Double d = Double.parseDouble(item.getSalesTax());
				salesTaxes = salesTaxes + d;
			}
		}catch (Exception e) {
			logger.error("getSalesTaxes ", e);
			throw new CalculationErrorException("getSalesTaxes error on basket id : " + id);
		}
		return FormatValue.fromDoubleToString(salesTaxes);
	}

	private String getTotal(List<Item> itemsList, String id)  throws CalculationErrorException{
		Double total = new Double(0);
		try{
			for(Item item:itemsList){
				Double d = Double.parseDouble(item.getFinalCost());
				total = total + d;
			}
		}catch (Exception e) {
			logger.error("getTotal Taxes ", e);
			throw new CalculationErrorException("getTotal error on basket id : " + id);
		}
		return FormatValue.fromDoubleToString(total);

	}

}
