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
 * Servlet implementation class ShowAllProductsServlet
 */
@WebServlet("/getAll")
public class ShowAllProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private INykaaService nykaaService=new NykaaServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllProductsServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Product> productList=nykaaService.getAll();
		
		
		request.setAttribute("productList",productList);
		RequestDispatcher dispatcher=request.getRequestDispatcher("final.jsp");
		dispatcher.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
