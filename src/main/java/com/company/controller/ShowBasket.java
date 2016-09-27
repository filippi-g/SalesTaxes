package com.company.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.domain.model.ProductDetail;
import com.company.service.impl.FillingBasketImpl;

/**
 * 
 * @author Candidate GFILIPPI
 *
 */
public class ShowBasket extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5492464693039342533L;
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
			String basketId = request.getParameter("basketId");
			List<ProductDetail> list = (ArrayList<ProductDetail>) fillingBasketImpl.getBasketById(basketId);
			
			request.setAttribute("basketId", basketId);
			request.setAttribute("list", list);
			
			request.getSession().setAttribute("listSession", list);
			
			RequestDispatcher disp = request.getRequestDispatcher("/showBasket.jsp");
			disp.forward(request, response);
		} catch (Exception ex) {
			ex.getMessage();
		} finally {
			
		}
	}
	
}