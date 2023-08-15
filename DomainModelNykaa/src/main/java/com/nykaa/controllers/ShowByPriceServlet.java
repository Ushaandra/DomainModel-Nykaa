package com.nykaa.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nykaa.model.Product;
import com.nykaa.service.INykaaService;
import com.nykaa.service.NykaaServiceImpl;

/**
 * Servlet implementation class ShowByPrice
 */
@WebServlet("/showByPrice")
public class ShowByPriceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private INykaaService nykaaService=new NykaaServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowByPriceServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		double price=Double.parseDouble(request.getParameter("price")) ;
		List<Product> productList=nykaaService.getByPriceLessThan(price);
		
		request.setAttribute("productList", productList);
		RequestDispatcher dispatcher=request.getRequestDispatcher("final.jsp");
		dispatcher.include(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
