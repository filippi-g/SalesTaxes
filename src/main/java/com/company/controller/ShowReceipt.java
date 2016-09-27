package com.company.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.domain.model.Basket;
import com.company.domain.model.ProductDetail;
import com.company.domain.model.Receipt;
import com.company.service.impl.ReceiptManagerImpl;

/**
 * 
 * @author Candidate GFILIPPI
 *
 */
public class ShowReceipt extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4262472368080034159L;
	ReceiptManagerImpl receiptManagerImpl = new ReceiptManagerImpl();

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
			@SuppressWarnings("unchecked")
			List<ProductDetail> productDetailList =  (List<ProductDetail>) request.getSession().getAttribute("listSession");
		
			Basket basket = new Basket();
			basket.setId(basketId);
			basket.setProductDetailList(productDetailList);
			
			Receipt receipt = receiptManagerImpl.getReceipt(basket);
			
			request.setAttribute("receipt", receipt);
			
			RequestDispatcher disp = request.getRequestDispatcher("/showReceipt.jsp");
			disp.forward(request, response);
		} catch (Exception ex) {
			ex.getMessage();
		} finally {

		}
	}

}