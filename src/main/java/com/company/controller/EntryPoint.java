package com.company.controller;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.service.impl.FillingBasketImpl;

/**
 * 
 * @author Candidate GFILIPPI
 *
 */
public class EntryPoint extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3745575430775768290L;

	FillingBasketImpl fillingBasketImpl = new FillingBasketImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Map<Integer,String> ascSortedBasket = new TreeMap<Integer,String>();
			Iterator<Integer> iterator = fillingBasketImpl.getAllBasketIds().iterator();
			while(iterator.hasNext()) {
				Integer setElement = iterator.next();
				ascSortedBasket.put(setElement, "Number " + setElement);
			}
			
			request.setAttribute("ascSortedBasket", ascSortedBasket);

			RequestDispatcher disp = request.getRequestDispatcher("/entryPoint.jsp");
			disp.forward(request, response);
		} catch (Exception ex) {
			ex.getMessage();
		} finally {

		}
	}

}