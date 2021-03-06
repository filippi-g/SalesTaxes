package com.company.common.csv;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.LoggerFactory;

import com.company.domain.model.ProductDetail;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

/**
 * 
 * @author Candidate GFILIPPI
 *
 */
public final class ParseCSV2BeanSingleton {

	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(ParseCSV2BeanSingleton.class);
	private static final String FILENAME = "./input/ProductDetail.csv";
	private static ParseCSV2BeanSingleton instance = null;
	private List<ProductDetail> productList = null;
	private Set<Integer> set = null;
	
	private ParseCSV2BeanSingleton(){
		initParseCSV2BeanSingleton() ;
	}
	
	private void initParseCSV2BeanSingleton() {
		try {
			// Ignore Processing of 1st row
			CSVReader reader = new CSVReader(new FileReader(FILENAME), ';', '\"', 1);

			ColumnPositionMappingStrategy<ProductDetail> mappingStrategy 
			= new ColumnPositionMappingStrategy<ProductDetail>();
			mappingStrategy.setType(ProductDetail.class);

			String[] columns = new String[] {"productNumber","productName","price","category","imported","basketId"};
			mappingStrategy.setColumnMapping(columns);

			CsvToBean<ProductDetail> csv = new CsvToBean<ProductDetail>();
			productList = new ArrayList<ProductDetail>();
			productList = csv.parse(mappingStrategy, reader);
			
			set = new HashSet<Integer>();

			for (int i = 0; i < productList.size(); i++) {
				ProductDetail productDetail = productList.get(i);
				// display CSV values
				logger.debug("productNumber : {}", productDetail.getProductNumber());
				logger.debug("productName : {}", productDetail.getProductName());
				logger.debug("price : {}", productDetail.getPrice());
				logger.debug("category : {}", productDetail.getCategory());
				logger.debug("imported : {}", productDetail.getImported());
				logger.debug("basketId : {}", productDetail.getBasketId());
				set.add(new Integer(productDetail.getBasketId()));
				logger.debug("------------------------------");
			}
			
		}catch (FileNotFoundException e) {
			logger.error("FileNotFoundException ", e);
		}
	}

	public static ParseCSV2BeanSingleton getInstance() {
		if ( instance == null){
			instance = new ParseCSV2BeanSingleton();
		}
		return instance;
	}
	
	public List<ProductDetail> getProductList() {
		return productList;
	}

	public Set<Integer> getBasketIds() {
		return set;
	}
}