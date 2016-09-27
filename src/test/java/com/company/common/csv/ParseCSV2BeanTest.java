package com.company.common.csv;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;
import org.slf4j.LoggerFactory;

import com.company.domain.model.ProductDetail;

public class ParseCSV2BeanTest {

	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(ParseCSV2BeanTest.class);
	
	ParseCSV2BeanSingleton parseCSV2BeanSingleton = ParseCSV2BeanSingleton.getInstance();
	
	@Test
	public void testParseCSVtoBean() {
		List<ProductDetail> list = parseCSV2BeanSingleton.getProductList();
		assertNotNull(list);
		assertTrue(list!=null);
		assertTrue(list.size()>0);
		logger.debug("testParseCSVtoBean - list.size: {} ",list.size());
	}

	@Test
	public void testCSVtoIntegerBean() {
		Set<Integer> set = parseCSV2BeanSingleton.getBasketIds();

		assertNotNull(set);
		assertTrue(set!=null);
		assertTrue(set.size()>0);

		Map<Integer,String> ascSortedBasket = new TreeMap<Integer,String>();
		
		Iterator<Integer> iterator = set.iterator();
		while(iterator.hasNext()) {
			Integer setElement = iterator.next();
			ascSortedBasket.put(setElement, "Number : " + setElement);
		}

		logger.debug("assertNotNull - ascSortedBasket: {} ", ascSortedBasket!=null);
		assertTrue(ascSortedBasket!=null);
		assertTrue(ascSortedBasket.size()>0);
		logger.debug("ascSortedBasket - size: {} ",ascSortedBasket.size());
		for(Map.Entry<Integer, String> mapData : ascSortedBasket.entrySet()) {
			logger.debug(("Key : " + mapData.getKey()+ "Value : "+mapData.getValue()));
		}

		
	}



}
