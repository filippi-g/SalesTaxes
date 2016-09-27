package com.company.domain.model;

/**
 * 
 * @author Candidate GFILIPPI
 *
 */
public class ProductDetail 
{
	
	String productNumber = null;
	String productName = null;
	String price = null;
	String category = null;
	String imported = null;
	String basketId = null;
	
	public String getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImported() {
		return imported;
	}
	public void setImported(String imported) {
		this.imported = imported;
	}
	public String getBasketId() {
		return basketId;
	}
	public void setBasketId(String basketId) {
		this.basketId = basketId;
	}
	

}