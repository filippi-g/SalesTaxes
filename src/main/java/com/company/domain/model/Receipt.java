package com.company.domain.model;

import java.util.List;

import com.company.service.bean.Item;

/**
 * 
 * @author Candidate GFILIPPI
 *
 */
public class Receipt {

	String id = null;
	List<Item> itemsList  = null;
	String salesTaxes = null;
	String total = null;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Item> getItemsList() {
		return itemsList;
	}
	public void setItemsList(List<Item> itemsList) {
		this.itemsList = itemsList;
	}
	public String getSalesTaxes() {
		return salesTaxes;
	}
	public void setSalesTaxes(String salesTaxes) {
		this.salesTaxes = salesTaxes;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	
	
}
