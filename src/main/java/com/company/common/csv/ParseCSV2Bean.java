package com.company.common.csv;

import java.io.FileNotFoundException;
import java.io.FileReader;
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
public class ParseCSV2Bean {
	
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(ParseCSV2Bean.class);
	
	public List<ProductDetail> parseCSVtoBean(String filename) 
	{
		List<ProductDetail> productList = null;
		try 
		{
			// Ignore Processing of 1st row
			CSVReader reader = new CSVReader(new FileReader(filename), ';', '\"', 1);

			ColumnPositionMappingStrategy<ProductDetail> mappingStrategy 
			= new ColumnPositionMappingStrategy<ProductDetail>();
			mappingStrategy.setType(ProductDetail.class);

			String[] columns = new String[] {"productNumber","productName","price","category","imported","basketId"};
			mappingStrategy.setColumnMapping(columns);

			CsvToBean<ProductDetail> csv = new CsvToBean<ProductDetail>();
			productList = csv.parse(mappingStrategy, reader);

			for (int i = 0; i < productList.size(); i++) 
			{
				ProductDetail productDetail = productList.get(i);
				// display CSV values
				logger.debug("productNumber : {}", productDetail.getProductNumber());
				logger.debug("productName : {}", productDetail.getProductName());
				logger.debug("price : {}", productDetail.getPrice());
				logger.debug("category : {}", productDetail.getCategory());
				logger.debug("imported : {}", productDetail.getImported());
				logger.debug("basketId : {}", productDetail.getBasketId());
				logger.debug("------------------------------");
			}
			return productList;
		}catch (FileNotFoundException e) {
			logger.error("FileNotFoundException ", e);
		}
		return null;
	}
	
	public Set<Integer> parseCSVtoInteger(String filename) 
	{
		List<ProductDetail> productList = null;
		 Set<Integer> set = new HashSet<Integer>();
		try 
		{
			// Ignore Processing of 1st row
			CSVReader reader = new CSVReader(new FileReader(filename), ';', '\"', 1);

			ColumnPositionMappingStrategy<ProductDetail> mappingStrategy 
			= new ColumnPositionMappingStrategy<ProductDetail>();
			mappingStrategy.setType(ProductDetail.class);

			String[] columns = new String[] {"productNumber","productName","price","category","imported","basketId"};
			mappingStrategy.setColumnMapping(columns);

			CsvToBean<ProductDetail> csv = new CsvToBean<ProductDetail>();
			productList = csv.parse(mappingStrategy, reader);

			for (int i = 0; i < productList.size(); i++) 
			{
				ProductDetail productDetail = productList.get(i);
				logger.debug("basketId : {}", productDetail.getBasketId());
				set.add(new Integer(productDetail.getBasketId()));
				logger.debug("------------------------------");
			}
			return set;
		}catch (FileNotFoundException e) {
			logger.error("FileNotFoundException ", e);
		}
		return null;
	}
}