package com.nykaa.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nykaa.service.INykaaService;
import com.nykaa.service.NykaaServiceImpl;

/**
 * Servlet implementation class EditProductServlet
 */
@WebServlet("/editProductServlet")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private INykaaService nykaaService=new NykaaServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProductServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int productId=Integer.parseInt(request.getParameter("productId"));
		double price=Double.parseDouble(request.getParameter("price"));
		
		nykaaService.updateProduct(productId, price);
		
		request.setAttribute("message", "Product updated successfully");
		RequestDispatcher dispatcher=request.getRequestDispatcher("admin.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
