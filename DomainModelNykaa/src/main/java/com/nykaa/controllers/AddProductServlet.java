package com.nykaa.controllers;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/addProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private INykaaService nykaaService=new NykaaServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
//        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		//name,category,productId,price,offer
		String name=request.getParameter("name");
		String category=request.getParameter("category");
		int productId=Integer.parseInt(request.getParameter("productId"));
		double price=Double.parseDouble(request.getParameter("price"));
		int offer=Integer.parseInt(request.getParameter("offer"));
		
		Product product=new Product();
		product.setName(name);
		product.setCategory(category);
		product.setProductId(productId);
		product.setPrice(price);
		product.setOffer(offer);
		
		nykaaService.addProduct(product);
		request.setAttribute("message", "Product added successfully");
		RequestDispatcher dispatcher=request.getRequestDispatcher("admin.jsp");
		dispatcher.forward(request, response);
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
